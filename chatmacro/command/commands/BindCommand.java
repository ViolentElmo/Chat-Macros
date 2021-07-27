package chatmacro.command.commands;

import chatmacro.command.Command;
import chatmacro.main.Init;
import chatmacro.util.KeyHelper;
import chatmacro.util.Macro;
import net.minecraft.util.Formatting;

import java.util.ArrayList;

public class BindCommand extends Command {
    public BindCommand() {
        super("bind", "Binds a micro!", ";bind (macro) (key)");
        this.args = 2;
    }

    public void run(ArrayList<String> args){
        for(Macro i : Init.macros){
            if(args.get(0).toLowerCase().equals(i.name)){
                if(KeyHelper.isKey(args.get(1))){
                    i.bind = args.get(1);
                    return;
                }
            }
        }
        feedback(Formatting.RED + "Module not found!");
    }
}
