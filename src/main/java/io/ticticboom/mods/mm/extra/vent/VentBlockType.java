package io.ticticboom.mods.mm.extra.vent;

import io.ticticboom.mods.mm.extra.ExtraBlockModel;
import io.ticticboom.mods.mm.extra.ExtraBlockType;
import io.ticticboom.mods.mm.setup.MMRegisters;
import io.ticticboom.mods.mm.setup.RegistryGroupHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class VentBlockType extends ExtraBlockType {

    @Override
    public RegistryObject<Block> registerBlock(ExtraBlockModel model, RegistryGroupHolder groupHolder) {
        return MMRegisters.BLOCKS.register(model.id(), () -> new VentBlock(model, groupHolder));
    }

    @Override
    public RegistryObject<Item> registerItem(ExtraBlockModel model, RegistryGroupHolder groupHolder) {
        return MMRegisters.ITEMS.register(model.id(), () -> new VentBlockItem(model, groupHolder));
    }
}
