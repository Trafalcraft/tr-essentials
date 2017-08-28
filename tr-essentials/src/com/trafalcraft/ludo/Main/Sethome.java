package com.trafalcraft.ludo.Main;

import org.bukkit.entity.Player;

public class Sethome {
	
	public static void setHome(Player p, String[] args){
		if(p.hasPermission("home") && (!(Main.spawnNameContains(p.getName())))){
			Main.getconfig().set("player." + p.getUniqueId().toString() + ".home.world", p.getLocation().getWorld().getName());
			Main.getconfig().set("player." + p.getUniqueId().toString() + ".home.x", p.getLocation().getX());
			Main.getconfig().set("player." + p.getUniqueId().toString() + ".home.y", p.getLocation().getY());
			Main.getconfig().set("player." + p.getUniqueId().toString() + ".home.z", p.getLocation().getZ());
			Main.getconfig().set("player." + p.getUniqueId().toString() + ".home.yaw", p.getLocation().getYaw());
			Main.getconfig().set("player." + p.getUniqueId().toString() + ".home.pitch", p.getLocation().getPitch());
			Main.saveconfig();
			
			p.sendMessage("home enregistrer");
		}else{
			p.sendMessage("vous n'avez pas acces a cette commande");
		}
	}

}
