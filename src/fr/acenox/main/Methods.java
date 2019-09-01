package fr.acenox.main;

import com.massivecraft.factions.Rel;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Methods
{
  static Map<String, Inventory> inv = new HashMap<String, Inventory>();
  static Map<String, Inventory> permission = new HashMap<String, Inventory>();
  static Map<String, Inventory> members = new HashMap<String, Inventory>();
  static Map<String, Inventory> promote = new HashMap<String, Inventory>();
  static Map<String, Inventory> demote = new HashMap<String, Inventory>();
  static Map<String, Inventory> kick = new HashMap<String, Inventory>();
  
  public static void InitPermInventory()
  {
    Main.permissions.setItem(0, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(1, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(2, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(3, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(4, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(5, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(6, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(7, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(8, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(9, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(10, ItemStackBuilder.builder(Material.WOOD_PLATE, 1, "§8§l>> §fPermission: §aAccess"));
    Main.permissions.setItem(11, ItemStackBuilder.builder(Material.DIAMOND_PICKAXE, 1, "§8§l>> §fPermission: §aBuild"));
    Main.permissions.setItem(12, ItemStackBuilder.builder(Material.WOOD_BUTTON, 1, "§8§l>> §fPermission: §aButton"));
    Main.permissions.setItem(13, ItemStackBuilder.builder(Material.CHEST, 1, "§8§l>> §fPermission: §aContainer"));
    Main.permissions.setItem(14, ItemStackBuilder.builder(Material.PAPER, 1, "§8§l>> §fPermission: §aDesc"));
    Main.permissions.setItem(15, ItemStackBuilder.builder(Material.BARRIER, 1, "§8§l>> §fPermission: §aDisband"));
    Main.permissions.setItem(16, ItemStackBuilder.builder(Material.WOOD_DOOR, 1, "§8§l>> §fPermission: §aDoor"));
    Main.permissions.setItem(17, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(18, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(20, ItemStackBuilder.builder(Material.BED, 1, "§8§l>> §fPermission: §aHome"));
    Main.permissions.setItem(19, ItemStackBuilder.builder(Material.MINECART, 1, "§8§l>> §fPermission: §aInvite"));
    Main.permissions.setItem(21, ItemStackBuilder.builder(Material.IRON_DOOR, 1, "§8§l>> §fPermission: §aKick"));
    Main.permissions.setItem(22, ItemStackBuilder.builder(Material.LEVER, 1, "§8§l>> §fPermission: §aLever"));
    Main.permissions.setItem(23, ItemStackBuilder.builder(Material.ANVIL, 1, "§8§l>> §fPermission: §aMotd"));
    Main.permissions.setItem(24, ItemStackBuilder.builder(Material.NAME_TAG, 1, "§8§l>> §fPermission: §aName"));
    Main.permissions.setItem(25, ItemStackBuilder.builder(Material.NETHER_STAR, 1, "§8§l>> §fPermission: §aRel"));
    Main.permissions.setItem(26, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(27, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(28, ItemStackBuilder.builder(Material.EYE_OF_ENDER, 1, "§8§l>> §fPermission: §aSethome"));
    Main.permissions.setItem(29, ItemStackBuilder.builder(Material.GRASS, 1, "§8§l>> §fPermission: §aTerritory"));
    Main.permissions.setItem(33, ItemStackBuilder.builder(Material.GOLD_INGOT, 1, "§8§l>> §fPermission: §aWithDraw"));
    Main.permissions.setItem(34, ItemStackBuilder.builder(Material.COMMAND, 1, "§8§l>> §fPermission: §aPerms"));
    Main.permissions.setItem(35, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(36, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(37, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(38, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(39, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(40, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(41, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(42, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(43, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    Main.permissions.setItem(44, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
  }
  
  public static void InitTerritoryInventory()
  {
    Main.territory.setItem(0, ItemStackBuilder.builder(Material.MINECART, 1, "§8§l>> §aSe téléporter au f home"));
    Main.territory.setItem(3, ItemStackBuilder.builder(Material.GRASS, 1, "§8§l>> §aClaim le chunk"));
    Main.territory.setItem(5, ItemStackBuilder.builder(Material.WOOD_PICKAXE, 1, "§8§l>> §aUnclaim le chunk"));
    Main.territory.setItem(8, ItemStackBuilder.builder(Material.BEACON, 1, "§8§l>> §aDefinir le /f home"));
  }
  
  public static Inventory getInventoryMain(Player p, Type type)
  {
    Inventory i = (Inventory)inv.get(p.getName());
    if (i == null)
    {
      i = Bukkit.createInventory(null, 18, "§cGestion de votre Faction");
      inv.put(p.getName(), i);
    }
    i.clear();
    if (type == Type.OK)
    {
      i.setItem(0, ItemStackBuilder.builder(Material.MAP, 1, "§8§l>> §cMap"));
      i.setItem(3, ItemStackBuilder.builder(Material.COMMAND, 1, "§8§l>> §cPermissions"));
      i.setItem(5, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §cMembres de la faction"));
      i.setItem(8, ItemStackBuilder.builder(Material.WOOD_DOOR, 1, "§8§l>> §cQuitter la faction"));
      i.setItem(13, ItemStackBuilder.builder(Material.MINECART, 1, "§8§l>> §cTerritoires"));
    }
    if (type == Type.NOFAC)
    {
      i.setItem(0, ItemStackBuilder.builder(Material.GRASS, 1, "§8§l>> §cCréer une faction"));
      i.setItem(8, ItemStackBuilder.builder(Material.PAPER, 1, "§8§l>> §cRejoindre une faction"));
    }
    return i;
  }
  
  public static Inventory getPermissionInventory(Player p, Permission perm)
  {
    Inventory i = (Inventory)permission.get(p.getName());
    if (i == null)
    {
      i = Bukkit.createInventory(null, 45, "§cGérer les permissions");
      permission.put(p.getName(), i);
    }
    i.clear();
    i.setItem(0, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(1, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(2, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(3, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(5, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(6, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(7, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(8, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(13, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(22, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(31, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(36, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(37, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(38, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(39, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(40, ItemStackBuilder.builder(Material.BARRIER, 1, "§8§l>> §cRetour"));
    i.setItem(41, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(42, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(43, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    i.setItem(44, ItemStackBuilder.builder(Material.THIN_GLASS, 1, " "));
    
    ItemStack a = ItemStackBuilder.builder(Material.WOOL, 1, "§8§l>> §aAutoriser");
    a.setDurability((short)5);
    
    ItemStack r = ItemStackBuilder.builder(Material.WOOL, 1, "§8§l>> §cInterdire");
    r.setDurability((short)14);
    
    i.setItem(18, a);
    i.setItem(19, a);
    i.setItem(20, a);
    i.setItem(21, a);
    i.setItem(23, a);
    i.setItem(24, a);
    i.setItem(25, a);
    i.setItem(26, a);
    
    i.setItem(27, r);
    i.setItem(28, r);
    i.setItem(29, r);
    i.setItem(30, r);
    i.setItem(32, r);
    i.setItem(33, r);
    i.setItem(34, r);
    i.setItem(35, r);
    
    i.setItem(9, ItemStackBuilder.builder(Material.DIAMOND_HELMET, 1, "§4Chefs"));
    i.setItem(10, ItemStackBuilder.builder(Material.DIAMOND_CHESTPLATE, 1, "§cOfficiers"));
    i.setItem(11, ItemStackBuilder.builder(Material.DIAMOND_LEGGINGS, 1, "§6Membres"));
    i.setItem(12, ItemStackBuilder.builder(Material.DIAMOND_BOOTS, 1, "§eRecrues"));
    
    i.setItem(14, ItemStackBuilder.builder(Material.DIAMOND_HOE, 1, "§dAllys"));
    i.setItem(15, ItemStackBuilder.builder(Material.DIAMOND_SPADE, 1, "§eTruce"));
    i.setItem(16, ItemStackBuilder.builder(Material.DIAMOND_PICKAXE, 1, "§fNeutral"));
    i.setItem(17, ItemStackBuilder.builder(Material.DIAMOND_SWORD, 1, "§cEnemy"));
    if (perm == Permission.ACCESS) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aAccess"));
    }
    if (perm == Permission.BUILD) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aBuild"));
    }
    if (perm == Permission.BUTTON) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aButton"));
    }
    if (perm == Permission.CONTAINER) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aContainer"));
    }
    if (perm == Permission.DESC) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aDesc"));
    }
    if (perm == Permission.DISBAND) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aDisband"));
    }
    if (perm == Permission.DOOR) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aDoor"));
    }
    if (perm == Permission.HOME) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aHome"));
    }
    if (perm == Permission.INVITE) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aInvite"));
    }
    if (perm == Permission.KICK) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aKick"));
    }
    if (perm == Permission.LEVER) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aLever"));
    }
    if (perm == Permission.MOTD) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aMotd"));
    }
    if (perm == Permission.NAME) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aName"));
    }
    if (perm == Permission.PERMS) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aPerms"));
    }
    if (perm == Permission.REL) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aRel"));
    }
    if (perm == Permission.SETHOME) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aSethome"));
    }
    if (perm == Permission.TERRITORY) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aTerritory"));
    }
    if (perm == Permission.TITLE) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aTitle"));
    }
    if (perm == Permission.WITHDRAW) {
      i.setItem(4, ItemStackBuilder.builder(Material.BOOK, 1, "§8§l>> §fPermission: §aWithDraw"));
    }
    return i;
  }
  
  public static Inventory getInventoryMembers(Player p)
  {
    MPlayer mp = MPlayer.get(p);
    Faction f = mp.getFaction();
    Inventory i = (Inventory)members.get(p.getName());
    if (i == null)
    {
      i = Bukkit.createInventory(null, 27, "§cMembres de la faction");
      members.put(p.getName(), i);
    }
    i.clear();
    
    i.setItem(1, ItemStackBuilder.builder(Material.DIAMOND_BLOCK, 1, "§4Chef", "§f- " + f.getLeader().getName()));
    if (f.getMPlayersWhereRole(Rel.OFFICER).isEmpty())
    {
      i.setItem(3, ItemStackBuilder.builder(Material.GOLD_BLOCK, 1, "§cOfficiers", "§f- Aucun"));
    }
    else
    {
      List<String> o = new ArrayList<String>();
      for (MPlayer officers : f.getMPlayersWhereRole(Rel.OFFICER))
      {
        o.add(officers.getName());
        i.setItem(3, ItemStackBuilder.builder(Material.GOLD_BLOCK, 1, "§cOfficiers", "§f- " + o));
      }
    }
    i.setItem(21, ItemStackBuilder.builderlore(Material.WOOD_DOOR, 1, "§cGestion des membres", "§8§l>> §aClic droit §7> §aInviter un membre", "§8§l>> §aClic gauche §7> §aExpulser un membre"));
    i.setItem(23, ItemStackBuilder.builderlore(Material.ANVIL, 1, "§8§l>> §cRangs", "§8§l>> §aClic droit §7> §aPromote un membre", "§8§l>> §aClic gauche §7> §aDémote un membre"));
    if (f.getMPlayersWhereRole(Rel.MEMBER).isEmpty())
    {
      i.setItem(5, ItemStackBuilder.builder(Material.COAL_BLOCK, 1, "§6Membres", "§f- Aucun"));
    }
    else
    {
      List<String> m = new ArrayList<String>();
      for (MPlayer members : f.getMPlayersWhereRole(Rel.MEMBER))
      {
        m.add(members.getName());
        i.setItem(5, ItemStackBuilder.builder(Material.COAL_BLOCK, 1, "§6Membres", "§f- " + m));
      }
    }
    if (f.getMPlayersWhereRole(Rel.RECRUIT).isEmpty())
    {
      i.setItem(7, ItemStackBuilder.builder(Material.HAY_BLOCK, 1, "§eRecrues", "§f- Aucune"));
    }
    else
    {
      List<String> r = new ArrayList<String>();
      for (MPlayer recruit : f.getMPlayersWhereRole(Rel.RECRUIT))
      {
        r.add(recruit.getName());
        i.setItem(7, ItemStackBuilder.builder(Material.HAY_BLOCK, 1, "§eRecrues", "§f- " + r));
      }
    }
    return i;
  }
  
  public static Type hasSufficentRank(Player p)
  {
    MPlayer mplayer = MPlayer.get(p);
    Faction faction = mplayer.getFaction();
    if ((faction.getName().equals("§2Wilderness")) || (faction.getName().equals("Nature"))) {
      return Type.NOFAC;
    }
    return Type.OK;
  }
  
  public static Inventory getAllMembers(Player p, Type type)
  {
    if (type == Type.DEMOTE)
    {
      Inventory inv = (Inventory)demote.get(p.getName());
      MPlayer mp = MPlayer.get(p);
      Faction f = mp.getFaction();
      int i = 0;
      if (inv == null)
      {
        inv = Bukkit.createInventory(null, 27, "§cDémote un membre");
        demote.put(p.getName(), inv);
      }
      inv.clear();
      for (MPlayer emp : f.getMPlayers())
      {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM);
        skull.setDurability((short)3);
        SkullMeta mskull = (SkullMeta)skull.getItemMeta();
        mskull.setOwner(emp.getName());
        mskull.setDisplayName("§cDémote §c" + emp.getName());
        List<String> emplore = new ArrayList<String>();
        emplore.add("§fRang: §c" + emp.getRole().toString());
        emplore.add("");
        if (type == Type.PROMOTE) {
          emplore.add("§aCliquez pour promote ce membre !");
        }
        if (type == Type.DEMOTE) {
          emplore.add("§aCliquez pour démote ce membre !");
        }
        mskull.setLore(emplore);
        skull.setItemMeta(mskull);
        inv.setItem(i, skull);
        i++;
      }
      return inv;
    }
    if (type == Type.PROMOTE)
    {
      Inventory inv = (Inventory)promote.get(p.getName());
      MPlayer mp = MPlayer.get(p);
      Faction f = mp.getFaction();
      int i = 0;
      if (inv == null)
      {
        inv = Bukkit.createInventory(null, 27, "§aPromote un membre");
        promote.put(p.getName(), inv);
      }
      inv.clear();
      for (MPlayer emp : f.getMPlayers())
      {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM);
        skull.setDurability((short)3);
        SkullMeta mskull = (SkullMeta)skull.getItemMeta();
        mskull.setOwner(emp.getName());
        mskull.setDisplayName("§ePromote §c" + emp.getName());
        List<String> emplore = new ArrayList<String>();
        emplore.add("§fRang: §c" + emp.getRole().toString());
        emplore.add("");
        if (type == Type.PROMOTE) {
          emplore.add("§aCliquez pour promote ce membre !");
        }
        if (type == Type.DEMOTE) {
          emplore.add("§aCliquez pour démote ce membre !");
        }
        mskull.setLore(emplore);
        skull.setItemMeta(mskull);
        inv.setItem(i, skull);
        i++;
      }
      return inv;
    }
    if (type == Type.EXCLUDE)
    {
      Inventory inv = (Inventory)kick.get(p.getName());
      MPlayer mp = MPlayer.get(p);
      Faction f = mp.getFaction();
      int i = 0;
      if (inv == null)
      {
        inv = Bukkit.createInventory(null, 27, "§cKick un membre");
        kick.put(p.getName(), inv);
      }
      inv.clear();
      for (MPlayer emp : f.getMPlayers())
      {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM);
        skull.setDurability((short)3);
        SkullMeta mskull = (SkullMeta)skull.getItemMeta();
        mskull.setOwner(emp.getName());
        mskull.setDisplayName("§eKick §c" + emp.getName());
        List<String> emplore = new ArrayList<String>();
        emplore.add("§fRang: §c" + emp.getRole().toString());
        emplore.add("");
        emplore.add("§cCliquez pour kick ce membre !");
        mskull.setLore(emplore);
        skull.setItemMeta(mskull);
        inv.setItem(i, skull);
        i++;
      }
      return inv;
    }
    return null;
  }
}