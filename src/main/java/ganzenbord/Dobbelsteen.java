package ganzenbord;

import java.util.Random;

public class Dobbelsteen {

    public int rollDobbelsteen() {
        Random random = new Random();
        int a = random.nextInt(6) + 1; // random telt vanaf 0 tot 5.Omdat 0 niet meedoet ��n bij toegevoegd om 1-6 te krijgen.
        return a;
    }
}