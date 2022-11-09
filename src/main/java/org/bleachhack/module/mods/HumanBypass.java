/*
 * This file is part of the BleachHack distribution (https://github.com/BleachDrinker420/BleachHack/).
 * Copyright (c) 2021 Bleach and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package org.bleachhack.module.mods;

import org.bleachhack.eventbus.BleachSubscribe;
import org.bleachhack.module.Module;
import org.bleachhack.module.ModuleCategory;
import org.bleachhack.util.BleachLogger;

// credit: https://github.com/Wurst-Imperium/Wurst7/blob/21w11a/src/main/java/net/wurstclient/hacks/ParkourHack.java
// modified by https://github.com/lasnikprogram
// modified by https://github.com/BleachDrinker420

import org.bleachhack.module.Module;
import org.bleachhack.module.ModuleCategory;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

public class HumanBypass extends Module {
    public HumanBypass() {
        super("HumanBypass", KEY_UNBOUND, ModuleCategory.OVERFLOW, "I'm not a robot");
    }

    public static double roundCoordinate(double n) {
        n = Math.round(n * 100) / 100d;
        return Math.nextAfter(n, n + Math.signum(n));
    }

    public static void onPositionPacket(Args args) {
        double x = args.get(0);
        double y = args.get(1);
        double z = args.get(2);

        x = roundCoordinate(x);
        z = roundCoordinate(z);

        args.set(0, x);
        args.set(1, y);
        args.set(2, z);
    }
}