package game;

import java.util.Arrays;

public class Duel extends Mode {
    private int nbEssais;
    private boolean alreadyExecuted;
    private int[] propositionHum;
    private int[] propositionIaFinale;
    private String indiceIa;

    @Override
    public void run(int gameType) {
        if (gameType == 0) {
            combinaison = convertir(rdmProposition());
            do {
                System.out.println("Joueur Humain, faites une proposition");
                propositionHum = convertir(saisir());
                verifCombi(combinaison, propositionHum, 0);
                System.out.println(Arrays.toString(propositionHum) + "indice : " + indice);
                if (!alreadyExecuted) {
                    propositionIa = convertir(propositionInit());
                    alreadyExecuted = true;
                    verifCombi(combinaison, propositionIa, 0);
                    indiceIa = indice;
                    System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa);
                } else {
                    verifCombi(combinaison, computerTest(indiceIa, 0), 0);
                    indiceIa = indice;
                    System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa);
                    propositionIaFinale = propositionIa;
                }

            } while (!Arrays.equals(combinaison, propositionIaFinale) && !Arrays.equals(combinaison, propositionHum));
            if (propositionIaFinale == propositionHum) {
                System.out.println("ex-aequo!");
            } else if (combinaison == propositionIaFinale) {
                System.out.println("Victoire IA!");
            } else {
                System.out.println("Victoire joueur humain!");
            }
        } else {
            System.out.println("---");
        }
    }
}
