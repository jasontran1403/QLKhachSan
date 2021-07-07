/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Helper.xDate;
import java.util.Date;

/**
 *
 * @author Tran Trung Nghia <PS14820>
 */
public class NhanVien {
        
        private String maNhanVien;
        private String tenNhanVien;
        private String CCCD;
        private boolean gioiTinh;
        private Date ngaySinh = xDate.addDays(new Date(), -365 * 20);
        private String diaChi;
        private String Email;
        private String SDT;
        private String chucVu;
        
        public NhanVien() {
        }
        
        public NhanVien(String maNhanVien, String tenNhanVien, String CCCD, boolean gioiTinh, Date ngaySinh, String diaChi, String Email, String SDT, String chucVu) {
                this.maNhanVien = maNhanVien;
                this.tenNhanVien = tenNhanVien;
                this.CCCD = CCCD;
                this.gioiTinh = gioiTinh;
                this.ngaySinh = ngaySinh;
                this.diaChi = diaChi;
                this.Email = Email;
                this.SDT = SDT;
                this.chucVu = chucVu;
        }
        
        public String getMaNhanVien() {
                return maNhanVien;
        }
        
        public void setMaNhanVien(String maNhanVien) {
                this.maNhanVien = maNhanVien;
        }
        
        public String getTenNhanVien() {
                return tenNhanVien;
        }
        
        public void setTenNhanVien(String tenNhanVien) {
                this.tenNhanVien = tenNhanVien;
        }
        
        public String getCCCD() {
                return CCCD;
        }
        
        public void setCCCD(String CCCD) {
                this.CCCD = CCCD;
        }
        
        public boolean isGioiTinh() {
                return gioiTinh;
        }
        
        public void setGioiTinh(boolean gioiTinh) {
                this.gioiTinh = gioiTinh;
        }
        
        public Date getNgaySinh() {
                return ngaySinh;
        }
        
        public void setNgaySinh(Date ngaySinh) {
                this.ngaySinh = ngaySinh;
        }
        
        public String getDiaChi() {
                return diaChi;
        }
        
        public void setDiaChi(String diaChi) {
                this.diaChi = diaChi;
        }
        
        public String getEmail() {
                return Email;
        }
        
        public void setEmail(String Email) {
                this.Email = Email;
        }
        
        public String getSDT() {
                return SDT;
        }
        
        public void setSDT(String SDT) {
                this.SDT = SDT;
        }
        
        public String getChucVu() {
                return chucVu;
        }
        
        public void setChucVu(String chucVu) {
                this.chucVu = chucVu;
        }
        
}
