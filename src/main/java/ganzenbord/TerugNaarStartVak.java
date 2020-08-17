package ganzenbord;


public class TerugNaarStartVak extends ganzenbord.vakken.StandaardVak {

    public TerugNaarStartVak(int vakNummer, Speelbord speelbord) {
        super(vakNummer, speelbord);
    }

    public void welkomBericht(Speler speler) {
        speelbord.verplaatsSpelerNaarStart(speler);
        System.out.println("Ga terug naar start!");
    }
}
