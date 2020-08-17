package ganzenbord;

public class Main {

    public static void main(String[] args) {
//        Speelbord speelbord1 = Speelbord.getInstance();
//        Speelbord speelbord2 = Speelbord.getInstance();
//
        Thread t1 = new Thread(Speelbord::getInstance);
        Thread t2 = new Thread(Speelbord::getInstance);

        t1.start();
        t2.start();

        //System.out.println(speelbord1 == speelbord2);
    }
}
