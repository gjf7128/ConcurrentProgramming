public class Fork implements IFork {

    private boolean forkAllocated;

    @Override
    public synchronized void acquire() throws InterruptedException {
        if (forkAllocated) {
            wait();
        }
        forkAllocated = true;
    }

    @Override
    public synchronized void release() {
        forkAllocated = false;
        notifyAll();
    }
}
