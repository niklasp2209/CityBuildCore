package utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import de.bukkitnews.citybuild.CityBuild;

public class ClearLag {


	private static int sched;
	private static int sched2;
	
	
	public static void start(){
		sched = Bukkit.getScheduler().scheduleSyncRepeatingTask(CityBuild.getInstance(), new Runnable(){
			int count = 1000;

			@Override
			public void run() {
				if(count == 300){
					for(Player all : Bukkit.getOnlinePlayers()){
						all.sendMessage(CityBuild.prefix_general + "§7Herumliegende Items werden in §a5 Minuten§7 entfernt!");
					}
				}else if(count == 60){
					for(Player all : Bukkit.getOnlinePlayers()){
						all.sendMessage(CityBuild.prefix_general + "§7Herumliegende Items werden in §a1 Minuten§7 entfernt!");
					}
				}else if(count == 5){
					for(Player all : Bukkit.getOnlinePlayers()){
						all.sendMessage(CityBuild.prefix_general + "§7Herumliegende Items werden in §a" + count + " Sekunden§7 entfernt!");
					}
				}else if(count == 0){
					for(Player all : Bukkit.getOnlinePlayers()){
						all.sendMessage(CityBuild.prefix_general + "§cHerumliegende Items wurden entfernt.");
					}
                       for(Entity entity : Bukkit.getWorld("farmwelt").getEntities()){
                        	if(entity instanceof Item){
                        		entity.remove();
                        		
                        	}
                    		stop();
                    		start();
					}
				}
				count--;
			}
			
		}, 20, 20);
	}
	
	public static void startRL() {
		sched2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(CityBuild.getInstance(), new Runnable(){
			int count = 3600;

			@Override
			public void run() {
				if(count == 0) {
					Bukkit.reload();
				}
				count--;
				
			}
			
		}, 20, 20);
		
	}
	
		public static void stop(){
		Bukkit.getScheduler().cancelTask(sched);
}	
		public static void stopRL(){
			Bukkit.getScheduler().cancelTask(sched2);
	}

		public static void stop(boolean t){
		Bukkit.getScheduler().cancelTask(sched);
	}
}
