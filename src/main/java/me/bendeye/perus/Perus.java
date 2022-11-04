package me.bendeye.perus;

import org.bukkit.plugin.java.JavaPlugin;


public final class Perus extends JavaPlugin {
    private static Perus instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
