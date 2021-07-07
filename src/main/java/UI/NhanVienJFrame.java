/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.NhanVienDAO;
import Entity.NhanVien;
import Helper.Auth;
import Helper.MsgBox;
import Helper.xDate;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class NhanVienJFrame extends javax.swing.JDialog {

        /**
         * Creates new form NhanVienJFrame
         */
        public NhanVienJFrame(java.awt.Frame parent, boolean modal) {
                super(parent, modal);
                initComponents();
                init();
        }

        void init() {
                setLocationRelativeTo(null);
                setResizable(false);
                initCbo();
                loadToTable();

        }

        void initCbo() {
                cboChucVu.removeAllItems();
                String[] data = {
                        "Admin",
                        "Lễ Tân",
                        "Kinh Doanh",
                        "Kế Toán",
                        "Nhân Sự"
                };
                for (String str : data) {
                        cboChucVu.addItem(str);
                }
                cboChucVu.setRenderer(new DefaultListCellRenderer() {
                        public Component getListCellRendererComponent(JList jlist, Object o, int i, boolean b, boolean b1) {
                                JLabel rendrlbl = (JLabel) super.getListCellRendererComponent(jlist, o, i, b, b1);
                                rendrlbl.setHorizontalAlignment(SwingConstants.CENTER);
                                return rendrlbl;
                        }
                });
        }

        boolean checkForm() {
                // kiểm tra trống mã nhân viên
                if (txtMaNhanVien.getText().trim().isEmpty()) {
                        MsgBox.alert(this, "Nhập mã nhân viên !");
                        txtMaNhanVien.requestFocus();
                        return false;
                }

                // kiểm tra trống tên
                if (txtTenNhanVien.getText().trim().isEmpty()) {
                        MsgBox.alert(this, "Nhập tên nhân viên !");
                        txtTenNhanVien.requestFocus();
                        return false;
                }

                // kiểm tra trống CCCD
                if (txtCCCD.getText().trim().isEmpty()) {
                        MsgBox.alert(this, "Nhập CCCD !");
                        txtCCCD.requestFocus();
                        return false;
                }

                // kiểm tra trống ngày sinh
                if (txtNgaySinh.getText().trim().isEmpty()) {
                        MsgBox.alert(this, "Nhập ngày sinh !");
                        txtNgaySinh.requestFocus();
                        return false;
                }

                // kiểm tra trống giới tính
                if (!rdoNam.isSelected() && !rdoNu.isSelected()) {
                        MsgBox.alert(this, "Chọn giới tính !");
                        return false;
                }

                // kiểm tra trống  Email
                if (txtEmail.getText().trim().isEmpty()) {
                        MsgBox.alert(this, "Nhập Email !");
                        txtEmail.requestFocus();
                        return false;
                }
                // kiểm tra định dạng email
//                String email = "\\w+@\\w+{\\.\\w+}{1,2}$";
                String email = "^[A-Za-z0-9+_.-]+@(.+)$";
                if (!txtEmail.getText().matches(email)) {
                        MsgBox.alert(this, "Sai định dạng email !");
                        txtEmail.requestFocus();
                        return false;
                }

                //Kiểm tra trống SĐT
                if (txtSoDienThoai.getText().trim().isEmpty()) {
                        MsgBox.alert(this, "Nhập số điện thoại !");
                        txtSoDienThoai.requestFocus();
                        return false;
                }
                // kiểm tra định dạng SĐT
                if (!txtSoDienThoai.getText().matches("0\\d{9,10}")) {
                        MsgBox.alert(this, "Sai định dạng số điện thoại !");
                        txtSoDienThoai.requestFocus();
                        return false;
                }

                // không cần kiểm tra chức vụ (mặc định vào là admin)
                // kiểm tra trống địa chỉ
                if (txtDiaChi.getText().trim().isEmpty()) {
                        MsgBox.alert(this, "Nhập địa chỉ !");
                        txtDiaChi.requestFocus();
                        return false;
                }

                // đúng tất cả định dạng
                return true;
        }

        NhanVienDAO nvDAO = new NhanVienDAO();
        int tableRow = -1;

        void loadToTable() {
                DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
                model.setRowCount(0);
                String keyword = txtTimKiem.getText();
                List<NhanVien> lstNhanVien = nvDAO.SelectByKeyWord(keyword);
                for (NhanVien nv : lstNhanVien) {
                        String gt = nv.isGioiTinh() ? "Nam" : "Nữ";
                        Object[] row = {
                                nv.getMaNhanVien(),
                                nv.getTenNhanVien(),
                                nv.getCCCD(),
                                gt,
                                nv.getEmail(),
                                nv.getSDT(),
                                nv.getChucVu()
                        };
                        model.addRow(row);
                }
        }

        void edit() {
                String maNV = (String) tblNhanVien.getValueAt(tableRow, 0);
                NhanVien nv = nvDAO.selectByID(maNV);
                setForm(nv);
        }

        void setForm(NhanVien nv) {
                txtMaNhanVien.setText(nv.getMaNhanVien());
                txtTenNhanVien.setText(nv.getTenNhanVien());
                txtCCCD.setText(nv.getCCCD());
                txtNgaySinh.setText(xDate.dateToString(nv.getNgaySinh(), "dd/MM/yyyy"));
                rdoNam.setSelected(nv.isGioiTinh());
                rdoNu.setSelected(!nv.isGioiTinh());
                txtEmail.setText(nv.getEmail());
                txtSoDienThoai.setText(nv.getSDT());
                cboChucVu.setSelectedItem(nv.getChucVu());
                txtDiaChi.setText(nv.getDiaChi());
        }

        NhanVien getForm() {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(txtMaNhanVien.getText());
                nv.setTenNhanVien(txtTenNhanVien.getText());
                nv.setCCCD(txtCCCD.getText());
                nv.setNgaySinh(xDate.stringToDate(txtNgaySinh.getText(), "dd/MM/yyyy"));
//                nv.setNgaySinh(xDate.stringToDate(txtNgaySinh.getText(), "yyyy/MM/dd"));
                nv.setGioiTinh(rdoNam.isSelected());
                nv.setEmail(txtEmail.getText());
                nv.setSDT(txtSoDienThoai.getText());
                nv.setDiaChi(txtDiaChi.getText());
                nv.setChucVu(cboChucVu.getSelectedItem().toString());
                return nv;
        }

        void clearForm() {
                NhanVien nv = new NhanVien();
                setForm(nv);
                txtNgaySinh.setText("");
                cboChucVu.setSelectedIndex(0);
                buttonGroup1.clearSelection();
        }

        void insert() {
                if (!checkForm()) {
                        return;
                } else {
                        NhanVien nv = getForm();
                        try {
                                nvDAO.insert(nv);
                                loadToTable();
                                clearForm();
                                MsgBox.alert(this, "Thêm nhân viên thành công !");
                        } catch (Exception e) {
                                MsgBox.alert(this, "Thêm nhân viên thất bại !");
                        }
                }
        }

        void update() {
                if (!checkForm()) {
                        return;
                } else {
                        NhanVien nv = getForm();
                        try {
                                nvDAO.update(nv);
                                loadToTable();
                                clearForm();
                                MsgBox.alert(this, "Cập nhật nhân viên thành công !");
                        } catch (Exception e) {
//                                e.printStackTrace();
                                MsgBox.alert(this, "Cập nhật nhân viên thất bại !");
                        }
                }
        }

        void delete() {
                if (txtMaNhanVien.getText().trim().isEmpty()) {
                        MsgBox.alert(this, "Chọn nhân viên cần xoá !");
                        return;
                }
                String maNV = txtMaNhanVien.getText();

                if (maNV.equalsIgnoreCase(Auth.user.getMaNhanVien())) {
                        MsgBox.alert(this, "Không thể tự xoá !");
                        return;
                }

                if (MsgBox.confirm(this, "Xác nhận xoá !")) {
                        try {
                                nvDAO.delete(maNV);
                                loadToTable();
                                clearForm();
                                MsgBox.alert(this, "Xoá thành công !");
                        } catch (Exception e) {
                                MsgBox.alert(this, "Xoá thất bại !");
                        }
                }
        }

        /**
         * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                buttonGroup1 = new javax.swing.ButtonGroup();
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                jLabel7 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                txtMaNhanVien = new javax.swing.JTextField();
                txtTenNhanVien = new javax.swing.JTextField();
                txtCCCD = new javax.swing.JTextField();
                txtNgaySinh = new javax.swing.JTextField();
                txtEmail = new javax.swing.JTextField();
                txtSoDienThoai = new javax.swing.JTextField();
                jScrollPane2 = new javax.swing.JScrollPane();
                txtDiaChi = new javax.swing.JTextArea();
                rdoNam = new javax.swing.JRadioButton();
                rdoNu = new javax.swing.JRadioButton();
                btnThem = new javax.swing.JButton();
                btnXoa = new javax.swing.JButton();
                btnSua = new javax.swing.JButton();
                cboChucVu = new javax.swing.JComboBox<>();
                btnClear = new javax.swing.JButton();
                jPanel2 = new javax.swing.JPanel();
                txtTimKiem = new javax.swing.JTextField();
                jLabel11 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                tblNhanVien = new javax.swing.JTable();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Nhân Viên");
                setResizable(false);

                jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(null));

                jLabel1.setText("Mã nhân viên");

                jLabel2.setText("Tên nhân viên");

                jLabel3.setText("CCCD");

                jLabel4.setText("Ngày sinh");

                jLabel5.setText("Giới tính");

                jLabel6.setText("Email");

                jLabel7.setText("Số điện thoại");

                jLabel8.setText("Chức vụ");

                jLabel9.setText("Địa chỉ");

                txtDiaChi.setColumns(20);
                txtDiaChi.setRows(5);
                jScrollPane2.setViewportView(txtDiaChi);

                buttonGroup1.add(rdoNam);
                rdoNam.setText("Nam");

                buttonGroup1.add(rdoNu);
                rdoNu.setText("Nữ");

                btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_person_1_32_black.png"))); // NOI18N
                btnThem.setText("Thêm");
                btnThem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnThemActionPerformed(evt);
                        }
                });

                btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_person_1_24.png"))); // NOI18N
                btnXoa.setText("Xóa");
                btnXoa.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnXoaActionPerformed(evt);
                        }
                });

                btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit_person_24.png"))); // NOI18N
                btnSua.setText("Sửa");
                btnSua.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSuaActionPerformed(evt);
                        }
                });

                cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                btnClear.setText("Clear");
                btnClear.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnClearActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel1)
                                                                                        .addComponent(jLabel5)
                                                                                        .addComponent(jLabel8)
                                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGap(18, 18, Short.MAX_VALUE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGap(24, 24, 24))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(btnClear)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(txtSoDienThoai)
                                                                        .addComponent(txtEmail)
                                                                        .addComponent(txtMaNhanVien)
                                                                        .addComponent(txtTenNhanVien)
                                                                        .addComponent(txtCCCD)
                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(btnThem)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(rdoNam)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(rdoNu)))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(rdoNam)
                                        .addComponent(rdoNu))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnClear))
                                .addContainerGap(30, Short.MAX_VALUE))
                );

                jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(null));

                txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyReleased(java.awt.event.KeyEvent evt) {
                                txtTimKiemKeyReleased(evt);
                        }
                });

                jLabel11.setText("Tìm kiếm");

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiem)
                                .addContainerGap())
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                .addContainerGap(18, Short.MAX_VALUE))
                );

                tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null}
                        },
                        new String [] {
                                "Mã nhân viên", "Tên nhân viên", "CCCD", "Giới tính", "Email", "Số điện thoại", "Chức vụ"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false, false, false, false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                tblNhanVienMouseClicked(evt);
                        }
                });
                jScrollPane1.setViewportView(tblNhanVien);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
                // TODO add your handling code here:
                loadToTable();
        }//GEN-LAST:event_txtTimKiemKeyReleased

        private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
                // TODO add your handling code here:
                if (evt.getClickCount() == 2) {
                        tableRow = tblNhanVien.getSelectedRow();
                        edit();
                }
        }//GEN-LAST:event_tblNhanVienMouseClicked

        private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
                // TODO add your handling code here:
                insert();
        }//GEN-LAST:event_btnThemActionPerformed

        private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
                // TODO add your handling code here:
                delete();
        }//GEN-LAST:event_btnXoaActionPerformed

        private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
                // TODO add your handling code here:
                update();
        }//GEN-LAST:event_btnSuaActionPerformed

        private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
                // TODO add your handling code here:
                clearForm();
        }//GEN-LAST:event_btnClearActionPerformed

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                /* Set the Nimbus look and feel */
                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
                /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                NhanVienJFrame dialog = new NhanVienJFrame(new javax.swing.JFrame(), true);
                                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                                        @Override
                                        public void windowClosing(java.awt.event.WindowEvent e) {
                                                System.exit(0);
                                        }
                                });
                                dialog.setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnClear;
        private javax.swing.JButton btnSua;
        private javax.swing.JButton btnThem;
        private javax.swing.JButton btnXoa;
        private javax.swing.ButtonGroup buttonGroup1;
        private javax.swing.JComboBox<String> cboChucVu;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JRadioButton rdoNam;
        private javax.swing.JRadioButton rdoNu;
        private javax.swing.JTable tblNhanVien;
        private javax.swing.JTextField txtCCCD;
        private javax.swing.JTextArea txtDiaChi;
        private javax.swing.JTextField txtEmail;
        private javax.swing.JTextField txtMaNhanVien;
        private javax.swing.JTextField txtNgaySinh;
        private javax.swing.JTextField txtSoDienThoai;
        private javax.swing.JTextField txtTenNhanVien;
        private javax.swing.JTextField txtTimKiem;
        // End of variables declaration//GEN-END:variables
}
