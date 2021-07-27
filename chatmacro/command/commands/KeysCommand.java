package chatmacro.command.commands;

import chatmacro.command.Command;
import chatmacro.util.KeyHelper;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class KeysCommand extends Command {
    public KeysCommand() {
        super("keys", "Lists all bindable keys!", ";keys");
    }

    public void run(ArrayList<String> args){
        feedback(Formatting.GOLD + "Bindable keys:");
        feedback(Formatting.LIGHT_PURPLE + KeyHelper.keys.stream().collect(Collectors.joining(", ")));
    }
}
