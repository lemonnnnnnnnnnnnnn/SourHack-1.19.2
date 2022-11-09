package org.bleachhack.module.mods;

import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import org.bleachhack.event.events.EventPacket;
import org.bleachhack.eventbus.BleachSubscribe;
import org.bleachhack.module.Module;
import org.bleachhack.module.ModuleCategory;

public class AutoGamemode extends Module {
    public AutoGamemode() {
        super("AutoGamemode", KEY_UNBOUND, ModuleCategory.OVERFLOW, "Automatically switches your gamemode to survival");
    }
    @BleachSubscribe
    public void onReadPacket(EventPacket.Read event){
        if(event.getPacket() instanceof GameStateChangeS2CPacket gameStateChange){
            if(gameStateChange.getReason() == GameStateChangeS2CPacket.GAME_MODE_CHANGED){
                event.setCancelled(true);
            }
        }
    }
}
