package com.trafalcraft.ludo.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Home {
	public static void home(Player p, String[] args){
		if(p.hasPermission("home")){
			if(Main.getconfig().contains("player." + p.getUniqueId().toString() + ".home.x")){
				if(!(Main.homeNameContains(p.getName()))){
					if(p.hasPermission("nodelayedhome")){
						if(Main.getconfig().getString("player." + p.getUniqueId().toString() + ".home.world").equals(p.getWorld().getName()) || p.hasPermission("homeinterworld")){
						
							Location loc = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".home.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".home.x"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".home.y"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".home.z"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".home.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".home.pitch"));
							Location loc2 = new Location(loc.getWorld(), loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ(), loc.getYaw(), loc.getPitch());
						
							if((loc.getBlock().getType() == Material.AIR || loc.getBlock().getType() == Material.WATER || loc.getBlock().getType() == Material.WATER_LILY || loc.getBlock().getType() == Material.STATIONARY_WATER) && (loc2.getBlock().getType() == Material.AIR || loc2.getBlock().getType() == Material.WATER || loc2.getBlock().getType() == Material.WATER_LILY || loc2.getBlock().getType() == Material.STATIONARY_WATER)){
						
								p.teleport(loc);
								p.sendMessage("teleportation ...");
						
							}else{
								p.sendMessage("votre home est obstrué");
							}
						
						}else{
								p.sendMessage("vous n'avez pas le droit d'utiliser le home dans une dimantion diferente");
						}
					}else{
						if(Main.getconfig().getString("player." + p.getUniqueId().toString() + ".home.world").equals(p.getWorld().getName()) || p.hasPermission("homeinterworld")){
						
							Location loc = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".home.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".home.x"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".home.y"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".home.z"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".home.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".home.pitch"));
							Location loc2 = new Location(loc.getWorld(), loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ(), loc.getYaw(), loc.getPitch());
						
							if((loc.getBlock().getType() == Material.AIR || loc.getBlock().getType() == Material.WATER || loc.getBlock().getType() == Material.WATER_LILY || loc.getBlock().getType() == Material.STATIONARY_WATER) && (loc2.getBlock().getType() == Material.AIR || loc2.getBlock().getType() == Material.WATER || loc2.getBlock().getType() == Material.WATER_LILY || loc2.getBlock().getType() == Material.STATIONARY_WATER)){
						
								DelayedHome tp	= new DelayedHome(p, "home", loc, 5, null);
								Main.addHome(tp);
								Main.addHomeName(p.getName());
								
								((com.trafalcraft.ludo.Main.DelayedHome)Main.getHome(Main.homeNameIndexOf(p.getName()))).startTpTimer();
								
							}
						}else{
							p.sendMessage("vous n'avez pas le droit d'utiliser le home dans une dimantion diferente");
						}
					}
				}else{
					p.sendMessage("vous ne pouvez pas lancer 2 home en meme temps");
				}
			}else{
				p.sendMessage("vous n'avez pas definie de home");
			}
		}else{
			if(p.hasPermission("bedhome")){
				BedHome.bedHome(p, args);
			}else{
				p.sendMessage("vous n'avez pas acces a cette commande");
			}
		}
	}

}
