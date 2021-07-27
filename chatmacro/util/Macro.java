package chatmacro.util;

import java.util.ArrayList;

public class Macro {
    public ArrayList<String> texts = new ArrayList<>();
    public String name;
    public String bind = "No bind";
    public Macro(String name, String bind){
        this.name = name;
        this.bind = bind;
    }
}
