package com.trafalcraft.ludo.Main;

import org.bukkit.entity.Player;

public class DeleteWarp {
	public static void deletewarp(Player p, String[] args){
		if(p.hasPermission("adminwarp")){
			if(args.length == 1){
				if(Main.getconfig().contains("warp." + args[0])){
					
					Main.getconfig().set("warp." + args[0], null);
					Main.saveconfig();
					p.sendMessage("warp detruit");
				
				}else{
					p.sendMessage("ce warp n'existe pas");
				}
			}else{
				p.sendMessage("la commande est incomplete");
			}
		}else{
			p.sendMessage("vous n'avez pas l'autorisation d'utiliser cette commande");
		}
	}
}
