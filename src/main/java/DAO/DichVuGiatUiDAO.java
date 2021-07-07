/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.DVGiatUi;
import Helper.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class DichVuGiatUiDAO {
        
        public void insert(DVGiatUi dv) {
                String sql = "insert into DVGiatUi(MaLoaiDVGiatUi, TenLoaiDVGiatUi, DonGia) values(?,?,?)";
                JDBC.update(sql,
                dv.getMaLoaiDVGiatUi(),
                dv.getTenLoaiDVGiatUi(),
                dv.getDonGia()
                );
        }
        
        public void update(DVGiatUi dv) {
                String sql = "update DVGiatUi set TenLoaiDVGiatUi = ?, DonGia = ? where MaLoaiDVGiatUi = ?";
                JDBC.update(sql,
                dv.getTenLoaiDVGiatUi(),
                dv.getDonGia(),
                dv.getMaLoaiDVGiatUi()
                );
        }
        
        public void delete(String maDV) {
                String sql = "delete from DVGiatUi where MaLoaiDVGiatUi = ?";
                JDBC.update(sql, maDV);
        }
        
        public List<DVGiatUi> SelectBySQL(String sql, Object... args) {
                List<DVGiatUi> lstDVGiatUi = new ArrayList<>();
                try {
                        ResultSet rs = null;
                        try {
                                rs = JDBC.query(sql, args);
                                while (rs.next()) {
                                        DVGiatUi dv = new DVGiatUi();
                                        dv.setMaLoaiDVGiatUi(rs.getString("MaLoaiDVGiatUi"));
                                        dv.setTenLoaiDVGiatUi(rs.getString("TenLoaiDVGiatUi"));
                                        dv.setDonGia(rs.getDouble("DonGia"));
                                        lstDVGiatUi.add(dv);
                                }
                        } finally {
                                rs.getStatement().getConnection().close();
                        }
                } catch (Exception e) {
                        throw new RuntimeException();
                }
                return lstDVGiatUi;
        }
        
        public List<DVGiatUi> SelectAll() {
                String sql = "select * from DVGiatUi";
                return SelectBySQL(sql);
        }
        
        public DVGiatUi SelectByID(String maDV) {
                String sql = "select * from DVGiatUi where MaLoaiDVGiatUi = ?";
                List<DVGiatUi> lst = SelectBySQL(sql, maDV);
                return lst.size() > 0 ? lst.get(0) : null;
        }
        
}
