/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.DVSpa;
import Helper.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class DichVuSpaDAO {
        
        public void insert(DVSpa dv) {
                String sql = "insert into DVSpa(MaLoaiDVSpa, TenLoaiDVSpa, DonGia) values(?,?,?)";
                JDBC.update(sql,
                dv.getMaLoaiDVSpa(),
                dv.getTenLoaiDVSpa(),
                dv.getDonGia()
                );
        }
        
        public void update(DVSpa dv) {
                String sql = "update DVSpa set TenLoaiDVSpa = ?, DonGia = ? where MaLoaiDVSpa = ?";
                JDBC.update(sql,
                dv.getTenLoaiDVSpa(),
                dv.getDonGia(),
                dv.getMaLoaiDVSpa()
                );
        }
        
        public void delete(String maDV) {
                String sql = "delete from DVSpa where MaLoaiDVSpa = ?";
                JDBC.update(sql, maDV);
        }
        
        public List<DVSpa> SelectBySQL(String sql, Object... args) {
                List<DVSpa> lstSpa = new ArrayList<>();
                try {
                        ResultSet rs = null;
                        try {
                                rs = JDBC.query(sql, args);
                                while (rs.next()) {
                                        DVSpa dv = new DVSpa();
                                        dv.setMaLoaiDVSpa(rs.getString("MaLoaiDVSpa"));
                                        dv.setTenLoaiDVSpa(rs.getString("TenLoaiDVSpa"));
                                        dv.setDonGia(rs.getDouble("DonGia"));
                                        lstSpa.add(dv);
                                }
                        } finally {
                                rs.getStatement().getConnection().close();
                        }
                } catch (Exception e) {
                        throw new RuntimeException();
                }
                return lstSpa;
        }
        
        public List<DVSpa> SelectAll() {
                String sql = "select * from DVSpa";
                return SelectBySQL(sql);
        }
        
        public DVSpa SelectByID(String maDV) {
                String sql = "select * from DVSpa where MaLoaiDVSpa = ?";
                List<DVSpa> lst = SelectBySQL(sql, maDV);
                return lst.size() > 0 ? lst.get(0) : null;
        }
}
