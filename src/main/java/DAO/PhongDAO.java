/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Phong;
import Helper.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class PhongDAO {
        
        public List<Phong> SelectBySQL(String sql, Object... args) {
                List<Phong> lstPhong = new ArrayList<>();
                try {
                        ResultSet rs = null;
                        try {
                                rs = JDBC.query(sql, args);
                                while (rs.next()) {
                                        Phong p = new Phong();
                                        p.setMaPhong(rs.getString("MaPhong"));
                                        p.setTenPhong(rs.getString("TenPhong"));
                                        p.setTinhTrangPhong(rs.getInt("TinhTrangPhong"));
                                        p.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                                        lstPhong.add(p);
                                }
                        } finally {
                                rs.getStatement().getConnection().close();
                        }
                } catch (Exception e) {
                        throw new RuntimeException();
                }
                return lstPhong;
        }
        
        
}
