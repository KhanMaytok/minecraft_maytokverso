
package net.mcreator.maytokverso.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.maytokverso.init.MaytokversoModFluids;

public class DiggerFluidBlock extends LiquidBlock {
	public DiggerFluidBlock() {
		super(() -> (FlowingFluid) MaytokversoModFluids.DIGGER_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
	}
}
