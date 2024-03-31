package mrunknown404.dice;

import mrunknown404.dice.utils.ClientEvents;
import net.fabricmc.api.ClientModInitializer;

// SNWCreations: client mod initializer
public class DiceClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientEvents.register();
    }
}
