package utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {

	public static ItemStack cItem(Material id, String name, int ammount, String lore){
		ItemStack item = new ItemStack(id, ammount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		List<String> list = new ArrayList<>();
		list.add(lore);
		meta.setLore(list);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack cset(Material id, int ammount){
		ItemStack item = new ItemStack(id, ammount);
		return item;
	}
	public static ItemStack cItem2(Material id, String name, int ammount, List<String> lore){
		ItemStack item = new ItemStack(id, ammount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		List<String> list = new ArrayList<>();
		list.addAll(lore);
		meta.setLore(list);
		item.setItemMeta(meta);
		return item;
	}
}
