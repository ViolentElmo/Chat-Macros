package chatmacro.command.commands;

import chatmacro.command.Command;
import chatmacro.main.Init;
import chatmacro.util.Macro;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class InsertCommand extends Command {
    public InsertCommand() {
        super("insert", "Inserts text at an index in a macro!", ";insert (macro) (index) (text)");
    }

    public void run(ArrayList<String> args){
        if(args.size() > 2) {
            for(Macro i : Init.macros){
                if (i.name.equals(args.get(0).toLowerCase())) {
                    try {
                        i.texts.add(Integer.parseInt(args.get(1)), args.stream().skip(2).collect(Collectors.joining(" ")));
                        feedback(Formatting.GREEN + "Text added!");
                    } catch (Exception e) {
                        feedback(Formatting.RED + "Something went wrong!");
                    }
                    return;
                }
            }
            feedback(Formatting.RED + "Macro not found!");
        }
        else{feedback(Formatting.RED + "Wrong syntax! Syntax: " + this.syntax);}
    }
}
