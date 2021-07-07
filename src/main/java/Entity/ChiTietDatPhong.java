/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class ChiTietDatPhong {

        private String maCTDP;
        private Date ngayDatPhong;
        private Date ngayTraPhong;
        private String maDatPhong;

        public ChiTietDatPhong() {
        }

        public ChiTietDatPhong(String maCTDP, Date ngayDatPhong, Date ngayTraPhong, String maDatPhong) {
                this.maCTDP = maCTDP;
                this.ngayDatPhong = ngayDatPhong;
                this.ngayTraPhong = ngayTraPhong;
                this.maDatPhong = maDatPhong;
        }

        public String getMaCTDP() {
                return maCTDP;
        }

        public void setMaCTDP(String maCTDP) {
                this.maCTDP = maCTDP;
        }

        public Date getNgayDatPhong() {
                return ngayDatPhong;
        }

        public void setNgayDatPhong(Date ngayDatPhong) {
                this.ngayDatPhong = ngayDatPhong;
        }

        public Date getNgayTraPhong() {
                return ngayTraPhong;
        }

        public void setNgayTraPhong(Date ngayTraPhong) {
                this.ngayTraPhong = ngayTraPhong;
        }

        public String getMaDatPhong() {
                return maDatPhong;
        }

        public void setMaDatPhong(String maDatPhong) {
                this.maDatPhong = maDatPhong;
        }

}
