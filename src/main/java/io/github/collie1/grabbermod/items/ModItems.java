package io.github.collie1.grabbermod.items;

import io.github.collie1.grabbermod.items.custom.Grabber;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class ModItems {
    public static final Grabber grabber = new Grabber(new FabricItemSettings()
            .maxDamage(6),
            "grabber"

    );

    public static void Initialize() {
        grabber.initialize();

    }
}
