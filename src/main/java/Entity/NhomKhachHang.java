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
public class NhomKhachHang {

        private String maNhomKhachHang;
        private String maKhachHang;
        private String tenNhomKhachHang;
        private int soLuong;
        private String tenDoan;

        public NhomKhachHang() {
        }

        public NhomKhachHang(String maNhomKhachHang, String maKhachHang, String tenNhomKhachHang, int soLuong, String tenDoan) {
                this.maNhomKhachHang = maNhomKhachHang;
                this.maKhachHang = maKhachHang;
                this.tenNhomKhachHang = tenNhomKhachHang;
                this.soLuong = soLuong;
                this.tenDoan = tenDoan;
        }

        public String getMaNhomKhachHang() {
                return maNhomKhachHang;
        }

        public void setMaNhomKhachHang(String maNhomKhachHang) {
                this.maNhomKhachHang = maNhomKhachHang;
        }

        public String getMaKhachHang() {
                return maKhachHang;
        }

        public void setMaKhachHang(String maKhachHang) {
                this.maKhachHang = maKhachHang;
        }

        public String getTenNhomKhachHang() {
                return tenNhomKhachHang;
        }

        public void setTenNhomKhachHang(String tenNhomKhachHang) {
                this.tenNhomKhachHang = tenNhomKhachHang;
        }

        public int getSoLuong() {
                return soLuong;
        }

        public void setSoLuong(int soLuong) {
                this.soLuong = soLuong;
        }

        public String getTenDoan() {
                return tenDoan;
        }

        public void setTenDoan(String tenDoan) {
                this.tenDoan = tenDoan;
        }

}
