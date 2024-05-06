public class Worker {

    private Node currentNode;

    public Worker() {
        this.currentNode = null;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node node) {
        this.currentNode = node;
    }

//    public synchronized void run() {
//        try {
//            currentNode.useNode(this);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
