package com.trafalcraft.ludo.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BedHome {
	public static void bedHome(Player p, String[] args){
		if(p.hasPermission("bedhome")){
			
			if(Main.getconfig().contains("player." + p.getUniqueId().toString() + ".bedhome.x")){
				
				if(!(Main.bedhomeNameContains(p.getName()))){
					
					Location pos1 = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x") +1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos1bis = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x") +1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y")+1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos2 = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x") -1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos2bis = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x") -1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y")+1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos3 = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z") +1, (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos3bis = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y")+1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z") +1, (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos4 = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z") -1, (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos4bis = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y")+1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z") -1, (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos5 = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x") +1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z")+1, (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos5bis = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x") +1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y")+1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z")+1, (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos6 = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x") +1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z")-1, (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos6bis = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x") +1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y")+1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z")-1, (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos7 = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x")-1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z") +1, (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos7bis = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x")-1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y")+1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z") +1, (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos8 = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x")-1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z") -1, (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					Location pos8bis = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x")-1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y")+1, Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z") -1, (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
					
					if(p.hasPermission("noDelayedbedHome")){
						
						if(Main.getconfig().getString("player." + p.getUniqueId().toString() + ".bedhome.world").equals(p.getWorld().getName()) || p.hasPermission("bedhomeinterworld")){
							
							Location pos = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
							if(pos.getBlock().getType() == Material.BED || pos.getBlock().getType() == Material.BED_BLOCK){
								
								if(pos1.getBlock().getType() == Material.AIR && pos1bis.getBlock().getType() == Material.AIR){
									p.teleport(pos1);
									p.sendMessage("teleportation ...");
								}else if(pos2.getBlock().getType() == Material.AIR && pos2bis.getBlock().getType() == Material.AIR){
									p.teleport(pos2);
									p.sendMessage("teleportation ...");
								}else if(pos3.getBlock().getType() == Material.AIR && pos3bis.getBlock().getType() == Material.AIR){
									p.teleport(pos3);
									p.sendMessage("teleportation ...");
								}else if(pos4.getBlock().getType() == Material.AIR && pos4bis.getBlock().getType() == Material.AIR){
									p.teleport(pos4);
									p.sendMessage("teleportation ...");
								}else if(pos5.getBlock().getType() == Material.AIR && pos5bis.getBlock().getType() == Material.AIR){
									p.teleport(pos5);
									p.sendMessage("teleportation ...");
								}else if(pos6.getBlock().getType() == Material.AIR && pos6bis.getBlock().getType() == Material.AIR){
									p.teleport(pos6);
									p.sendMessage("teleportation ...");
								}else if(pos7.getBlock().getType() == Material.AIR && pos7bis.getBlock().getType() == Material.AIR){
									p.teleport(pos7);
									p.sendMessage("teleportation ...");
								}else if(pos8.getBlock().getType() == Material.AIR && pos8bis.getBlock().getType() == Material.AIR){
									p.teleport(pos8);
									p.sendMessage("teleportation ...");
								}else{
									p.sendMessage("votre lit est obstrué");
								}
				
							}else{
								p.sendMessage("vous lit a étè detruit");
							}
						}else{
							
							p.sendMessage("vous n'avez pas le droit d'utiliser le home dans une dimantion diferente");
							
						}						
					}else{
						if(Main.getconfig().getString("player." + p.getUniqueId().toString() + ".bedhome.world").equals(p.getWorld().getName()) || p.hasPermission("bedhomeinterworld")){
							Location pos = new Location(Bukkit.getWorld(Main.getconfig().getString("player."  + p.getUniqueId().toString() + ".bedhome.world")), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.x"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.y"), Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.z"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.yaw"), (float)Main.getconfig().getDouble("player."  + p.getUniqueId().toString() + ".bedhome.pitch"));
							if(pos.getBlock().getType() == Material.BED || pos.getBlock().getType() == Material.BED_BLOCK){
								
								if(pos1.getBlock().getType() == Material.AIR && pos1bis.getBlock().getType() == Material.AIR){
									DelayedHome tp	= new DelayedHome(p, "bedhome", pos1, 5, null);
									Main.addbedHome(tp);
									Main.addbedHomeName(p.getName());
									
									((com.trafalcraft.ludo.Main.DelayedHome)Main.getbedHome(Main.bedhomeNameIndexOf(p.getName()))).startTpTimer();
								}else if(pos2.getBlock().getType() == Material.AIR && pos2bis.getBlock().getType() == Material.AIR){
									DelayedHome tp	= new DelayedHome(p, "bedhome", pos2, 5, null);
									Main.addbedHome(tp);
									Main.addbedHomeName(p.getName());
									
									((com.trafalcraft.ludo.Main.DelayedHome)Main.getbedHome(Main.bedhomeNameIndexOf(p.getName()))).startTpTimer();
								}else if(pos3.getBlock().getType() == Material.AIR && pos3bis.getBlock().getType() == Material.AIR){
									DelayedHome tp	= new DelayedHome(p, "bedhome", pos3, 5, null);
									Main.addbedHome(tp);
									Main.addbedHomeName(p.getName());
									
									((com.trafalcraft.ludo.Main.DelayedHome)Main.getbedHome(Main.bedhomeNameIndexOf(p.getName()))).startTpTimer();
								}else if(pos4.getBlock().getType() == Material.AIR && pos4bis.getBlock().getType() == Material.AIR){
									DelayedHome tp	= new DelayedHome(p, "bedhome", pos4, 5, null);
									Main.addbedHome(tp);
									Main.addbedHomeName(p.getName());
									
									((com.trafalcraft.ludo.Main.DelayedHome)Main.getbedHome(Main.bedhomeNameIndexOf(p.getName()))).startTpTimer();
								}else if(pos5.getBlock().getType() == Material.AIR && pos5bis.getBlock().getType() == Material.AIR){
									DelayedHome tp	= new DelayedHome(p, "bedhome", pos5, 5, null);
									Main.addbedHome(tp);
									Main.addbedHomeName(p.getName());
									
									((com.trafalcraft.ludo.Main.DelayedHome)Main.getbedHome(Main.bedhomeNameIndexOf(p.getName()))).startTpTimer();
								}else if(pos6.getBlock().getType() == Material.AIR && pos6bis.getBlock().getType() == Material.AIR){
									DelayedHome tp	= new DelayedHome(p, "bedhome", pos6, 5, null);
									Main.addbedHome(tp);
									Main.addbedHomeName(p.getName());
									
									((com.trafalcraft.ludo.Main.DelayedHome)Main.getbedHome(Main.bedhomeNameIndexOf(p.getName()))).startTpTimer();
								}else if(pos7.getBlock().getType() == Material.AIR && pos7bis.getBlock().getType() == Material.AIR){
									DelayedHome tp	= new DelayedHome(p, "bedhome", pos7, 5, null);
									Main.addbedHome(tp);
									Main.addbedHomeName(p.getName());
									
									((com.trafalcraft.ludo.Main.DelayedHome)Main.getbedHome(Main.bedhomeNameIndexOf(p.getName()))).startTpTimer();
								}else if(pos8.getBlock().getType() == Material.AIR && pos8bis.getBlock().getType() == Material.AIR){
									DelayedHome tp	= new DelayedHome(p, "bedhome", pos8, 5, null);
									Main.addbedHome(tp);
									Main.addbedHomeName(p.getName());
									
									((com.trafalcraft.ludo.Main.DelayedHome)Main.getbedHome(Main.bedhomeNameIndexOf(p.getName()))).startTpTimer();
								}else{
									p.sendMessage("votre lit est obstrué");
								}							
								
							}else{
								p.sendMessage("vous lit a étè detruit");
							}
						}else{
							
							p.sendMessage("vous n'avez pas le droit d'utiliser le home dans une dimantion diferente");
							
						}
					}
				}else{
					p.sendMessage("vous ne pouvez pas lancer 2 bedhome en meme temps");
				}
			}else{
				p.sendMessage("vous n'avez pas definie de bedhome");
			}
		}else{
			
			p.sendMessage("vous n'avez pas acces a cette commande");
		}
	}
}
