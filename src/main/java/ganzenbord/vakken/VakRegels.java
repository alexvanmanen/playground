package ganzenbord.vakken;

public class VakRegels {
    public void regels(int pion[], int beurt, int delay[], Integer put[]){
        switch (pion[beurt]) {
            case 6:
                System.out.println("BRUG: Je staat op de brug en mag verder naar 12");
                pion[beurt] = 12;
                break;


            case 19:
                System.out.println("HERBERG: Je bent in de herberg. Slaap lekker en sla een beurt over");
                delay[beurt] = delay[beurt] + 1;
                break;

            case 25:
                System.out.println("Ga terug naar start!");
                pion[beurt] = 0;
                break;
            case 45:
                System.out.println("Ga terug naar start!");
                pion[beurt] = 0;
                break;

            case 31:
                System.out.println("PUT: Je bent in de put. Hier blijf je tot er iemand anders ook op komt");
                put[beurt] = put[beurt] + 1;

                break;
            case 42:
                System.out.println("DOOLHOF: Je zoekt een tijdje de weg en komt terug op plek 39");
                pion[beurt] = 39;
                break;
            case 52:
                System.out.println("GEVANGENIS: Je bent in de gevangenis, en moet 3 beurten overslaan");
                delay[beurt] = delay[beurt] + 3;
                break;
            case 58:
                System.out.println("DOOD: Je moet helaas opnieuw beginnen en start weer vanaf het begin");
                pion[beurt] = 0;
                break;
            case 63:
                System.out.println("Je bent op de finish en hebt gewonnen. Gefeliciteerd!");
                System.exit(0);


        }
    }

}
