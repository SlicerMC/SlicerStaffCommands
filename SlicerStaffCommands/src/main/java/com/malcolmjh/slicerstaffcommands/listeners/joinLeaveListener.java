package com.malcolmjh.slicerstaffcommands.listeners;
import com.malcolmjh.slicerstaffcommands.SlicerStaffCommands;
import com.malcolmjh.slicerstaffcommands.utils.makeBossBar;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.bossbar.BossBar;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class joinLeaveListener implements Listener {
    private final SlicerStaffCommands plugin;
    public joinLeaveListener(SlicerStaffCommands plugin) {
        this.plugin = plugin;
    }
    //Set Join Message.
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(p.getDisplayName() + " is ready to" + ChatColor.RED +" Slice!");
        Audience audience = (Audience) p;
        String data = plugin.getConfig().getString("default-notice");
        new makeBossBar(data, 1, BossBar.Color.RED, BossBar.Overlay.NOTCHED_6, audience);
    }
    //Set Leave Message.
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(p.getDisplayName() + " is no longer " + ChatColor.RED + "Slicing!");
    }
}
