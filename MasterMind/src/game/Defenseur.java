package game;

import java.util.Arrays;

public class Defenseur extends Mode {


    @Override
    public void run(int gameType) {
        if (gameType == 0) {
            System.out.println("sasir code:"); // mettre limite nbre de tours ds la boucle, et indice ds comuterTest
            combinaison = convertir(saisir());
            propositionInitiale = convertir(rdmProposition());
            proposition = propositionInitiale;
            System.out.println(Arrays.toString(proposition));
            verifCombi(combinaison, proposition, 0);
            while (!Arrays.equals(combinaison, proposition)) {
                verifCombi(combinaison, computerTest(indice,0), 0);
                System.out.println("indice " + indice);
                System.out.println(Arrays.toString(proposition));
            }
        }else {
            System.out.println("---");
        }
    }
}

