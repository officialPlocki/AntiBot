package de.plocki.antibot.utils;

import java.util.HashMap;

public class ListHandler {
	
	public static HashMap<String, String> ipbot = new HashMap<String, String>();
	
	public static void inset(String ip, String name) {
		
		ipbot.put(ip, "false");
		
		//ConfigManager.getData().set("bot."+ip+".name", name);
		//ConfigManager.getData().set("bot."+ip+".ip", ip);
		//ConfigManager.getData().set("bot."+ip+".isbot", false);
		//ConfigManager.saveData();
	}
	
	public static boolean isInserted(String ip) {
		if(ipbot.containsKey(ip)/*ConfigManager.getData().isSet("bot."+ip+".isbot")*/) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void add(String ip) {

		ipbot.put(ip, "true");
		//ConfigManager.getData().set("bot."+ip+".isbot", true);
		//ConfigManager.saveData();
	}
	public static void remove(String ip) {
		ipbot.put(ip, "false");
		//ConfigManager.getData().set("bot."+ip+".isbot", false);
		//ConfigManager.saveData();
	}
	public static boolean contains(String ip) {
		if(Boolean.valueOf(ipbot.get(ip))) {
			return true;
		} else {
			return false;
		}
	}
}
