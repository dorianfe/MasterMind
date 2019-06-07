package game;

import java.util.Arrays;

public class Defenseur extends Mode {


    @Override
    public void run(int gameType) {
        if (gameType == 0) {
            System.out.println("sasir code:");
            combinaison = convertir(saisir());
            nbEssais = 1;
            propositionIa = convertir(propositionInit());
            System.out.println((" essais: " + nbEssais + " proposition ") + Arrays.toString(propositionIa));
            verifCombi(combinaison, propositionIa, 0);
            while (!Arrays.equals(combinaison, propositionIa) && nbEssais <= 10) {
                verifCombi(combinaison, computerTest(indice, 0), 0);
                nbEssais++;
                System.out.println(("indice: " + indice + " essais: " + nbEssais + " proposition ") + Arrays.toString(propositionIa));
                if (nbEssais == 10) {
                    System.out.println("Perdu, nombre d'essais max atteint!" + " La réponse était: " + Arrays.toString(combinaison));
                }
            }
        } else {
            System.out.println("---");
            System.out.println("sasir code:");
            combinaison = convertir(saisir());
            propositionIa = convertir(1100);
            nbEssais = 1;
            verifCombi(combinaison, propositionIa, 1);
            System.out.println(Arrays.toString(propositionIa) + indice + " essai :" + nbEssais);
            while (!Arrays.equals(combinaison, propositionIa) && nbEssais <= 12) {
                /*if(!alreadyExecuted){
                    propositionIa = convertir(2233);
                    nbEssais++;
                    System.out.println(Arrays.toString(propositionIa) + indice + " essai :" + nbEssais);
                    verifCombi(combinaison, propositionIa, 1);
                }*/
                verifCombi(combinaison, computerTest(indice, 1), 1);
                _LastIndice.add(score(indice));
                nbEssais++;
                System.out.println(Arrays.toString(propositionIa) + indice + " essai :" + nbEssais);

            }
        }
    }
}


