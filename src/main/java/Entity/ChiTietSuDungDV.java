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
public class ChiTietSuDungDV {

        private String maCTSDDV;
        private String tenDichVu;
        private int soLuong;
        private String maDichVu;

        public ChiTietSuDungDV() {
        }

        public ChiTietSuDungDV(String maCTSDDV, String tenDichVu, int soLuong, String maDichVu) {
                this.maCTSDDV = maCTSDDV;
                this.tenDichVu = tenDichVu;
                this.soLuong = soLuong;
                this.maDichVu = maDichVu;
        }

        public String getMaCTSDDV() {
                return maCTSDDV;
        }

        public void setMaCTSDDV(String maCTSDDV) {
                this.maCTSDDV = maCTSDDV;
        }

        public String getTenDichVu() {
                return tenDichVu;
        }

        public void setTenDichVu(String tenDichVu) {
                this.tenDichVu = tenDichVu;
        }

        public int getSoLuong() {
                return soLuong;
        }

        public void setSoLuong(int soLuong) {
                this.soLuong = soLuong;
        }

        public String getMaDichVu() {
                return maDichVu;
        }

        public void setMaDichVu(String maDichVu) {
                this.maDichVu = maDichVu;
        }

}
