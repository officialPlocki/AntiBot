package de.plocki.antibot.utils;

import org.bukkit.Bukkit;

public class Messenger {
	
	public static void sendConsole(String msg) {
		Bukkit.getConsoleSender().sendMessage(msg);
	}
}
