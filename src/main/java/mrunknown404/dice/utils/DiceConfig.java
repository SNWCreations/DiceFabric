package mrunknown404.dice.utils;

import org.apache.commons.lang3.tuple.Pair;

//import net.minecraftforge.common.ForgeConfigSpec;
//import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

import io.github.fabricators_of_create.porting_lib.config.ModConfigSpec; // SNWCreations: thank you porting lib

@SuppressWarnings("UnstableApiUsage")
public class DiceConfig {
    public static class Common {
		private static final int DEFAULT_DICE_EXPIRE_TIME = 10;

		public final ModConfigSpec.ConfigValue<Integer> diceExpireTime;

		public Common(ModConfigSpec.Builder builder) {
			builder.push("dice");
			this.diceExpireTime = builder.comment("How many seconds should the dice last before exploding?").worldRestart().defineInRange("dice expire time",
					DEFAULT_DICE_EXPIRE_TIME, 1, 60);
			builder.pop();
		}
	}

	public static final Common COMMON;
	public static final ModConfigSpec COMMON_SPEC;

	static {
		Pair<Common, ModConfigSpec> commonSpecPair = new ModConfigSpec.Builder().configure(Common::new);
		COMMON = commonSpecPair.getLeft();
		COMMON_SPEC = commonSpecPair.getRight();
	}
}
