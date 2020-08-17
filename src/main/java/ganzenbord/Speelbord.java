package ganzenbord;

import ganzenbord.vakken.StandaardVak;
import ganzenbord.vakken.Vak;

import java.util.ArrayList;

public class Speelbord {

    ArrayList<Vak> vakken = new ArrayList<>();

    public Speelbord() {
        for(int i = 0; i < 63; i++) {
            vakken.set(i, new ganzenbord.vakken.StandaardVak(i+1, this));
        }

        vakken.set(5, new Brug(6, this));
        vakken.set(24, new TerugNaarStartVak(25, this));
        vakken.set(44, new TerugNaarStartVak(45, this));

        // HERBERG
        // PUT
        // ETC
    }

    public void verplaatsAantalStappen(Speler speler, int aantalStappenTeVerplaatsen) {
        int nieuweLocatieAlsCijfer = speler.getLocatie() + aantalStappenTeVerplaatsen;
        ganzenbord.vakken.Vak nieuweLocatie = vakken.get(nieuweLocatieAlsCijfer);
        speler.setLocatie(nieuweLocatie);
    }

    public void verplaatsSpelerNaarStart(Speler speler) {
        speler.setLocatie(vakken.get(0));
    }
}
