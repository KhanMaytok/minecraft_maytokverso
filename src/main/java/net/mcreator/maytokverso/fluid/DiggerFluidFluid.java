
package net.mcreator.maytokverso.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.maytokverso.init.MaytokversoModFluids;
import net.mcreator.maytokverso.init.MaytokversoModBlocks;

public abstract class DiggerFluidFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(MaytokversoModFluids.DIGGER_FLUID,
			MaytokversoModFluids.FLOWING_DIGGER_FLUID, FluidAttributes.builder(new ResourceLocation("maytokverso:blocks/mkdiggerfluid"),
					new ResourceLocation("maytokverso:blocks/mkdiggerfluid"))

	).explosionResistance(100f).canMultiply()

			.block(() -> (LiquidBlock) MaytokversoModBlocks.DIGGER_FLUID.get());

	private DiggerFluidFluid() {
		super(PROPERTIES);
	}

	public static class Source extends DiggerFluidFluid {
		public Source() {
			super();
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends DiggerFluidFluid {
		public Flowing() {
			super();
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
