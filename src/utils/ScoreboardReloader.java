package utils;

import org.bukkit.Bukkit;

import de.bukkitnews.citybuild.CityBuild;

public class ScoreboardReloader {
	private static int sched;
	
	
	public static void start(){
		sched = Bukkit.getScheduler().scheduleSyncRepeatingTask(CityBuild.getInstance(), new Runnable(){
			int count = 10;

			@Override
			public void run() {
				if(count == 5) {
				}else if(count == 0){
					stop();
					start();
					new ScoreboardManager().set();
					CityBuild.getInstance().reloadConfig();
					}
					
				count--;
			}
			
		}, 20, 20);
	}
	
	public static void stop(){
		Bukkit.getScheduler().cancelTask(sched);
}

	public static void stop(boolean t){
		Bukkit.getScheduler().cancelTask(sched);
	}
}
