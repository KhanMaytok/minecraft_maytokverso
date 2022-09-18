
package net.mcreator.maytokverso.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.maytokverso.init.MaytokversoModFluids;

public class DigFluidBlock extends LiquidBlock {
	public DigFluidBlock() {
		super(() -> (FlowingFluid) MaytokversoModFluids.DIG_FLUID.get(), BlockBehaviour.Properties.of(Material.LAVA).strength(100f)

		);
	}
}
