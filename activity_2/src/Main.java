class Main {

    public static void main(String[] args) {
        final String LOC1 = "Merctan";
        final String LOC2 = "Sicstine";

        Woolie stan = new Woolie("Stan", 5, LOC1);
        Woolie kyle = new Woolie("Kyle", 8, LOC2);
        Woolie kenny = new Woolie("Kenny", 6, LOC1);
        Woolie eric = new Woolie("Eric", 10, LOC2);

        stan.start();
        kyle.start();
        kenny.start();
        eric.start();
    }
}