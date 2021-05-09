package me.koba1.agentcraft;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Agentcraft extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new fishing(), this);
        getServer().getPluginManager().registerEvents(new ironregen(), this);
        getServer().getPluginManager().registerEvents(new woodregen(), this);
        getServer().getPluginManager().registerEvents(new chickenregen(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}