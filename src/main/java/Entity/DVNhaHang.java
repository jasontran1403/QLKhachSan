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
public class DVNhaHang {

        private String maLoaiDVNhaHang;
        private String tenLoaiDVNhaHang;
        private double donGia;

        public DVNhaHang() {
        }

        public DVNhaHang(String maLoaiDVNhaHang, String tenLoaiDVNhaHang, double donGia) {
                this.maLoaiDVNhaHang = maLoaiDVNhaHang;
                this.tenLoaiDVNhaHang = tenLoaiDVNhaHang;
                this.donGia = donGia;
        }

        public String getMaLoaiDVNhaHang() {
                return maLoaiDVNhaHang;
        }

        public void setMaLoaiDVNhaHang(String maLoaiDVNhaHang) {
                this.maLoaiDVNhaHang = maLoaiDVNhaHang;
        }

        public String getTenLoaiDVNhaHang() {
                return tenLoaiDVNhaHang;
        }

        public void setTenLoaiDVNhaHang(String tenLoaiDVNhaHang) {
                this.tenLoaiDVNhaHang = tenLoaiDVNhaHang;
        }

        public double getDonGia() {
                return donGia;
        }

        public void setDonGia(double donGia) {
                this.donGia = donGia;
        }

}
