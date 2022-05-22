package utils;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import de.bukkitnews.citybuild.CityBuild;

public class Intro implements Runnable{
	private BukkitTask task;
	private final Player player;
	private int count = 0;
	
	public Intro(CityBuild plugin, Player player) {
		this.task = plugin.getServer().getScheduler().runTaskTimerAsynchronously(CityBuild.getInstance(), this, 20L, 20L);
		this.player = player;
	}
	
	@Override
	public void run() {
		count++;
		checkEnd();
	}

	private void checkEnd() {
		if(count == 2) {
			player.sendTitle("§eWillkommen neuer Bürger!", "§6TUTORIAL", 15, 30, 15);
		}
		
		if(count == 5) {
			task.cancel();
			player.sendTitle("§eDu kommst zurück mit", "§6/spawn", 15, 30, 15);
		}
	}
}
