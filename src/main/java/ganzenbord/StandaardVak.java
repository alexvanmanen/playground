package ganzenbord;

public class StandaardVak implements ganzenbord.vakken.Vak {


    protected Speelbord speelbord;
    protected int vakNummer;

    public StandaardVak(int vakNummer, Speelbord speelbord) {
        this.vakNummer = vakNummer;
        this.speelbord = speelbord;
    }

    @Override
    public void welkomBericht() {


    }

    @Override
    public void gooiVanaf() {

    }

    @Override
    public int getVakNummer() {
        return vakNummer;
    }
}
