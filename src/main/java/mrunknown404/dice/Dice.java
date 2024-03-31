package mrunknown404.dice;

import mrunknown404.dice.registries.DiceRegistry;
//import mrunknown404.dice.utils.DiceConfig;
//import net.minecraftforge.fml.ModLoadingContext;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.config.ModConfig;
import io.github.fabricators_of_create.porting_lib.config.ConfigRegistry; // SNWCreations: use porting lib for configs!
import io.github.fabricators_of_create.porting_lib.config.ConfigType;
import mrunknown404.dice.utils.DiceConfig;
import net.fabricmc.api.ModInitializer; // SNWCreations: This is the Fabric port!

//@Mod(Dice.MOD_ID) // SNWCreations: Fabric don't have Mod annotation :/
public class Dice implements ModInitializer { // SNWCreations: implement ModInitializer to fit Fabric's requirement
	public static final String MOD_ID = "dice";

	@Override
	public void onInitialize() {
//	public Dice() { // SNWCreations: Fabric uses onInitialize to initialize mod
//		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DiceConfig.COMMON_SPEC); // SNWCreations: use porting lib now
		//noinspection UnstableApiUsage
		ConfigRegistry.registerConfig(MOD_ID, ConfigType.COMMON, DiceConfig.COMMON_SPEC);
		DiceRegistry.register();
	}

}
