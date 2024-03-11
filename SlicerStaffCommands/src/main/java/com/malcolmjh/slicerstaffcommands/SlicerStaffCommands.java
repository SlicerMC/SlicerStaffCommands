package com.malcolmjh.slicerstaffcommands;
import com.malcolmjh.slicerstaffcommands.commands.hologramCommand;
import com.malcolmjh.slicerstaffcommands.commands.invseeCommand;
import com.malcolmjh.slicerstaffcommands.commands.noticeCommand;
import com.malcolmjh.slicerstaffcommands.commands.spawnCommand;
import com.malcolmjh.slicerstaffcommands.commands.setSpawnCommand;
import com.malcolmjh.slicerstaffcommands.listeners.joinListener;
import com.malcolmjh.slicerstaffcommands.listeners.spawnListener;
import org.bukkit.plugin.java.JavaPlugin;
public final class SlicerStaffCommands extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("[START UP-LOADING] [INFO]: Slicer Slices Is Loading...");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getLogger().info("[START UP-1] [COMMANDS] [INFO]: The Commands Are Starting...");
        getCommand("hologram").setExecutor(new hologramCommand());
        getCommand("invsee").setExecutor(new invseeCommand());
        getCommand("notice").setExecutor(new noticeCommand());
        getCommand("setspawn").setExecutor(new setSpawnCommand(this));
        getCommand("spawn").setExecutor(new spawnCommand(this));
        getLogger().info("[START UP-2] [COMMANDS] [INFO]: The Commands Have Started!");
        getLogger().info("[START UP-3] [COMMANDS] [INFO]: The Commands Are Starting...");
        getServer().getPluginManager().registerEvents(new spawnListener(this), this);
        getServer().getPluginManager().registerEvents(new joinListener(), this);
        getLogger().info("[START UP-4] [COMMANDS] [INFO]: The Commands Have Started!");
        getLogger().info("[START UP-FINAL] [INFO]: Slicer Slices Has Started!");
    }
}
