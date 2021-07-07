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
public class ThongTinKhachHang {

        private String maKhachHang;
        private String tenKhachHang;
        private String CCCD;
        private boolean gioiTinh;
        private Date ngaySinh;
        private String quocTich;
        private String diaChi;
        private String Email;
        private String SDT;

        public ThongTinKhachHang() {
        }

        public ThongTinKhachHang(String maKhachHang, String tenKhachHang, String CCCD, boolean gioiTinh, Date ngaySinh, String quocTich, String diaChi, String Email, String SDT) {
                this.maKhachHang = maKhachHang;
                this.tenKhachHang = tenKhachHang;
                this.CCCD = CCCD;
                this.gioiTinh = gioiTinh;
                this.ngaySinh = ngaySinh;
                this.quocTich = quocTich;
                this.diaChi = diaChi;
                this.Email = Email;
                this.SDT = SDT;
        }

        public String getMaKhachHang() {
                return maKhachHang;
        }

        public void setMaKhachHang(String maKhachHang) {
                this.maKhachHang = maKhachHang;
        }

        public String getTenKhachHang() {
                return tenKhachHang;
        }

        public void setTenKhachHang(String tenKhachHang) {
                this.tenKhachHang = tenKhachHang;
        }

        public String getCCCD() {
                return CCCD;
        }

        public void setCCCD(String CCCD) {
                this.CCCD = CCCD;
        }

        public boolean isGioiTinh() {
                return gioiTinh;
        }

        public void setGioiTinh(boolean gioiTinh) {
                this.gioiTinh = gioiTinh;
        }

        public Date getNgaySinh() {
                return ngaySinh;
        }

        public void setNgaySinh(Date ngaySinh) {
                this.ngaySinh = ngaySinh;
        }

        public String getQuocTich() {
                return quocTich;
        }

        public void setQuocTich(String quocTich) {
                this.quocTich = quocTich;
        }

        public String getDiaChi() {
                return diaChi;
        }

        public void setDiaChi(String diaChi) {
                this.diaChi = diaChi;
        }

        public String getEmail() {
                return Email;
        }

        public void setEmail(String Email) {
                this.Email = Email;
        }

        public String getSDT() {
                return SDT;
        }

        public void setSDT(String SDT) {
                this.SDT = SDT;
        }
}
