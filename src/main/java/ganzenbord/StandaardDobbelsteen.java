package ganzenbord;

import java.util.Random;

public class StandaardDobbelsteen implements Dobbelsteen {

    private final int maximaleWaarde;
    private int aantalOgen;

    public StandaardDobbelsteen(int maximaleWaarde) {
        if(maximaleWaarde > 1000) {
            maximaleWaarde = 1000;
        }
        this.maximaleWaarde = maximaleWaarde;
    }

    public void gooi() {
        Random random = new Random();
        this.aantalOgen = random.nextInt(maximaleWaarde)+1; // random telt vanaf 0 tot 5.Omdat 0 niet meedoet ��n bij toegevoegd om 1-6 te krijgen.
    }

    public int getAantalOgen() {
        return aantalOgen;
    }
}
