package ganzenbord;


public class Speler {


    public int spelen() {

        System.out.println("Welkom bij ganzenbord.");

        Invoer invoerObject = new Invoer();
        int spelers = invoerObject.InvoerInt("Kies met hoeveel spelers je wilt spelen (1-5) en druk op enter. Voer een heel getal in:");

        System.out.println("Je speelt met " + spelers + " spelers. Speler 1, druk op G om te gooien en druk op enter.");
        return spelers;
    }


}