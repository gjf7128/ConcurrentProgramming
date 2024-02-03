class Main {

    public static void main(String[] args) {
        final String LOC1 = "Merctan";
        final String LOC2 = "Sicstine";
        Bridge troll = new Bridge();

        Woolie stan = new Woolie("Stan", 5, LOC1, troll);
        Woolie kyle = new Woolie("Kyle", 8, LOC2, troll);
        Woolie kenny = new Woolie("Kenny", 6, LOC1, troll);
        Woolie eric = new Woolie("Eric", 10, LOC2, troll);

        stan.start();
        kyle.start();
        kenny.start();
        eric.start();
    }
}