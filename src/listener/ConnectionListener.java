package listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.bukkitnews.citybuild.CityBuild;
import mysql.MySQL_API_CityBuild;
import mysql.MySQL_API_Perms;
import mysql.MySQL_API_Spieler;
import utils.Intro;
import utils.LocationUtil;
import utils.ScoreboardManager;

public class ConnectionListener implements Listener {
	
	@EventHandler
	public void handleConnect(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		String uuid = MySQL_API_Spieler.playerUUID(player.getName());
		MySQL_API_Perms.setRang(player);
		event.setJoinMessage(null);
		
		if(!MySQL_API_CityBuild.playerExists(uuid)) {
			MySQL_API_CityBuild.createPlayer(player);
			new ScoreboardManager().set();
			player.teleport(LocationUtil.getLocation("intro"));
			new Intro(CityBuild.getInstance(), player);
		}else {
			new ScoreboardManager().set();
		}
	}
	
	@EventHandler
	public void handleDisconnect(PlayerQuitEvent event) {
		@SuppressWarnings("unused")
		Player player = event.getPlayer();
		event.setQuitMessage(null);
	}
}
