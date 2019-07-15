package main.java.game;

import java.util.Arrays;

import static main.java.Main.saisir;

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
                    if (modDev == 1)
                        System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa + " Essais: " + nbEssais);
                } else {
                    verifCombi(combinaison, computerTest(indiceIa, 0), 0);
                    indiceIa = indice;
                    if (modDev == 1)
                        System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa + " Essais: " + nbEssais);
                    propositionIaFinale = propositionIa;
                }
            } while (!Arrays.equals(combinaison, propositionIaFinale) && !Arrays.equals(combinaison, propositionHum) && nbEssais <= nbEssaisMax);
            if (nbEssais == nbEssaisMax) {
                System.out.println("Perdu, nombre d'essais max atteint!" + " La réponse était: " + Arrays.toString(combinaison));
            }
            if (convertir(propositionIaFinale) == convertir(propositionHum)) {
                System.out.println("ex-aequo! En " + nbEssais + " coups.");
            } else if (convertir(combinaison) == convertir(propositionIaFinale)) {
                System.out.println("Victoire IA! En " + nbEssais + " coups. La réponse était: " + Arrays.toString(combinaison));
            } else if (convertir(combinaison) == convertir(propositionHum)) {
                System.out.println("Victoire joueur humain! En " + nbEssais + " coups.");
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
                    if (modDev == 1)
                        System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa + " Essais: " + nbEssais);
                } else {
                    verifCombi(combinaison, computerTest(indiceIa, 1), 1);
                    indiceIa = indice;
                    if (modDev == 1)
                        System.out.println(Arrays.toString(propositionIa) + "indiceIa : " + indiceIa + " Essais: " + nbEssais);
                    propositionIaFinale = propositionIa;
                }
            } while (!Arrays.equals(combinaison, propositionIaFinale) && !Arrays.equals(combinaison, propositionHum) && nbEssais <= nbEssaisMax);
            if (nbEssais > nbEssaisMax) {
                System.out.println("Perdu, nombre d'essais max atteint!" + " La réponse était: " + Arrays.toString(combinaison));
            }
            if (convertir(propositionIaFinale) == convertir(propositionHum)) {
                System.out.println("ex-aequo! En " + nbEssais + " coups.");
            } else if (convertir(combinaison) == convertir(propositionIaFinale)) {
                System.out.println("Victoire IA! En " + nbEssais + " coups. La réponse était: " + Arrays.toString(combinaison));
            } else if (convertir(combinaison) == convertir(propositionHum)) {
                System.out.println("Victoire joueur humain! En " + nbEssais + " coups.");
            } else {
                System.out.println("Nombre maximum de coups atteint !");
            }
        }
    }
}
