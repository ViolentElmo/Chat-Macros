package chatmacro.main;

import chatmacro.command.Command;
import chatmacro.command.commands.*;
import chatmacro.events.ChatEvent;
import chatmacro.events.KeyEvent;
import chatmacro.orbit.EventHandler;
import chatmacro.util.Macro;
import com.google.gson.Gson;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Init implements ModInitializer {

    public static MinecraftClient mc = MinecraftClient.getInstance();
    public static ArrayList<Macro> macros = new ArrayList<Macro>();


    public static Command[] commands = {
            new NewCommand(),
            new RemoveCommand(),
            new AddCommand(),
            new InsertCommand(),
            new TextsCommand(),
            new HelpCommand(),
            new MacrosCommand(),
            new RemoveTextCommand(),
            new BindCommand(),
            new KeysCommand(),
    };


    public void onInitialize() {
        ChatMacros.registerLambdaFactory();
        ChatMacros.EVENT_BUS.subscribe(this);
        ClientLifecycleEvents.CLIENT_STARTED.register((a) -> { //I never worked with JSON files before cut me some slack lol
            Gson gson = new Gson();
            try {
                Macro[] macroList = gson.fromJson(new FileReader("chatmacros/chatmacros.json"), Macro[].class); 
                for (Macro i : macroList) {
                    macros.add(i);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        ClientLifecycleEvents.CLIENT_STOPPING.register((a) -> { //i never did this before dont judge my approach lmao
            //THIS TOOK 3 AND A HALF HOURS TO GET TO WORK
            File f = new File("chatmacros/chatmacros.json");
            File folder = new File("chatmacros");
            folder.mkdir();

            if (f.exists()) {
                f.delete();
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Gson gson = new Gson();
            try {
                Writer writer = Files.newBufferedWriter(Paths.get("chatmacros/chatmacros.json"));
                writer.write("[\n");
                for(int i = 0; i < macros.size() - 1; i++) {
                    Macro obj = macros.get(i);
                    writer.write(gson.toJson(obj) + ",\n");
                }
                writer.write( gson.toJson(macros.get(macros.size() - 1)) + "\n");
                writer.write("]");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        });
    }

    @EventHandler
    public void onChat(ChatEvent event){
        if(event.getMessage().trim().startsWith(";")){
            ArrayList<String> args = new ArrayList<String>(Arrays.asList(event.getMessage().trim().substring(1).split(" ")));
            String commandName = args.get(0).toLowerCase();
            args.remove(0);
            boolean commandFound = false;
            for(Command i : this.commands){
                if(commandName.equals(i.name)){
                    if(args.size() == i.args || i.args == -123){
                        i.run(args);
                    }
                    else{mc.player.sendMessage(new LiteralText(Formatting.RED + "Wrong syntax! Syntax: " + i.syntax),false);}
                    commandFound = true;
                }
            }
            if(!commandFound){
                mc.player.sendMessage(new LiteralText(Formatting.RED + "That's not recognized as a command! Try doing ;help!"),false);
            }
            event.cancelled = true;
        }
    }

    @EventHandler
    public void onKey(KeyEvent event) {
        if (mc.player != null) {
            if(event.type == 1){
                for(Macro i : macros) {
                    if(event.key.equals(i.bind)){
                        for(String j : i.texts){
                            mc.player.sendChatMessage(j);
                        }
                    }
                }
            }
        }
    }
}












