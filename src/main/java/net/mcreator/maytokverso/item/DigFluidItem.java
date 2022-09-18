
package net.mcreator.maytokverso.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BucketItem;

import net.mcreator.maytokverso.init.MaytokversoModFluids;

public class DigFluidItem extends BucketItem {
	public DigFluidItem() {
		super(MaytokversoModFluids.DIG_FLUID,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.RARE).tab(CreativeModeTab.TAB_MISC));
	}
}
