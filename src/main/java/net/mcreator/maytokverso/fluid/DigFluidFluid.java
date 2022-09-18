
package net.mcreator.maytokverso.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.item.Rarity;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.maytokverso.init.MaytokversoModItems;
import net.mcreator.maytokverso.init.MaytokversoModFluids;
import net.mcreator.maytokverso.init.MaytokversoModBlocks;

public abstract class DigFluidFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(MaytokversoModFluids.DIG_FLUID,
			MaytokversoModFluids.FLOWING_DIG_FLUID,
			FluidAttributes.builder(new ResourceLocation("maytokverso:blocks/lava_still"), new ResourceLocation("maytokverso:blocks/lava_flow"))
					.luminosity(15)

					.rarity(Rarity.RARE))
			.explosionResistance(100f).canMultiply()

			.bucket(MaytokversoModItems.DIG_FLUID_BUCKET).block(() -> (LiquidBlock) MaytokversoModBlocks.DIG_FLUID.get());

	private DigFluidFluid() {
		super(PROPERTIES);
	}

	public static class Source extends DigFluidFluid {
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

	public static class Flowing extends DigFluidFluid {
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
