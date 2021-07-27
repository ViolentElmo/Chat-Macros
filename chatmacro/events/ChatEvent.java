package chatmacro.events;

public class ChatEvent {
    private String message;
    public boolean cancelled = false;
    public ChatEvent(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
