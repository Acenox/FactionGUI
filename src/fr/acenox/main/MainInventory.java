package fr.acenox.main;


import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MainInventory
  implements Listener
{
  static List<String> newfac = new ArrayList<String>();
  static List<String> joinfac = new ArrayList<String>();
  
  @EventHandler
  public void GUI(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    MPlayer mp = MPlayer.get(p);
    Faction f = mp.getFaction();
    ItemStack clicked = e.getCurrentItem();
    Inventory inventory = e.getInventory();
    if (inventory.getName().equals("§cGestion de votre Faction"))
    {
      e.setCancelled(true);
      if (clicked.getType() == Material.WOOD_DOOR)
      {
        mp.leave();
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      }
      if (clicked.getType() == Material.MAP)
      {
        p.performCommand("f map");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      }
      if (clicked.getType() == Material.BOOK)
      {
        p.openInventory(Methods.getInventoryMembers(p));
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      }
      if (clicked.getType() == Material.GRASS)
      {
        if (newfac.contains(p.getName())) {
          newfac.remove(p.getName());
        }
        p.sendMessage("§bFaction §8» §fEcrivez le nom de la faction que vous souhaitez créer !");
        p.sendMessage("§bFaction §8» §fPour annuler, tapez '-' dans le chat");
        newfac.add(p.getName());
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      }
      if (clicked.getType() == Material.PAPER)
      {
        if (joinfac.contains(p.getName())) {
          joinfac.remove(p.getName());
        }
        p.sendMessage("§bFaction §8» §fVeuillez écrire le nom de la faction que vous souhaitez rejoindre");
        p.sendMessage("§bFaction §8» §fPour annuler, tapez '-' dans le chat");
        joinfac.add(p.getName());
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      }
      if (clicked.getType() == Material.COMMAND) {
        if (f.isPermitted("perms", mp.getRole()))
        {
          p.openInventory(Main.permissions);
          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        }
        else
        {
          p.sendMessage("§bFaction §8» §cVous n'avez pas la permission.");
          p.closeInventory();
        }
      }
      if (clicked.getType() == Material.MINECART)
      {
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        p.openInventory(Main.territory);
      }
    }
  }
}