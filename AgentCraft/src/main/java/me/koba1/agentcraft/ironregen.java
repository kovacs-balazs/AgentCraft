package me.koba1.agentcraft;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ironregen implements Listener {

    private Agentcraft m = Agentcraft.getPlugin(Agentcraft.class);

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();
        Block block = event.getBlock();

        double x = block.getX();
        double z = block.getZ();

        if(block.getType() == Material.IRON_ORE) {
            if (block.getWorld().getName().equals("banya")) {
                if (x >= 99 && x <= 122 && z >= 8 && z <= 35) {
                    if (event.getPlayer().hasPermission("ac.banyasz")) {
                        event.setDropItems(false);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.IRON_ORE);
                            }
                        }.runTaskLater(m, 120L);

                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                p.getInventory().addItem(new ItemStack(Material.IRON_ORE));
                                block.setType(Material.COBBLESTONE);
                            }
                        }.runTaskLater(m, 1L);
                    }
                }
            }
        }
    }
}
