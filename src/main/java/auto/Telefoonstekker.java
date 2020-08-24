package auto;

public class Telefoonstekker implements Stekker{
    @Override
    public void transporteerEnergie() throws EnergieException {
        int energie = 10;
        if(energie < 5) {
            throw new EnergieException("Can not handle so much power");
        }
    }
}
