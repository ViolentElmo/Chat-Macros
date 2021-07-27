package chatmacro.command.commands;

import chatmacro.command.Command;
import chatmacro.main.Init;
import net.minecraft.util.Formatting;

import java.util.ArrayList;

public class HelpCommand extends Command {
    public HelpCommand(){
        super("help", "Tells you about every command!", ";help");
    }

    public void run(ArrayList<String> args){
        feedback(Formatting.GOLD + "Commands:");
        for(Command i : Init.commands){
            feedback(Formatting.LIGHT_PURPLE + i.name + ": " + i.description);
        }
    }
}
