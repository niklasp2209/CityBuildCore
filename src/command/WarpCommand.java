package command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import utils.ItemUtils;

public class WarpCommand implements CommandExecutor {
	private Inventory inventory;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			inventory = Bukkit.getServer().createInventory(null, 45, "§aWarps");
			
			ItemStack glass = ItemUtils.cItem(Material.WHITE_STAINED_GLASS_PANE, " ", 1, null);
			ItemStack farmwelt = ItemUtils.cItem(Material.GRASS_BLOCK, "§aFarmwelt", 1, null);
			ItemStack spawn = ItemUtils.cItem(Material.MAGMA_CREAM, "§aSpawn", 1, "§7Linksklick zum teleportieren");
			
			for(int i = 0; i < 1; i++) {
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(all.getWorld().getName().equals("farmwelt")) {
						i++;
						ItemMeta farmMeta = farmwelt.getItemMeta();
						List<String> farmList = new ArrayList<>();
						farmList.add("§r");
						farmList.add("§7Linksklick für einen §ezufälligen Teleport");
						farmList.add("§cHier ist PVP §aaktiviert§c!");
						farmList.add("§7Spieler online: §a"+i);
						farmList.add("§r");
						farmMeta.setLore(farmList);
						farmwelt.setItemMeta(farmMeta);
						inventory.setItem(20, farmwelt);
					}else {
						ItemMeta farmMeta = farmwelt.getItemMeta();
						List<String> farmList = new ArrayList<>();
						farmList.add("§r");
						farmList.add("§7Linksklick für einen §ezufälligen Teleport");
						farmList.add("§cHier ist PVP §aaktiviert§c!");
						farmList.add("§7Spieler online: §a0");
						farmList.add("§r");
						farmMeta.setLore(farmList);
						farmwelt.setItemMeta(farmMeta);
						inventory.setItem(20, farmwelt);
						
					}
				}
			}
			
			for(int i = 0; i < 45; i++) {
				if(i != 22 && i != 20) {
					inventory.setItem(i, glass);
				}
			}

			inventory.setItem(22, spawn);
			player.openInventory(inventory);
			
			player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
		}
		return false;
	}

}
