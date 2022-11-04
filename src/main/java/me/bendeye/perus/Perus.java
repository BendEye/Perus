package me.bendeye.perus;

import lombok.Getter;

import me.bendeye.perus.command.PerusCommand;
import me.bendeye.perus.listener.EventListener;
import me.bendeye.perus.manager.AlertManager;
import me.bendeye.perus.manager.CheckManager;
import me.bendeye.perus.manager.ConfigManager;
import me.bendeye.perus.manager.PlayerDataManager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Perus extends JavaPlugin {

    @Getter
    private static Perus instance;

    @Getter
    private final CheckManager checkManager = new CheckManager();

    @Getter
    private ConfigManager configManager;
    @Getter
    private final AlertManager alertManager = new AlertManager();

    @Getter
    private final PlayerDataManager dataManager = new PlayerDataManager();
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();
        configManager = new ConfigManager(getConfig());
        getCommand("perus").setExecutor(new PerusCommand());

        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
