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
public class DichVu {

        private String maDichVu;
        private String maLoaiSpa;
        private String maLoaiDVNhaHang;
        private String maLoaiGiatUi;
        private String maLoaiDVGiaiTri;
        private String maMiniBar;
        private String hinhAnh;

        public DichVu() {
        }

        public DichVu(String maDichVu, String maLoaiSpa, String maLoaiDVNhaHang, String maLoaiGiatUi, String maLoaiDVGiaiTri, String maMiniBar, String hinhAnh) {
                this.maDichVu = maDichVu;
                this.maLoaiSpa = maLoaiSpa;
                this.maLoaiDVNhaHang = maLoaiDVNhaHang;
                this.maLoaiGiatUi = maLoaiGiatUi;
                this.maLoaiDVGiaiTri = maLoaiDVGiaiTri;
                this.maMiniBar = maMiniBar;
                this.hinhAnh = hinhAnh;
        }

        public String getMaDichVu() {
                return maDichVu;
        }

        public void setMaDichVu(String maDichVu) {
                this.maDichVu = maDichVu;
        }

        public String getMaLoaiSpa() {
                return maLoaiSpa;
        }

        public void setMaLoaiSpa(String maLoaiSpa) {
                this.maLoaiSpa = maLoaiSpa;
        }

        public String getMaLoaiDVNhaHang() {
                return maLoaiDVNhaHang;
        }

        public void setMaLoaiDVNhaHang(String maLoaiDVNhaHang) {
                this.maLoaiDVNhaHang = maLoaiDVNhaHang;
        }

        public String getMaLoaiGiatUi() {
                return maLoaiGiatUi;
        }

        public void setMaLoaiGiatUi(String maLoaiGiatUi) {
                this.maLoaiGiatUi = maLoaiGiatUi;
        }

        public String getMaLoaiDVGiaiTri() {
                return maLoaiDVGiaiTri;
        }

        public void setMaLoaiDVGiaiTri(String maLoaiDVGiaiTri) {
                this.maLoaiDVGiaiTri = maLoaiDVGiaiTri;
        }

        public String getMaMiniBar() {
                return maMiniBar;
        }

        public void setMaMiniBar(String maMiniBar) {
                this.maMiniBar = maMiniBar;
        }

        public String getHinhAnh() {
                return hinhAnh;
        }

        public void setHinhAnh(String hinhAnh) {
                this.hinhAnh = hinhAnh;
        }

}
