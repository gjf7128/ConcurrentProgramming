public class MainWoolies3 {
    public static void main(String[] args) {
        final String LOC1 = "Merctan";
        final String LOC2 = "Sicstine";
        Bridge3 troll = new Bridge3();

        Woolie3 stan = new Woolie3("Stan", 8, LOC1, troll);
        Woolie3 kyle = new Woolie3("Kyle", 8, LOC2, troll);
        Woolie3 kenny = new Woolie3("Kenny", 7, LOC1, troll);
        Woolie3 eric = new Woolie3("Eric", 10, LOC2, troll);
        Woolie3 raphael = new Woolie3("Raphael", 7, LOC2, troll);
        Woolie3 leonardo = new Woolie3("Leonardo", 8, LOC2, troll);

        stan.start();
        kyle.start();
        kenny.start();
        eric.start();
        raphael.start();
        leonardo.start();
    }
}
