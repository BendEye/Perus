package me.bendeye.perus;

import lombok.Getter;
import me.bendeye.perus.manager.CheckManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Perus extends JavaPlugin {

    @Getter
    private static Perus instance;

    @Getter
    private final CheckManager checkManager = new CheckManager();
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
