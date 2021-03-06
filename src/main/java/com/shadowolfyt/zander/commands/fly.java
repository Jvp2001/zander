package com.shadowolfyt.zander.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (player.hasPermission("zander.fly")) {
            if (player.isFlying() || player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.setFlying(false);
                player.sendMessage(ChatColor.GREEN + "You are no longer " + ChatColor.GOLD + "flying.");
                return true;
            } else {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage(ChatColor.GREEN + "You are now " + ChatColor.GOLD + "flying.");
                return true;
            }
        } else {
            player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }
    }
}
