package game;

import java.util.Scanner;

public abstract class Mode {
    private Scanner sc = new Scanner(System.in);
    protected int[] derniereTentative;
    protected int[] combinaison;
    protected int[] propositionIa;
    String indice;


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

    protected String verifCombi(int[] combinaison, int[] proposition, int gameType) {
        //gameType = PlusMoins ou Mastermind
        // blackPeg (B) = bien placé  -- whitePeg (W) = mal placé mais présent
        int B = 0;
        int W = 0;
        indice = "";
        for (int i = 0; i < combinaison.length; i++) {
            if (combinaison[i] < proposition[i]) {
                indice = indice + "-";
            } else if (combinaison[i] == proposition[i]) {
                indice = indice + "=";
                B++;
            } else {
                indice = indice + "+";
            }
            for (int j = 0; j < proposition.length; j++) {
                if (combinaison[i] == proposition[j] && combinaison[i] != proposition[i]) {
                    W++;
                    break;
                }
            }
        }
        if (gameType == 0) { //0 = PlusMoins
            return indice;
        } else {
            indice = "B" + B + "W" + W;
        }
        return indice;
    }


    protected int saisir() { // try catch
        int x = sc.nextInt();
        return x;
    }

    protected int rdmProposition() {
        double rdmProposition = Math.random() * 9999;
        return (int) rdmProposition;

    }

    protected int propositionInit() {
        double propositionInit = 4444;
        return (int) propositionInit;
    }

    protected int[] computerTest(String indice, int gameType) {
        if (gameType == 0) {
            propositionIa = derniereTentative;
            int i;
            for (i = 0; i < 4; i++) {
                char plusMoins = indice.charAt(i);
                switch (plusMoins) {
                    case '=':
                        propositionIa[i] = derniereTentative[i];
                        break;
                    case '+':
                        propositionIa[i] = derniereTentative[i] + 1;
                        break;
                    case '-':
                        propositionIa[i] = derniereTentative[i] - 1;
                        break;
                }
            }

        } else {
            //knuth pour mastermind ?
            return derniereTentative;
        }
        return propositionIa;
    }


    public abstract void run(int gameType);

    /*
    Random r = new Random();  Si besoin de random avec param pour nb_chiffres et max (de 0 à max+1)
        for(int i=0 ; i<NB_CHIFFRES ; i++) {
            solution[i] = r.nextInt(MAX+1);
        }
     */

}
