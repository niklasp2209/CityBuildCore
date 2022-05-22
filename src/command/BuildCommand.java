package command;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.bukkitnews.citybuild.CityBuild;
import mysql.Perms;

public class BuildCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			if(Perms.cmd_build.contains(player)) {
				if(CityBuild.bauen.contains(player)) {
					CityBuild.bauen.remove(player);
					player.sendMessage(CityBuild.prefix_general + "§7Du bist §cnicht mehr §7im Baumodus");
					player.setMaxHealth(20);
					player.setHealth(20);
					player.setFoodLevel(20);
					player.setGameMode(GameMode.SURVIVAL);
					player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
				}else {
					CityBuild.bauen.add(player);
					player.sendMessage(CityBuild.prefix_general + "§7Du bist §anun §7im Baumodus");
					player.setGameMode(GameMode.CREATIVE);
					player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
				}
			}else{
				player.sendMessage(CityBuild.noperm);
			}
		}else {
			
		}
		return false;
	}
}
