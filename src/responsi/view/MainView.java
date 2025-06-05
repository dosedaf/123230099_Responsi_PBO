/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi.view;

/**
 *
 * @author Lab Informatika
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView extends JFrame {
	private JTable table;
	private DefaultTableModel tableModel;

	private JTextField txtNama, txtPlat, txtMerk, txtDurasi;
	private JButton addBtn, editBtn, deleteBtn;
	private int selectedRowIndex = -1;

	public MainView() {
		setTitle("Aplkasi Pembantu Parkir");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		txtNama = new JTextField();
		txtPlat = new JTextField();
		txtMerk = new JTextField();
		txtDurasi = new JTextField();

		addBtn = new JButton("Tambah");
		editBtn = new JButton("Edit");
		deleteBtn = new JButton("Delete");

		JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
		formPanel.add(new JLabel("Nama Pemilik"));
		formPanel.add(txtNama);
		formPanel.add(new JLabel("Nomor Plat"));
		formPanel.add(txtPlat);
		formPanel.add(new JLabel("Merk Kendaraan"));
		formPanel.add(txtMerk);
		formPanel.add(new JLabel("Durasi Parkir"));
		formPanel.add(txtDurasi);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));
		buttonPanel.add(addBtn);
		buttonPanel.add(editBtn);
		buttonPanel.add(deleteBtn);

		JPanel topPanel = new JPanel(new BorderLayout(0, 10));
		topPanel.setBorder(BorderFactory.createTitledBorder("Form Transaksi"));
		topPanel.add(formPanel, BorderLayout.CENTER);
		topPanel.add(buttonPanel, BorderLayout.SOUTH);

		add(topPanel, BorderLayout.NORTH);

		tableModel = new DefaultTableModel(new Object[] {
				"ID", "Nama Pemilik", "Plat Nomor", "Merk Kendaraan", "Durasi Parkir"
		}, 0);

		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);

		add(scrollPane, BorderLayout.CENTER);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				selectedRowIndex = table.getSelectedRow();
				if (selectedRowIndex >= 0) {
					{
						txtNama.setText(tableModel.getValueAt(selectedRowIndex, 1).toString());
						txtPlat.setText(tableModel.getValueAt(selectedRowIndex, 2).toString());
						txtMerk.setText(tableModel.getValueAt(selectedRowIndex, 3).toString());
						txtDurasi.setText(tableModel.getValueAt(selectedRowIndex, 4).toString());
					}
				}
				;
			}
		});
	}

	public JButton getAddButton() {
		return addBtn;
	}

	public JButton getEditButton() {
		return editBtn;
	}

	public JButton getDeleteButton() {
		return deleteBtn;
	}

	public JTextField getTxtNama() {
		return txtNama;
	}

	public JTextField getTxtPlat() {
		return txtPlat;
	}

	public JTextField getTxtMerk() {
		return txtMerk;
	}

	public JTextField getTxtDurasi() {
		return txtDurasi;
	}

	public int getSelectedRowIndex() {
		return selectedRowIndex;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}
}
