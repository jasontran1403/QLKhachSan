/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.DVNhaHang;
import Helper.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class DichVuNhaHangDAO {

        public void insert(DVNhaHang dv) {
                String sql = "insert into DVNhaHang(MaLoaiDVNhaHang, TenLoaiDVNhaHang, DonGia) values(?,?,?)";
                JDBC.update(sql,
                dv.getMaLoaiDVNhaHang(),
                dv.getTenLoaiDVNhaHang(),
                dv.getDonGia()
                );
        }

        public void update(DVNhaHang dv) {
                String sql = "update DVNhaHang set TenLoaiDVNhaHang = ?, DonGia = ? where MaLoaiDVNhaHang = ?";
                JDBC.update(sql,
                dv.getTenLoaiDVNhaHang(),
                dv.getDonGia(),
                dv.getMaLoaiDVNhaHang()
                );
        }

        public void delete(String maDV) {
                String sql = "delete from DVNhaHang where MaLoaiDVNhaHang = ?";
                JDBC.update(sql, maDV);
        }

        public List<DVNhaHang> SelectBySQL(String sql, Object... args) {
                List<DVNhaHang> lstDVNhaHang = new ArrayList<>();
                try {
                        ResultSet rs = null;
                        try {
                                rs = JDBC.query(sql, args);
                                while (rs.next()) {
                                        DVNhaHang dv = new DVNhaHang();
                                        dv.setMaLoaiDVNhaHang(rs.getString("MaLoaiDVNhaHang"));
                                        dv.setTenLoaiDVNhaHang(rs.getString("TenLoaiDVNhaHang"));
                                        dv.setDonGia(rs.getDouble("DonGia"));
                                        lstDVNhaHang.add(dv);
                                }
                        } finally {
                                rs.getStatement().getConnection().close();
                        }
                } catch (Exception e) {
                        throw new RuntimeException();
                }
                return lstDVNhaHang;
        }

        public List<DVNhaHang> SelectAll() {
                String sql = "select * from DVNhaHang";
                return SelectBySQL(sql);
        }

        public DVNhaHang SelectByID(String maDV) {
                String sql = "select * from DVNhaHang where MaLoaiDVNhaHang = ?";
                List<DVNhaHang> lst = SelectBySQL(sql, maDV);
                return lst.size() > 0 ? lst.get(0) : null;
        }

}
