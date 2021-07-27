package chatmacro.command;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;

import java.util.ArrayList;

public class Command {
    public String name;
    public String description;
    public String syntax;
    public int args = -123;
    protected MinecraftClient mc = MinecraftClient.getInstance();
    public Command(String name, String description, String syntax) {
        this.name = name;
        this.description = description;
        this.syntax = syntax;
    }
    public void run(ArrayList<String> args){ }
    public void feedback(String text){
        mc.player.sendMessage(new LiteralText(text), false);
    }
}
