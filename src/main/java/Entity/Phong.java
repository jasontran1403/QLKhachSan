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
public class Phong {

        private String maPhong;
        private String tenPhong;
        private int tinhTrangPhong;
        private String maLoaiPhong;

        public Phong() {
        }

        public Phong(String maPhong, String tenPhong, int tinhTrangPhong, String maLoaiPhong) {
                this.maPhong = maPhong;
                this.tenPhong = tenPhong;
                this.tinhTrangPhong = tinhTrangPhong;
                this.maLoaiPhong = maLoaiPhong;
        }

        public String getMaPhong() {
                return maPhong;
        }

        public void setMaPhong(String maPhong) {
                this.maPhong = maPhong;
        }

        public String getTenPhong() {
                return tenPhong;
        }

        public void setTenPhong(String tenPhong) {
                this.tenPhong = tenPhong;
        }

        public int getTinhTrangPhong() {
                return tinhTrangPhong;
        }

        public void setTinhTrangPhong(int tinhTrangPhong) {
                this.tinhTrangPhong = tinhTrangPhong;
        }

        public String getMaLoaiPhong() {
                return maLoaiPhong;
        }

        public void setMaLoaiPhong(String maLoaiPhong) {
                this.maLoaiPhong = maLoaiPhong;
        }

}
