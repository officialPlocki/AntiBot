package de.plocki.antibot.utils;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import de.plocki.antibot.main.Main;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class ActionbarHandler {
	public static HashMap<String, Integer> cps = new HashMap<String, Integer>();
	
	public static void sendActionbar(String ip) {
		for(Player p : Bukkit.getOnlinePlayers()) {
	        if(p.hasPermission("antibot.view")) {
	        	PlayerConnection con = ((CraftPlayer)p).getHandle().playerConnection;
				IChatBaseComponent chat = IChatBaseComponent.ChatSerializer.a("{\"text\": \"§c§lAntiBot §8» §7Blocked: §c"+ip+"\"}");
		        PacketPlayOutChat packet = new PacketPlayOutChat(chat, (byte) 2);
		        con.sendPacket(packet);
	        }
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void init() {
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.pl, new Runnable() {
			
			@Override
			public void run() {
				
				if(!(cps.get("cps") != null)) {
					cps.put("cps", 0);
				}
				
				for(Player p : Bukkit.getOnlinePlayers()) {
					
			        PlayerConnection con = ((CraftPlayer)p).getHandle().playerConnection;

			        IChatBaseComponent chat = IChatBaseComponent.ChatSerializer.a("{\"text\": \"§c§lAntiBot §8» §7CPS: "+cps.get("cps")+"\"}");
			        PacketPlayOutChat packet = new PacketPlayOutChat(chat, (byte) 2);
			        con.sendPacket(packet);
			        cps.clear();
					
				}
				
			}
		}, 0, 20);
	}

}
