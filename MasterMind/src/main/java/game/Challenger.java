package main.java.game;

import java.util.Arrays;

public class Challenger extends Mode {

    private int[] proposition;
    private int nbEssais;

    public Challenger() {
        super();
    }

    @Override
    public void run(int gameType) {
        if (gameType == 0) {
            combinaison = convertir(rdmProposition());
            nbEssais = 0;
            do {
                System.out.println("Faites une proposition");
                proposition = convertir(saisir());
                nbEssais++;
                verifCombi(combinaison, proposition, 0);
                //System.out.println(Arrays.toString(proposition) + "indice : " + indice + " essais: " + nbEssais);
                System.out.println(("indice: " + indice + " essais: " + nbEssais + " proposition ") + Arrays.toString(proposition));
                if (nbEssais == 10){
                    System.out.println("Perdu, nombre d'essais max atteint!");
                    break;
                }
            } while (!Arrays.equals(combinaison, proposition));
            System.out.println("Victoire en " + nbEssais + " essais.");

        }else {
            System.out.println("-----------");
            combinaison = convertir(rdmProposition());
            nbEssais = 0;
            do {
                System.out.println("Faites une proposition");
                proposition = convertir(saisir());
                nbEssais++;
                verifCombi(combinaison, proposition,1);
                System.out.println(("indice: " + indice + " essais: " + nbEssais + " proposition ") + Arrays.toString(proposition));
                if (nbEssais == nbEssaisMax){
                    System.out.println("Perdu, nombre d'essais max atteint!" + " La réponse était: " + Arrays.toString(combinaison));
                    break;
                }
            } while (!Arrays.equals(combinaison, proposition));
            System.out.println("Victoire en " + nbEssais + " essais.");
        }
    }
}
