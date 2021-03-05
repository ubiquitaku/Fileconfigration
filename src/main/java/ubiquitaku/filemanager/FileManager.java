package ubiquitaku.filemanager;

import org.bukkit.plugin.java.JavaPlugin;

public final class FileManager extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
