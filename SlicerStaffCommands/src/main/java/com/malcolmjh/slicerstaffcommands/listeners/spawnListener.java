package com.malcolmjh.slicerstaffcommands.listeners;

import com.malcolmjh.slicerstaffcommands.SlicerStaffCommands;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class spawnListener implements Listener {
    private final SlicerStaffCommands plugin;
    public spawnListener(SlicerStaffCommands plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if(!e.getPlayer().hasPlayedBefore()){
            Location location = plugin.getConfig().getLocation("spawn");
            if(location != null){
                e.getPlayer().teleport(location);
            }
        }

    }

    @EventHandler
    public void onPlayerDeath(PlayerRespawnEvent e){
        //When the player dies, respawn them at the spawn location if set
        Location location = plugin.getConfig().getLocation("spawn");
        if(location != null){
            //spawn them
            e.setRespawnLocation(location);
        }
    }
}
