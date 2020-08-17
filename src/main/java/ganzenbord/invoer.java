package ganzenbord;

import java.util.Scanner;

public class invoer {
    public int InvoerInt(String melding){
        int result = 1;
        boolean ok = false;
        Scanner keyboardinput = new Scanner(System.in);
        while (!ok){
            try {
                System.out.println(melding);
                result = keyboardinput.nextInt();

                ok = true;
            }
            catch(Exception e) {
                System.out.println("De invoer was geen heel getal!");
                keyboardinput = new Scanner(System.in);
                ok = false;
            }
            if (result == 0 | result > 5)
            {
                System.out.println("Je hebt 0 of meer dan 5 spelers gekozen. Dat kan niet. Kies opnieuw");
                keyboardinput = new Scanner(System.in);
                ok = false;
            }
        }

        return result;

    }




}
