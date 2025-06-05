/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi.controller;

/**
 *
 * @author Lab Informatika
 */

import responsi.view.MainView;
import responsi.model.Kendaraan;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class KendaraanController {
    private MainView view;
    private Kendaraan model;

    public KendaraanController(MainView view, Kendaraan model) {
        this.view = view;
        this.model = model;

        loadTableData();

        view.getAddButton().addActionListener(e -> tambahData());
        view.getEditButton().addActionListener(e -> editData());
        view.getDeleteButton().addActionListener(e -> hapusData());
    }

    private void loadTableData() {
        DefaultTableModel tableModel = view.getTableModel();
        tableModel.setRowCount(0);
        for (Object[] row : model.getAllKendaraan()) {
            tableModel.addRow(row);
        }
    }

    private void tambahData() {
        String nama = view.getTxtNama().getText().trim();
        String plat = view.getTxtPlat().getText().trim();
        String merk = view.getTxtMerk().getText().trim();
        String durasiStr = view.getTxtDurasi().getText().trim();

        if (nama.isEmpty() | plat.isEmpty() | merk.isEmpty() | durasiStr.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Semua field harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int durasi = Integer.parseInt(durasiStr);

            if (durasi <= 0) {
                JOptionPane.showMessageDialog(view, "Durasi harus lebih dari 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            model.tambahKendaraan(nama, plat, merk, durasi);
            clearForm();
            loadTableData();

            JOptionPane.showMessageDialog(view, "Data berhasil ditambahkan");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Durasi harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editData() {
        int selected = view.getSelectedRowIndex();
        if (selected >= 0) {
            String nama = view.getTxtNama().getText().trim();
            String plat = view.getTxtPlat().getText().trim();
            String merk = view.getTxtMerk().getText().trim();
            String durasiStr = view.getTxtDurasi().getText().trim();

            if (nama.isEmpty() | plat.isEmpty() | merk.isEmpty() | durasiStr.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Semua field harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                int id = (int) view.getTableModel().getValueAt(selected, 0);
                int durasi = Integer.parseInt(durasiStr);

                if (durasi <= 0) {
                    JOptionPane.showMessageDialog(view, "Durasi harus lebih dari 0", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                model.updateKendaraan(nama, plat, merk, durasi, id);
                clearForm();
                loadTableData();

                JOptionPane.showMessageDialog(view, "Data berhasil diperbarui");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view, "Durasi harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void hapusData() {
        int selected = view.getSelectedRowIndex();
        if (selected >= 0) {
            int id = (int) view.getTableModel().getValueAt(selected, 0);
            int confirm = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus data ini?", "Konfirmasi",
                    JOptionPane.YES_NO_OPTION);
            model.hapusKendaraan(id);
            clearForm();
            loadTableData();
            JOptionPane.showMessageDialog(view, "Data Berhasil dihapus!");
        } else {
            JOptionPane.showMessageDialog(view, "Pilih dahulu data yang ingin dihapus!");
        }
    }

    private void clearForm() {
        view.getTxtNama().setText("");
        view.getTxtPlat().setText("");
        view.getTxtMerk().setText("");
        view.getTxtDurasi().setText("");
    }
}
