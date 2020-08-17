package ganzenbord;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;


class ganzenbord {


    public static void main (String args[])
    {

        System.out.println("Welkom bij ganzenbord.");

        int[] pion = { 0,0,0,0,0,0};


        int[] delay = { 0,0,0,0,0,0};

        Integer[] put = { 0,0,0,0,0,0};



        invoer invoerObject = new invoer();
        int spelers = invoerObject.InvoerInt("Kies met hoeveel spelers je wilt spelen (1-5) en druk op enter. Voer een heel getal in:");

        System.out.println("Je speelt met " + spelers + " spelers. Speler 1, druk op G om te gooien en druk op enter.");
        Scanner keyboardinput2 = new Scanner(System.in);
        int beurt = 1; // speler 1 begint altijd
        while (beurt <= spelers)
        {



            // System.out.println("Deze speler is aan de beurt:" + beurt);
            // System.out.println("Zoveel spelers zijn er:" + spelers);

            while (pion[beurt] < 63)
            {

                String gooi = keyboardinput2.next();

                char c = gooi.charAt(0);         // omdat ik alleen het eerste teken nodig heb, de g

                if (c == 'g' || c == 'G')
                { // er is gegooid


                    Random random = new Random(); int a = random.nextInt(6)+1; // random telt vanaf 0 tot 5.Omdat 0 niet meedoet ��n bij toegevoegd om 1-6 te krijgen.




                    if (delay[beurt] > 0) // hier moet je de beurt overslaan en mag je dus niet gooien
                    {
                        System.out.println("SPELER" + beurt + " ");
                        System.out.println("Je moet nog " + delay[beurt] + " beurt(en) overslaan. De volgende speler is nu aan zet.");
                        delay[beurt] = delay[beurt] -1; // delay afnemen met 1, omdat de beurt is afgewacht



                        beurt = beurt +1; // alles is klaar, volgende speler is aan de beurt


                        if (beurt > spelers)
                        {
                            // laatste speler is bereikt. Beurt gaat weer naar 1.
                            beurt = 1;
                        }

                    }



                    else if (put[beurt] > 0) // hier moet je de beurt overslaan en mag je dus niet gooien
                    {
                        System.out.println("SPELER" + beurt + " ");
                        System.out.println("PUT: Je zit nog in de put en moet wachten tot er iemand bij je komt");
                        put[beurt] = put[beurt] +1; // put toenemen met 1, zo lang zit je nu in de put
                        System.out.println("Dit is het aantal worpen dat je nu in de put zit: " + put[beurt]);
                        System.out.println("De volgende speler moet nu gooien met G.");


                        Integer[] gesorteerd = put.clone(); // hiermee maak ik een kopie van de array put, zodat ik hem omgekeerd kan sorteren. Dat betekent grootste als eerste.
                        Arrays.sort(gesorteerd, Collections.reverseOrder());

                        //	System.out.println(Arrays.toString(gesorteerd)); checken of de array oke is, niet meer nodig



                        if (put[beurt] == gesorteerd[0] && gesorteerd[1] != 0) // deze huidige put zit er het meest aantal worpen in, en er moet nog iemand anders in de put zitten.
                        {
                            System.out.println	("Je zat het langste in de put van jullie twee, en mag er nu uit. Druk om G om te gooien.");
                            put[beurt] = 0;

                        }
                        beurt = beurt +1; // alles is klaar, volgende speler is aan de beurt


                        if (beurt > spelers)
                        {
                            // laatste speler is bereikt. Beurt gaat weer naar 1.
                            beurt = 1;
                        }



                    }
                    else // hier wel
                    {
                        System.out.println("SPELER" + beurt + " ");
                        System.out.println("Je pion staat nu op plek: " + pion[beurt] +  " ");
                        System.out.println("Het getal dat je hebt gegooid is: " +a);

                        pion[beurt] = pion[beurt]+a;
                        System.out.println("Je pion staat nu op plek: " +pion[beurt]);





                        if (pion[beurt]%10 == 0) // kijken of het getal te delen is door tien. dus plek 20 of 30 of 40
                        {
                            System.out.println("He wacht, je staat nu op een plek met bonuspunten, dus je mag nog een keer met " + a + " vooruit");
                            pion[beurt] = pion[beurt]+a;
                            System.out.println("Je pion staat nu op plek: " + pion[beurt]);
                        }

                        if (pion[beurt] > 63)
                        {
                            int	b = pion[beurt] -63; // dit is het aantal dat je te veel hebt
                            pion[beurt] = 63-b; // dus je pion komt dan weer terug op deze plek
                            System.out.println("Je hebt te veel gegooid en bent voorbij 63 gelopen. Daarom moet je " + b + " stapjes terug");
                            System.out.println("En je staat nu op plek: " + pion[beurt]);
                        }

                        switch (pion[beurt])
                        {
                            case 6: System.out.println("BRUG: Je staat op de brug en mag verder naar 12");
                                pion[beurt] = 12;
                                break;



                            case 19: System.out.println("HERBERG: Je bent in de herberg. Slaap lekker en sla een beurt over");
                                delay[beurt] = delay[beurt]+1;
                                break;

                            case 25: System.out.println("Ga terug naar start!");
                                pion[beurt] = 0;
                                break;
                            case 45: System.out.println("Ga terug naar start!");
                                pion[beurt] = 0;
                                break;

                            case 31: System.out.println("PUT: Je bent in de put. Hier blijf je tot er iemand anders ook op komt");
                                put[beurt] = put[beurt] +1;

                                break;
                            case 42: System.out.println("DOOLHOF: Je zoekt een tijdje de weg en komt terug op plek 39");
                                pion[beurt] = 39;
                                break;
                            case 52:
                                System.out.println("GEVANGENIS: Je bent in de gevangenis, en moet 3 beurten overslaan");
                                delay[beurt] = delay[beurt]+3;
                                break;
                            case 58:
                                System.out.println("DOOD: Je moet helaas opnieuw beginnen en start weer vanaf het begin");
                                pion[beurt] = 0;
                                break;
                            case 63: System.out.println("Je bent op de finish en hebt gewonnen. Gefeliciteerd!");
                                System.exit(0);


                        }
                        beurt = beurt +1; // alles is klaar, volgende speler is aan de beurt


                        if (beurt > spelers)
                        {
                            // laatste speler is bereikt. Beurt gaat weer naar 1.
                            beurt = 1;
                        }
                        System.out.println("De volgende speler is aan de beurt: SPELER " + beurt + " (Gooi weer met G en enter)");


                    }
                }


                else
                {
                    System.out.println("Voer een G in om te gooien en druk op enter.");

                }

            }
        }

        keyboardinput2.close();

    }
}