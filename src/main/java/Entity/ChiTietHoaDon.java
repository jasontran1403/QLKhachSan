/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class ChiTietHoaDon {

        private String maCTHoaDon;
        private String maHoaDon;
        private double thanhTien;

        public ChiTietHoaDon() {
        }

        public ChiTietHoaDon(String maCTHoaDon, String maHoaDon, double thanhTien) {
                this.maCTHoaDon = maCTHoaDon;
                this.maHoaDon = maHoaDon;
                this.thanhTien = thanhTien;
        }

        public String getMaCTHoaDon() {
                return maCTHoaDon;
        }

        public void setMaCTHoaDon(String maCTHoaDon) {
                this.maCTHoaDon = maCTHoaDon;
        }

        public String getMaHoaDon() {
                return maHoaDon;
        }

        public void setMaHoaDon(String maHoaDon) {
                this.maHoaDon = maHoaDon;
        }

        public double getThanhTien() {
                return thanhTien;
        }

        public void setThanhTien(double thanhTien) {
                this.thanhTien = thanhTien;
        }

}
