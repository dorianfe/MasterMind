package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Mode {
    private Scanner sc = new Scanner(System.in);
    protected int[] derniereTentative;
    protected int[] combinaison;
    protected int[] propositionIa;
    private ArrayList<Integer> tentative = new ArrayList<Integer>();
    protected String indice;
    private int turn;


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
            derniereTentative = propositionIa;
            int i;
            for (i = 0; i < 4; i++) {
                char plusMoins = indice.charAt(i);
                switch (plusMoins) {
                    case '=':
                        propositionIa[i] = derniereTentative[i];
                        break;
                    case '+':
                        propositionIa[i] = (derniereTentative[i] + 10) / 2;
                        break;
                    case '-':
                        propositionIa[i] = derniereTentative[i] - 1;
                        break;
                }
            }
           /* - Si X>A
                    - Si (9-A)%2 = 0 alors X = X - (9-A)/2  sinon X = X - (9-A)/2 + 1
                    - Si X<A
            - Si (9-A)%2 = 0 alors X = X + (9-A)/2  sinon X = X + (9-A)/2 - 1 */
        } else {
            //knuth pour mastermind ?

            int B = indice.charAt(2);
            int W = indice.charAt(4);
            if (B == 0 && W == 0) {
                propositionIa = convertir(3344);
            } else {
                switch (B) {
                    case 1:

                }
            }
            tentative.add(convertir(propositionIa), turn);
            turn++;
            return propositionIa;


        }
        return propositionIa;
    }


    public abstract void run(int gameType);
}
