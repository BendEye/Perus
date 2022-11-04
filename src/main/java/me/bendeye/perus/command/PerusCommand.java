package me.bendeye.perus.command;

import me.bendeye.perus.Perus;
import me.bendeye.perus.manager.AlertManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PerusCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {



        if (sender instanceof Player) {
            if (args.length == 0) {
                sender.sendMessage(Perus.getInstance().getConfigManager().getHelpmessage());
            } else {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("alerts")) {
                        if (sender.hasPermission("perus.alerts") || sender.isOp()) {
                            Perus.getInstance().getAlertManager().toggleAlerts((Player) sender);
                        }
                    }
                }
            }
        }
            return false;
    }
}

