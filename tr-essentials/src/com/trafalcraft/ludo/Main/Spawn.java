package com.trafalcraft.ludo.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Spawn {
	public static void spawn(Player p, String[] args){
		if(p.hasPermission("spawn")){
			if(Main.getconfig().contains("spawn.x")){
				if(!(Main.spawnNameContains(p.getName()))){
					
					Location loc = new Location(Bukkit.getWorld(Main.getconfig().getString("spawn.world")),Main.getconfig().getDouble("spawn.x"),Main.getconfig().getDouble("spawn.y"),Main.getconfig().getDouble("spawn.z"),(float)Main.getconfig().getDouble("spawn.yaw"),(float)Main.getconfig().getDouble("spawn.pitch"));
					
					if(p.hasPermission("delayedspawn")){
						if(Main.getconfig().getString("spawn.world").equals(p.getWorld().getName()) || p.hasPermission("bedhomeinterworld")){
							
							p.teleport(loc);
							
							p.sendMessage("teleportation ...");
						}else{
							p.sendMessage("vous n'avez pas le droit d'utiliser le home dans une dimantion diferente");
						}
					}else{
						if(Main.getconfig().getString("spawn.world").equals(p.getWorld().getName()) || p.hasPermission("bedhomeinterworld")){
							DelayedHome tp	= new DelayedHome(p, "spawn", loc, 5, null);
							Main.addspawn(tp);
							Main.addspawnName(p.getName());
							
							((com.trafalcraft.ludo.Main.DelayedHome)Main.getspawn(Main.spawnNameIndexOf(p.getName()))).startTpTimer();
						}else{
							p.sendMessage("vous n'avez pas le droit d'utiliser le home dans une dimantion diferente");
						}
					}
				}else{
					p.sendMessage("vous ne pouvez pas lancer 2 bedhome en meme temps");
				}
			}else{
				p.sendMessage("vous n'avez pas acces a cette commande");
			}
		}else{
			p.sendMessage("vous n'avez pas acces a cette commande");
		}
	}
}
