package fr.acenox.main;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStackBuilder
{
  public static ItemStack builderlore(Material material, int size, String name, String lore1, String lore2)
  {
    ItemStack item = new ItemStack(material, size);
    ItemMeta itemmeta = item.getItemMeta();
    itemmeta.setDisplayName(name);
    List<String> itemlore = new ArrayList<String>();
    itemlore.add("");
    itemlore.add(lore1);
    itemlore.add(lore2);
    itemmeta.setLore(itemlore);
    item.setItemMeta(itemmeta);
    
    return item;
  }
  
  public static ItemStack builder(Material material, int size, String name, String lore1)
  {
    ItemStack item = new ItemStack(material, size);
    ItemMeta itemmeta = item.getItemMeta();
    itemmeta.setDisplayName(name);
    List<String> itemlore = new ArrayList<String>();
    itemlore.add(lore1);
    itemmeta.setLore(itemlore);
    item.setItemMeta(itemmeta);
    
    return item;
  }
  
  public static ItemStack builder(Material material, int size, String name)
  {
    ItemStack item = new ItemStack(material, size);
    ItemMeta itemmeta = item.getItemMeta();
    itemmeta.setDisplayName(name);
    item.setItemMeta(itemmeta);
    
    return item;
  }
}