package ubiquitaku.filemanager;

import org.bukkit.plugin.java.JavaPlugin;

public final class FileManager extends JavaPlugin {
    YamlConfig yml = new YamlConfig(this);

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
