package ubiquitaku.filemanager;

import org.bukkit.plugin.java.JavaPlugin;

public final class FileManager extends JavaPlugin {
    //読み書きをするクラスで宣言
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
