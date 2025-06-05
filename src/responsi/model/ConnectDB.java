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

public class ConnectDB {
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/99pbo";
		String username = "root";
		String password = "";

		try{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);

			System.out.println("Berhasil");
		}  catch(SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	
}
