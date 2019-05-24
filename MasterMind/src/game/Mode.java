package game;

import java.util.*;

public abstract class Mode {
    private Scanner sc = new Scanner(System.in);
    protected int[] combinaison;
    protected int[] propositionIa;
    List<String> _PossibleTokens; //combinaisons possibles
    String[] _indicesPossibles = {"B0W0", "B0W1", "B0W2", "B0W3", "B0W4", "B1W0", "B1W1", "B1W2", "B1W3", "B2W0", "B2W1", "B2W2", "B3W0", "B3W1", "B4W0"};
    protected String indice;
    List<String> _LastTry;
    protected boolean alreadyExecuted;


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

    protected int[] computerTest(String indiceIn, int gameType) {
        if (gameType == 0) {
            int i;
            for (i = 0; i < 4; i++) {
                char plusMoins = indiceIn.charAt(i);
                switch (plusMoins) {
                    case '=':
                        propositionIa[i] = propositionIa[i];
                        break;
                    case '+':
                        propositionIa[i] = (propositionIa[i] + 10) / 2;
                        break;
                    case '-':
                        propositionIa[i] = propositionIa[i] - 1;
                        break;
                }
            }

        } else {
            if (!alreadyExecuted) {
                _PossibleTokens = generateCombinations();
                alreadyExecuted = true;
            }
            int i;
            for (i = 0; i < _PossibleTokens.size(); i++) {
                int[] token = convertir(Integer.parseInt(_PossibleTokens.get(i)));
                //System.out.println("avant: " + score(verifCombi(token, propositionIa, 1)));
                //System.out.println("après: " + score(indiceIn));
                if (score(verifCombi(token, propositionIa, 1)) != score(indiceIn)) { //attention à différencier "indice"
                    //System.out.println("avant: " + _PossibleTokens.size());
                    _PossibleTokens.remove(i);
                    //removeAll(_PossibleTokens, _PossibleTokens.get(i));
                    //System.out.println("après: " + _PossibleTokens.size());

                /*} else {
                    propositionIa = convertir(Integer.parseInt(_PossibleTokens.get((_PossibleTokens.size() / 2) + 1)));*/
                }
            }
            char B = indiceIn.charAt(1);

            System.out.println(B);
            System.out.println(indiceIn);
            if ('0' == B) {
                List<String> possibleTemp = _PossibleTokens;
                for (String possibility : possibleTemp) {

                    boolean resultat = containsChar(possibility, propositionIa);
                    System.out.println(resultat);
                }

            }
            if (_PossibleTokens.size() <= 2) {
                propositionIa = convertir(Integer.parseInt(_PossibleTokens.get(0)));
            } else {
                propositionIa = convertir(Integer.parseInt(_PossibleTokens.get((_PossibleTokens.size() / 2) + 1)));
            }
        }
        /*if (score(indiceIn) == 0) {
            int j;
            for (j = 0; j < 4; j++) {
                propositionIa[j] = propositionIa[j] + 1;
                if (propositionIa[j] > 9) {
                    propositionIa[j] = 9;
                }
            }
        }*/

        return propositionIa;
    }

    private boolean containsChar(String possiblity, int[] propositionIa) {
        int c;
        String propoString = Integer.toString(convertir(propositionIa));
        System.out.println(propoString);

        for (c = 0; c < propoString.length(); c++) {
            char p = propoString.charAt(c);
            if (possiblity.indexOf(p) >= 0) {
                System.out.println(p);
                //removeAll(_PossibleTokens, possiblity);
                _PossibleTokens.remove(possiblity);
                return true;

            }

        }

        return false;
    }


    protected List<String> generateCombinations() {
        List<String> tokens = new ArrayList<>();
        for (int i = 9999; i >= 0; i--) {
            String result = "" + i;
            for (int c = 0; c < 4; c++) {
                if (result.length() < 4) {
                    result = "0" + result;
                }
            }
            tokens.add(result);
        }
        //System.out.println(tokens);
        return tokens;
    }

    private void removeAll(List<String> list, String element) {
        List<String> remainingElements = new ArrayList<>();
        for (String number : list) {
            if (!Objects.equals(number, element)) {
                remainingElements.add(number);
            }
        }
        list.clear();
        list.addAll(remainingElements);
    }


    private int score(String indiceIn) {
        int j;
        int score = 0;
        for (j = 0; j < _indicesPossibles.length; j++) {
            if (indiceIn.equals(_indicesPossibles[j])) {
                score = j;
            }
        }
        return score;
    }

    public abstract void run(int gameType);
}
