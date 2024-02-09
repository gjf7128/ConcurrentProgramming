import java.util.Random;

public class Philosopher extends Thread {
    int id;
    Fork left;
    Fork right;
    boolean rHanded;
    int nTimes;
    long thinkMillis;
    long eatMillis;

    public Philosopher(int id, Fork left, Fork right, boolean rHanded,
                       int nTimes, long thinkMillis, long eatMillis) {
        this.id = id;
        this.left = left;
        this.right = right;
        this. rHanded = rHanded;
        this.nTimes = nTimes;
        this.thinkMillis = thinkMillis;
        this.eatMillis = eatMillis;
    }

    public void run() {

        for (int count = 0; count < nTimes || nTimes == 0; count++) {
            Random rand = new Random();
            int sleepTime = (thinkMillis != 0) ? rand.nextInt((int)thinkMillis) : 0;
            System.out.println("Philosopher " + id + " thinks for " + sleepTime + " milliseconds");
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (rHanded) {
                System.out.println("Philosopher " + id + " goes for right fork");
                try {
                    right.acquire();
                    System.out.println("Philosopher " + id + " has right fork");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield();
            }
            System.out.println("Philosopher " + id + " goes for left fork");
            try {
                left.acquire();
                System.out.println("Philosopher " + id + " has left fork");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
            if (!rHanded) {
                System.out.println("Philosopher " + id + " goes for right fork");
                try {
                    right.acquire();
                    System.out.println("Philosopher " + id + " has right fork");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int eatTime = (eatMillis != 0 ) ? rand.nextInt((int)eatMillis) : 0;
            System.out.println("Philosopher " + id + " eats for " + eatTime + " milliseconds");
            try {
                sleep(eatTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            right.release();
            System.out.println("Philosopher " + id + " releases right fork");
            left.release();
            System.out.println("Philosopher " + id + " releases left fork");
        }
    }
}
