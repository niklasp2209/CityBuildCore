package utils;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationUtil {
	public static Location getLocation(String name) {
		if(name.equals("spawn")) {
			Location location = new Location(Bukkit.getWorld("world"), -2.5, 88, -2.5);
			location.setYaw(-89);
			location.setPitch(0);
			return location;
		}else if(name.equals("intro")) {
			Location location = new Location(Bukkit.getWorld("world"), -5.6, 78, -2.5);
			location.setYaw(-48);
			location.setPitch(-1);
			return location;
		}
		return null;
	}
	
	public static Location getRandomLocationFarmwelt() {
		World world = Bukkit.getWorld("farmwelt");
		Random rand = new Random();
		int rangeMax = 5000;
		int rangeMin = -5000;
		
		int X = rand.nextInt((rangeMax - rangeMin) + 1) + rangeMin;
	    int Z = rand.nextInt((rangeMax - rangeMin) + 1) + rangeMin;
	    int Y = world.getHighestBlockYAt(X, Z);
	    
	    return new Location(world, X, Y, Z).add(0.5, 0, 0.5);
	}
	
	public static Location getRandomLocationNether() {
		World world = Bukkit.getWorld("nether");
		
		int X = -5619;
	    int Z = 10977;
	    int Y = 38;
	    return new Location(world, X, Y, Z).add(0.5, 0, 0.5);
	}
}
