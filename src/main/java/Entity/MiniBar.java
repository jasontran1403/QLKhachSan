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
public class MiniBar {

        private String maMiniBar;
        private String tenSanPham;
        private double donGia;

        public MiniBar() {
        }

        public MiniBar(String maMiniBar, String tenSanPham, double donGia) {
                this.maMiniBar = maMiniBar;
                this.tenSanPham = tenSanPham;
                this.donGia = donGia;
        }

        public String getMaMiniBar() {
                return maMiniBar;
        }

        public void setMaMiniBar(String maMiniBar) {
                this.maMiniBar = maMiniBar;
        }

        public String getTenSanPham() {
                return tenSanPham;
        }

        public void setTenSanPham(String tenSanPham) {
                this.tenSanPham = tenSanPham;
        }

        public double getDonGia() {
                return donGia;
        }

        public void setDonGia(double donGia) {
                this.donGia = donGia;
        }

}
