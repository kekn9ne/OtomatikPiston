package com.kekn9ne.otomatikpiston.events;

import com.kekn9ne.otomatikpiston.OtomatikPiston;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockSpreadEvent;


public class OtomatikPistonEvents implements Listener {

    @EventHandler
    public static void onBlockSpread(BlockSpreadEvent event) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(OtomatikPiston.plugin, new Runnable() {
            public void run() {
                Location o = event.getBlock().getLocation();
                int r = 1;
                for(int x = (r * -1); x <= r; x++) {
                    for(int y = (r * -1); y <= r; y++) {
                        for(int z = (r * -1); z <= r; z++) {
                            Location b = new Location(o.getWorld(), o.getBlockX() + x, o.getBlockY() + y, o.getBlockZ() + z);

                            if(b.distance(o) > r)
                                continue;

                            if(b.distance((o)) < r - 1)
                                continue;

                            if (b.getBlock().getType() == Material.PISTON) {
                                BlockFace blockFace = ((Directional) b.getBlock().getState().getBlockData()).getFacing();
                                BlockFace gerekli = (BlockFace) b.getBlock().getFace(event.getBlock());
                                if (blockFace == gerekli) {
                                    event.getBlock().breakNaturally();
                                }
                            }
                        }
                    }
                }
            }
        }, 20L);

    }

    @EventHandler
    public static void onBlockGrow(BlockGrowEvent event) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(OtomatikPiston.plugin, new Runnable() {
            public void run() {
                if (event.getBlock().getType() != Material.SUGAR_CANE && event.getBlock().getType() != Material.MELON && event.getBlock().getType() != Material.PUMPKIN && event.getBlock().getType() != Material.KELP_PLANT) return;
                Location o = event.getBlock().getLocation();
                int r = 1;
                for(int x = (r * -1); x <= r; x++) {
                    for(int y = (r * -1); y <= r; y++) {
                        for(int z = (r * -1); z <= r; z++) {
                            Location b = new Location(o.getWorld(), o.getBlockX() + x, o.getBlockY() + y, o.getBlockZ() + z);

                            if(b.distance(o) > r)
                                continue;

                            if(b.distance((o)) < r - 1)
                                continue;

                            if (b.getBlock().getType() == Material.PISTON) {
                                BlockFace blockFace = ((Directional) b.getBlock().getState().getBlockData()).getFacing();
                                BlockFace gerekli = b.getBlock().getFace(event.getBlock());
                                if (blockFace == gerekli) {
                                    event.getBlock().breakNaturally();
                                }
                            }
                        }
                    }
                }
            }
        }, 10L);
    }
}
