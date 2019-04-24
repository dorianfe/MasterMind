package game;

import java.util.Arrays;

public class Challenger extends Mode {

    private int[] proposition;
    private int nbEssais;

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
                System.out.println(Arrays.toString(proposition) + "indice : " + indice + " essais: " + nbEssais);
                if (nbEssais == 10){
                    System.out.println("Perdu, nombre d'essais max atteint!");
                    break;
                }
            } while (!Arrays.equals(combinaison, proposition));

        }else {
            System.out.println("-----------");
        }
    }
}
