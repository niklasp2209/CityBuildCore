package world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class World_WeatherListener implements Listener {
	
	@EventHandler
	public void handleWeather(WeatherChangeEvent event) {
		if(event.getWorld().getName().equals("world")) {
			if(event.toWeatherState())
				event.setCancelled(true);
		}
	}
}
