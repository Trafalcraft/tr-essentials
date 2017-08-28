package com.trafalcraft.ludo.Main;

import org.bukkit.entity.Player;

public class DeleteJail {
	public static void deletejail(Player p, String[] args){
		if(p.isOp()){
			if(args.length == 1){
				if(Main.getconfig().contains("jail." + args[0])){
					
					Main.getconfig().set("jail." + args[0], null);
					Main.saveconfig();
					p.sendMessage("jail detruit");
				
				}else{
					p.sendMessage("se jail n'existe pas");
				}
			}else{
				p.sendMessage("la commande est imcomplete");
			}
		}else{
			p.sendMessage("vous n'avez pas l'autorisation d'utiliser cette commande");
		}
	}
}
