package com.malcolmjh.slicerstaffcommands.commands;
import com.malcolmjh.slicerstaffcommands.model.noticeMap;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
public class noticeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player p = (Player) sender;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < args.length; i++) {
            builder.append(args[i]);
            builder.append(" ");
        }
        String data = builder.toString();
        data = data.stripTrailing();
        noticeMap.setData(data);
        return true;
    }
}
