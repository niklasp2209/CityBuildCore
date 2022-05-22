package mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.bukkitnews.citybuild.CityBuild;
import utils.ScoreboardManager;

public class LevelAPI {
	
	public static int getLevel(String uuid) {
		ResultSet rs = MySQL_CON_Spieler.getResult("SELECT * FROM CityBuild WHERE UUID='"+uuid+"'");
		try {
			if(rs.next()) {
				return rs.getInt("Level");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	
	public static int getEP(String uuid) {
		ResultSet rs = MySQL_CON_Spieler.getResult("SELECT * FROM CityBuild WHERE UUID='"+uuid+"'");
		try {
			if(rs.next()) {
				return rs.getInt("EP");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	
	public static void setLevel(String uuid, int level) {
		MySQL_CON_Spieler.update("UPDATE CityBuild SET Level = '"+level+"'  WHERE UUID='"+uuid+"'");
		new ScoreboardManager().set();
	}
	
	public static void addLevel(String uuid, int level) {
		int current = getLevel(uuid);
		int newLevel = current+level;
		MySQL_CON_Spieler.update("UPDATE CityBuild SET Level = '"+newLevel+"'  WHERE UUID='"+uuid+"'");
		for(Player all :Bukkit.getOnlinePlayers()) {
			LevelAPI.detect(all);
		}
		new ScoreboardManager().set();
	}
	
	public static void removeLevel(String uuid, int level) {
		int current = getLevel(uuid);
		int newLevel = current-level;
		MySQL_CON_Spieler.update("UPDATE CityBuild SET Level = '"+newLevel+"'  WHERE UUID='"+uuid+"'");
		new ScoreboardManager().set();
	}
	
	public static void setEP(String uuid, int EP) {
		MySQL_CON_Spieler.update("UPDATE CityBuild SET EP = '"+EP+"'  WHERE UUID='"+uuid+"'");
		new ScoreboardManager().set();
	}
	
	public static void addEP(String uuid, int EP) {
		int current = getEP(uuid);
		int newEP = current+EP;
		MySQL_CON_Spieler.update("UPDATE CityBuild SET EP = '"+newEP+"'  WHERE UUID='"+uuid+"'");
		new ScoreboardManager().set();
	}
	
	public static void removeEP(String uuid, int EP) {
		int current = getEP(uuid);
		int newEP = current-EP;
		MySQL_CON_Spieler.update("UPDATE CityBuild SET EP = '"+newEP+"'  WHERE UUID='"+uuid+"'");
		new ScoreboardManager().set();
	}
	
	public static void detect(Player player) {
		String uuid = MySQL_API_Spieler.playerUUID(player.getName());

		if(getEP(uuid) >= getLevel(uuid)*1000 && getLevel(uuid) != 0) {
			int Level = getLevel(uuid);
			setLevel(uuid, Level+1);
			int ep = getEP(uuid);
			setEP(uuid, ep-Level*1000);
			player.sendMessage(CityBuild.prefix_general + "§7Du bist nun §eLevel " + getLevel(uuid));
			
		}else if(getEP(uuid) >= 1000 && getLevel(uuid) == 0) {
			setEP(uuid, 0);
			setLevel(uuid, 1);
			player.sendMessage(CityBuild.prefix_general + "§7Du bist nun §eLevel " + getLevel(uuid));
			
		}
	}
}
