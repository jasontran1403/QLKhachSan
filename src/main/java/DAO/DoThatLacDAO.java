/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.DoThatLac;
import Helper.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class DoThatLacDAO {

        public void insert(DoThatLac dtl) {
                String sql = "insert into DoThatLac (MaDoThatLac, TenVatPham, ThoiGianTimThay, TinhTrang, MoTa, MaNhanVien, MaPhong) values  (?,?,?,?,?,?,?)";
                JDBC.update(sql,
                dtl.getMaDoThatLac(),
                dtl.getTenVatPham(),
                dtl.getThoiGianTimThay(),
                dtl.getTinhTrang(),
                dtl.getMoTa(),
                dtl.getMaNhanVien(),
                dtl.getMaPhong()
                );
        }

        public void update(DoThatLac dtl) {
                String sql = "update DoThatLac set TenVatPham = ?, ThoiGianTimThay = ?, TinhTrang = ?, MoTa = ?, MaNhanVien = ?, MaPhong = ? where MaDoThatLac = ?";
                JDBC.update(sql,
                dtl.getTenVatPham(),
                dtl.getThoiGianTimThay(),
                dtl.getTinhTrang(),
                dtl.getMoTa(),
                dtl.getMaNhanVien(),
                dtl.getMaPhong(),
                dtl.getMaDoThatLac()
                );
        }

        public List<DoThatLac> SelectBySQL(String sql, Object... args) {
                List<DoThatLac> lstDoThatLac = new ArrayList<>();
                try {
                        ResultSet rs = null;
                        try {
                                rs = JDBC.query(sql, args);
                                while (rs.next()) {
                                        DoThatLac dtl = new DoThatLac();
                                        dtl.setMaDoThatLac(rs.getString("MaDoThatLac"));
                                        dtl.setTenVatPham(rs.getString("TenVatPham"));
                                        dtl.setThoiGianTimThay(rs.getDate("ThoiGianTimThay"));
                                        dtl.setTinhTrang(rs.getInt("TinhTrang"));
                                        dtl.setMoTa(rs.getString("MoTa"));
                                        dtl.setMaNhanVien(rs.getString("MaNhanVien"));
                                        dtl.setMaPhong(rs.getString("MaPhong"));
                                        lstDoThatLac.add(dtl);
                                }
                        } finally {
                                rs.getStatement().getConnection().close();
                        }
                } catch (Exception e) {
                        throw new RuntimeException();
                }
                return lstDoThatLac;
        }

        public List<DoThatLac> SelectAll() {
                String sql = "select * from DoThatLac";
                return SelectBySQL(sql);
        }

        public DoThatLac SelecByID(String maDoThatLac) {
                String sql = "select * from DoThatLac where MaDoThatLac = ?";
                List<DoThatLac> lst = SelectBySQL(sql, maDoThatLac);
                return lst.size() > 0 ? lst.get(0) : null;
        }
}
