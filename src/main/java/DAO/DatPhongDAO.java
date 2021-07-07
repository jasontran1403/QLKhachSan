/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.DatPhong;
import Helper.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class DatPhongDAO {

        public void insert(DatPhong dp) {
                String sql = "insert into DatPhong (MaDatPhong, MaPhong, MaNhomKhachHang, MaKhachHang ,MaTaiKhoan) values  (?,?,?,?,?)";
                JDBC.update(sql,
                dp.getMaDatPhong(),
                dp.getMaPhong(),
                dp.getMaNhomKhachHang(),
                dp.getMaKhachHang(),
                dp.getMaTaiKhoan()
                );
        }

        public void update(DatPhong dp) {
                String sql = "update DatPhong set MaPhong = ?, MaNhomKhachHang = ?, MaKhachHang = ? where MaDatPhong = ?";
                JDBC.update(sql,
                dp.getMaPhong(),
                dp.getMaNhomKhachHang(),
                dp.getMaKhachHang(),
                dp.getMaDatPhong()
                );
        }

        public void delete(String maDatPhong) {
                String sql = "delete from DatPhong where  MaDatPhong = ?";
                JDBC.update(sql, maDatPhong);
        }

        public List<DatPhong> SelectBySQL(String sql, Object... args) {
                List<DatPhong> lstDatPhong = new ArrayList<>();
                try {
                        ResultSet rs = null;
                        try {
                                while (rs.next()) {
                                        DatPhong dp = new DatPhong();
                                        dp.setMaDatPhong(rs.getString("MaDatPhong"));
                                        dp.setMaPhong(rs.getString("MaPhong"));
                                        dp.setMaNhomKhachHang(rs.getString("MaNhomKhachHang"));
                                        dp.setMaKhachHang(rs.getString("MaKhachHang"));
                                        dp.setMaTaiKhoan(rs.getString("MaTaiKhoan"));
                                }
                        } finally {
                                rs.getStatement().getConnection().close();
                        }
                } catch (Exception e) {
                        throw new RuntimeException();
                }
                return lstDatPhong;
        }

        public List<DatPhong> SelectAll() {
                String sql = "select * from DatPhong";
                return SelectBySQL(sql);
        }

        public List<Object[]> getDanhSachDatPhong() {
                String sql = "{call sp_DanhSachDatPhong";
                String[] cols = {
                        "MaPhong",
                        "MaNhomKhachHang",
                        "TenDoan",
                        "MaKhachHang",
                        "MaTaiKhoan"
                };
                return JDBC.getListOfArray(sql, cols);
        }

        public List<Object[]> getDanhSachNhomKhachHang(String maNhomKhachHang) {
                String sql = "{call sp_DanhSachNhomKhachHang(?)}";
                String[] cols = {
                        "MaNhomKhachHang",
                        "MaKhachHang",
                        "TenKhachHang"
                };
                return JDBC.getListOfArray(sql, cols, maNhomKhachHang);
        }
}
