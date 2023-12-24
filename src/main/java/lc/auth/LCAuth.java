package lc.auth;

import lc.captcha2.LCCaptcha2;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public final class LCAuth extends JavaPlugin {

    @Override
    public void onEnable() {
getServer().getPluginManager().registerEvents(new AuthListener(), this);
    }

    public static void setScoreboard(Player Online) {

        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Online.setScoreboard(sb);


        Objective objHealth = sb.getObjective("ShowHealth");

        if(objHealth == null) {
            objHealth = sb.registerNewObjective("ShowHealth", "health");
            objHealth.setDisplaySlot(DisplaySlot.BELOW_NAME);
            objHealth.setDisplayName(ChatColor.RED+"❤");
        }

        Objective objGame = sb.getObjective("Lobby");

        if(objGame == null) {
            objGame = sb.registerNewObjective("Lobby", "dummy");

            objGame.setDisplaySlot(DisplaySlot.SIDEBAR);

            objGame.setDisplayName(ChatColor.GOLD+""+ChatColor.BOLD+"MineLC " + ChatColor.DARK_AQUA + "Network");

            //LCoins
            objGame.getScore(ChatColor.translateAlternateColorCodes('&',"&7&m+------------------------+")).setScore(14);

            objGame.getScore(ChatColor.translateAlternateColorCodes('&', "&8» &fNick: &7" + Online.getName())).setScore(13);
            objGame.getScore("      ").setScore(12);
            objGame.getScore(ChatColor.translateAlternateColorCodes('&', "&8» &fRegistrate:")).setScore(11);

            objGame.getScore(ChatColor.translateAlternateColorCodes('&', "&8» &a/register <clave>")).setScore(10);

            objGame.getScore(" ").setScore(9);
            objGame.getScore(ChatColor.translateAlternateColorCodes('&', "&8» &fInicia sesión:")).setScore(8);

            objGame.getScore(ChatColor.translateAlternateColorCodes('&', "&8» &a/login <clave>")).setScore(7);

            objGame.getScore("   ").setScore(6);
            objGame.getScore(ChatColor.translateAlternateColorCodes('&', "&8» &fcompleta el captchat:")).setScore(5);
            String cap = LCCaptcha2.player_catpchat.get(Online);
            objGame.getScore(ChatColor.translateAlternateColorCodes('&', "&8» &a/captcha " + cap)).setScore(4);
            objGame.getScore("    ").setScore(3);
            objGame.getScore(ChatColor.translateAlternateColorCodes('&', "&8» &fIP: &eplay.minelc.net")).setScore(2);
            objGame.getScore(ChatColor.translateAlternateColorCodes('&',"&7&m+--------------------------+")).setScore(1);


        }


    }
}
