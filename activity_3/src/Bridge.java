public class Bridge {

    boolean bridgeOccupied;

    public synchronized void enterBridge() throws InterruptedException {
        if (bridgeOccupied) {
            wait();
        }
        bridgeOccupied = true;
    }

    public synchronized void leaveBridge() {
        bridgeOccupied = false;
        notify();
    }
}
