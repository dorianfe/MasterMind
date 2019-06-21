package main.java.game;

import java.util.Arrays;

public class Duel extends Mode {
    private boolean alreadyExecuted;
    private int[] propositionHum;
    private int[] propositionIaFinale;
    private String indiceIa;

    public Duel() {
        super();
    }

    @Override
    public void run(int gameType) {
        if (gameType == 0) {
            combinaison = convertir(rdmProposition());
            do {
                System.out.println("Joueur Humain, faites une proposition");
                propositionHum = convertir(saisir());
                nbEssais++;
                verifCombi(combinaison, propositionHum, 0);
                System.out.println(Arrays.toString(propositionHum) + "indice : " + indice + " Essais: " + nbEssais);
                if (!alreadyExecuted) {
                    propositionIa = convertir(propositionInit());
                    alreadyExecuted = true;
                    verifCombi(combinaison, propositionIa, 0);
                    indiceIa = indice;
                    if(modDev == 1)
                    System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa + " Essais: " + nbEssais);
                } else {
                    verifCombi(combinaison, computerTest(indiceIa, 0), 0);
                    indiceIa = indice;
                    if(modDev == 1)
                    System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa + " Essais: " + nbEssais);
                    propositionIaFinale = propositionIa;
                }
            } while (!Arrays.equals(combinaison, propositionIaFinale) && !Arrays.equals(combinaison, propositionHum));

            System.out.println(convertir(propositionIaFinale) + "--" + convertir(propositionHum) + "--" + convertir(combinaison));
            if (convertir(propositionIaFinale) == convertir(propositionHum)) {
                System.out.println("ex-aequo!");
            } else if (convertir(combinaison) == convertir(propositionIaFinale)) {
                System.out.println("Victoire IA!");
            } else if (convertir(combinaison) == convertir(propositionHum)) {
                System.out.println("Victoire joueur humain!");
            } else {
                System.out.println("--");
            }
        } else {
            combinaison = convertir(rdmProposition());
            do {
                System.out.println("Joueur Humain, faites une proposition");
                propositionHum = convertir(saisir());
                nbEssais++;
                verifCombi(combinaison, propositionHum, 1);
                System.out.println(Arrays.toString(propositionHum) + "indice : " + indice + " Essais: " + nbEssais);
                if (!alreadyExecuted) {
                    propositionIa = convertir(propositionInitMaster());
                    alreadyExecuted = true;
                    verifCombi(combinaison, propositionIa, 1);
                    indiceIa = indice;
                    if(modDev == 1)
                    System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa + " Essais: " + nbEssais);
                } else {
                    verifCombi(combinaison, computerTest(indiceIa, 1), 1);
                    indiceIa = indice;
                    if(modDev == 1)
                    System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa + " Essais: " + nbEssais);
                    propositionIaFinale = propositionIa;
                }
            } while (!Arrays.equals(combinaison, propositionIaFinale) && !Arrays.equals(combinaison, propositionHum) && nbEssais <= nbEssaisMax);
            if (convertir(propositionIaFinale) == convertir(propositionHum)) {
                System.out.println("ex-aequo!");
            } else if (convertir(combinaison) == convertir(propositionIaFinale)) {
                System.out.println("Victoire IA!");
            } else if (convertir(combinaison) == convertir(propositionHum)) {
                System.out.println("Victoire joueur humain!");
            } else {
                System.out.println("Nombre maximum de coups atteint !");
            }
        }
    }
}
