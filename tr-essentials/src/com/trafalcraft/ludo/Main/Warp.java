package com.trafalcraft.ludo.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Warp {
	public static void warp(Player p, String[] args){
		if(p.hasPermission("warp")){
			if(args.length == 1){
				if(Main.getconfig().contains("warp." + args[0] + ".x")){
					if(!(Main.warpNameContains(p.getName()))){
						if(p.hasPermission("nodelayedwarp")){
							if(Bukkit.getWorld(Main.getconfig().getString("warp." + args[0] + ".world")).equals(p.getLocation().getWorld()) || p.hasPermission("warpinterworld")){
							
								Location loc = new Location(Bukkit.getWorld(Main.getconfig().getString("warp." + args[0] + ".world")), Main.getconfig().getDouble("warp." + args[0] + ".x"), Main.getconfig().getDouble("warp." + args[0] + ".y"), Main.getconfig().getDouble("warp." + args[0] + ".z"), (float)Main.getconfig().getDouble("warp." + args[0] + ".yaw"), (float)Main.getconfig().getDouble("warp." + args[0] + ".pitch"));
								p.teleport(loc);
								p.sendMessage("teleportation ...");
								
								
							}else{
								p.sendMessage("vous n'avez pas le droit d'utiliser le warp dans une dimantion diferente");
							}
						}else{
							if(Bukkit.getWorld(Main.getconfig().getString("warp." + args[0] + ".world")).equals(p.getLocation().getWorld()) || p.hasPermission("warpinterworld")){
								
								Location loc = new Location(Bukkit.getWorld(Main.getconfig().getString("warp." + args[0] + ".world")), Main.getconfig().getDouble("warp." + args[0] + ".x"), Main.getconfig().getDouble("warp." + args[0] + ".y"), Main.getconfig().getDouble("warp." + args[0] + ".z"), (float)Main.getconfig().getDouble("warp." + args[0] + ".yaw"), (float)Main.getconfig().getDouble("warp." + args[0] + ".pitch"));
								
								DelayedHome tp	= new DelayedHome(p, "warp", loc, 5, null);
								Main.addwarp(tp);
								Main.addwarpName(p.getName());
								
								((com.trafalcraft.ludo.Main.DelayedHome)Main.getwarp(Main.warpNameIndexOf(p.getName()))).startTpTimer();
																
							}else{
								p.sendMessage("vous n'avez pas le droit d'utiliser le warp dans une dimantion diferente");
							}						
						}
					}else{
						p.sendMessage("vous ne pouvez pas lancer 2 warp en meme temps");
					}
				}else{
					p.sendMessage("ce warp n'existe pas");
				}
			}else{
				p.sendMessage("la commande est incomplete");
			}
		}else{
			p.sendMessage("vous n'avez pas acces a cette commande");
		}
	}
}
