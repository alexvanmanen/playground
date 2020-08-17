package ganzenbord;

import ganzenbord.vakken.Vak;

public class Speler {

    private ganzenbord.vakken.Vak vak;

    public int getLocatie() {
        return vak.getVakNummer();
    }

    public void setLocatie(ganzenbord.vakken.Vak vak) {
        this.vak = vak;
    }
}
