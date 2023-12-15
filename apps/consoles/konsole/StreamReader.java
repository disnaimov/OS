package consoles.konsole;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class StreamReader extends Thread{
    private InputStream is;
    private CommandListener listener;

    public StreamReader(CommandListener listener, InputStream is){
        this.listener = listener;
        this.is = is;
        start();
    }

    @Override
    public void run() {

        try {
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);

        int value = -1;
        while ((value = isr.read()) != -1) {
            listener.commandOutput(Character.toString((char) value));
        } 
        } catch (IOException exp){
            exp.printStackTrace();
        }
    }

    
}
