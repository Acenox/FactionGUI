package fr.acenox.main;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
{
  private static Main plugin;
  public static Inventory permissions = Bukkit.createInventory(null, 45, "§cPermissions de Faction");
  public static Inventory territory = Bukkit.createInventory(null, 9, "§cTerritoire");
  
  public static Main getInstance()
  {
    return plugin;
  }
  
  public void onEnable()
  {
    plugin = this;
    Methods.InitPermInventory();
    Methods.InitTerritoryInventory();
    getCommand("fgui").setExecutor(new FhCommand());
    Bukkit.getPluginManager().registerEvents(new MainInventory(), this);
    Bukkit.getPluginManager().registerEvents(new MembersInventory(), this);
    Bukkit.getPluginManager().registerEvents(new ChatTypeListener(), this);
    Bukkit.getPluginManager().registerEvents(new PermsInventory(), this);
    Bukkit.getPluginManager().registerEvents(new TerritoryInventory(), this);
  }
}
