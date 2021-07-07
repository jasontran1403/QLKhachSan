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
public class DatPhong {

        private String maDatPhong;
        private String maPhong;
        private String maNhomKhachHang;
        private String maTaiKhoan;
        private String maKhachHang;

        public DatPhong() {
        }

        public DatPhong(String maDatPhong, String maPhong, String maNhomKhachHang, String maTaiKhoan, String maKhachHang) {
                this.maDatPhong = maDatPhong;
                this.maPhong = maPhong;
                this.maNhomKhachHang = maNhomKhachHang;
                this.maTaiKhoan = maTaiKhoan;
                this.maKhachHang = maKhachHang;
        }

        public String getMaDatPhong() {
                return maDatPhong;
        }

        public void setMaDatPhong(String maDatPhong) {
                this.maDatPhong = maDatPhong;
        }

        public String getMaPhong() {
                return maPhong;
        }

        public void setMaPhong(String maPhong) {
                this.maPhong = maPhong;
        }

        public String getMaNhomKhachHang() {
                return maNhomKhachHang;
        }

        public void setMaNhomKhachHang(String maNhomKhachHang) {
                this.maNhomKhachHang = maNhomKhachHang;
        }

        public String getMaTaiKhoan() {
                return maTaiKhoan;
        }

        public void setMaTaiKhoan(String maTaiKhoan) {
                this.maTaiKhoan = maTaiKhoan;
        }

        public String getMaKhachHang() {
                return maKhachHang;
        }

        public void setMaKhachHang(String maKhachHang) {
                this.maKhachHang = maKhachHang;
        }

}
