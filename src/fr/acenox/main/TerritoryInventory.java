package fr.acenox.main;

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TerritoryInventory
  implements Listener
{
  @EventHandler
  public void eGUI(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    MPlayer mp = MPlayer.get(p);
    Faction f = mp.getFaction();
    ItemStack clicked = e.getCurrentItem();
    Inventory inventory = e.getInventory();
    if (inventory.getName().equals("§cTerritoire"))
    {
      e.setCancelled(true);
      if (clicked.getType() == Material.MINECART) {
        if (f.isPermitted("home", mp.getRole()))
        {
          p.performCommand("f home");
          p.closeInventory();
          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        }
        else
        {
          p.closeInventory();
          p.sendMessage("§cVous n'avez pas la permission.");
        }
      }
      if (clicked.getType() == Material.BEACON) {
        if (f.isPermitted("sethome", mp.getRole()))
        {
          p.performCommand("f sethome");
          p.closeInventory();
          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        }
        else
        {
          p.closeInventory();
          p.sendMessage("§cVous n'avez pas la permission.");
        }
      }
      if (clicked.getType() == Material.GRASS) {
        if (f.isPermitted("territory", mp.getRole()))
        {
          p.performCommand("f claim o");
          p.closeInventory();
          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        }
        else
        {
          p.closeInventory();
          p.sendMessage("§cVous n'avez pas la permission.");
        }
      }
      if (clicked.getType() == Material.WOOD_PICKAXE) {
        if (f.isPermitted("territory", mp.getRole()))
        {
          p.performCommand("f unclaim o");
          p.closeInventory();
          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        }
        else
        {
          p.closeInventory();
          p.sendMessage("§cVous n'avez pas la permission.");
        }
      }
    }
  }
}
