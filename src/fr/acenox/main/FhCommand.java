package fr.acenox.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FhCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player p = (Player)sender;
    if (args.length == 1)
    {
      if (args[0].equalsIgnoreCase("version")) {
        p.sendMessage("§bFaction §8» §fMenu Faction crée par Acenox en version " + Main.getInstance().getDescription().getVersion() + " Un bug? Contactez Acenox#6666 sur discord.");
      } else if (Methods.hasSufficentRank(p) == Type.OK) {
        p.openInventory(Methods.getInventoryMain(p, Type.OK));
      } else if (Methods.hasSufficentRank(p) == Type.NOFAC) {
        p.openInventory(Methods.getInventoryMain(p, Type.NOFAC));
      } else {
        p.sendMessage("§bFaction §8» §cUne erreur est survenue.");
      }
    }
    else if (Methods.hasSufficentRank(p) == Type.OK) {
      p.openInventory(Methods.getInventoryMain(p, Type.OK));
    } else if (Methods.hasSufficentRank(p) == Type.NOFAC) {
      p.openInventory(Methods.getInventoryMain(p, Type.NOFAC));
    } else {
      p.sendMessage("§bFaction §8» §cUne erreur est survenue.");
    }
    return true;
  }
}