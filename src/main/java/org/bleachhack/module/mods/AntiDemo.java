/*
 * This file is part of the BleachHack distribution (https://github.com/BleachDrinker420/BleachHack/).
 * Copyright (c) 2021 Bleach and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package org.bleachhack.module.mods;

import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldBorderInitializeS2CPacket;
import org.bleachhack.event.events.EventPacket;
import org.bleachhack.eventbus.BleachSubscribe;
import org.bleachhack.module.Module;
import org.bleachhack.module.ModuleCategory;

public class AntiDemo extends Module {

    private boolean bool = false;

    public AntiDemo() {
        super("AntiDemo", KEY_UNBOUND, ModuleCategory.OVERFLOW, "Drops demo packages.");
    }

    @BleachSubscribe
    public void onReadPacket(EventPacket.Read event) {
        if (event.getPacket() instanceof GameStateChangeS2CPacket) {
            GameStateChangeS2CPacket p = (GameStateChangeS2CPacket) event.getPacket();

            GameStateChangeS2CPacket.Reason reason = p.getReason();

            if (reason == GameStateChangeS2CPacket.DEMO_MESSAGE_SHOWN || reason == GameStateChangeS2CPacket.GAME_WON) {
                event.setCancelled(true);
            }
        }
    }

}
