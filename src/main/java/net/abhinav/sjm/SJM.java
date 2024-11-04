package net.abhinav.sjm;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SJM extends JavaPlugin implements Listener {
    private String welcomeMessage;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        welcomeMessage = config.getString("welcome-message", "Hi!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @org.bukkit.event.EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().sendMessage(welcomeMessage);
    }
}