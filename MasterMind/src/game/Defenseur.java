package game;

import java.util.Arrays;

public class Defenseur extends Mode {
    int nbEssais;



    @Override
    public void run(int gameType) {
        if (gameType == 0) {
            System.out.println("sasir code:"); // mettre limite nbre de tours ds la boucle, et indice ds comuterTest
            combinaison = convertir(saisir());
            nbEssais = 1;
            propositionIa = convertir(propositionInit());
            System.out.println(Arrays.toString(propositionIa));
            verifCombi(combinaison, propositionIa, 0);
            while (!Arrays.equals(combinaison, propositionIa)) {
                verifCombi(combinaison, computerTest(indice,0), 0);
                nbEssais++;
                System.out.println("indice " + indice + " essais: " + nbEssais);
                System.out.println(Arrays.toString(propositionIa));
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

