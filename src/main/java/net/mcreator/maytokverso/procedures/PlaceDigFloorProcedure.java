package net.mcreator.maytokverso.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.Util;

public class PlaceDigFloorProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {

		String command = "fill " + (int)(x+10) + " " + (int)(y-1) + " " + (int)(z+10) + " " + (int)(x-10) + " " + (int)(y-1) + " " + (int)(z-10) + " minecraft:glass";

		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
					new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), command);
		if (!world.isClientSide()) {
			MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
			if (_mcserv != null)
				_mcserv.getPlayerList().broadcastMessage(new TextComponent(command), ChatType.SYSTEM, Util.NIL_UUID);
		}
	}
}
