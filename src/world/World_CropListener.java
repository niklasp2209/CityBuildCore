package world;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class World_CropListener implements Listener {
	
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
	if(event.getAction().equals(Action.PHYSICAL) && event.getClickedBlock().getType().equals(Material.FARMLAND)){
		Player player = event.getPlayer();
		if(player.getWorld().getName().equals("world")) 
			event.setCancelled(true);
		}
	}
}
