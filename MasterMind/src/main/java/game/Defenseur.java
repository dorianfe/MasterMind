package main.java.game;

import java.util.Arrays;

import static main.java.Main.saisir;

public class Defenseur extends Mode {

    public Defenseur() {
        super();
    }

    @Override
    public void run(int gameType) {
        message("démarrage du mode defenseur");
        if (gameType == 0) {
            System.out.println("sasir code:");
            combinaison = convertir(saisir());
            nbEssais = 1;
            propositionIa = convertir(propositionInit());
            System.out.println((" essais: " + nbEssais + " proposition ") + Arrays.toString(propositionIa));
            verifCombi(combinaison, propositionIa, 0);
            while (!Arrays.equals(combinaison, propositionIa) && nbEssais <= nbEssaisMax) {
                verifCombi(combinaison, computerTest(indice, 0), 0);
                nbEssais++;
                System.out.println(("indice: " + indice + " essais: " + nbEssais + " proposition ") + Arrays.toString(propositionIa));
                if (nbEssais == nbEssaisMax) {
                    System.out.println("Perdu, nombre d'essais max atteint!" + " La réponse était: " + Arrays.toString(combinaison));
                }
            }
        } else {
            System.out.println("---");
            System.out.println("sasir code:");
            combinaison = convertir(saisir());
            propositionIa = convertir(propositionInitMaster());
            nbEssais = 1;
            verifCombi(combinaison, propositionIa, 1);
            System.out.println(Arrays.toString(propositionIa) + indice + " essai :" + nbEssais);
            while (!Arrays.equals(combinaison, propositionIa) && nbEssais <= nbEssaisMax) {
                verifCombi(combinaison, computerTest(indice, 1), 1);
                nbEssais++;
                System.out.println(Arrays.toString(propositionIa) + indice + " essai :" + nbEssais);
                if (nbEssais == nbEssaisMax) {
                    System.out.println("Perdu, nombre d'essais max atteint!" + " La réponse était: " + Arrays.toString(combinaison));
                }

            }
        }
    }
}


