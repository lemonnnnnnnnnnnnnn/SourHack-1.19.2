/*
 * This file is part of the BleachHack distribution (https://github.com/BleachDrinker420/BleachHack/).
 * Copyright (c) 2021 Bleach and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package org.bleachhack.module.mods;

import org.bleachhack.module.Module;
import org.bleachhack.module.ModuleCategory;
import org.bleachhack.setting.module.SettingColor;
import org.bleachhack.setting.module.SettingToggle;

// credit: https://github.com/Wurst-Imperium/Wurst7/blob/21w11a/src/main/java/net/wurstclient/hacks/ParkourHack.java
// modified by https://github.com/lasnikprogram
// modified by https://github.com/BleachDrinker420

public class AntiHumanBypass extends Module {

    public AntiHumanBypass() {
        super("AntiHumanBypass", KEY_UNBOUND, ModuleCategory.OVERFLOW, "Bypasses the AntiHuman plugin on the LO Server.");
    }
}
