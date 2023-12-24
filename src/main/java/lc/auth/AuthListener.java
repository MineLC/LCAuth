package lc.auth;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static lc.auth.LCAuth.setScoreboard;

public class AuthListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999 ,9999));
        setScoreboard(e.getPlayer());
    }
}
