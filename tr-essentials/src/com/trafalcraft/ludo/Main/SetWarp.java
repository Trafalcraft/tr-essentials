package com.trafalcraft.ludo.Main;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class SetWarp {
	public static void setWarp(Player p, String[] args){
		if(p.hasPermission("adminwarp")){
			if(args.length == 1){
				
				ArrayList<String> nomwarp = new ArrayList<String>();
				
				if(Main.getconfig().getConfigurationSection("warp") != null){
			
					for(String aname : Main.getconfig().getConfigurationSection("warp").getKeys(false)){
						nomwarp.add(aname);
					}
				}
				
				if(!(Main.getconfig().contains("warp." + args[0]))){
					
					Main.getconfig().set("warp." + args[0] + ".world", p.getLocation().getWorld().getName());
					Main.getconfig().set("warp." + args[0] + ".x", p.getLocation().getX());
					Main.getconfig().set("warp." + args[0] + ".y", p.getLocation().getY());
					Main.getconfig().set("warp." + args[0] + ".z", p.getLocation().getZ());
					Main.getconfig().set("warp." + args[0] + ".yaw", p.getLocation().getYaw());
					Main.getconfig().set("warp." + args[0] + ".pitch", p.getLocation().getPitch());
					Main.saveconfig();
					
					p.sendMessage("warp enregistré");
				}else{
					p.sendMessage("ce nom de warp est deja atribué");
				}
			}else{
				p.sendMessage("la commande est imcomplete");
			}
		}else{
			p.sendMessage("vous n'avez pas l'autorisation d'utiliser cette commande");
		}
	}
}
