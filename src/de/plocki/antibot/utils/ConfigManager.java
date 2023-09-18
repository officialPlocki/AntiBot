package de.plocki.antibot.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	
	private static File config = new File("plugins//AntiBot//config.yml");
	private static YamlConfiguration configyml = YamlConfiguration.loadConfiguration(config);
	
	private static File data = new File("plugins//AntiBot//data.yml");
	private static YamlConfiguration datayml = YamlConfiguration.loadConfiguration(data);
	
	public static YamlConfiguration getConfig() {
		return configyml;
	}
	
	public static void saveConfig() {
		try {
			configyml.save(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static YamlConfiguration getData() {
		return datayml;
	}
	public static void saveData() {
		try {
			datayml.save(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
