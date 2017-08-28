package com.trafalcraft.ludo.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventClass implements Listener {
	

	@EventHandler
	public void onPlayerJoint(PlayerJoinEvent e){
		if(!(Main.getconfig().getConfigurationSection("player").contains(e.getPlayer().getUniqueId().toString()))){
			Main.getconfig().set("player." + e.getPlayer().getUniqueId().toString() + ".name", e.getPlayer().getName());
			Main.saveconfig();
			
		}else if(Main.getconfig().contains("jailwait." + e.getPlayer().getName() + ".loc.x")){
			
			Location loc = new Location(Bukkit.getWorld(Main.getconfig().getString("jailwait." + e.getPlayer().getName() + ".loc.world")), Main.getconfig().getDouble("jailwait." + e.getPlayer().getName() + ".loc.x"), Main.getconfig().getDouble("jailwait." + e.getPlayer().getName() + ".loc.y"), Main.getconfig().getDouble("jailwait." + e.getPlayer().getName() + ".loc.z"), (float)Main.getconfig().getDouble("jailwait." + e.getPlayer().getName() + ".loc.yaw"), (float)Main.getconfig().getDouble("jailwait." + e.getPlayer().getName() + ".loc.pitch"));
			
			DelayedHome tp	= new DelayedHome(e.getPlayer(), "jail", loc, Main.getconfig().getInt("jailwait." + e.getPlayer().getName() + "temps"), Main.getconfig().getString("jailwait." + e.getPlayer().getName() + "jail"));
			Main.addjail(tp);
			Main.addjailName(e.getPlayer().getName());
			
			((com.trafalcraft.ludo.Main.DelayedHome)Main.getjail(Main.jailNameIndexOf(e.getPlayer().getName()))).startTpTimer();
			
			Location loc2 = new Location(Bukkit.getWorld(Main.getconfig().getString("jail." + Main.getconfig().getString("jailwait." + e.getPlayer().getName() + ".jail") + ".world")), Main.getconfig().getDouble("jail." + Main.getconfig().getString("jailwait." + e.getPlayer().getName() + ".jail") + ".x"), Main.getconfig().getDouble("jail." + Main.getconfig().getString("jailwait." + e.getPlayer().getName() + ".jail") + ".y"),Main.getconfig().getDouble("jail." + Main.getconfig().getString("jailwait." + e.getPlayer().getName() + ".jail") + ".z"),(float)Main.getconfig().getDouble("jail." + Main.getconfig().getString("jailwait." + e.getPlayer().getName() + ".jail") + ".yaw"),(float)Main.getconfig().getDouble("jail." + Main.getconfig().getString("jailwait." + e.getPlayer().getName() + ".jail") + ".pitch"));
			e.getPlayer().teleport(loc2);
			Main.getconfig().set("jailwait." + e.getPlayer().getName(), null);
			Main.saveconfig();
			
		
		}
	}
	
	@EventHandler
	public void onplayermove(PlayerMoveEvent e){
		if(Main.homeNameContains(e.getPlayer().getName())){
			if(e.getTo().getBlockX() != e.getFrom().getBlockX() || e.getTo().getBlockY() != e.getFrom().getBlockY() || e.getTo().getBlockZ() != e.getFrom().getBlockZ()){
				
				int index = Main.homeNameIndexOf(e.getPlayer().getName());
				((com.trafalcraft.ludo.Main.DelayedHome) Main.getHome(index)).stopTpTimer(false);
			}
		}else if(Main.bedhomeNameContains(e.getPlayer().getName())){
			if(e.getTo().getBlockX() != e.getFrom().getBlockX() || e.getTo().getBlockY() != e.getFrom().getBlockY() || e.getTo().getBlockZ() != e.getFrom().getBlockZ()){
				
				int index = Main.bedhomeNameIndexOf(e.getPlayer().getName());
				((com.trafalcraft.ludo.Main.DelayedHome) Main.getbedHome(index)).stopTpTimer(false);
			}
		}else if(Main.spawnNameContains(e.getPlayer().getName())){
			if(e.getTo().getBlockX() != e.getFrom().getBlockX() || e.getTo().getBlockY() != e.getFrom().getBlockY() || e.getTo().getBlockZ() != e.getFrom().getBlockZ()){
				
				int index = Main.spawnNameIndexOf(e.getPlayer().getName());
				((com.trafalcraft.ludo.Main.DelayedHome) Main.getspawn(index)).stopTpTimer(false);
			}
		}else if(Main.warpNameContains(e.getPlayer().getName())){
			if(e.getTo().getBlockX() != e.getFrom().getBlockX() || e.getTo().getBlockY() != e.getFrom().getBlockY() || e.getTo().getBlockZ() != e.getFrom().getBlockZ()){
				
				int index = Main.warpNameIndexOf(e.getPlayer().getName());
				((com.trafalcraft.ludo.Main.DelayedHome) Main.getwarp(index)).stopTpTimer(false);
			}
		}
	}
	
	@EventHandler
	public void onentitydamage(EntityDamageEvent e){
		if(e.getEntity().getType() == EntityType.PLAYER){
			if(Main.homeNameContains(((Player)e.getEntity()).getName())){
				
				int index = Main.homeNameIndexOf(((Player)e.getEntity()).getName());
				((com.trafalcraft.ludo.Main.DelayedHome) Main.getHome(index)).stopTpTimer(false);
			}else if(Main.bedhomeNameContains(((Player)e.getEntity()).getName())){
					
				int index = Main.bedhomeNameIndexOf(((Player)e.getEntity()).getName());
				((com.trafalcraft.ludo.Main.DelayedHome) Main.getbedHome(index)).stopTpTimer(false);
				
			}else if(Main.spawnNameContains(((Player)e.getEntity()).getName())){
				
				int index = Main.spawnNameIndexOf(((Player)e.getEntity()).getName());
				((com.trafalcraft.ludo.Main.DelayedHome) Main.getspawn(index)).stopTpTimer(false);
			
			}else if(Main.jailNameContains(((Player)e.getEntity()).getName())){
				
				e.setCancelled(true);
				
			}else if(Main.warpNameContains(((Player)e.getEntity()).getName())){
				
				int index = Main.warpNameIndexOf(((Player)e.getEntity()).getName());
				((com.trafalcraft.ludo.Main.DelayedHome) Main.getwarp(index)).stopTpTimer(false);
			
			}
		}
	}
	
	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent e){
		if(Main.homeNameContains(e.getPlayer().getName())){
				
			int index = Main.homeNameIndexOf(e.getPlayer().getName());
			((com.trafalcraft.ludo.Main.DelayedHome) Main.getHome(index)).stopTpTimer(false);
			
		}else if(Main.bedhomeNameContains(((Player)e.getPlayer()).getName())){
			
			int index = Main.bedhomeNameIndexOf(((Player)e.getPlayer()).getName());
			((com.trafalcraft.ludo.Main.DelayedHome) Main.getbedHome(index)).stopTpTimer(false);
		
		}else if(Main.spawnNameContains(((Player)e.getPlayer()).getName())){
			
			int index = Main.spawnNameIndexOf(((Player)e.getPlayer()).getName());
			((com.trafalcraft.ludo.Main.DelayedHome) Main.getspawn(index)).stopTpTimer(false);
		
		}else if(Main.jailNameContains(((Player)e.getPlayer()).getName())){
			
			int index = Main.jailNameIndexOf(((Player)e.getPlayer()).getName());
			
			Main.getconfig().set("jailwait." + e.getPlayer().getName() + ".loc.world", ((com.trafalcraft.ludo.Main.DelayedHome) Main.getjail(index)).getLoc().getWorld().getName());
			Main.getconfig().set("jailwait." + e.getPlayer().getName() + ".loc.x", ((com.trafalcraft.ludo.Main.DelayedHome) Main.getjail(index)).getLoc().getX());
			Main.getconfig().set("jailwait." + e.getPlayer().getName() + ".loc.y", ((com.trafalcraft.ludo.Main.DelayedHome) Main.getjail(index)).getLoc().getY());
			Main.getconfig().set("jailwait." + e.getPlayer().getName() + ".loc.z", ((com.trafalcraft.ludo.Main.DelayedHome) Main.getjail(index)).getLoc().getZ());
			Main.getconfig().set("jailwait." + e.getPlayer().getName() + ".loc.yaw", ((com.trafalcraft.ludo.Main.DelayedHome) Main.getjail(index)).getLoc().getYaw());
			Main.getconfig().set("jailwait." + e.getPlayer().getName() + ".loc.pitch", ((com.trafalcraft.ludo.Main.DelayedHome) Main.getjail(index)).getLoc().getPitch());
			Main.getconfig().set("jailwait." + e.getPlayer().getName() + ".temps", ((com.trafalcraft.ludo.Main.DelayedHome) Main.getjail(index)).getTemps());
			Main.getconfig().set("jailwait." + e.getPlayer().getName() + ".jail", ((com.trafalcraft.ludo.Main.DelayedHome) Main.getjail(index)).getJail());
			Main.saveconfig();
			
			((com.trafalcraft.ludo.Main.DelayedHome) Main.getjail(index)).pauseTimer();
		
		}else if(Main.warpNameContains(((Player)e.getPlayer()).getName())){
			
			int index = Main.warpNameIndexOf(((Player)e.getPlayer()).getName());
			((com.trafalcraft.ludo.Main.DelayedHome) Main.getwarp(index)).stopTpTimer(false);
		
		}
	}
	
	@EventHandler
	public void onBreackBlock(BlockBreakEvent e){
		if(Main.homeNameContains(e.getPlayer().getName())){
			
			int index = Main.homeNameIndexOf(e.getPlayer().getName());
			((com.trafalcraft.ludo.Main.DelayedHome) Main.getHome(index)).stopTpTimer(false);
			
		}else if(Main.bedhomeNameContains(((Player)e.getPlayer()).getName())){
			
			int index = Main.bedhomeNameIndexOf(((Player)e.getPlayer()).getName());
			((com.trafalcraft.ludo.Main.DelayedHome) Main.getbedHome(index)).stopTpTimer(false);

		}else if(Main.spawnNameContains(((Player)e.getPlayer()).getName())){
			
			int index = Main.spawnNameIndexOf(((Player)e.getPlayer()).getName());
			((com.trafalcraft.ludo.Main.DelayedHome) Main.getspawn(index)).stopTpTimer(false);
		
		}else if(Main.jailNameContains(((Player)e.getPlayer()).getName())){
	
			e.setCancelled(true);
	
			int index = Main.jailNameIndexOf(((Player)e.getPlayer()).getName());
			double temps = ((com.trafalcraft.ludo.Main.DelayedHome) Main.getjail(index)).getTemps();
			System.out.println(temps);
			
			if(temps < 60){
				e.getPlayer().sendMessage("il vous reste " + temps + " secondes de jail");
			}else if(temps < 3600){
				int temps2 = (int) (temps/60);
				e.getPlayer().sendMessage("il vous reste " + temps2 + " minutes de jail");
			}else{
				double temps2 = temps/3600;
				System.out.println(temps2);
				int tempsH = (int) temps2;
				System.out.println(tempsH);
				
				Double temps3 = temps2 - tempsH;
				System.out.println(temps3);
				int tempsMdeci = (int) (temps3 * 100);
				System.out.println(tempsMdeci);
				
				int tempsM = (int) (tempsMdeci * 0.6);
				System.out.println(tempsM);
				e.getPlayer().sendMessage("il vous reste " + tempsH + " heure(s) et " + tempsM + " minute(s) de jail");
			}
		}else if(Main.warpNameContains(((Player)e.getPlayer()).getName())){
			
			int index = Main.warpNameIndexOf(((Player)e.getPlayer()).getName());
			((com.trafalcraft.ludo.Main.DelayedHome) Main.getwarp(index)).stopTpTimer(false);
		
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		if(Main.homeNameContains(e.getPlayer().getName())){
			
			int index = Main.homeNameIndexOf(e.getPlayer().getName());
			((com.trafalcraft.ludo.Main.DelayedHome) Main.getHome(index)).stopTpTimer(false);
			
		}else if(Main.bedhomeNameContains(((Player)e.getPlayer()).getName())){
			
			int index = Main.bedhomeNameIndexOf(((Player)e.getPlayer()).getName());
			((com.trafalcraft.ludo.Main.DelayedHome) Main.getbedHome(index)).stopTpTimer(false);
		
		}else if(Main.spawnNameContains(((Player)e.getPlayer()).getName())){
			
			int index = Main.spawnNameIndexOf(((Player)e.getPlayer()).getName());
			((com.trafalcraft.ludo.Main.DelayedHome) Main.getspawn(index)).stopTpTimer(false);
		
		}else if(Main.jailNameContains(((Player)e.getPlayer()).getName())){
			if(e.getAction() != Action.LEFT_CLICK_BLOCK){
				e.setCancelled(true);
			}
		}else if(Main.warpNameContains(((Player)e.getPlayer()).getName())){
			
			int index = Main.warpNameIndexOf(((Player)e.getPlayer()).getName());
			((com.trafalcraft.ludo.Main.DelayedHome) Main.getwarp(index)).stopTpTimer(false);
		
		}
	}
	
	@EventHandler
	public void onBed(PlayerBedEnterEvent e){
		if(e.getPlayer().hasPermission("bedhome")){
			
			Main.getconfig().set("player." + e.getPlayer().getUniqueId() + ".bedhome.world", e.getBed().getLocation().getWorld().getName());
			Main.getconfig().set("player." + e.getPlayer().getUniqueId() + ".bedhome.x", (e.getBed().getLocation().getX() + 0.5));
			Main.getconfig().set("player." + e.getPlayer().getUniqueId() + ".bedhome.y", e.getBed().getLocation().getY());
			Main.getconfig().set("player." + e.getPlayer().getUniqueId() + ".bedhome.z", (e.getBed().getLocation().getZ() + 0.5));
			Main.getconfig().set("player." + e.getPlayer().getUniqueId() + ".bedhome.yaw", e.getBed().getLocation().getYaw());
			Main.getconfig().set("player." + e.getPlayer().getUniqueId() + ".bedhome.pitch", e.getBed().getLocation().getPitch());
			Main.saveconfig();
			
			e.getPlayer().sendMessage("bedHome enregistrer");
		}
	}

	
}
