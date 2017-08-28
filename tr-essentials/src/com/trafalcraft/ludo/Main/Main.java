package com.trafalcraft.ludo.Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	private static Main plugin;
	public EventClass ec;
	private ArrayList <Object> homeList = new ArrayList<Object>();
	private ArrayList <String> homeName = new ArrayList<String>();
	private ArrayList <Object> bedhomeList = new ArrayList<Object>();
	private ArrayList <String> bedhomeName = new ArrayList<String>();
	private ArrayList <Object> spawnList = new ArrayList<Object>();
	private ArrayList <String> spawnName = new ArrayList<String>();
	private ArrayList <Object> jailList = new ArrayList<Object>();
	private ArrayList <String> jailName = new ArrayList<String>();
	private ArrayList <Object> warpList = new ArrayList<Object>();
	private ArrayList <String> warpName = new ArrayList<String>();
	
	public void onEnable() {
		getConfig().options().copyDefaults(false);
		this.ec = new EventClass();
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents((Listener) ec,this);
		
		plugin = this;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		
		if(command.getName().equalsIgnoreCase("sethome")){
			Sethome.setHome(p,args);
		}else if(command.getName().equalsIgnoreCase("home")){
			Home.home(p, args);
		}else if(command.getName().equalsIgnoreCase("bedhome")){
			BedHome.bedHome(p,args);
		}else if(command.getName().equalsIgnoreCase("setspawn")){
			SetSpawn.setspawn(p, args);
		}else if(command.getName().equalsIgnoreCase("spawn")){
			Spawn.spawn(p, args);
		}else if(command.getName().equalsIgnoreCase("jail")){
			Jail.jail(p, args);
		}else if(command.getName().equalsIgnoreCase("setjail")){
			SetJail.setJail(p, args);
		}else if(command.getName().equalsIgnoreCase("unjail")){
			UnJail.unJail(p, args);
		}else if(command.getName().equalsIgnoreCase("deletejail")){
			DeleteJail.deletejail(p, args);
		}else if(command.getName().equalsIgnoreCase("setwarp")){
			SetWarp.setWarp(p, args);
		}else if(command.getName().equalsIgnoreCase("deletewarp")){
			DeleteWarp.deletewarp(p, args);
		}else if(command.getName().equalsIgnoreCase("warp")){
			Warp.warp(p, args);
		}
		return false;
	}
	
	//-------------------------------------------------------------------------------------------------------------
	
	public static FileConfiguration getconfig(){
		return plugin.getConfig();
	}
	
	public static Main getPlugin(){
		return plugin;
	}
	public static void saveconfig(){
		plugin.saveConfig();
	}
	
	//--------------------------------------------------------------------------------------------------------------
	
	public static void addHome(Object i){
		getPlugin().homeList.add(i);
	}
	public static void removeHome(int i){
		plugin.homeList.remove(i);
	}
	public static Object getHome(int i){
		return plugin.homeList.get(i);
	}
	
	//--------------------------------------------------------------------------------------------------------------
	
	public static void addHomeName(String i){
		getPlugin().homeName.add(i);
	}
	public static void removeHomeName(int i){
		plugin.homeName.remove(i);
	}
	public static int homeNameIndexOf(String i){
		return plugin.homeName.indexOf(i);
	}
	public static boolean homeNameContains(String i){
		return plugin.homeName.contains(i);
	}
	
	//---------------------------------------------------------------------------------------------------------------
	
	public static void addbedHome(Object i){
		getPlugin().bedhomeList.add(i);
	}
	public static void removebedHome(int i){
		plugin.bedhomeList.remove(i);
	}
	public static Object getbedHome(int i){
		return plugin.bedhomeList.get(i);
	}
	
	//---------------------------------------------------------------------------------------------------------------
	
	public static void addbedHomeName(String i){
		getPlugin().bedhomeName.add(i);
	}
	public static void removebedHomeName(int i){
		plugin.bedhomeName.remove(i);
	}
	public static int bedhomeNameIndexOf(String i){
		return plugin.bedhomeName.indexOf(i);
	}
	public static boolean bedhomeNameContains(String i){
		return plugin.bedhomeName.contains(i);
	}
	
	//---------------------------------------------------------------------------------------------------------------
	
	public static void addspawn(Object i){
		getPlugin().spawnList.add(i);
	}
	public static void removespawn(int i){
		plugin.spawnList.remove(i);
	}
	public static Object getspawn(int i){
		return plugin.spawnList.get(i);
	}
		
	//---------------------------------------------------------------------------------------------------------------
		
	public static void addspawnName(String i){
		getPlugin().spawnName.add(i);
	}
	public static void removespawnName(int i){
			plugin.spawnName.remove(i);
	}
	public static int spawnNameIndexOf(String i){
		return plugin.spawnName.indexOf(i);
	}
	public static boolean spawnNameContains(String i){
		return plugin.spawnName.contains(i);
	}
	
	//---------------------------------------------------------------------------------------------------------------
	
	public static void addjail(Object i){
		getPlugin().jailList.add(i);
	}
	public static void removejail(int i){
		plugin.jailList.remove(i);
	}
	public static Object getjail(int i){
		return plugin.jailList.get(i);
	}
			
	//---------------------------------------------------------------------------------------------------------------
			
	public static void addjailName(String i){
		getPlugin().jailName.add(i);
	}
	public static void removejailName(int i){
			plugin.jailName.remove(i);
	}
	public static int jailNameIndexOf(String i){
		return plugin.jailName.indexOf(i);
	}
	public static boolean jailNameContains(String i){
		return plugin.jailName.contains(i);
	}
	
	//---------------------------------------------------------------------------------------------------------------
	
	public static void addwarp(Object i){
		getPlugin().warpList.add(i);
	}
	public static void removewarp(int i){
		plugin.warpList.remove(i);
	}
	public static Object getwarp(int i){
		return plugin.warpList.get(i);
	}
			
	//---------------------------------------------------------------------------------------------------------------
			
	public static void addwarpName(String i){
		getPlugin().warpName.add(i);
	}
	public static void removewarpName(int i){
			plugin.warpName.remove(i);
	}
	public static int warpNameIndexOf(String i){
		return plugin.warpName.indexOf(i);
	}
	public static boolean warpNameContains(String i){
		return plugin.warpName.contains(i);
	}
}
