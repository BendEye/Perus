package me.bendeye.perus;

import com.comphenix.protocol.ProtocolLibrary;
import lombok.Getter;

import me.bendeye.perus.command.PerusCommand;
import me.bendeye.perus.listener.EventListener;
import me.bendeye.perus.listener.PacketListener;
import me.bendeye.perus.manager.*;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
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
    @Getter
    private final PunishmentManager punishmentManager = new PunishmentManager();
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketListener());
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
