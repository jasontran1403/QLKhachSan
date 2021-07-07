/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.NhanVien;
import Helper.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class NhanVienDAO {

        public List<NhanVien> SelectBySQL(String sql, Object... args) {
                List<NhanVien> lstNhanVien = new ArrayList<>();
                try {
                        ResultSet rs = null;
                        try {
                                rs = JDBC.query(sql, args);
                                while (rs.next()) {
                                        NhanVien nv = new NhanVien();
                                        nv.setMaNhanVien(rs.getString("MaNhanVien"));
                                        nv.setTenNhanVien(rs.getString("TenNhanVien"));
                                        nv.setCCCD(rs.getString("CCCD"));
                                        nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                                        nv.setNgaySinh(rs.getDate("NgaySinh"));
                                        nv.setDiaChi(rs.getString("DiaChi"));
                                        nv.setEmail(rs.getString("Email"));
                                        nv.setSDT(rs.getString("SDT"));
                                        nv.setChucVu(rs.getString("ChucVu"));
                                        lstNhanVien.add(nv);
                                }
                        } finally {
                                rs.getStatement().getConnection().close();
                        }
                } catch (Exception e) {
                        throw new RuntimeException();
                }
                return lstNhanVien;
        }

        public List<NhanVien> SelectAll() {
                String sql = "select * from NhanVien";
                return SelectBySQL(sql);
        }

        public NhanVien selectByID(String maNhanVien) {
                String sql = "select * from NhanVien where MaNhanVien = ?";
                List<NhanVien> lstNhanVien = SelectBySQL(sql, maNhanVien);
                return lstNhanVien.size() > 0 ? lstNhanVien.get(0) : null;
        }

        public void insert(NhanVien nv) {
                String sql = "insert into NhanVien(MaNhanVien, TenNhanVien, CCCD, GioiTinh, NgaySinh, DiaChi, Email, SDT, ChucVu) values  (?,?,?,?,?,?,?,?,?)";
                JDBC.update(sql,
                nv.getMaNhanVien(),
                nv.getTenNhanVien(),
                nv.getCCCD(),
                nv.isGioiTinh(),
                nv.getNgaySinh(),
                nv.getDiaChi(),
                nv.getEmail(),
                nv.getSDT(),
                nv.getChucVu()
                );
        }

        public void update(NhanVien nv) {
                String sql = "update NhanVien set TenNhanVien = ?, CCCD = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?, Email = ?, SDT = ?, ChucVu = ? where MaNhanVien = ?";
                JDBC.update(sql,
                nv.getTenNhanVien(),
                nv.getCCCD(),
                nv.isGioiTinh(),
                nv.getNgaySinh(),
                nv.getDiaChi(),
                nv.getEmail(),
                nv.getSDT(),
                nv.getChucVu(),
                nv.getMaNhanVien()
                );
        }

        public void delete(String maNhanVien) {
                String sql = "delete from NhanVien where MaNhanVien = ?";
                JDBC.update(sql, maNhanVien);
        }

        public List<NhanVien> SelectByKeyWord(String keyword) {
                String sql = "";
                if (keyword.trim().startsWith("NV")) {
                        sql = "select * from NhanVien where MaNhanVien like ? ";
                } else {
                        sql = "select * from NhanVien where TenNhanVien like ?";
                }
                return SelectBySQL(sql, "%" + keyword + "%");
        }
}
