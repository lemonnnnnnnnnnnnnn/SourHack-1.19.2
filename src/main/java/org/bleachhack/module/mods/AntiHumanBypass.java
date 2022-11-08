package org.bleachhack.module.mods;

import net.minecraft.util.math.BlockPos;
import org.bleachhack.module.Module;
import org.bleachhack.module.ModuleCategory;
import org.bleachhack.setting.module.SettingColor;
import org.bleachhack.setting.module.SettingToggle;

public class AntiHumanBypass extends Module {

    private BlockPos smartPos = null;

    public AntiHumanBypass() {
        super("AntiHumanBypass", KEY_UNBOUND, ModuleCategory.MOVEMENT, "Bypasses the AntiHuman plugin on the LiveOverflow server.");
    }
}