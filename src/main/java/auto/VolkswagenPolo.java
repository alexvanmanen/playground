package auto;

public class VolkswagenPolo implements  Auto, Schakelbaar, Tankbaar {
    @Override
    public void versnellen() {
        //Vroem verbrandingsmotor
    }

    @Override
    public void remmen() {

    }

    public void koppeling() {

    }

    @Override
    public void schakelen() {
        koppeling();
        //naar andere versnelling
    }

    @Override
    public void tank() {

    }
}
