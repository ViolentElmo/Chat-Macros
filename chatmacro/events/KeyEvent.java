package chatmacro.events;

public class KeyEvent {
    public String key;
    public int type;
    public KeyEvent(String key, int type){
        this.key = key;
        this.type = type;
    }
}
