package me.koba1.agentcraft;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Directional;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class chickenregen implements Listener, CommandExecutor {

    private Agentcraft m = Agentcraft.getPlugin(Agentcraft.class);

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity e = event.getEntity();
        double x = e.getLocation().getX();
        double y = e.getLocation().getY();
        double z = e.getLocation().getZ();
        if (event.getEntityType() == EntityType.CHICKEN
                && e.getWorld().getName().equals("world")
                && x >= 190 && x <= 199 && z >= 806 && z <= 815) {
            event.getDrops().clear();
            event.setDroppedExp(0);
            if (!(event.getEntity().getKiller() == null)) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Random chance = new Random();
                        int chanceInteger = chance.nextInt(100);
                        if (chanceInteger <= 20) {
                            event.getEntity().getKiller().getInventory().addItem(new ItemStack(Material.CHICKEN, 2));
                        } else {
                            event.getEntity().getKiller().getInventory().addItem(new ItemStack(Material.CHICKEN));
                        }

                        Random xRand = new Random();
                        int randX = xRand.nextInt(9);

                        Random zRand = new Random();
                        int randZ = zRand.nextInt(9);

                        Location loc = new Location(e.getWorld(), 190 + randX, y, 806 + randZ);
                        e.getWorld().spawnEntity(loc, EntityType.CHICKEN);
                    }
                }.runTaskLater(m, 1L);
            }
        }
    }

    @EventHandler
    public void omEggThrow(PlayerEggThrowEvent event) {
        event.setHatching(false);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("chickenfarm")) {
            if (p instanceof Player) {
                if (p.isOp()) {
                    p.sendTitle("§4§lNe mozogj!", "§aFordulgathatsz, de ne mozogj!");

                    new BukkitRunnable() {
                        @Override
                        public void run() {

                            int yInt = (int) p.getLocation().getY();

                            int xIntAdded = (int) p.getLocation().getX() + 5;
                            int xIntRemoved = (int) p.getLocation().getX() - 5;
                            int zIntRemoved = (int) p.getLocation().getZ() - 6;
                            int zIntRemoved2 = (int) p.getLocation().getZ() + 4;

                            p.performCommand("fill " + xIntRemoved + " " + (yInt - 1) + " " + zIntRemoved + " " + xIntAdded + " " + (yInt - 1) + " " + zIntRemoved2 + " grass_block");
                            p.playSound(p.getLocation(), Sound.BLOCK_GRASS_PLACE, 1f, 1f);
                        }
                    }.runTaskLater(m, 30L);

                    new BukkitRunnable() {
                        @Override
                        public void run() {

                            int xInt = (int) p.getLocation().getX();
                            int yInt = (int) p.getLocation().getY();

                            int zIntRemoved = (int) p.getLocation().getZ() - 6;
                            int zIntAdded = (int) p.getLocation().getZ() + 4;

                            for (int z1 = zIntRemoved; z1 <= zIntAdded; z1++) {

                                Location loc = new Location(p.getWorld(), xInt + 5, yInt, z1);
                                Block block = loc.getBlock();
                                block.setType(Material.OAK_FENCE);
                            }
                            p.playSound(p.getLocation(), Sound.ENTITY_ARMOR_STAND_BREAK, 1f, 1f);
                        }
                    }.runTaskLater(m, 60L);

                    new BukkitRunnable() {
                        @Override
                        public void run() {

                            int xIntRemoved = (int) p.getLocation().getX() - 5;
                            int xIntAdded = (int) p.getLocation().getX() + 4;
                            int yInt = (int) p.getLocation().getY();
                            int zInt = (int) p.getLocation().getZ() - 6;

                            for (int x1 = xIntRemoved; x1 <= xIntAdded; x1++) {

                                Location loc = new Location(p.getWorld(), x1, yInt, zInt);
                                Block block = loc.getBlock();
                                block.setType(Material.OAK_FENCE);
                            }
                            p.playSound(p.getLocation(), Sound.ENTITY_ARMOR_STAND_BREAK, 1f, 1f);
                        }
                    }.runTaskLater(m, 90L);

                    new BukkitRunnable() {
                        @Override
                        public void run() {

                            int xInt = (int) p.getLocation().getX();
                            int yInt = (int) p.getLocation().getY();

                            int zIntRemoved = (int) p.getLocation().getZ() - 6;
                            int zIntAdded = (int) p.getLocation().getZ() + 4;

                            for (int z1 = zIntRemoved; z1 <= zIntAdded; z1++) {

                                Location loc = new Location(p.getWorld(), xInt - 5 , yInt, z1);
                                Block block = loc.getBlock();
                                block.setType(Material.OAK_FENCE);
                            }
                            p.playSound(p.getLocation(), Sound.ENTITY_ARMOR_STAND_BREAK, 1f, 1f);
                        }
                    }.runTaskLater(m, 120L);

                    new BukkitRunnable() {
                        @Override
                        public void run() {

                            int intX = (int) p.getLocation().getX();
                            int intY = (int) p.getLocation().getY();
                            int intZ = (int) p.getLocation().getZ();

                            int xIntRemoved = (int) p.getLocation().getX() - 5;
                            int xIntAdded = (int) p.getLocation().getX() + 4;
                            int yInt = (int) p.getLocation().getY();
                            int zInt = (int) p.getLocation().getZ() + 4;

                            for (int x1 = xIntRemoved; x1 <= xIntAdded; x1++) {

                                Location loc = new Location(p.getWorld(), x1, yInt, zInt);
                                Block block = loc.getBlock();
                                block.setType(Material.OAK_FENCE);
                            }

                            Location loc = new Location(p.getWorld(), intX + 1, intY, intZ);
                            loc.getBlock().setType(Material.OAK_SIGN);
                            Sign sign = (Sign) loc.getBlock().getState();
                            sign.setLine(0, "Kerítés lehet");
                            sign.setLine(1, "bugos. Undo-zni");
                            sign.setLine(2, "nem lehet,kiütöd");
                            sign.setLine(3, "vagy worldedit:)");
                            sign.update();
                            p.playSound(p.getLocation(), Sound.ITEM_TOTEM_USE, 1f, 1f);
                            p.sendTitle("§aKész a terület", "§eMostmár mozoghatsz");

                        }
                    }.runTaskLater(m, 150L);
                }
            }
        }
        return false;
    }
}
