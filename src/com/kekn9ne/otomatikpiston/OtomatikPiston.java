package com.kekn9ne.otomatikpiston;

import com.kekn9ne.otomatikpiston.events.OtomatikPistonEvents;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class OtomatikPiston extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        saveDefaultConfig();

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

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("otomatikpiston")) {
            if (args.length > 0 && args[0].equalsIgnoreCase("kapat")) {
                getConfig().set("enabled", false);
                saveConfig();
                getServer().getPluginManager().disablePlugin(this);
                getServer().getPluginManager();
                sender.sendMessage(ChatColor.RED + "Eklenti devre dışı bırakıldı. Yeniden etkinleştirmek için config dosyasını düzenleyip sunucuyu yeniden başlatın.");
            } else {
                sender.sendMessage(ChatColor.RED + cmd.getUsage());
            }
        }

        return true;
    }

}
