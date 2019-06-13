package game;

import java.util.Arrays;

public class Duel extends Mode {
    private boolean alreadyExecuted;
    private int[] propositionHum;
    private int[] propositionIaFinale;
    private String indiceIa;

    @Override
    public void run(int gameType) {
        codeSize();
        if (gameType == 0) {
            combinaison = convertir(rdmProposition(codeSize));
            do {
                System.out.println("Joueur Humain, faites une proposition");
                propositionHum = convertir(saisir());
                nbEssais++;
                verifCombi(combinaison, propositionHum, 0, codeSize);
                System.out.println(Arrays.toString(propositionHum) + "indice : " + indice + " Essais: " + nbEssais);
                if (!alreadyExecuted) {
                    propositionIa = convertir(propositionInit(codeSize));
                    alreadyExecuted = true;
                    verifCombi(combinaison, propositionIa, 0, codeSize);
                    indiceIa = indice;
                    System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa + " Essais: " + nbEssais);
                } else {
                    verifCombi(combinaison, computerTest(indiceIa, 0, codeSize), 0, codeSize);
                    indiceIa = indice;
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
            combinaison = convertir(rdmProposition(codeSize));
            do {
                System.out.println("Joueur Humain, faites une proposition");
                propositionHum = convertir(saisir());
                nbEssais++;
                verifCombi(combinaison, propositionHum, 1, codeSize);
                System.out.println(Arrays.toString(propositionHum) + "indice : " + indice + " Essais: " + nbEssais);
                if (!alreadyExecuted) {
                    propositionIa = convertir(1122);
                    alreadyExecuted = true;
                    verifCombi(combinaison, propositionIa, 1, 4);
                    indiceIa = indice;
                    System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa + " Essais: " + nbEssais);
                } else {
                    verifCombi(combinaison, computerTest(indiceIa, 1, codeSize), 1, codeSize);
                    indiceIa = indice;
                    System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa + " Essais: " + nbEssais);
                    propositionIaFinale = propositionIa;
                }
            } while (!Arrays.equals(combinaison, propositionIaFinale) && !Arrays.equals(combinaison, propositionHum) && nbEssais <= 12);
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
