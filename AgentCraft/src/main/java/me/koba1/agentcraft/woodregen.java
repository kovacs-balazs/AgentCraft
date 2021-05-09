package me.koba1.agentcraft;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class woodregen implements Listener {

    private Agentcraft m = Agentcraft.getPlugin(Agentcraft.class);

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();
        Block block = event.getBlock();

        double x = block.getX() * (-1);
        double z = block.getZ() * (-1);

        if(block.getType() == Material.OAK_LOG) {
            if (block.getWorld().getName().equals("horgaszto")) {
                if (x >= 843 && x <= 943 && z >= 257 && z <= 373) {
                    if (event.getPlayer().hasPermission("ac.favago")) {
                        block.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, block.getLocation(), 5, 0.5, 0.5, 0.5, 1);
                        event.setDropItems(false);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.OAK_LOG);
                                event.getBlock().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, block.getLocation(), 5, 0.5, 0.5, 0.5, 1);
                            }
                        }.runTaskLater(m, 200L);

                        p.getInventory().addItem(new ItemStack(Material.OAK_LOG));
                    }
                }
            }
        }
    }
}
