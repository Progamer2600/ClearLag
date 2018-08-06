package me.progamer260.clearlag;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;


public class ClearLagCommands implements CommandExecutor {

    @Override
    public boolean onCommand (CommandSender sender, Command command, String s, String[] args) {

        if (command.getName().equalsIgnoreCase("clearlag") || command.getName().equalsIgnoreCase("cl")) {
            clearEntities();
            sender.sendMessage(ChatColor.GREEN + "Lag has been cleared");
        }
        return true;
    }
    public void clearEntities() {
        for (World world : Bukkit.getServer().getWorlds()) {
            for(Chunk chunks : world.getLoadedChunks()) {
                chunks.load();
                for (Entity entities: chunks.getEntities()) {
                    entities.remove();
                }
                chunks.unload(true);
            }
        }
    }
}
