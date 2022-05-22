package mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MySQL_API_Perms {
	
	public static String playerRang(String uuid) {
		ResultSet rs = MySQL_CON_Perms.getResult("SELECT * FROM Spieler WHERE UUID='"+uuid+"'");
		try {
			if(rs.next()) {
				return rs.getString("rangName");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return "none";
	}
	
	public static int playerVerified(String uuid) {
		ResultSet rs = MySQL_CON_Perms.getResult("SELECT * FROM Spieler WHERE UUID='"+uuid+"'");
		try {
			if(rs.next()) {
				return rs.getInt("Verified");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	public static void setRang(Player player) {
		String uuid = MySQL_API_Spieler.playerUUID(player.getName());
		String rang = playerRang(uuid);
		Perms.administrator.remove(player);
		Perms.team.remove(player);
		Perms.srstaff.remove(player);
		Perms.srbuilder.remove(player);
		Perms.developer.remove(player);
		Perms.staff.remove(player);
		Perms.builder.remove(player);
		Perms.content.remove(player);
		Perms.srcontent.remove(player);
		Perms.vip.remove(player);
		Perms.premium.remove(player);
		Perms.spieler.remove(player);
		Perms.gast.remove(player);
		player.setOp(false);
		
		
		if(rang.equals("Administrator") && playerVerified(uuid) == 1) {
			Perms.administrator.add(player);
			Perms.team.add(player);
			Perms.online.add(player);
			Perms.cmd_build.add(player);
			
			player.setOp(true);
			Bukkit.getConsoleSender().sendMessage("§e"+player.getName()+" §7wurde als §4Administrator §aeingeloggt§7. (§e"+Perms.administrator.size()+"§7)");
			
		}else if(rang.equals("SrBuilder") && playerVerified(uuid) == 1) {
			Perms.srbuilder.add(player);
			Perms.team.add(player);
			Perms.online.add(player);
			Bukkit.getConsoleSender().sendMessage("§e"+player.getName()+" §7wurde als §eSrBuilder §aeingeloggt§7. (§e"+Perms.srbuilder.size()+"§7)");
			
		}else if(rang.equals("SrContent") && playerVerified(uuid) == 1) {
			Perms.srcontent.add(player);
			Perms.team.add(player);
			Perms.online.add(player);
			Bukkit.getConsoleSender().sendMessage("§e"+player.getName()+" §7wurde als §bSrContent §aeingeloggt§7. (§e"+Perms.srcontent.size()+"§7)");
			
		}else if(rang.equals("SrStaff") && playerVerified(uuid) == 1) {
			Perms.srstaff.add(player);
			Perms.team.add(player);
			Perms.online.add(player);
			Bukkit.getConsoleSender().sendMessage("§e"+player.getName()+" §7wurde als §cSrStaff §aeingeloggt§7. (§e"+Perms.srstaff.size()+"§7)");
			
		}else if(rang.equals("Staff") && playerVerified(uuid) == 1) {
			Perms.staff.add(player);
			Perms.team.add(player);
			Perms.online.add(player);
			Bukkit.getConsoleSender().sendMessage("§e"+player.getName()+" §7wurde als §cStaff §aeingeloggt§7. (§e"+Perms.staff.size()+"§7)");
			
		}else if(rang.equals("Developer") && playerVerified(uuid) == 1) {
			Perms.developer.add(player);
			Perms.team.add(player);
			Perms.online.add(player);
			Bukkit.getConsoleSender().sendMessage("§e"+player.getName()+" §7wurde als §bDeveloper §aeingeloggt§7. (§e"+Perms.developer.size()+"§7)");
			
		}else if(rang.equals("Builder") && playerVerified(uuid) == 1) {
			Perms.builder.add(player);
			Perms.team.add(player);
			Perms.online.add(player);
			Bukkit.getConsoleSender().sendMessage("§e"+player.getName()+" §7wurde als §eBuilder §aeingeloggt§7. (§e"+Perms.builder.size()+"§7)");
			
		}else if(rang.equals("Content") && playerVerified(uuid) == 1) {
			Perms.content.add(player);
			Perms.team.add(player);
			Perms.online.add(player);
			Bukkit.getConsoleSender().sendMessage("§e"+player.getName()+" §7wurde als §bContent §aeingeloggt§7. (§e"+Perms.content.size()+"§7)");
			
		}else if(rang.equals("VIP") && playerVerified(uuid) == 1) {
			Perms.vip.add(player);
			Perms.online.add(player);
			Bukkit.getConsoleSender().sendMessage("§e"+player.getName()+" §7wurde als §5VIP §aeingeloggt§7. (§e"+Perms.vip.size()+"§7)");
			
		}else if(rang.equals("Premium") && playerVerified(uuid) == 1) {
			Perms.premium.add(player);
			Perms.online.add(player);
			Bukkit.getConsoleSender().sendMessage("§e"+player.getName()+" §7wurde als §6Premium §aeingeloggt§7. (§e"+Perms.premium.size()+"§7)");
			
		}else if(rang.equals("Spieler") && playerVerified(uuid) == 1) {
			Perms.spieler.add(player);
			Perms.online.add(player);
			Bukkit.getConsoleSender().sendMessage("§e"+player.getName()+" §7wurde als §aSpieler §aeingeloggt§7. (§e"+Perms.spieler.size()+"§7)");
			
		}else{
			Perms.gast.add(player);
			Perms.online.add(player);
			Bukkit.getConsoleSender().sendMessage("§e"+player.getName()+" §7wurde als §aGast §aeingeloggt§7. (§e"+Perms.gast.size()+"§7)");
			
		}
	}
}
