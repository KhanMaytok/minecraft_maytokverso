
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.maytokverso.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.maytokverso.item.MkTelephoneItem;
import net.mcreator.maytokverso.item.InvisibleArmorItem;
import net.mcreator.maytokverso.MaytokversoMod;

public class MaytokversoModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MaytokversoMod.MODID);
	public static final RegistryObject<Item> INVISIBLE_ARMOR_HELMET = REGISTRY.register("invisible_armor_helmet",
			() -> new InvisibleArmorItem.Helmet());
	public static final RegistryObject<Item> INVISIBLE_ARMOR_CHESTPLATE = REGISTRY.register("invisible_armor_chestplate",
			() -> new InvisibleArmorItem.Chestplate());
	public static final RegistryObject<Item> INVISIBLE_ARMOR_LEGGINGS = REGISTRY.register("invisible_armor_leggings",
			() -> new InvisibleArmorItem.Leggings());
	public static final RegistryObject<Item> INVISIBLE_ARMOR_BOOTS = REGISTRY.register("invisible_armor_boots", () -> new InvisibleArmorItem.Boots());
	public static final RegistryObject<Item> MK_TELEPHONE = REGISTRY.register("mk_telephone", () -> new MkTelephoneItem());
	public static final RegistryObject<Item> MK_DIGGER = block(MaytokversoModBlocks.MK_DIGGER, CreativeModeTab.TAB_BUILDING_BLOCKS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
