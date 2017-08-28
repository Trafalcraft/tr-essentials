package com.trafalcraft.ludo.Main;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class SetJail {

	public static void setJail(Player p, String[] args){
		if(p.isOp()){
			if(args.length == 1){
				if(!(Main.getconfig().contains("jail." + args[0]))){
					Main.getconfig().set("jail."+ args[0] +".world", p.getLocation().getWorld().getName());
					Main.getconfig().set("jail."+ args[0] +".x", p.getLocation().getX());
					Main.getconfig().set("jail."+ args[0] +".y", p.getLocation().getY());
					Main.getconfig().set("jail."+ args[0] +".z", p.getLocation().getZ());
					Main.getconfig().set("jail."+ args[0] +".yaw", p.getLocation().getYaw());
					Main.getconfig().set("jail."+ args[0] +".pitch", p.getLocation().getPitch());
					Main.saveconfig();
					
					p.sendMessage("jail enregistré");
				}else{
					p.sendMessage("ce nom de jail est deja atribué");
				}
			}else{
				p.sendMessage("la commande est imcomplete");
			}
		}else{
			p.sendMessage("vous n'avez pas l'autorisation d'utiliser cette commande");
		}
	}
}
