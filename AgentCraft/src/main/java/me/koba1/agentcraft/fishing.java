package me.koba1.agentcraft;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class fishing implements Listener {
    private Agentcraft m = Agentcraft.getPlugin(Agentcraft.class);

    @EventHandler(priority = EventPriority.HIGH)
    public void onFish(PlayerFishEvent e) {
        Player p = e.getPlayer();
        Item item = (Item) e.getCaught();
        if (e.getCaught() != null) {
            Random rand = new Random();
            int value = rand.nextInt(100);
            e.getCaught().remove();

            if (value > 50) {
                p.sendTitle("§4Nem fogtál semmit", "§cMajd legközelebb");
            }
            if (value <= 50) {
                p.getInventory().addItem(rawcod());
            }
        }
    }

    public ItemStack rawcod() {
        ItemStack is = new ItemStack(Material.LEGACY_RAW_FISH, 1);
        return is;
    }
}
