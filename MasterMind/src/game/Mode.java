package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class Mode {
    private Scanner sc = new Scanner(System.in);
    protected int[] derniereTentative;
    protected int[] combinaison;
    protected int[] propositionIa;
    List<Integer> _PossibleTokens; //combinaisons possibles
    List<Integer> tentatives;//liste pour stocker les tentatives mastermind
    int[] _ValidDigits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; //chiffres utilisables
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


            _PossibleTokens = GetAllPossibleTokens();
            int B = indice.charAt(1);
            int W = indice.charAt(3);
            if (B == 0 && W == 0) {
                removeAll(_PossibleTokens, 1);
                removeAll(_PossibleTokens, 2);

                propositionIa = convertir(3344); // possible d'utiliser replace sur string

            } else if (B + W >= 2) {
                System.out.println("-----");

            }
           /* tentatives.add(convertir(propositionIa), turn);
            turn++;*/
        }
        return propositionIa;
    }

    private List<Integer> GetAllPossibleTokens() {
        List<Integer> tokens = new ArrayList<>();
        for (int d1 = 0; d1 < _ValidDigits.length; d1++)
            for (int d2 = 0; d2 < _ValidDigits.length; d2++)
                for (int d3 = 0; d3 < _ValidDigits.length; d3++)
                    for (int d4 = 0; d4 < _ValidDigits.length; d4++) {
                        if (d1 != d2 && d1 != d3 && d1 != d4
                                && d2 != d3 && d2 != d4
                                && d3 != d4) {
                            tokens.add((_ValidDigits[d1] + _ValidDigits[d2] + _ValidDigits[d3] + _ValidDigits[d4]));
                        }
                    }
        return tokens;
    }

    private void removeAll(List<Integer> list, int element) {
        List<Integer> remainingElements = new ArrayList<>();
        for (Integer number : list) {
            if (!Objects.equals(number, element)) {
                remainingElements.add(number);
            }
        }

        list.clear();
        list.addAll(remainingElements);
    }

    public abstract void run(int gameType);
}
