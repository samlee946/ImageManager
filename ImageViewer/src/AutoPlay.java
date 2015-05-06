import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyTask extends TimerTask {
    public void run() {
        try {
            ImageAction action = ImageAction.getInstance();
            action.ViewNextImage(ImageViewer.frame);
        } catch (IOException ex) {
            Logger.getLogger(MyTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public class AutoPlay {
    public static AutoPlay extanence;
    Timer timer;
    MyTask task;
    static AutoPlay getInstance() {
        if(extanence == null) extanence = new AutoPlay();
        return extanence;
    }
    AutoPlay() {
        timer = new Timer();
        task = new MyTask();
    }
    void start() {
        if(timer != null) timer.cancel();
        timer = new Timer();
        timer.schedule(task, 1000, 4000);
    }
    void stop() {
        if(timer != null) timer.cancel();
    }
//    public static void main(String[] args) {
//        Timer timer = new Timer();
//        MyTask task = new MyTask();
//        timer.schedule(task, 1000, 50000);
//    }         
}