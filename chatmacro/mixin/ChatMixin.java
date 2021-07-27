package chatmacro.mixin;

import chatmacro.events.ChatEvent;
import chatmacro.main.ChatMacros;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ChatMixin {
    @Inject(at = @At("HEAD"), method = "sendChatMessage", cancellable = true)
    private void onChat(String message, CallbackInfo info){
        ChatEvent event = ChatMacros.EVENT_BUS.post(new ChatEvent(message));
        if(event.cancelled){
            info.cancel();
        }
    }
}
