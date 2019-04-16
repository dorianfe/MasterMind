package game;

import java.util.Arrays;

public class Defenseur extends Mode {
    int nbEssais;



    @Override
    public void run(int gameType) {
        if (gameType == 0) {
            System.out.println("sasir code:"); // mettre limite nbre de tours ds la boucle, et indice ds comuterTest
            combinaison = convertir(saisir());
            propositionInitiale = convertir(rdmProposition());
            nbEssais = 1;
            proposition = propositionInitiale;
            System.out.println(Arrays.toString(proposition));
            verifCombi(combinaison, proposition, 0);
            while (!Arrays.equals(combinaison, proposition)) {
                verifCombi(combinaison, computerTest(indice,0), 0);
                nbEssais++;
                System.out.println("indice " + indice + " essais: " + nbEssais);
                System.out.println(Arrays.toString(proposition));
                if (nbEssais >= 10){
                    System.out.println("Nombre d'essais max atteint. Perdu!");
                    break;
                }
            }
        }else {
            System.out.println("---");
        }
    }
}

