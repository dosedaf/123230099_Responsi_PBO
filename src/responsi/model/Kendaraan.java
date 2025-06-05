/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi.model;

/**
 *
 * @author Lab Informatika
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Kendaraan {
	private Connection conn;
	public String nama;
	public String plat;
	public String merk;
	public int durasi;

	public Kendaraan() {
		conn = ConnectDB.getConnection();
	}

	private int hitungTotalBiayaParkir(int durasi1) {
		int total = 0;

		if (durasi1 < 4) {
			total = 5000 * durasi;
		} else if(durasi1 > 5) {
			int sisa = this.durasi - 4;
			total = (5000 * 4) + (2000 * sisa);
		}

		return total;
	}

	public void tambahKendaraan(String nama, String plat, String merk, int durasi) {
		int total =  hitungTotalBiayaParkir(durasi);
		String query = "INSERT INTO kendaraan(nama, plat, merk, durasi, total) VALUES (?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, nama);
			stmt.setString(2, plat);
			stmt.setString(3, merk);
			stmt.setInt(4, durasi);
			stmt.setInt(5, total);
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Object[]> getAllKendaraan(){
		List<Object[]> data = new ArrayList<>();
		String query = "SELECT * FROM kendaraan";
		try(Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while(rs.next()) {
				Object[] row = new Object[]{
					rs.getInt("id"),
					rs.getString("nama"),
					rs.getString("plat"),
					rs.getString("merk"),
					rs.getInt("durasi"),
					rs.getInt("total"),
				};
				data.add(row);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	return data;
	}

	public void hapusKendaraan(int id) {
		String query = "DELETE FROM kendaraan WHERE id=?";
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateKendaraan(String nama, String plat, String merk, int durasi, int id) {
		int total =  hitungTotalBiayaParkir(durasi);
		String query = "UPDATE kendaraan set nama=?, plat=?, merk=?, durasi=?, total=? WHERE id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, nama);
			stmt.setString(2, plat);
			stmt.setString(3, merk);
			stmt.setInt(4, durasi);
			stmt.setInt(5, total);
			stmt.setInt(6, id);
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
