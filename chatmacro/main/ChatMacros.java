package chatmacro.main;

import chatmacro.orbit.EventBus;
import chatmacro.orbit.IEventBus;

import java.lang.invoke.MethodHandles;

public class ChatMacros {
    public static IEventBus EVENT_BUS = new EventBus();
    public static void registerLambdaFactory(){
        EVENT_BUS.registerLambdaFactory("chatmacro", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
    }
}
