package com.Gamerboy59.bukkit.TrollCommand;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {
	@Override
    public void onDisable() {
        this.getLogger().info(this.getDescription().getName() + " v" + this.getDescription().getVersion() + " disabled!");
    }
	


    @Override
    public void onEnable() {
        this.getCommand("troll").setExecutor(this);
        this.getLogger().info(this.getDescription().getName() + " v" + this.getDescription().getVersion() + " enabled!");
        
        try {
            BukkitMetrics metrics = new BukkitMetrics(this);
            metrics.start();
        } catch (IOException e) {
            // Failed to submit the stats :-(
        }
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			if(!sender.isOp() || !sender.hasPermission("cpf.admin")){
				sender.sendMessage(ChatColor.DARK_AQUA + "Trollololollololollololol...");
				return true;
			}else{
				sender.sendMessage(ChatColor.DARK_RED+"Insufficient Permissions");
			}
			return true;
        }else{
        	sender.sendMessage("This command must be used in-game");
            return false;
        }
	}
}