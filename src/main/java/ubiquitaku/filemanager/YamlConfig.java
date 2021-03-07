package ubiquitaku.filemanager;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YamlConfig {
    JavaPlugin plugin;
    List<FileConfiguration> yml = new ArrayList<>();
    public YamlConfig(JavaPlugin pl) {
        plugin = pl;
        make();
        read();
    }

    //ディレクトリが存在しない場合ディレクトリとデフォルトのファイルを生成する（ディレクトリが存在してデフォルトのファイルが存在しない場合はデフォルトのファイルは生成されない）
    public boolean make() {
        File dir = new File(plugin.getDataFolder().getAbsolutePath()+"/ubi");
        if (!dir.exists()) {
            dir.mkdir();
            try {
                new File(plugin.getDataFolder().getAbsolutePath()+"/ubi/test.yml").createNewFile();
                Bukkit.getLogger().info("ファイルを作成しました");
                return true;
            } catch (IOException e) {
                Bukkit.getLogger().warning("ファイルの作成に失敗しました");
                Bukkit.getLogger().warning("////////////////////////////////////////");
                e.printStackTrace();
                Bukkit.getLogger().warning("////////////////////////////////////////");
                return false;
            }
        }
        return true;
    }

    //ディレクトリに保存されているファイルを読み込んでListに入れ、ファイルが存在しなかった場合はそのListは空になる
    public void read() {
        File file = new File(plugin.getDataFolder().getAbsolutePath()+"/ubi");
        File[] files = file.listFiles();
        List<FileConfiguration> list = new ArrayList<>();
        for (File f : files) {
            if (!f.isFile())continue;
            if (!f.getPath().endsWith(".yml"))continue;
            FileConfiguration c = YamlConfiguration.loadConfiguration(f);
            list.add(c);
        }
        if (list.size() == 0) {
            yml = new ArrayList<>();
            return;
        }
        yml = list;
    }


    //ここから下は推奨はしないけど使えると思われるもの

    public String getString(String path) {
        for (FileConfiguration f : yml) {
            if (!f.contains(path)) {
                continue;
            }
            return f.getString(path);
        }
        return null;
    }

    public Integer getInt(String path) {
        for (FileConfiguration f : yml) {
            if (!f.contains(path)) {
                continue;
            }
            return f.getInt(path);
        }
        return null;
    }

    public List<String> getList(String path) {
        for (FileConfiguration f : yml) {
            if (!f.contains(path)) {
                continue;
            }
            return (List<String>) f.getList(path);
        }
        return null;
    }

    public boolean getBoolean(String path) {
        for (FileConfiguration f : yml) {
            if (!f.contains(path)) {
                continue;
            }
            return f.getBoolean(path);
        }
        return false;
    }

    public boolean contains(String path) {
        for (FileConfiguration f : yml) {
            if (!f.contains(path)) {
                continue;
            }
            return true;
        }
        return false;
    }

    //非推奨の中でも特に非推奨 上書きしかできない雑魚 上書き完了後保存までするがちゃんと保存できるかは知らん
    public boolean set(String path,String s) throws IOException {
        if (yml.size() == 0) {
            Bukkit.getLogger().warning("ファイルが読み込まれていません");
            return false;
        }
        if (!contains(path)) {
            Bukkit.getLogger().warning("存在しないpathを指定されたため上書きできません");
            return false;
        }
        for (FileConfiguration f : yml) {
            if (!f.contains(path)) {
                continue;
            }
            f.set(path,s);
            f.save(f.getName());
            return true;
        }
        return false;
    }
}
