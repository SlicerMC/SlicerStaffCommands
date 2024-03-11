package com.malcolmjh.slicerstaffcommands.commands;

import com.malcolmjh.slicerstaffcommands.SlicerStaffCommands;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnCommand implements CommandExecutor {
    private final SlicerStaffCommands plugin;
    public spawnCommand(SlicerStaffCommands plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //Make sure that they are a player
        if (sender instanceof Player){
            Player player = (Player) sender;
            //see if the plugin has a spawn point set in the config
            Location location = plugin.getConfig().getLocation("spawn");
            if (location != null){
                //teleport the player to the spawn point
                player.teleport(location);
                //send a message to the player
                player.sendMessage("You have been teleported to the spawn point.");
            }else{
                player.sendMessage("There is no spawn point set.");
            }
        }else{
            System.out.println("You Need To Be On The Server To Run This Command!");
        }
        return true;
    }
}
