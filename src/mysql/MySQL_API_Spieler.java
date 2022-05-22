package mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL_API_Spieler {
	
	public static String playerUUID(String displayname) {
		ResultSet rs = MySQL_CON_Spieler.getResult("SELECT * FROM Spieler WHERE Displayname='"+displayname+"'");
		try {
			if(rs.next()) {
				return rs.getString("UUID");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return "null";
	}
	
	public static int playerNick(String displayname) {
		ResultSet rs = MySQL_CON_Spieler.getResult("SELECT * FROM Spieler WHERE Displayname='"+displayname+"'");
		try {
			if(rs.next()) {
				return rs.getInt("AutoNick");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	public static void setPlayerNick(String displayname, int nick) {
		MySQL_CON_Spieler.update("UPDATE Spieler SET AutoNick = '"+nick+"'  WHERE Displayname='"+displayname+"'");
	}
	
	public static void setCoinbooster(String displayname, int count) {
		MySQL_CON_Spieler.update("UPDATE Spieler SET CoinBooster = '"+count+"'  WHERE Displayname='"+displayname+"'");
	}
	
	public static int getCoinsbooster(String displayname) {
		ResultSet rs = MySQL_CON_Spieler.getResult("SELECT * FROM Spieler WHERE Displayname='"+displayname+"'");
		try {
			if(rs.next()) {
				return rs.getInt("CoinBooster");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}
}
