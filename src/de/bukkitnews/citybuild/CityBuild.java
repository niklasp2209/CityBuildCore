package de.bukkitnews.citybuild;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import command.BuildCommand;
import command.SpawnCommand;
import command.WarpCommand;
import listener.ChatListener;
import listener.ConnectionListener;
import listener.NPCListener;
import listener.WarpListener;
import mysql.MySQL_CON_Perms;
import mysql.MySQL_CON_Spieler;
import utils.AutoReload;
import utils.ClearLag;
import utils.ScoreboardReloader;
import world.World_BreakPlaceListener;
import world.World_CropListener;
import world.World_WeatherListener;

public class CityBuild extends JavaPlugin{
	public static CityBuild instance;
	
	public static ArrayList<Player> bauen = new ArrayList<>();
	
	public static String prefix_general = "§7[§eCityBuild§7] ",
						 noperm = prefix_general+"§cDu hast nicht genügend Rechte.";
	
	@Override
	public void onEnable() {
		instance = this;
		
		MySQL_CON_Perms.connect();
		MySQL_CON_Spieler.connect();
		
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new ConnectionListener(), this);
		pluginManager.registerEvents(new World_BreakPlaceListener(), this);
		pluginManager.registerEvents(new World_WeatherListener(), this);
		pluginManager.registerEvents(new World_CropListener(), this);
		pluginManager.registerEvents(new ChatListener(), this);
		pluginManager.registerEvents(new WarpListener(), this);
		pluginManager.registerEvents(new NPCListener(), this);
		
		ScoreboardReloader.start();
		AutoReload.start();
		ClearLag.start();
		
		this.getCommand("spawn").setExecutor(new SpawnCommand());
		this.getCommand("build").setExecutor(new BuildCommand());
		this.getCommand("warp").setExecutor(new WarpCommand());
		
		for(World world : Bukkit.getWorlds()) {
			world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
		}

		getServer().getConsoleSender().sendMessage("§4[§8=========================================§4]");
		getServer().getConsoleSender().sendMessage("§eCityBuild §astarted");
		getServer().getConsoleSender().sendMessage("§eProgrammed by§7: §aniklasp2209");
		getServer().getConsoleSender().sendMessage("§eVersion§7: §a1.0");
		getServer().getConsoleSender().sendMessage("§eServer-Version§7: §a1.13");
		getServer().getConsoleSender().sendMessage("§eAdmin-Permission§7: §anetwork.citybuild.admin");
		getServer().getConsoleSender().sendMessage("§4[§8=========================================§4]");
	}
	
	@Override
	public void onDisable() {
		MySQL_CON_Perms.disconnect();
		MySQL_CON_Spieler.disconnect();

		getServer().getConsoleSender().sendMessage("§4[§8=========================================§4]");
		getServer().getConsoleSender().sendMessage("§eCityBuild §4stopped");
		getServer().getConsoleSender().sendMessage("§eProgrammed by§7: §aniklasp2209");
		getServer().getConsoleSender().sendMessage("§eVersion§7: §a1.0");
		getServer().getConsoleSender().sendMessage("§eServer-Version§7: §a1.13");
		getServer().getConsoleSender().sendMessage("§eAdmin-Permission§7: §anetwork.citybuild.admin");
		getServer().getConsoleSender().sendMessage("§4[§8=========================================§4]");
	}
	
	public static CityBuild getInstance() {
		return instance;
	}
}
