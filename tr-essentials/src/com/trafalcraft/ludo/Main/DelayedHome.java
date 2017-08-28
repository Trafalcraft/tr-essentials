package com.trafalcraft.ludo.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class DelayedHome {
	
	private Player player;
	private int taskTp;
	private int temps;
	private String type;
	private Location loc;
	private String jail;

	public DelayedHome(Player player, String type, Location loc, int temps, String jail){
		this.player = player;
		this.type = type;
		this.loc = loc;
		this.temps = temps;
		this.jail = jail;
	}
		
	public void startTpTimer(){
		this.taskTp = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            public void run() {
            	
            	if(temps == 4){
            		player.sendMessage("attendez avant d'etre teleporté");
            	}
            	if(temps == 0){
            		
            			player.teleport(loc);
            		
            		stopTpTimer(true);
            	} 
            		temps = temps-1;
            }
         }, 0, 20);
		
	}
	
	public void stopTpTimer(Boolean i){
		Bukkit.getServer().getScheduler().cancelTask(this.taskTp);
		if(i == true){
			player.sendMessage("teleportation ...");
		}else{
			player.sendMessage("teleportation annullé");
		}
		
		if(type.equalsIgnoreCase("home")){
			
			int index = Main.homeNameIndexOf(this.player.getName());
			Main.removeHome(index);
			Main.removeHomeName(index);
			
		}else if(type.equalsIgnoreCase("bedhome")){
			
			int index = Main.bedhomeNameIndexOf(this.player.getName());
			Main.removebedHome(index);
			Main.removebedHomeName(index);
			
		}else if(type.equalsIgnoreCase("spawn")){
			
			int index = Main.spawnNameIndexOf(this.player.getName());
			Main.removespawn(index);
			Main.removespawnName(index);
			
		}else if(type.equalsIgnoreCase("jail")){
			
			int index = Main.jailNameIndexOf(this.player.getName());
			Main.removejail(index);
			Main.removejailName(index);
			
		}else if(type.equalsIgnoreCase("warp")){
			
			int index = Main.warpNameIndexOf(this.player.getName());
			Main.removewarp(index);
			Main.removewarpName(index);
		}
	}
	
	public void pauseTimer(){
		Bukkit.getServer().getScheduler().cancelTask(this.taskTp);
		
		int index = Main.jailNameIndexOf(this.player.getName());
		Main.removejail(index);
		Main.removejailName(index);
		
	}
	
	public Location getLoc(){
		return this.loc;
	}
	
	public int getTemps(){
		return this.temps;
	}
	
	public String getJail(){
		return this.jail;
	}
}
