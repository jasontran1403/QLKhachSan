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
public class DVSpa {

        private String maLoaiDVSpa;
        private String tenLoaiDVSpa;
        private double donGia;

        public DVSpa() {
        }

        public DVSpa(String maLoaiDVSpa, String tenLoaiDVSpa, double donGia) {
                this.maLoaiDVSpa = maLoaiDVSpa;
                this.tenLoaiDVSpa = tenLoaiDVSpa;
                this.donGia = donGia;
        }

        public String getMaLoaiDVSpa() {
                return maLoaiDVSpa;
        }

        public void setMaLoaiDVSpa(String maLoaiDVSpa) {
                this.maLoaiDVSpa = maLoaiDVSpa;
        }

        public String getTenLoaiDVSpa() {
                return tenLoaiDVSpa;
        }

        public void setTenLoaiDVSpa(String tenLoaiDVSpa) {
                this.tenLoaiDVSpa = tenLoaiDVSpa;
        }

        public double getDonGia() {
                return donGia;
        }

        public void setDonGia(double donGia) {
                this.donGia = donGia;
        }

}
