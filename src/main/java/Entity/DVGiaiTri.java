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
public class DVGiaiTri {

        private String maLoaiDVGiaiTri;
        private String tenLoaiDVGiaiTri;
        private double donGia;

        public DVGiaiTri() {
        }

        public DVGiaiTri(String maLoaiDVGiaiTri, String tenLoaiDVGiaiTri, double donGia) {
                this.maLoaiDVGiaiTri = maLoaiDVGiaiTri;
                this.tenLoaiDVGiaiTri = tenLoaiDVGiaiTri;
                this.donGia = donGia;
        }

        public String getMaLoaiDVGiaiTri() {
                return maLoaiDVGiaiTri;
        }

        public void setMaLoaiDVGiaiTri(String maLoaiDVGiaiTri) {
                this.maLoaiDVGiaiTri = maLoaiDVGiaiTri;
        }

        public String getTenLoaiDVGiaiTri() {
                return tenLoaiDVGiaiTri;
        }

        public void setTenLoaiDVGiaiTri(String tenLoaiDVGiaiTri) {
                this.tenLoaiDVGiaiTri = tenLoaiDVGiaiTri;
        }

        public double getDonGia() {
                return donGia;
        }

        public void setDonGia(double donGia) {
                this.donGia = donGia;
        }

}
