
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.maytokverso.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.maytokverso.block.MkDestroyerBlock;
import net.mcreator.maytokverso.block.MKDiggerBlock;
import net.mcreator.maytokverso.MaytokversoMod;

public class MaytokversoModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MaytokversoMod.MODID);
	public static final RegistryObject<Block> MK_DIGGER = REGISTRY.register("mk_digger", () -> new MKDiggerBlock());
	public static final RegistryObject<Block> MK_DESTROYER = REGISTRY.register("mk_destroyer", () -> new MkDestroyerBlock());
}
