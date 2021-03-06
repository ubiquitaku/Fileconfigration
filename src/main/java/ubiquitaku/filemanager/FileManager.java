package ubiquitaku.filemanager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class FileManager extends JavaPlugin {
    YamlConfig yml = new YamlConfig(this);
    List<FileConfiguration> configs = yml.read();

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
