/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.DVGiaiTri;
import Helper.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class DichVuGiaiTriDAO {

        public void insert(DVGiaiTri dv) {
                String sql = "insert into DVGiaiTri(MaLoaiDVGiaiTri, TenLoaiDVGiaiTri, DonGia) values(?,?,?)";
                JDBC.update(sql,
                dv.getMaLoaiDVGiaiTri(),
                dv.getTenLoaiDVGiaiTri(),
                dv.getDonGia()
                );
        }

        public void update(DVGiaiTri dv) {
                String sql = "update DVGiaiTri set TenLoaiDVGiaiTri = ?, DonGia = ? where MaLoaiDVGiaiTri = ?";
                JDBC.update(sql,
                dv.getTenLoaiDVGiaiTri(),
                dv.getDonGia(),
                dv.getMaLoaiDVGiaiTri()
                );
        }

        public void delete(String maDV) {
                String sql = "delete from DVGiaiTri where MaLoaiDVGiaiTri = ?";
                JDBC.update(sql, maDV);
        }

        public List<DVGiaiTri> SelectBySQL(String sql, Object... args) {
                List<DVGiaiTri> lstDVGiaiTri = new ArrayList<>();
                try {
                        ResultSet rs = null;
                        try {
                                rs = JDBC.query(sql, args);
                                while (rs.next()) {
                                        DVGiaiTri dv = new DVGiaiTri();
                                        dv.setMaLoaiDVGiaiTri(rs.getString("MaLoaiDVGiaiTri"));
                                        dv.setTenLoaiDVGiaiTri(rs.getString("TenLoaiDVGiaiTri"));
                                        dv.setDonGia(rs.getDouble("DonGia"));
                                        lstDVGiaiTri.add(dv);
                                }
                        } finally {
                                rs.getStatement().getConnection().close();
                        }
                } catch (Exception e) {
                        throw new RuntimeException();
                }
                return lstDVGiaiTri;
        }

        public List<DVGiaiTri> SelectAll() {
                String sql = "select * from DVGiaiTri";
                return SelectBySQL(sql);
        }

        public DVGiaiTri SelectByID(String maDV) {
                String sql = "select * from DVGiaiTri where MaLoaiDVGiaiTri = ?";
                List<DVGiaiTri> lst = SelectBySQL(sql, maDV);
                return lst.size() > 0 ? lst.get(0) : null;
        }
}
