/*
 * This file is part of the BleachHack distribution (https://github.com/BleachDrinker420/BleachHack/).
 * Copyright (c) 2021 Bleach and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package org.bleachhack.module.mods;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.s2c.play.WorldBorderInitializeS2CPacket;
import org.bleachhack.event.events.EventPacket;
import org.bleachhack.eventbus.BleachSubscribe;
import org.bleachhack.module.Module;
import org.bleachhack.module.ModuleCategory;

public class AntiBorder extends Module {

    private boolean bool = false;

    public AntiBorder() {
        super("AntiBorder", KEY_UNBOUND, ModuleCategory.OVERFLOW, "Drops world border packets.");
    }

    @BleachSubscribe
    public void onReadPacket(EventPacket.Read event) {
        if (event.getPacket() instanceof WorldBorderInitializeS2CPacket) {
            event.setCancelled(true);
        }
    }

}
