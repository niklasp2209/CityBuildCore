package listener;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.bukkitnews.citybuild.CityBuild;
import utils.LocationUtil;

public class WarpListener implements Listener {
    private final Map<UUID, Long> cooldown_farmwelt = new HashMap<>();

	@EventHandler
	public void onInteract(InventoryClickEvent event){
		Player player = (Player)event.getWhoClicked();
		if(event.getView().getTitle().equals("§aWarps") && event.getCurrentItem() != null) {
			event.setCancelled(true);
			if(event.getCurrentItem().getType() == Material.GRASS_BLOCK){
				if(event.getCurrentItem().getItemMeta().getDisplayName().contains("§aFarmwelt")){
					if(cooldown_farmwelt.containsKey(player.getUniqueId())) {
						Long time = cooldown_farmwelt.get(player.getUniqueId());
						if(time < System.currentTimeMillis()) {
							player.teleport(LocationUtil.getRandomLocationFarmwelt());
							player.sendMessage(CityBuild.prefix_general+"§7Du wirst §ezufällig teleportiert§7...");
							player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
							cooldown_farmwelt.put(player.getUniqueId(), System.currentTimeMillis()+(20*5));
							cooldown_farmwelt.remove(player.getUniqueId());
						}else {
							Long time2 = cooldown_farmwelt.get(player.getUniqueId());
							player.sendMessage(CityBuild.prefix_general + "§cDu darfst das erst wieder in §e"+ ((time2-System.currentTimeMillis())/1000) +" §eSekunden§c!");
							player.closeInventory();
						}
					}else {
						player.teleport(LocationUtil.getRandomLocationFarmwelt());
						player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
						cooldown_farmwelt.put(player.getUniqueId(), System.currentTimeMillis()+(1000*300));
					}
				}
			}else if(event.getCurrentItem().getType() == Material.MAGMA_CREAM){
				if(event.getCurrentItem().getItemMeta().getDisplayName().contains("§aSpawn")){
					player.teleport(LocationUtil.getLocation("spawn"));
					player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
				}
			}
		}
	}
}
