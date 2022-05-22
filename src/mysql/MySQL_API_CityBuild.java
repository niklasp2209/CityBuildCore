package mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

public class MySQL_API_CityBuild {
	
	public static boolean playerExists(String uuid) {
		ResultSet rs = MySQL_CON_Spieler.getResult("SELECT * FROM CityBuild WHERE UUID='"+uuid+"'");
		try {
			return rs.next();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public static void createPlayer(Player player) {
		String uuid = MySQL_API_Spieler.playerUUID(player.getName());
		
		if(!playerExists(uuid))
		MySQL_CON_Spieler.update("INSERT INTO CityBuild (UUID,PlayedBefore,Beruf,Level,EP) VALUES ('"+uuid+"','"+1+"','"+"Arbeitslos"+"','"+0+"','"+0+"')");
	}
}
