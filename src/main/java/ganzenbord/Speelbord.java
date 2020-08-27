package ganzenbord;

import java.util.ArrayList;

public class Speelbord {

    ArrayList<Vak> vakken = new ArrayList<>();
    private static Speelbord instance;

    private Speelbord() {
        for(int i = 0; i < 62; i++) {
            vakken.add(new StandaardVak(i+1, this));
        }

        vakken.set(5, new Brug(6, this));
        vakken.set(24, new TerugNaarStartVak(25, this));
        vakken.set(44, new TerugNaarStartVak(45, this));

        // HERBERG
        // PUT
        // ETC
    }

    public static Speelbord getInstance(){
        if(instance == null) {
            instance = new Speelbord();
        }
        return instance;
    }}

//    public void verplaatsAantalStappen(Speler speler, int aantalStappenTeVerplaatsen) {
//        int nieuweLocatieAlsCijfer = speler.getLocatie() + aantalStappenTeVerplaatsen;
//        Vak nieuweLocatie = vakken.get(nieuweLocatieAlsCijfer);
//        speler.setLocatie(nieuweLocatie);
//    }

//    public void verplaatsSpelerNaarStart(Speler speler) {
//        speler.setLocatie(vakken.get(0));
//    }
//}
