package utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import mysql.CoinsAPI;
import mysql.LevelAPI;
import mysql.MySQL_API_Spieler;
import mysql.Perms;

public class ScoreboardManager {

	public ScoreboardManager(){};
	
	@SuppressWarnings("deprecation")
	public void set(){
		for(Player player : Bukkit.getOnlinePlayers()){
			Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
			Objective obj = board.registerNewObjective("lobby", "dummy");

			

			Team admin = board.registerNewTeam("000");
			Team srstaff = board.registerNewTeam("001");
			Team srbuilder = board.registerNewTeam("002");
			Team srcontent = board.registerNewTeam("003");
			Team staff = board.registerNewTeam("004");
			Team developer = board.registerNewTeam("005");
			Team content = board.registerNewTeam("006");
			Team builder = board.registerNewTeam("007");
			Team vip = board.registerNewTeam("008");
			Team premium = board.registerNewTeam("009");
			Team spieler = board.registerNewTeam("010");
			Team gast = board.registerNewTeam("011");

			Bukkit.getOnlinePlayers().forEach(players -> {
			admin.setPrefix("§4Admin §7| §4");
			admin.setColor(ChatColor.DARK_RED);
			
			srstaff.setPrefix("§cSrStaff §7| §c");
			srstaff.setColor(ChatColor.RED);
			
			srbuilder.setPrefix("§eSrBuilder §7| §e");
			srbuilder.setColor(ChatColor.YELLOW);
			
			srcontent.setPrefix("§bSrContent §7| §b");
			srcontent.setColor(ChatColor.AQUA);
			
			developer.setPrefix("§bDeveloper §7| §b");
			developer.setColor(ChatColor.AQUA);
			
			staff.setPrefix("§cStaff §7| §c");
			staff.setColor(ChatColor.RED);
			
			content.setPrefix("§bcontent §7| §b");
			content.setColor(ChatColor.AQUA);
			
			builder.setPrefix("§eBuilder §7| §e");
			builder.setColor(ChatColor.YELLOW);
			
			vip.setPrefix("§5");
			vip.setColor(ChatColor.DARK_PURPLE);
			
			premium.setPrefix("§6");
			premium.setColor(ChatColor.GOLD);
			
			spieler.setPrefix("§a");
			spieler.setColor(ChatColor.GREEN);
			
			gast.setPrefix("§7");
			gast.setColor(ChatColor.GRAY);
			});
			
			Bukkit.getOnlinePlayers().forEach(players -> {
			if(Perms.administrator.contains(players)) {
				admin.addEntry(players.getName());
				
			}else if(Perms.srstaff.contains(players)) {
				srstaff.addEntry(players.getName());
				
			}else if(Perms.srbuilder.contains(players)) {
				srbuilder.addEntry(players.getName());
				
			}else if(Perms.srcontent.contains(players)) {
				srcontent.addEntry(players.getName());
				
			}else if(Perms.developer.contains(players)) {
				developer.addEntry(players.getName());
				
			}else if(Perms.staff.contains(players)) {
				staff.addEntry(players.getName());
				
			}else if(Perms.content.contains(players)) {
				content.addEntry(players.getName());
				
			}else if(Perms.builder.contains(players)) {
				builder.addEntry(players.getName());
				
			}else if(Perms.vip.contains(players)) {
				vip.addEntry(players.getName());
				
			}else if(Perms.premium.contains(players)) {
				premium.addEntry(players.getName());
				
			}else if(Perms.spieler.contains(players)) {
				spieler.addEntry(players.getName());
				
			}else if(Perms.gast.contains(players)) {
				gast.addEntry(players.getName());
			}else {
				players.kickPlayer("§cDer Server wurde neugeladen. Bitte betrete den Server neu.");
			}
			});

			Bukkit.getOnlinePlayers().forEach(players -> {
				String uuid = MySQL_API_Spieler.playerUUID(players.getName());

				obj.setDisplaySlot(DisplaySlot.SIDEBAR);
				obj.setDisplayName(" §f§lPLAYNAYZ.NET ");
				
				obj.getScore(" ").setScore(13);
				obj.getScore("§aCoins:").setScore(12);
				obj.getScore("§6"+CoinsAPI.getCoins(uuid) + " §6Coins").setScore(11);
				obj.getScore("  ").setScore(10);
				obj.getScore("§aLevel §7(/level):").setScore(9);
				obj.getScore("§e"+LevelAPI.getLevel(uuid)).setScore(8);
				obj.getScore("   ").setScore(7);
				obj.getScore("§aClan §7(/clan):").setScore(6);
				obj.getScore("§bkein Clan").setScore(5);
				obj.getScore("    ").setScore(4);
				obj.getScore("§aBeruf §7(/beruf):").setScore(3);
				obj.getScore("§cArbeitslos").setScore(2);
				obj.getScore("     ").setScore(1);
				obj.getScore("§7Hilfe: §e/hilfe").setScore(0);
				
				
				player.setScoreboard(board);
			});
			
		}
	}
}
