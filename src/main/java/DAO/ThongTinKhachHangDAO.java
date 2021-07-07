/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.ThongTinKhachHang;
import Helper.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class ThongTinKhachHangDAO {

        public void insert(ThongTinKhachHang ttKh) {
                String sql = "insert into ThongTinKhachHang (MaKhachHang, TenKhachHang, CCCD, GioiTinh, NgaySinh, QuocTich, DiaChi, Email, SDT)	values  (?,?,?,?,?,?,?,?,?)";
                JDBC.update(sql,
                ttKh.getMaKhachHang(),
                ttKh.getTenKhachHang(),
                ttKh.getCCCD(),
                ttKh.isGioiTinh(),
                ttKh.getNgaySinh(),
                ttKh.getQuocTich(),
                ttKh.getDiaChi(),
                ttKh.getEmail(),
                ttKh.getSDT()
                );
        }

        public void update(ThongTinKhachHang ttKh) {
                String sql = "update ThongTinKhachHang set TenKhachHang = ?, CCCD = ?, GioiTinh = ?, NgaySinh = ?, QuocTich = ?, DiaChi = ?, Email = ?, SDT = ? where MaKhachHang = ?";
                JDBC.update(sql,
                ttKh.getTenKhachHang(),
                ttKh.getCCCD(),
                ttKh.isGioiTinh(),
                ttKh.getNgaySinh(),
                ttKh.getQuocTich(),
                ttKh.getDiaChi(),
                ttKh.getEmail(),
                ttKh.getSDT(),
                ttKh.getMaKhachHang()
                );
        }

        public void delete(String maKhachHang) {
                String sql = "delete from ThongTinKhachHang where MaKhachHang = ? ";
                JDBC.update(sql, maKhachHang);
        }

        public List<ThongTinKhachHang> SelectBySQL(String sql, Object... args) {
                List<ThongTinKhachHang> lstKhachHang = new ArrayList<>();
                try {
                        ResultSet rs = null;
                        try {
                                rs = JDBC.query(sql, args);
                                while (rs.next()) {
                                        ThongTinKhachHang ttKh = new ThongTinKhachHang();
                                        ttKh.setMaKhachHang(rs.getString("MaKhachHang"));
                                        ttKh.setTenKhachHang(rs.getString("TenKhachHang"));
                                        ttKh.setCCCD(rs.getString("CCCD"));
                                        ttKh.setGioiTinh(rs.getBoolean("GioiTinh"));
                                        ttKh.setNgaySinh(rs.getDate("NgaySinh"));
                                        ttKh.setQuocTich(rs.getString("QuocTich"));
                                        ttKh.setDiaChi(rs.getString("DiaChi"));
                                        ttKh.setEmail(rs.getString("Email"));
                                        ttKh.setSDT(rs.getString("SDT"));
                                        lstKhachHang.add(ttKh);
                                }
                        } finally {
                                rs.getStatement().getConnection().close();
                        }
                } catch (Exception e) {
                        throw new RuntimeException();
                }
                return lstKhachHang;
        }

        public List<ThongTinKhachHang> SelectAll() {
                String sql = "select * from ThongTinKhachHang";
                return SelectBySQL(sql);
        }

        public ThongTinKhachHang SelectByID(String maKhachHang) {
                String sql = "select * from ThongTinKhachHang where MaKhachHang = ?";
                List<ThongTinKhachHang> lstKhachHang = SelectBySQL(sql, maKhachHang);
                return lstKhachHang.size() > 0 ? lstKhachHang.get(0) : null;
        }

        public List<ThongTinKhachHang> SelectByKeyword(String keyword) {
                String sql = "";
                if (keyword.trim().startsWith("KH")) {
                        sql = "select * from ThongTinKhachHang where MaKhachHang like ?";
                } else {
                        sql = "select * from ThongTinKhachHang where TenKhachHang like ?";
                }
                return SelectBySQL(sql, "%" + keyword + "%");
        }

        public List<Object[]> getListKH_NKH() {
                String sql = "{call sp_DanhSach_NhomKH_KH}";
                String[] cols = {
                        "MaNhomKhachHang",
                        "TenNhomKhachHang",
                        "TenDoan",
                        "MaKhachHang",
                        "TenKhachHang",
                        "CCCD",
                        "GioiTinh",
                        "QuocTich",
                        "SDT"
                };
                return JDBC.getListOfArray(sql, cols);
        }

        public List<Object[]> getListSort(int dk) {
                String sql = "{call  sp_sort_KH_NKH(?)}";
                String[] cols = {
                        "MaNhomKhachHang",
                        "TenNhomKhachHang",
                        "TenDoan",
                        "MaKhachHang",
                        "TenKhachHang",
                        "CCCD",
                        "GioiTinh",
                        "QuocTich",
                        "SDT"
                };
                return JDBC.getListOfArray(sql, cols, dk);

        }
}
