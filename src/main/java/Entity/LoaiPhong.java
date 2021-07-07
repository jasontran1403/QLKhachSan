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
public class LoaiPhong {

        private String maLoaiPhong;
        private String tenLoaiPhong;
        private int viTriPhong;
        private double donGiaLoaiPhong;

        public LoaiPhong() {
        }

        public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, int viTriPhong, double donGiaLoaiPhong) {
                this.maLoaiPhong = maLoaiPhong;
                this.tenLoaiPhong = tenLoaiPhong;
                this.viTriPhong = viTriPhong;
                this.donGiaLoaiPhong = donGiaLoaiPhong;
        }

        public String getMaLoaiPhong() {
                return maLoaiPhong;
        }

        public void setMaLoaiPhong(String maLoaiPhong) {
                this.maLoaiPhong = maLoaiPhong;
        }

        public String getTenLoaiPhong() {
                return tenLoaiPhong;
        }

        public void setTenLoaiPhong(String tenLoaiPhong) {
                this.tenLoaiPhong = tenLoaiPhong;
        }

        public int getViTriPhong() {
                return viTriPhong;
        }

        public void setViTriPhong(int viTriPhong) {
                this.viTriPhong = viTriPhong;
        }

        public double getDonGiaLoaiPhong() {
                return donGiaLoaiPhong;
        }

        public void setDonGiaLoaiPhong(double donGiaLoaiPhong) {
                this.donGiaLoaiPhong = donGiaLoaiPhong;
        }

}
