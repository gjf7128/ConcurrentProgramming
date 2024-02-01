public class Woolie extends Thread {

    String name;

    /**How long it takes to cross a bridge in seconds */
    int speed;

    String destination;

    public Woolie(String name, int speed, String destination) {
        this.name = name;
        this.speed = speed;
        this.destination = destination;
    }

    public synchronized void run() {
        for (int count = 0; count <= speed; count++) {
            if (count == 0) {
                System.out.println(name + " has arrived at the bridge.");
                System.out.println(name + " is starting to cross.");
            }
            else if (count == speed) {
                System.out.println("\t" + name + " " + count + " seconds.");
                System.out.println(name + " leaves at " + destination);
                break;
            }
            else {
                System.out.println("\t" + name + " " + count + " seconds.");
            }
            try {
                sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}
