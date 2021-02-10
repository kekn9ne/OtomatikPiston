package com.kekn9ne.otomatikpiston;

import com.kekn9ne.otomatikpiston.events.OtomatikPistonEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class OtomatikPiston extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        getConfig().options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new OtomatikPistonEvents(), this);

        if (!plugin.getConfig().getBoolean("enabled")) {
            getServer().getPluginManager().disablePlugin(this);
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[OtomatikPiston] " + ChatColor.RED + "Eklenti config.yml üzerinden devre dışı bırakılmış!");
            return;
        }
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[OtomatikPiston] " + ChatColor.YELLOW + "Eklenti aktifleştirildi!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[OtomatikPiston] " + ChatColor.YELLOW + "Eklenti devre dışı bırakıldı!");
    }

}
