package me.tariqdin.randomegg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomEgg extends JavaPlugin implements Listener{
	private List<EntityType> types;
	private List<String> allowed;
	
	private void loadStuff(){
		this.reloadConfig();
		allowed = getConfig().getStringList("allowed");
		
		
		types = new ArrayList<EntityType>();
		add(EntityType.BAT);
		add(EntityType.BLAZE);
		add(EntityType.BOAT);
		add(EntityType.CREEPER);
		add(EntityType.MINECART);
		add(EntityType.COW);
		add(EntityType.ZOMBIE);
		add(EntityType.GHAST);
		add(EntityType.WITCH);
		add(EntityType.WOLF);
		add(EntityType.MAGMA_CUBE);
		add(EntityType.CAVE_SPIDER);
		add(EntityType.SHEEP);
		add(EntityType.SPIDER);
		add(EntityType.CHICKEN);
		add(EntityType.ARROW);
		add(EntityType.PIG);
		add(EntityType.VILLAGER);
     	add(EntityType.SILVERFISH);
		add(EntityType.SQUID);
		add(EntityType.SNOWMAN);
		add(EntityType.IRON_GOLEM);
		add(EntityType.SLIME);
		add(EntityType.HORSE);
		add(EntityType.MUSHROOM_COW);
		add(EntityType.SKELETON);
		add(EntityType.PIG_ZOMBIE);
		add(EntityType.PRIMED_TNT);
		add(EntityType.OCELOT);
		
		
	}
	
	@Override
	public void onEnable() {
		if(!new File(this.getDataFolder(), "config.yml").exists()){ 
			this.saveDefaultConfig();
			this.saveConfig();
		}
		loadStuff();
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	Random egg = new Random();
	
	
	@EventHandler
	public void throwegg(PlayerEggThrowEvent event){
		int debug = egg.nextInt(types.size());
		//System.out.println(debug);
		event.setHatchingType(types.get(debug));
	}
	
	private void add(EntityType type){
		//System.out.println(type.toString());
		if(allowed.contains(type.toString())){
			types.add(type);
			//System.out.println(":)");
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		loadStuff();
		sender.sendMessage(ChatColor.GREEN + "CONFIG RELOADED!");
		return true;
	}

}
