package chatmacro.command.commands;

import chatmacro.command.Command;
import chatmacro.main.Init;
import chatmacro.util.Macro;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AddCommand extends Command {
    public AddCommand() {
        super("add", "Adds text to the end of a macro!", ";add (macro) (text)");
    }

    public void run(ArrayList<String> args){
        if(args.size() > 1) {
            for(Macro i : Init.macros){
                if (i.name.equals(args.get(0).toLowerCase())) {
                    i.texts.add(args.stream().skip(1).collect(Collectors.joining(" ")));
                    feedback(Formatting.GREEN + "Text added!");
                    return;
                }
            }
            feedback(Formatting.RED + "Macro not found!");
        }
        else{feedback(Formatting.RED + "Wrong syntax! Syntax: " + this.syntax);}
    }
}
