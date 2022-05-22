package utils;

import org.bukkit.Bukkit;

import de.bukkitnews.citybuild.CityBuild;

public class AutoReload {
	
	public static void start() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(CityBuild.getInstance(), new Runnable() {
			int count = 14400;

			@Override
			public void run() {
				if(count == 60) {
					Bukkit.broadcastMessage(CityBuild.prefix_general + "§cDer Server wird in einer Minute neugeladen");
				}else if(count == 10) {
					Bukkit.broadcastMessage(CityBuild.prefix_general + "§cDer Server wird in 10 Sekunden neugeladen");
				}
				if(count == 0) {
					CityBuild.getInstance().saveConfig();
					Bukkit.reload();
				}
				
				count--;
			}
			
		}, 20, 20);
	}
}
