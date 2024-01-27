class SimpleThread extends Thread {

    String name;

    public SimpleThread(String name) {
        this.name = name;
    }

    public synchronized void run() {
        for (int count = 1; count < 11; count++) {
            try {
                sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                System.out.println("DONE! " + name);
            }
            else {
                System.out.println(count + " " + name);
            }
        }
    }
}