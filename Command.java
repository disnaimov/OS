public class Command {
    private CommandListeneer listener;
    private ProcessRunner runner;

    public Command(CommandListener listener){
        this.listener = listener;
    }

    
}
