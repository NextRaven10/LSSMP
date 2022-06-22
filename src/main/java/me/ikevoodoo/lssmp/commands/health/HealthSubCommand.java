package me.ikevoodoo.lssmp.commands.health;

import me.ikevoodoo.lssmp.config.CommandConfig;
import me.ikevoodoo.smpcore.SMPPlugin;
import me.ikevoodoo.smpcore.commands.SMPCommand;
import me.ikevoodoo.smpcore.commands.arguments.Argument;
import me.ikevoodoo.smpcore.commands.arguments.Arguments;
import me.ikevoodoo.smpcore.commands.arguments.OptionalFor;
import me.ikevoodoo.smpcore.utils.HealthUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealthSubCommand extends SMPCommand {
    protected HealthSubCommand(SMPPlugin plugin) {
        super(plugin, CommandConfig.HealthCommand.HealthSubCommand.name, CommandConfig.HealthCommand.HealthSubCommand.perms);
        setArgs(
                new Argument("player", true, Player.class, OptionalFor.NONE),
                new Argument("hearts", true, Double.class, OptionalFor.NONE)
        );
    }

    @Override
    public boolean execute(CommandSender commandSender, Arguments arguments) {
        double hearts = arguments.get("hearts", Double.class);
        Player player =arguments.get("player", Player.class);
        HealthUtils.decrease(hearts * 2, player);
        return true;
    }
}
