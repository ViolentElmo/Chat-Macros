package chatmacro.command.commands;

import chatmacro.command.Command;
import chatmacro.main.Init;
import chatmacro.util.Macro;
import net.minecraft.util.Formatting;

import java.util.ArrayList;

public class MacrosCommand extends Command {
    public MacrosCommand() {
        super("macros", "Lists all your macros!", ";macros");
        this.args = 0;
    }

    public void run(ArrayList<String> args){
        if(Init.macros.size() == 0){
            feedback(Formatting.RED + "There are no macros yet! Add some with :new (macro name)");
            return;
        }
        feedback(Formatting.GOLD + "Macros:");
        for(Macro i : Init.macros){
            feedback(Formatting.AQUA + i.name + " (" + i.bind + ")");
        }
    }
}
