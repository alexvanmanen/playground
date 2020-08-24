package ganzenbord;


public class Speler {

    private Vak vak;

    public int getLocatie() {
        return vak.getVakNummer();
    }

    public void setLocatie(Vak vak) {
        this.vak = vak;
    }
}
