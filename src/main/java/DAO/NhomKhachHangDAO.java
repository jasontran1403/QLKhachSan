/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.NhomKhachHang;
import Helper.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class NhomKhachHangDAO {

        public List<NhomKhachHang> SelectBySQL(String sql, Object... args) {
                List<NhomKhachHang> lstNhomKhachHang = new ArrayList<>();
                try {
                        ResultSet rs = null;
                        try {
                                rs = JDBC.query(sql, args);
                                while (rs.next()) {
                                        NhomKhachHang nkh = new NhomKhachHang();
                                        nkh.setMaNhomKhachHang(rs.getString("MaNhomKhachHang"));
                                        nkh.setMaKhachHang(rs.getString("MaKhachHang"));
                                        nkh.setTenNhomKhachHang(rs.getString("TenNhomKhachHang"));
                                        nkh.setSoLuong(rs.getInt("SoLuong"));
                                        nkh.setTenDoan(rs.getString("TenDoan"));
                                }
                        } finally {
                                rs.getStatement().getConnection().close();
                        }
                } catch (Exception e) {
                        throw new RuntimeException();
                }
                return lstNhomKhachHang;
        }

        public List<NhomKhachHang> SelectAll() {
                String sql = "select * from NhomKhachHang";
                return SelectBySQL(sql);
        }
        
        
}
