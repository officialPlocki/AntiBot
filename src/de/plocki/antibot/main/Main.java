package de.plocki.antibot.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.plocki.antibot.utils.BotHandler;
import de.plocki.antibot.utils.ListHandler;
import de.plocki.antibot.utils.Messenger;

public class Main extends JavaPlugin {
	
	//config
	
	public static double clienttime = 3;
	public static int clienttryes = 1;
	public static String kickmessage = "Bot";
	public static Plugin pl;
	
	
    @Override
    public void onEnable(){
    	pl = this;
       Messenger.sendConsole("Loading Plugin...");
       Bukkit.getPluginManager().registerEvents(new BotHandler(), this);
       init(pl);
    }
    
	@SuppressWarnings("deprecation")
	private static void init(Plugin pl) {
    	Bukkit.getScheduler().scheduleAsyncRepeatingTask(pl, new Runnable() {
			
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(ListHandler.ipbot.containsKey(p.getAddress().toString())) {
						if(Boolean.valueOf(ListHandler.ipbot.containsKey(p.getAddress().toString()))) {
							p.kickPlayer(kickmessage);
						}
					}
				}
				
			}
		}, 0, 20);
    }

}
