package mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ScoreboardManager;

public class CoinsAPI {
	
	public static int getCoins(String uuid) {
		ResultSet rs = MySQL_CON_Spieler.getResult("SELECT * FROM Spieler WHERE UUID='"+uuid+"'");
		try {
			if(rs.next()) {
				return rs.getInt("Coins");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	
	public static void setCoins(String uuid, int coins) {
		MySQL_CON_Spieler.update("UPDATE Spieler SET Coins = '"+coins+"'  WHERE UUID='"+uuid+"'");
		new ScoreboardManager().set();
	}
	
	public static void addCoins(String uuid, int coins) {
		int current = getCoins(uuid);
		int newCoins = current+coins;
		MySQL_CON_Spieler.update("UPDATE Spieler SET Coins = '"+newCoins+"'  WHERE UUID='"+uuid+"'");
		new ScoreboardManager().set();
	}
	
	public static void removeCoins(String uuid, int coins) {
		int current = getCoins(uuid);
		int newCoins = current-coins;
		MySQL_CON_Spieler.update("UPDATE Spieler SET Coins = '"+newCoins+"'  WHERE UUID='"+uuid+"'");
		new ScoreboardManager().set();
	}
}
