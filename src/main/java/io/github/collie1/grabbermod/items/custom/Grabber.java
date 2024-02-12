package io.github.collie1.grabbermod.items.custom;

import io.github.collie1.grabbermod.GrabberMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class Grabber extends Item {


    public String id;

    public Grabber(Settings settings, String id) {
        super(settings);
        this.id = id;
    }

    public void initialize() {
        Registry.register(Registries.ITEM, new Identifier(GrabberMod.mod_id, this.id), this);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(this);
        });
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        entity.addVelocity(new Vec3d(user.getX(), 0.4, user.getZ()).subtract(new Vec3d(entity.getX(), 0, entity.getZ())).multiply(0.3));

        return ActionResult.SUCCESS;
    }
}
