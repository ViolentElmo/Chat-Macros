package chatmacro.command.commands;

import chatmacro.command.Command;
import chatmacro.main.Init;
import chatmacro.util.Macro;
import net.minecraft.util.Formatting;

import java.util.ArrayList;

public class RemoveCommand extends Command {
    public RemoveCommand() {
        super("remove", "Removes a macro!", ";remove (macro name)");
        this.args = 1;
    }

    public void run(ArrayList<String> args){
        for(Macro i : Init.macros){
            if(args.get(0).toLowerCase().equals(i.name)){
                Init.macros.remove(i);
                feedback(Formatting.GREEN + i.name + " was removed!");
                return;
            }
        }
        feedback(Formatting.RED + "Macro was not found!");

    }
}
