
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.maytokverso.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.maytokverso.fluid.DigFluidFluid;
import net.mcreator.maytokverso.MaytokversoMod;

public class MaytokversoModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, MaytokversoMod.MODID);
	public static final RegistryObject<Fluid> DIG_FLUID = REGISTRY.register("dig_fluid", () -> new DigFluidFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_DIG_FLUID = REGISTRY.register("flowing_dig_fluid", () -> new DigFluidFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(DIG_FLUID.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_DIG_FLUID.get(), renderType -> renderType == RenderType.translucent());
		}
	}
}
