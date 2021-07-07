/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class DoThatLac {

        private String maDoThatLac;
        private String tenVatPham;
        private Date thoiGianTimThay;
        private int tinhTrang;
        private String moTa;
        private String maNhanVien;
        private String maPhong;

        public DoThatLac(String maDoThatLac, String tenVatPham, Date thoiGianTimThay, int tinhTrang, String moTa, String maNhanVien, String maPhong) {
                this.maDoThatLac = maDoThatLac;
                this.tenVatPham = tenVatPham;
                this.thoiGianTimThay = thoiGianTimThay;
                this.tinhTrang = tinhTrang;
                this.moTa = moTa;
                this.maNhanVien = maNhanVien;
                this.maPhong = maPhong;
        }

        public DoThatLac() {
        }

        public String getMaDoThatLac() {
                return maDoThatLac;
        }

        public void setMaDoThatLac(String maDoThatLac) {
                this.maDoThatLac = maDoThatLac;
        }

        public String getTenVatPham() {
                return tenVatPham;
        }

        public void setTenVatPham(String tenVatPham) {
                this.tenVatPham = tenVatPham;
        }

        public Date getThoiGianTimThay() {
                return thoiGianTimThay;
        }

        public void setThoiGianTimThay(Date thoiGianTimThay) {
                this.thoiGianTimThay = thoiGianTimThay;
        }

        public int getTinhTrang() {
                return tinhTrang;
        }

        public void setTinhTrang(int tinhTrang) {
                this.tinhTrang = tinhTrang;
        }

        public String getMoTa() {
                return moTa;
        }

        public void setMoTa(String moTa) {
                this.moTa = moTa;
        }

        public String getMaNhanVien() {
                return maNhanVien;
        }

        public void setMaNhanVien(String maNhanVien) {
                this.maNhanVien = maNhanVien;
        }

        public String getMaPhong() {
                return maPhong;
        }

        public void setMaPhong(String maPhong) {
                this.maPhong = maPhong;
        }

}
