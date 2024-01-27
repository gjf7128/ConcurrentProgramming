class TwoThreadTest {

    public static void main(String[] args) {
        SimpleThread hi = new SimpleThread("Hi");
        SimpleThread ho = new SimpleThread("Ho");
        hi.start();
        ho.start();
    }
}