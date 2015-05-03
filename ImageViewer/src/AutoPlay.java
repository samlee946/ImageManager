import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask {
    public void run() {
        ImageAction action = ImageAction.getInstance();
        action.ViewNextImage(ImageViewer.frame);
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
        timer.purge();
        timer.schedule(task, 1000, 4000);
    }
    void stop() {
        timer.purge();
    }
//    public static void main(String[] args) {
//        Timer timer = new Timer();
//        MyTask task = new MyTask();
//        timer.schedule(task, 1000, 50000);
//    }         
}