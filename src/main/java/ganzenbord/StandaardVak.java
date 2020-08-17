package ganzenbord;

public class StandaardVak implements Vak {


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
