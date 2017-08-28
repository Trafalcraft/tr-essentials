package com.trafalcraft.ludo.Main;

import org.bukkit.entity.Player;

public class SetSpawn {
	public static void setspawn(Player p, String[] args){
		if(p.isOp() == true){
			
			Main.getconfig().set("spawn.world", p.getLocation().getWorld().getName());
			Main.getconfig().set("spawn.x", p.getLocation().getX());
			Main.getconfig().set("spawn.y", p.getLocation().getY());
			Main.getconfig().set("spawn.z", p.getLocation().getZ());
			Main.getconfig().set("spawn.yaw", p.getLocation().getYaw());
			Main.getconfig().set("spawn.pitch", p.getLocation().getPitch());
			Main.saveconfig();
			
			p.sendMessage("spawn enregistré");
		}
	}
}
