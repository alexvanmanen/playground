package auto;

import javax.transaction.NotSupportedException;

public class TeslaModel3 implements Auto, Oplaadbaar {
    @Override
    public void versnellen() {
        //Zoef elektromotor
    }

    @Override
    public void remmen() {

    }

    public void opladen(Stekker stekker) {

    }
}
