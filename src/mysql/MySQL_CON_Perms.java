package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL_CON_Perms {

	
	public static String host = "localhost";
	public static String port = "3306";
	public static String database = "PlayNayz";
	public static String username = "admin";
	public static String password = "5TnLHcCJQFUx(QuM";
	public static Connection con;
	
	public static void connect(){
		if(!isConnected()){
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useJDBCCompliantTimezoneShift=true&&serverTimezone=UTC&&useUnicode=true&autoReconnect=true",username, password);
				System.out.println("[MySQL-Perms] Die Verbindung wurde aufgebaut");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void disconnect(){
		if(isConnected()){
			try {
				con.close();
				System.out.println("[MySQL-Perms] Die Verbindung wurde getrennt");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isConnected(){
		return (con == null ? false: true);
	}
	
	public static Connection getConnection(){
		return con;
	}
	
	public static ResultSet getResult(String qry) {
		if(isConnected()) {
			try {
				return con.createStatement().executeQuery(qry);
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	
	public static void update(String qry) {
		if(isConnected()) {
			try {
				con.createStatement().executeUpdate(qry);
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
