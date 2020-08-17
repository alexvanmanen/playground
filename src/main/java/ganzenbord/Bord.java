package ganzenbord;

import ganzenbord.vakken.VakRegels;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Bord {
    public void spelen() {

        Dobbelsteen onedicesix = new Dobbelsteen();
        VakRegels vakRegels = new VakRegels();

        int[] pion = {0, 0, 0, 0, 0, 0};

        int[] delay = {0, 0, 0, 0, 0, 0};

        Integer[] put = {0, 0, 0, 0, 0, 0};


        int spelers = new Speler().spelen();
        Scanner keyboardinput2 = new Scanner(System.in);


        int beurt = 1; // speler 1 begint altijd
        while (beurt <= spelers) {


            // System.out.println("Deze speler is aan de beurt:" + beurt);
            // System.out.println("Zoveel spelers zijn er:" + spelers);

            while (pion[beurt] < 63) {

                String gooi = keyboardinput2.next().toLowerCase();

                char c = gooi.charAt(0);         // omdat ik alleen het eerste teken nodig heb, de g

                if (c == 'g') { // er is gegooid

                    int a = onedicesix.rollDobbelsteen();

                    if (delay[beurt] > 0) // hier moet je de beurt overslaan en mag je dus niet gooien
                    {
                        System.out.println("SPELER" + beurt + " ");
                        System.out.println("Je moet nog " + delay[beurt] + " beurt(en) overslaan. De volgende speler is nu aan zet.");
                        delay[beurt] = delay[beurt] - 1; // delay afnemen met 1, omdat de beurt is afgewacht


                        beurt = beurt + 1; // alles is klaar, volgende speler is aan de beurt


                        if (beurt > spelers) {
                            // laatste speler is bereikt. Beurt gaat weer naar 1.
                            beurt = 1;
                        }

                    } else if (put[beurt] > 0) // hier moet je de beurt overslaan en mag je dus niet gooien
                    {
                        System.out.println("SPELER" + beurt + " ");
                        System.out.println("PUT: Je zit nog in de put en moet wachten tot er iemand bij je komt");
                        put[beurt] = put[beurt] + 1; // put toenemen met 1, zo lang zit je nu in de put
                        System.out.println("Dit is het aantal worpen dat je nu in de put zit: " + put[beurt]);
                        System.out.println("De volgende speler moet nu gooien met G.");


                        Integer[] gesorteerd = put.clone(); // hiermee maak ik een kopie van de array put, zodat ik hem omgekeerd kan sorteren. Dat betekent grootste als eerste.
                        Arrays.sort(gesorteerd, Collections.reverseOrder());

                        //	System.out.println(Arrays.toString(gesorteerd)); checken of de array oke is, niet meer nodig


                        if (put[beurt] == gesorteerd[0] && gesorteerd[1] != 0) // deze huidige put zit er het meest aantal worpen in, en er moet nog iemand anders in de put zitten.
                        {
                            System.out.println("Je zat het langste in de put van jullie twee, en mag er nu uit. Druk om G om te gooien.");
                            put[beurt] = 0;

                        }
                        beurt = beurt + 1; // alles is klaar, volgende speler is aan de beurt


                        if (beurt > spelers) {
                            // laatste speler is bereikt. Beurt gaat weer naar 1.
                            beurt = 1;
                        }


                    } else // hier wel
                    {
                        System.out.println("SPELER" + beurt + " ");
                        System.out.println("Je pion staat nu op plek: " + pion[beurt] + " ");
                        System.out.println("Het getal dat je hebt gegooid is: " + a);

                        pion[beurt] = pion[beurt] + a;
                        System.out.println("Je pion staat nu op plek: " + pion[beurt]);


                        if (pion[beurt] % 10 == 0) // kijken of het getal te delen is door tien. dus plek 20 of 30 of 40
                        {
                            System.out.println("He wacht, je staat nu op een plek met bonuspunten, dus je mag nog een keer met " + a + " vooruit");
                            pion[beurt] = pion[beurt] + a;
                            System.out.println("Je pion staat nu op plek: " + pion[beurt]);
                        }

                        if (pion[beurt] > 63) {
                            int b = pion[beurt] - 63; // dit is het aantal dat je te veel hebt
                            pion[beurt] = 63 - b; // dus je pion komt dan weer terug op deze plek
                            System.out.println("Je hebt te veel gegooid en bent voorbij 63 gelopen. Daarom moet je " + b + " stapjes terug");
                            System.out.println("En je staat nu op plek: " + pion[beurt]);
                        }

                        //switch insert here
                        vakRegels.regels(pion, beurt, delay, put);

                        beurt = beurt + 1; // alles is klaar, volgende speler is aan de beurt


                        if (beurt > spelers) {
                            // laatste speler is bereikt. Beurt gaat weer naar 1.
                            beurt = 1;
                        }
                        System.out.println("De volgende speler is aan de beurt: SPELER " + beurt + " (Gooi weer met G en enter)");


                    }
                } else {
                    System.out.println("Voer een G in om te gooien en druk op enter.");

                }

            }
        }

        keyboardinput2.close();

    }


}
