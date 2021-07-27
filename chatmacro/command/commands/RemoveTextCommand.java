package chatmacro.command.commands;

import chatmacro.command.Command;
import chatmacro.main.Init;
import chatmacro.util.Macro;
import net.minecraft.util.Formatting;

import java.util.ArrayList;

public class RemoveTextCommand extends Command {
    public RemoveTextCommand() {
        super("removetext", "Removes text from a macro!", ";removetext (macro) (index)");
        this.args = 2;
    }

    public void run(ArrayList<String> args){

        for(Macro i : Init.macros){
            if(i.name.equals(args.get(0))){
                try {
                    i.texts.remove(Integer.parseInt(args.get(1)));
                    feedback(Formatting.GREEN + "The text at index " + args.get(1) + " was removed!");
                }
                catch(Exception e){
                    feedback(Formatting.RED + "Something went wrong!");
                }
                return;
            }
        }
        feedback(Formatting.RED + "Macro not found!");
    }
}
