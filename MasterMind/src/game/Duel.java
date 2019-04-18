package game;

import java.util.Arrays;

public class Duel extends Mode {
    private int nbEssais;
    private boolean alreadyExecuted;
    private int[] propositionHum;
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
                    computerTest(indiceIa, 0);
                    verifCombi(combinaison, propositionIa, 0);
                    indiceIa = indice;
                    System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa);
                }

            } while (!Arrays.equals(combinaison, propositionHum) && !Arrays.equals(combinaison, propositionIa));
            if (combinaison == propositionHum) {
                System.out.println("Victoire joueur Hum!");
            } else if (indiceIa == indiceIa) {
                System.out.println("ex-aequo!");
            } else {
                System.out.println("Victoire IA!");
            }
        } else {
            System.out.println("---");
        }
    }
}
