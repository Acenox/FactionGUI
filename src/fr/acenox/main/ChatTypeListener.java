package fr.acenox.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatTypeListener
  implements Listener
{
  @EventHandler
  public void CreateFaction(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    String message = e.getMessage();
    if (MainInventory.newfac.contains(p.getName()))
    {
      e.setCancelled(true);
      if (message.equals("-"))
      {
        e.setCancelled(true);
        p.sendMessage("§bFaction §8» §cAction annulée !");
        MainInventory.newfac.remove(p.getName());
      }
      else if (message.length() > 16)
      {
        p.sendMessage("§bFaction §8» §cLe nom de la faction est trop grande !");
        MainInventory.newfac.remove(p.getName());
      }
      else
      {
        p.performCommand("f create " + message);
        p.sendMessage("§bFaction §8» §fVous venez de créer votre Faction !");
        MainInventory.newfac.remove(p.getName());
      }
    }
  }
  
  @EventHandler
  public void JoinFaction(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    String message = e.getMessage();
    if (MainInventory.joinfac.contains(p.getName()))
    {
      e.setCancelled(true);
      if (message.equals("-"))
      {
        e.setCancelled(true);
        p.sendMessage("§bFaction §8» §fAction annulée !");
        MainInventory.joinfac.remove(p.getName());
      }
      else
      {
        p.performCommand("f join " + message);
        p.sendMessage("§bFaction §8» §fVotre requête vient d'être envoyé.");
        MainInventory.joinfac.remove(p.getName());
      }
    }
  }
  
  @EventHandler
  public void InviteFaction(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    String message = e.getMessage();
    if (MembersInventory.invite.contains(p.getName()))
    {
      e.setCancelled(true);
      if (message.equals("-"))
      {
        e.setCancelled(true);
        p.sendMessage("§bFaction §8» §fAction annulée !");
        MembersInventory.invite.remove(p.getName());
      }
      else if (Bukkit.getPlayer(message) == null)
      {
        p.sendMessage("§bFaction §8» §fLe joueur est hors ligne !");
        MembersInventory.invite.remove(p.getName());
      }
      else
      {
        p.performCommand("f invite add " + message);
        p.sendMessage("§bFaction §8» §fVous venez d'inviter le joueur !");
        MembersInventory.invite.remove(p.getName());
      }
    }
  }
}