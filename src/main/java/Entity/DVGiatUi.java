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
public class DVGiatUi {

        private String maLoaiDVGiatUi;
        private String tenLoaiDVGiatUi;
        private double donGia;

        public DVGiatUi() {
        }

        public DVGiatUi(String maLoaiDVGiatUi, String tenLoaiDVGiatUi, double donGia) {
                this.maLoaiDVGiatUi = maLoaiDVGiatUi;
                this.tenLoaiDVGiatUi = tenLoaiDVGiatUi;
                this.donGia = donGia;
        }

        public String getMaLoaiDVGiatUi() {
                return maLoaiDVGiatUi;
        }

        public void setMaLoaiDVGiatUi(String maLoaiDVGiatUi) {
                this.maLoaiDVGiatUi = maLoaiDVGiatUi;
        }

        public String getTenLoaiDVGiatUi() {
                return tenLoaiDVGiatUi;
        }

        public void setTenLoaiDVGiatUi(String tenLoaiDVGiatUi) {
                this.tenLoaiDVGiatUi = tenLoaiDVGiatUi;
        }

        public double getDonGia() {
                return donGia;
        }

        public void setDonGia(double donGia) {
                this.donGia = donGia;
        }

}
