package chatmacro.mixin;

import chatmacro.events.KeyEvent;
import chatmacro.main.ChatMacros;
import chatmacro.util.KeyHelper;
import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    @Inject(at = @At("HEAD"), method = "onKey")
    private void onKey(long window, int key, int scancode, int i, int modifiers, CallbackInfo info){
        ChatMacros.EVENT_BUS.post(new KeyEvent(KeyHelper.getKeyString(key), i));
    }
}
