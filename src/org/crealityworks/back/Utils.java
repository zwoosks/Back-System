package org.crealityworks.back;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Location;

public class Utils {
	
	public static HashMap<String, Location> locations = new HashMap<String, Location>();
	
	public static String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
}