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

        AlertManager alertManager = new AlertManager();

        if (sender instanceof Player) {
            if (args.length == 0) {
                sender.sendMessage(Perus.getInstance().getConfigManager().getHelpmessage());
            } else {
                if (args.length == 1 && equals("alerts") && sender.hasPermission("perus.alerts")) {
                    alertManager.toggleAlerts(((Player) sender).getPlayer());
                    sender.sendMessage(Perus.getInstance().getConfigManager().getToggledonalerts());
                } else {
                    sender.hasPermission("perus.alerts");
                    alertManager.toggleAlerts(((Player) sender).getPlayer());
                    sender.sendMessage(Perus.getInstance().getConfigManager().getUntoggledonalerts());
                }

            }

        }

        return false;
    }

}
