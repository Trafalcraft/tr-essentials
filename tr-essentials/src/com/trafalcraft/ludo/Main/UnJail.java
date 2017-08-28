package com.trafalcraft.ludo.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UnJail {

	public static void unJail(Player p, String[] args) {
		if(p.hasPermission("jail")){
			if(args.length == 1){
				if(Main.jailNameContains(args[0])){
					
					int index = Main.jailNameIndexOf(args[0]);
					
					Bukkit.getPlayer(args[0]).teleport(((com.trafalcraft.ludo.Main.DelayedHome) Main.getjail(index)).getLoc());
					
					((com.trafalcraft.ludo.Main.DelayedHome) Main.getjail(index)).stopTpTimer(true);
					
				}else{
					p.sendMessage("se joueur n'est pas jail ou est deconecté");
				}
			}else{
				p.sendMessage("la commande est imcomplete");
			}
		}else{
			p.sendMessage("vous n'avez pas l'autorisation d'utiliser cette commande");
		}
	}

}
