package org.crealityworks.back;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	
	private Main plugin;
	
	public Commands(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("back")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("back.command")) {
					try {
						player.teleport(Utils.locations.get(player.getUniqueId().toString()));
						player.sendMessage(Utils.chat(plugin.getConfig().getString("teleported").replace("%player", player.getName())));
					} catch(Exception e) {
						player.sendMessage(Utils.chat(plugin.getConfig().getString("noLocation").replace("%player%", player.getName())));
					}
				} else {
					player.sendMessage(Utils.chat(plugin.getConfig().getString("noAcess").replace("%player%", player.getName()).replace("%perm%", "back.command")));
				}
			} else {
				sender.sendMessage(Utils.chat("&cOnly players can execute this command!"));
			}
		}
		return true;
	}
	
	
	
}