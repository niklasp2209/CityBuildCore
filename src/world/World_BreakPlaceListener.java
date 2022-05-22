package world;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import de.bukkitnews.citybuild.CityBuild;

public class World_BreakPlaceListener implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		
		if(!CityBuild.bauen.contains(player)) {
			if(event.getBlock().getWorld().getName().equals("world"))
				event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		
		if(!CityBuild.bauen.contains(player)) {
			if(event.getBlock().getWorld().getName().equals("world"))
				event.setCancelled(true);
		}
		
	}
}
