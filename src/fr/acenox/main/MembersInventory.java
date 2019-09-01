package fr.acenox.main;

import com.massivecraft.factions.Rel;
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

public class MembersInventory
  implements Listener
{
  static List<String> invite = new ArrayList<String>();
  
  @EventHandler
  public void GUI(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    MPlayer mp = MPlayer.get(p);
    Faction f = mp.getFaction();
    ItemStack clicked = e.getCurrentItem();
    Inventory inventory = e.getInventory();
    if (inventory.getName().equals("§cMembres de la faction"))
    {
      e.setCancelled(true);
      if ((clicked.getType() == Material.WOOD_DOOR) && (e.isLeftClick()))
      {
        if (f.isPermitted("kick", mp.getRole()))
        {
          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
          p.openInventory(Methods.getAllMembers(p, Type.EXCLUDE));
        }
        else
        {
          p.closeInventory();
          p.sendMessage("§bFaction §8» §fVous n'avez pas la permission.");
        }
      }
      else if ((clicked.getType() == Material.WOOD_DOOR) && (e.isRightClick()))
      {
        if (f.isPermitted("invite", mp.getRole()))
        {
          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
          p.closeInventory();
          p.sendMessage("§bFaction §8» §fVeuillez écrire le pseudo de la personne que vous souhaitez inviter");
          p.sendMessage("§bFaction §8» §fPour annuler, tapez '-' dans le chat");
          invite.add(p.getName());
        }
        else
        {
          p.closeInventory();
          p.sendMessage("§bFaction §8» §cVous n'avez pas la permission.");
        }
      }
      else if ((clicked.getType() == Material.ANVIL) && (e.isRightClick()))
      {
        if ((mp.getRole() == Rel.OFFICER) || (mp.getRole() == Rel.LEADER))
        {
          p.openInventory(Methods.getAllMembers(p, Type.PROMOTE));
        }
        else
        {
          p.closeInventory();
          p.sendMessage("§bFaction §8» §cVous n'avez pas la permission.");
        }
      }
      else if ((clicked.getType() == Material.ANVIL) && (e.isLeftClick())) {
        if ((mp.getRole() == Rel.OFFICER) || (mp.getRole() == Rel.LEADER))
        {
          p.openInventory(Methods.getAllMembers(p, Type.DEMOTE));
        }
        else
        {
          p.closeInventory();
          p.sendMessage("§bFaction §8» §cVous n'avez pas la permission.");
        }
      }
    }
  }
  
  @EventHandler
  public void eGUI(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    ItemStack clicked = e.getCurrentItem();
    Inventory inventory = e.getInventory();
    if (inventory.getName().equals("§cDémote un membre"))
    {
      e.setCancelled(true);
      if (clicked.getType() == Material.SKULL_ITEM)
      {
        String name = clicked.getItemMeta().getDisplayName().replace("§cDémote §c", "");
        p.performCommand("f demote " + name);
        p.closeInventory();
      }
    }
    if (inventory.getName().equals("§aPromote un membre"))
    {
      e.setCancelled(true);
      if (clicked.getType() == Material.SKULL_ITEM)
      {
        String name = clicked.getItemMeta().getDisplayName().replace("§aPromote §c", "");
        p.performCommand("f promote " + name);
        p.closeInventory();
      }
    }
  }
  
  @EventHandler
  public void aGUI(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    ItemStack clicked = e.getCurrentItem();
    Inventory inventory = e.getInventory();
    if (inventory.getName().equals("§cKick un membre"))
    {
      e.setCancelled(true);
      if (clicked.getType() == Material.SKULL_ITEM)
      {
        String name = clicked.getItemMeta().getDisplayName().replace("§eKick §c", "");
        p.performCommand("f kick " + name);
        p.closeInventory();
      }
    }
  }
}