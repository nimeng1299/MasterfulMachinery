package io.ticticboom.mods.mm.structure.block;

import com.google.gson.JsonObject;
import io.ticticboom.mods.mm.Ref;
import io.ticticboom.mods.mm.structure.MMStructurePart;
import io.ticticboom.mods.mm.structure.IConfiguredStructurePart;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockStructurePart extends MMStructurePart {
    @Override
    public IConfiguredStructurePart parse(JsonObject json) {
        var block = ResourceLocation.tryParse(json.get("block").getAsString());
        return new BlockConfiguredStructurePart(block, Ref.StructureParts.BLOCK);
    }

    @Override
    public boolean validatePlacement(Level level, BlockPos expectedPos, IConfiguredStructurePart config) {
        var currentConfig = (BlockConfiguredStructurePart)config;
        var state = level.getBlockState(expectedPos);
        return ForgeRegistries.BLOCKS.getKey(state.getBlock()).equals(currentConfig.block());
    }
}
