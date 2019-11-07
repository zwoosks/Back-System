package org.crealityworks.back;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		this.getCommand("back").setExecutor(new Commands(this));
		this.getServer().getPluginManager().registerEvents(new EvtListener(), this);
		getLogger().info("Back system plugin by zwoosks has been enabled.");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Back system plugin by zwoosks has been disabled.");
	}

}
