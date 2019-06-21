/*

package main.java.game;

import java.util.Arrays;

public abstract class Game {

    protected int[] combinaison;
    protected int[] proposition;


    public void jouerDuel() {
        proposition();
        verifCombi();
    }

    public void jouer() { //permet de lancer ds l'ordre la proposition qui est convertie puis de vérifier la combinaison
        do {
            proposition();
            verifCombi();
        }
        while (!Arrays.equals(combinaison, proposition));
    }

    public void proposition() {
        proposition = convertir(demanderAttaquant());
        System.out.println(Arrays.toString(proposition));
    }

    public void init() {
        combinaison = convertir(demanderDefenseur());
        System.out.println(Arrays.toString(combinaison));
    }

    protected int[] convertir(int nb) {  //méthode servant à convertir les int en int[]
        int[] retVal = new int[4];
        int i = 3;
        while (nb != 0) {
            int reste = nb % 10;
            retVal[i] = reste;
            i = i - 1;
            nb = nb / 10;
        }
        return retVal;
    }

    protected int convertir(int[] thisIsAnArray) { //convertit dansl'autre sens - int[] en int
        String delimiter = "";
        StringBuilder sb = new StringBuilder();
        for (int element : thisIsAnArray) {
            if (sb.length() > 0) {
                sb.append(delimiter);
            }
            sb.append(element);
        }
        String theString = sb.toString();
        int result = Integer.parseInt(theString);

        return result;
    }


    protected abstract int demanderAttaquant();

    protected abstract int demanderDefenseur();

    protected abstract String verifCombi();

}

*/
