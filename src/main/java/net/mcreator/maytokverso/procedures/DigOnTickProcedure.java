package net.mcreator.maytokverso.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class DigOnTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double bufferLevel = 0;
		double encontreRompible = 0;
		double level = 0;
		double sx = 0;
		double sz = 0;
		level = 2;
		bufferLevel = 2;
		encontreRompible = 0;
		while (encontreRompible == 0) {
			if ((world.getBlockState(new BlockPos(x, y - level, z))).getBlock() == Blocks.BARRIER) {
				level = level + 1;
			} else {
				encontreRompible = 1;
			}
		}
		sz = -8;
		for (int index1 = 0; index1 < (int) (16); index1++) {
			sx = -8;
			for (int index2 = 0; index2 < (int) (16); index2++) {
				if (!(world.getBlockState(new BlockPos(x + sx, y - level, z + sz)))
						.is(BlockTags.create(new ResourceLocation("minecraft:wither_immune")))) {
					{
						BlockPos _pos = new BlockPos(x + sx, y - level, z + sz);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y + 1, z), null);
						world.destroyBlock(_pos, false);
					}
					world.setBlock(new BlockPos(x + sx, y - level, z + sz), Blocks.BARRIER.defaultBlockState(), 3);
				}
				sx = sx + 1;
			}
			sz = sz + 1;
		}
		if ((world.getBlockState(new BlockPos(x, y - level, z))).getBlock() == Blocks.BEDROCK) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4,
						"", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "//pos1");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4,
						"", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "//pos2");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4,
						"", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "//replace barrier air");
			{
				BlockPos _pos = new BlockPos(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y + 1, z), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}
