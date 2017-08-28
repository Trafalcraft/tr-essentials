package com.trafalcraft.ludo.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Jail {
	public static void jail(Player p, String[] args){
		if(p.hasPermission("jail")){
			
			if(args.length == 4){
				
				if(Main.getconfig().getConfigurationSection("jail." + args[2]) != null){
				
					if(Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))){
					
						if(!(Bukkit.getPlayer(args[0]).hasPermission("jail"))){
						
							char unity = args[1].charAt(args[1].length() - 1);
			
							if(Character.compare(unity, 's') == 0 || Character.compare(unity, 'm') == 0 || Character.compare(unity, 'h') == 0 || Character.compare(unity, 'd') == 0){
							
								String args2 = args[1].replaceAll("s", "");
								args2 = args2.replaceAll("m", "");
								args2 = args2.replaceAll("h", "");
								args2 = args2.replaceAll("d", "");
							
								try{
									Integer duration = Integer.valueOf(args2);
									int finalduration = 0;
							
									if(Character.compare(unity, 's') == 0 ){
										finalduration = duration;
									}else if(Character.compare(unity, 'm') == 0){
										finalduration = 60*duration;
									}else if(Character.compare(unity, 'h') == 0){
										finalduration = 3600*duration;
									}else if(Character.compare(unity, 'd') == 0){
										finalduration = 86400*duration;
									}
									DelayedHome tp	= new DelayedHome(Bukkit.getPlayer(args[0]), "jail", Bukkit.getPlayer(args[0]).getLocation(), finalduration, args[2]);
									Main.addjail(tp);
									Main.addjailName(Bukkit.getPlayer(args[0]).getName());
								
									((com.trafalcraft.ludo.Main.DelayedHome)Main.getjail(Main.jailNameIndexOf(Bukkit.getPlayer(args[0]).getName()))).startTpTimer();
								
									Location loc = new Location(Bukkit.getWorld(Main.getconfig().getString("jail." + args[2] + ".world")), Main.getconfig().getDouble("jail." + args[2] + ".x"), Main.getconfig().getDouble("jail." + args[2] + ".y"),Main.getconfig().getDouble("jail." + args[2] + ".z"),(float)Main.getconfig().getDouble("jail." + args[2] + ".yaw"),(float)Main.getconfig().getDouble("jail." + args[2] + ".pitch"));
									Bukkit.getPlayer(args[0]).teleport(loc);
									Bukkit.getPlayer(args[0]).sendMessage("vous avez étè jail pour : " + args[3]);

									}catch(NumberFormatException e){
										p.sendMessage("durée invalide");
									}
						
							}else{
								p.sendMessage("durée invalide");
							}
						}else{
							p.sendMessage("vous n'avez pas le droit de jail cette personne");
						}
					}else{
						p.sendMessage("joueur introuvable");
					}
				}else{
					p.sendMessage("ce jail n'existe pas");
				}
			}else{
				p.sendMessage("la commande est imcomplete");
			}
		}else{
			p.sendMessage("vous n'avez pas l'autorisation d'utiliser cette commande");
		}
	}
}
