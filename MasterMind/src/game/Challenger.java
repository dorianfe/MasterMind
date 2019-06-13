package game;

import java.util.Arrays;

public class Challenger extends Mode {

    private int[] proposition;
    private int nbEssais;

    @Override
    public void run(int gameType) {
        codeSize();
        if (gameType == 0) {
            combinaison = convertir(rdmProposition(codeSize), codeSize);
            nbEssais = 0;
            do {
                System.out.println("Faites une proposition");
                proposition = convertir(saisir(), codeSize);
                nbEssais++;
                verifCombi(combinaison, proposition, 0, codeSize);
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
            combinaison = convertir(rdmProposition(codeSize), codeSize);
            nbEssais = 0;
            do {
                System.out.println("Faites une proposition");
                proposition = convertir(saisir(), codeSize);
                nbEssais++;
                verifCombi(combinaison, proposition,1, codeSize);
                System.out.println(("indice: " + indice + " essais: " + nbEssais + " proposition ") + Arrays.toString(proposition));
                if (nbEssais == 10){
                    System.out.println("Perdu, nombre d'essais max atteint!" + " La réponse était: " + Arrays.toString(combinaison));
                    break;
                }
            } while (!Arrays.equals(combinaison, proposition));
            System.out.println("Victoire en " + nbEssais + " essais.");
        }
    }
}
