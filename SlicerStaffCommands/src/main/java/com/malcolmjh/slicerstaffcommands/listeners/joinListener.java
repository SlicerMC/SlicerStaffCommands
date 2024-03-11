package com.malcolmjh.slicerstaffcommands.listeners;
import com.malcolmjh.slicerstaffcommands.model.noticeMap;
import com.malcolmjh.slicerstaffcommands.utils.makeBossBar;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.bossbar.BossBar;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class joinListener implements Listener {
    //Set Join Message.
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(p.getDisplayName() + " is ready to" + ChatColor.RED +" Slice!");
        Audience audience = (Audience) p;
        String data = noticeMap.getData();
        new makeBossBar(data, 1, BossBar.Color.RED, BossBar.Overlay.NOTCHED_6, audience);
    }
    //Set Leave Message.
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(p.getDisplayName() + " is no longer " + ChatColor.RED + "Slicing!");
    }
}
