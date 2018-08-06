package me.progamer260.clearlag;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable() {
        this.getCommand("clearlag").setExecutor(new ClearLagCommands());

    }
}
