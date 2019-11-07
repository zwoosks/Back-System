package org.crealityworks.back;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EvtListener implements Listener {
	
	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent e) {
		Player player = e.getPlayer();
		if(player.hasPermission("back.command")) {
			Utils.locations.put(player.getUniqueId().toString(), e.getFrom());
		}
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player player = e.getEntity();
		if(player.hasPermission("back.command")) {
			Utils.locations.put(player.getUniqueId().toString(), player.getLocation());
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		if(player.hasPermission("back.command")) {
			try {
				Utils.locations.remove(player.getUniqueId().toString());
			} catch(Exception ex) {}
		}
	}
	
}