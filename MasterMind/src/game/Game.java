package game;

import java.util.Arrays;

public abstract class Game {

    protected int[] combinaison;
    protected int[] proposition;

    public void jouer() {
        do {
            proposition();
            verifCombi();
        }
        while (!Arrays.equals(combinaison, proposition)); //il faudrait arrêter la partie du mastermind avant que propo = combi
    }

    public void proposition() {
        proposition = convertir(demanderAttaquant());
        System.out.println(Arrays.toString(proposition));
    }

    public void init() {
        combinaison = convertir(demanderDefenseur());
        System.out.println(Arrays.toString(combinaison));

    }

    protected int[] convertir(int nb) {
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

    protected int convertir(int[] thisIsAnArray) {
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
