package listener;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;

public class NPCListener implements Listener {
	Inventory grundst�cke;

	@EventHandler
	public void handleInteract(PlayerInteractAtEntityEvent event) {
		Player player = event.getPlayer();
		if(event.getRightClicked() instanceof Player) {
			if(event.getHand().equals(EquipmentSlot.HAND)) {
				if(event.getRightClicked().getName().equals("�aGrundst�cke")) {
					grundst�cke = Bukkit.getServer().createInventory(null, 27, "�aGrundst�cke");
					
					player.openInventory(grundst�cke);
					player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);
				}
			}
		}
	}
}
