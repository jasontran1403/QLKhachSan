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
public class HoaDon {

        private String maHoaDon;
        private String maCTSDDV;
        private String maCTDP;
        private String maTaiKhoan;

        public HoaDon() {
        }

        public HoaDon(String maHoaDon, String maCTSDDV, String maCTDP, String maTaiKhoan) {
                this.maHoaDon = maHoaDon;
                this.maCTSDDV = maCTSDDV;
                this.maCTDP = maCTDP;
                this.maTaiKhoan = maTaiKhoan;
        }

        public String getMaHoaDon() {
                return maHoaDon;
        }

        public void setMaHoaDon(String maHoaDon) {
                this.maHoaDon = maHoaDon;
        }

        public String getMaCTSDDV() {
                return maCTSDDV;
        }

        public void setMaCTSDDV(String maCTSDDV) {
                this.maCTSDDV = maCTSDDV;
        }

        public String getMaCTDP() {
                return maCTDP;
        }

        public void setMaCTDP(String maCTDP) {
                this.maCTDP = maCTDP;
        }

        public String getMaTaiKhoan() {
                return maTaiKhoan;
        }

        public void setMaTaiKhoan(String maTaiKhoan) {
                this.maTaiKhoan = maTaiKhoan;
        }

}
