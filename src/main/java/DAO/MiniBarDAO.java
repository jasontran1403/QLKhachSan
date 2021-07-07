/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.MiniBar;
import Helper.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class MiniBarDAO {
        
        public void insert(MiniBar dv) {
                String sql = "insert into MiniBar(MaMiniBar, TenSanPham, DonGia) values(?,?,?)";
                JDBC.update(sql,
                dv.getMaMiniBar(),
                dv.getTenSanPham(),
                dv.getDonGia()
                );
        }
        
        public void update(MiniBar dv) {
                String sql = "update MiniBar set TenSanPham = ?, DonGia = ? where MaMiniBar = ?";
                JDBC.update(sql,
                dv.getTenSanPham(),
                dv.getDonGia(),
                dv.getMaMiniBar()
                );
        }
        
        public void delete(String maSP) {
                String sql = "delete from MiniBar where MaMiniBar = ?";
                JDBC.update(sql, maSP);
        }
        
        public List<MiniBar> SelectBySQL(String sql, Object... args) {
                List<MiniBar> lstMiniBar = new ArrayList<>();
                try {
                        ResultSet rs = null;
                        try {
                                rs = JDBC.query(sql, args);
                                while (rs.next()) {
                                        MiniBar dv = new MiniBar();
                                        dv.setMaMiniBar(rs.getString("MaMiniBar"));
                                        dv.setTenSanPham(rs.getString("TenSanPham"));
                                        dv.setDonGia(rs.getDouble("DonGia"));
                                        lstMiniBar.add(dv);
                                }
                        } finally {
                                rs.getStatement().getConnection().close();
                        }
                } catch (Exception e) {
                        throw new RuntimeException();
                }
                return lstMiniBar;
        }
        
        public List<MiniBar> SelectAll() {
                String sql = "select * from MiniBar";
                return SelectBySQL(sql);
        }
        
        public MiniBar SelectByID(String maSP) {
                String sql = "select * from MiniBar where MaMiniBar = ?";
                List<MiniBar> lst = SelectBySQL(sql, maSP);
                return lst.size() > 0 ? lst.get(0) : null;
        }
}
