package listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

import de.bukkitnews.citybuild.CityBuild;
import mysql.LevelAPI;
import mysql.MySQL_API_Spieler;
import mysql.Perms;

public class ChatListener implements Listener {
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onUnknown(PlayerCommandPreprocessEvent e){
		if(!(e.isCancelled())){
			Player p = e.getPlayer();
			String msg = e.getMessage().split(" ")[0];
			HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
			if(topic == null){
				p.sendMessage(CityBuild.prefix_general + "§7Befehl §e" + msg + " §7wurde nicht gefunden!");
				e.setCancelled(true);
			}
		}
	}

	public static String admin = "§4Admin §8» §l§7";
	public static String srstaff = "§cSrStaff §8» §l§7";
	public static String srcontent = "§bSrContent §8» §l§7";
	public static String srbuilder = "§eSrBuilder §8» §l§7";
	public static String developer = "§bDeveloper §8» §l§7";
	public static String staff = "§cStaff §8» §l§7";
	public static String builder = "§eBuilder §8» §l§7";
	public static String content = "§bContent §8» §l§7";
	public static String vip = "§5VIP";
	public static String premium = "§6";
	public static String spieler = "§a";
	public static String gast = "§7";
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String Msg = event.getMessage();
		String uuid = MySQL_API_Spieler.playerUUID(player.getName());
		int Level = LevelAPI.getLevel(uuid);
		
		if(Perms.administrator.contains(player)){
			event.setFormat("§8(§f"+Level+"§8) "+admin+player.getName()+"§8: §7"+Msg);
		}else if(Perms.srbuilder.contains(player)){
			event.setFormat("§8(§f"+Level+"§8) "+srbuilder+player.getName()+"§8: §7"+Msg);
		}else if(Perms.srcontent.contains(player)){
			event.setFormat("§8(§f"+Level+"§8) "+srcontent+player.getName()+"§8: §7"+Msg);
		}else if(Perms.srstaff.contains(player)){
			event.setFormat("§8(§f"+Level+"§8) "+srstaff+player.getName()+"§8: §7"+Msg);
		}else if(Perms.developer.contains(player)){
			event.setFormat("§8(§f"+Level+"§8) "+developer+player.getName()+"§8: §7"+Msg);
		}else if(Perms.builder.contains(player)){
			event.setFormat("§8(§f"+Level+"§8) "+builder+player.getName()+"§8: §7"+Msg);
		}else if(Perms.content.contains(player)){
			event.setFormat("§8(§f"+Level+"§8) "+content+player.getName()+"§8: §7"+Msg);
		}else if(Perms.staff.contains(player)){
			event.setFormat("§8(§f"+Level+"§8) "+staff+player.getName()+"§8: §7"+Msg);
		}else if(Perms.vip.contains(player)){
			event.setFormat("§8(§f"+Level+"§8) "+vip+player.getName()+"§8: §7"+Msg);
		}else if(Perms.premium.contains(player)){
			event.setFormat("§8(§f"+Level+"§8) "+premium+player.getName()+"§8: §7"+Msg);
		}else if(Perms.spieler.contains(player)){
			event.setFormat("§8(§f"+Level+"§8) "+spieler+player.getName()+"§8: §7"+Msg);
		}else if(Perms.gast.contains(player)){
			event.setFormat("§8(§f"+Level+"§8) "+gast+player.getName()+"§8: §7"+Msg);
		}else {
			event.setCancelled(true);
			player.sendMessage("§cEs ist ein Fehler aufgetreten. Bitte betrete den Server neu!");
		}
	}
}
