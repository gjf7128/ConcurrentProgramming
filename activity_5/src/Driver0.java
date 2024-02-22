public class Driver0 {
    public static void main(String[] args) {
        boolean minusEll = false;
        int numPhilosophers = 4;
        int numCycles = 10;
        long thinkTime = 0; // milliseconds
        long eatTime = 0; // milliseconds

        if (args.length == 5) {
            minusEll = true;
            numPhilosophers = Integer.parseInt(args[1]);
            numCycles = Integer.parseInt(args[2]);
            thinkTime = Long.parseLong(args[3]);
            eatTime = Long.parseLong(args[4]);
        }
        else if (args.length == 4) {
            minusEll = true;
            numPhilosophers = Integer.parseInt(args[1]);
            numCycles = Integer.parseInt(args[2]);
            thinkTime = Long.parseLong(args[3]);
        }
        else if (args.length == 3) {
            minusEll = true;
            numPhilosophers = Integer.parseInt(args[1]);
            numCycles = Integer.parseInt(args[2]);
        }
        else if (args.length == 2) {
            minusEll = true;
            numPhilosophers = Integer.parseInt(args[1]);
        }
        else if (args.length == 1) {
            minusEll = true;
        }

        // Generating forks array
        Fork[] forks = new Fork[numPhilosophers];
        for (int count = 0; count < numPhilosophers; count++) {
            Fork fork = new Fork();
            forks[count] = fork;
        }

        // Generating philosopher array
        Philosopher[] philophers = new Philosopher[numPhilosophers];
        for (int count = 0; count < numPhilosophers; count++) {
            boolean rHanded;

            if (minusEll) {
                rHanded = true;
            }
            else {
                rHanded = (count % 2) == 0;
            }

            Philosopher philosopher = new Philosopher(count,
                    forks[(numPhilosophers + count - 1) % numPhilosophers], forks[count],
                    rHanded, numCycles, thinkTime, eatTime);
            philophers[count] = philosopher;
        }

        for (int count = 0; count < philophers.length; count++) {
            philophers[count].start();
        }
    }
}
