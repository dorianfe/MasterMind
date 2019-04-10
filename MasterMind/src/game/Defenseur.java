package game;

import java.util.Arrays;

public class Defenseur extends Mode {


    @Override
    public void run(int gameType) {
        if (gameType == 0) {
            System.out.println("sasir code:");
            combinaison = convertir(saisir());
            proposition = convertir(randomProposition());
            System.out.println(Arrays.toString(proposition));
            verifCombi(combinaison, proposition, 0);
            while (!Arrays.equals(combinaison, proposition)) {
                verifCombi(combinaison, computerTest(0), 0);
                System.out.println(Arrays.toString(proposition));
            }
        }else {
            System.out.println("---");
        }
    }
}

