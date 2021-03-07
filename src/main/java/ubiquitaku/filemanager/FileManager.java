package ubiquitaku.filemanager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class FileManager extends JavaPlugin {
    //読み書きをするクラスで宣言
    YamlConfig yml = new YamlConfig(this);
    //Listに入ったファイルをいじりたいなら
    List<FileConfiguration> config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        //YamlocnfigのymlってListだからすごい変に見えます
        config = yml.yml;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
