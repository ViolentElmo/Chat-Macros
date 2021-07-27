package chatmacro.command.commands;

import chatmacro.command.Command;
import chatmacro.main.Init;
import chatmacro.util.KeyHelper;
import chatmacro.util.Macro;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.Locale;

public class NewCommand extends Command{
    public NewCommand(){
        super("new", "Adds a new macro!", ";new (macro name) (bind)");
        this.args = 2;
    }

    @Override
    public void run(ArrayList<String> args) {
        if(KeyHelper.isKey(args.get(1).toLowerCase())) {
            for (Macro i : Init.macros) {
                if (args.get(0).toLowerCase().equals(i.name)) {
                    feedback(Formatting.DARK_RED + "A macro with that name already exists!");
                    return;
                }
            }
            Init.macros.add(new Macro(args.get(0).toLowerCase(), args.get(1)));
            feedback(Formatting.GREEN + "Added the macro \"" + args.get(0).toLowerCase() + "\" ");
        }
        else{feedback(Formatting.RED + args.get(1) + " is not a valid key! Do ;keys to see all of them!");}
    }
}
