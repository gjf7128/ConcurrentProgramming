import java.util.LinkedList;
import java.util.Queue;

public class Bridge3 {

    Queue<Woolie3> queue = new LinkedList<>();
    Queue<Woolie3> waitingLine = new LinkedList<>();

    public synchronized void enterBridge(Woolie3 woolie3) throws InterruptedException {
        if (queue.size() >= 3) {
            waitingLine.add(woolie3);
            while (queue.size() >= 3) {
                wait();
                if (queue.size() < 3 & waitingLine.peek() == woolie3) {
                    break;
                }
            }
            queue.add(waitingLine.remove());
        }
        else {
            queue.add(woolie3);
        }
    }

    public synchronized void leaveBridge() {
        queue.remove();
        notifyAll();
    }
}
