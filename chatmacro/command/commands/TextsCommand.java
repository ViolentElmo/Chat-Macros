package chatmacro.command.commands;

import chatmacro.command.Command;
import chatmacro.main.Init;
import chatmacro.util.Macro;
import net.minecraft.util.Formatting;

import java.util.ArrayList;

public class TextsCommand extends Command {
    public TextsCommand(){
        super("texts", "Lists all the text a macro sends in order!", ";texts (macro)");
        this.args = 1;
    }

    public void run(ArrayList<String> args){
        for(Macro i : Init.macros){
            if(args.get(0).toLowerCase().equals(i.name)){
                feedback(Formatting.GOLD + i.name + "'s" + " texts:");
                for(int j = 0; j < i.texts.size(); j++){
                    feedback(j + ": " + i.texts.get(j));
                }
                return;
            }
        }
        feedback(Formatting.RED + "Macro not found!");
    }
}
