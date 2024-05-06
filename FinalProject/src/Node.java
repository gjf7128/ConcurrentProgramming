import java.util.LinkedList;
import java.util.Queue;

public class Node {
    private NodeType nodeType;

    //How many workers can harvest at once
    private int nodeSlots;
    private int units;

    private Queue<Worker> queue = new LinkedList<>();

    public Node(NodeType nodeType, int nodeSlots, int units) {
        this.nodeType = nodeType;
        this.nodeSlots = nodeSlots;
        this.units = units;
    }

    public synchronized void useNode(Worker worker) {
        if (queue.size() >= nodeSlots) {
            System.out.println("This node is full");
        }
        else {
            queue.add(worker);
        }
    }

    public synchronized void leaveNode() {
        queue.remove();
        notifyAll();
    }
}
