package fr.acenox.main;

import com.massivecraft.factions.entity.MPlayer;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PermsInventory
  implements Listener
{
  @EventHandler
  public void GUI(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    ItemStack clicked = e.getCurrentItem();
    Inventory inventory = e.getInventory();
    if (inventory.getName().equals("§cPermissions de Faction"))
    {
      e.setCancelled(true);
      clicked.getType();
      if (clicked.getType() != Material.THIN_GLASS) {
        if ((clicked.getType() != Material.AIR) || (clicked.getType() == Material.THIN_GLASS)) {
          p.openInventory(Methods.getPermissionInventory(p, Permission.valueOf(clicked.getItemMeta().getDisplayName().replace("§8§l>> §fPermission: §a", "").toUpperCase())));
        }
      }
    }
  }
  
  @EventHandler
  public void UGUI(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    MPlayer mp = MPlayer.get(p);
    Inventory inventory = e.getInventory();
    if (inventory.getName().equals("§cGérer les permissions"))
    {
      e.setCancelled(true);
      String perm = inventory.getItem(4).getItemMeta().getDisplayName().replace("§8§l>> §fPermission: §a", "");
      if (e.getSlot() == 40)
      {
        p.openInventory(Main.permissions);
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      }
      if (e.getSlot() == 18)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " LEADER yes");
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
        p.sendMessage("§bFaction §8» §fVous avez §aautorisée §c" + perm + " §fau §4Chef");
      }
      if (e.getSlot() == 19)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " OFF yes");
        p.sendMessage("§bFaction §8» §fVous avez §aautorisée §c" + perm + " §faux §cOfficiers");
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
      }
      if (e.getSlot() == 20)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " MEMBER yes");
        p.sendMessage("§bFaction §8» §fVous avez §aautorisée §c" + perm + " §faux §6Membres");
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
      }
      if (e.getSlot() == 21)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " RECRUIT yes");
        p.sendMessage("§bFaction §8» §fVous avez §aautorisée §c" + perm + " §faux §eRecrues");
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
      }
      if (e.getSlot() == 23)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " ALLY yes");
        p.sendMessage("§bFaction §8» §fVous avez §aautorisée §c" + perm + " §faux §dAllys");
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
      }
      if (e.getSlot() == 24)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " TRUCE yes");
        p.sendMessage("§bFaction §8» §fVous avez §aautorisée §c" + perm + " §faux §eTruce");
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
      }
      if (e.getSlot() == 25)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " NEUTRAL yes");
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
        p.sendMessage("§bFaction §8» §fVous avez §aautorisée §c" + perm + " §faux §fNeutres");
      }
      if (e.getSlot() == 26)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " ENEMY yes");
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
        p.sendMessage("§bFaction §8» §fVous avez §aautorisée §c" + perm + " §faux §cEnnemys");
      }
      if (e.getSlot() == 27)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " LEADER no");
        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        p.sendMessage("§bFaction §8» §fVous avez §cinterdit §c" + perm + " §fau §4Chef");
      }
      if (e.getSlot() == 28)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " OFF no");
        p.sendMessage("§bFaction §8» §fVous avez §cinterdit §c" + perm + " §faux §cOfficiers");
        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
      }
      if (e.getSlot() == 29)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " MEMBER no");
        p.sendMessage("§bFaction §8» §fVous avez §cinterdit §c" + perm + " §faux §6Membres");
        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
      }
      if (e.getSlot() == 30)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " RECRUIT no");
        p.sendMessage("§bFaction §8» §fVous avez §cinterdit §c" + perm + " §faux §eRecrues");
        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
      }
      if (e.getSlot() == 32)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " ALLY no");
        p.sendMessage("§bFaction §8» §fVous avez §cinterdit §c" + perm + " §faux §dAllys");
        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
      }
      if (e.getSlot() == 33)
      {
        p.performCommand("f perm " + mp.getFaction().getName() + " " + perm + " TRUCE no");
        p.sendMessage("§bFaction §8» §fVous avez §cinterdit §c" + perm + " §faux §eTruce");
        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
      }
      if (e.getSlot() == 34)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " NEUTRAL no");
        p.sendMessage("§bFaction §8» §fVous avez §cinterdit §c" + perm + " §faux §fNeutres");
        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
      }
      if (e.getSlot() == 35)
      {
        p.performCommand("f perm set " + mp.getFaction().getName() + " " + perm + " ENEMY no");
        p.sendMessage("§bFaction §8» §fVous avez §cinterdit §c" + perm + " §faux §cEnnemys");
        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
      }
    }
  }
}