/*
 * This file is part of the BleachHack distribution (https://github.com/BleachDrinker420/BleachHack/).
 * Copyright (c) 2021 Bleach and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package org.bleachhack.module.mods;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketCallbacks;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.bleachhack.event.events.EventPacket;
import org.bleachhack.eventbus.BleachSubscribe;
import org.bleachhack.module.Module;
import org.bleachhack.module.ModuleCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// credit: https://github.com/Wurst-Imperium/Wurst7/blob/21w11a/src/main/java/net/wurstclient/hacks/ParkourHack.java
// modified by https://github.com/lasnikprogram
// modified by https://github.com/BleachDrinker420

public class DemoBypass extends Module {

    public DemoBypass() {
        super("DemoBypass", KEY_UNBOUND, ModuleCategory.OVERFLOW, "Drops Demo Packets.");
    }
    @BleachSubscribe
    public void onSendPacket(EventPacket.Send event) {
        if (event.getPacket() instanceof PlayerMoveC2SPacket) {
            @Mixin(ClientConnection.class)
            class ClientConnectionMixin {
                @Inject(at = @At("TAIL"), method = "send(Lnet/minecraft/network/Packet;Lnet/minecraft/network/PacketCallbacks;)V", cancellable = true)
                public void send(Packet<?> packet, PacketCallbacks callbacks, CallbackInfo ci) {
                    ci.cancel();
                }
            }
        }
    }
}
