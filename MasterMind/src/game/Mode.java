package game;

import java.util.*;

public abstract class Mode {
    private Scanner sc = new Scanner(System.in);
    protected int[] combinaison;
    protected int[] propositionIa;
    List<String> _PossibleTokens; //combinaisons possibles
    String[] _indicesPossibles = {"B0W0", "B0W1", "B0W2", "B0W3", "B0W4", "B1W0", "B1W1", "B1W2", "B1W3", "B2W0", "B2W1", "B2W2", "B3W0", "B3W1", "B4W0"};
    protected String indice;
    private boolean alreadyExecuted;


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
                System.out.println(_PossibleTokens.size()); //devrait afficher 10000 possibilité, 5000 crées seulement
                System.out.println(_PossibleTokens.get(2000));
                alreadyExecuted = true;
            }
            int i;
            for (i = 0; i < _PossibleTokens.size(); i++) {
                int[] token = convertir(Integer.parseInt(_PossibleTokens.get(i)));
                //System.out.println("avant: " + score(verifCombi(token, propositionIa, 1)));
                //System.out.println("après: " + score(indiceIn));
                if (score(verifCombi(token, propositionIa, 1)) <= score(indiceIn)) { //attention à différencier "indice"
                    System.out.println("avant: " + _PossibleTokens.size());
                    removeAll(_PossibleTokens, _PossibleTokens.get(i));
                    System.out.println("après: " + _PossibleTokens.size());
                    Random rand = new Random();
                    propositionIa = convertir((Integer.parseInt(_PossibleTokens.get(rand.nextInt(_PossibleTokens.size())))));

                } else {
                    Random rand = new Random(); // voir else avec score ?
                    propositionIa = convertir(Integer.parseInt(_PossibleTokens.get(rand.nextInt(_PossibleTokens.size()))));
                }
            }
        }
        return propositionIa;
    }

    /*private List<String> generateCombinations(int arraySize, int[] _ValidDigits) {
        List<String> tokens = new ArrayList<>();
        int carry;
        int[] indices = new int[arraySize];
        do {
            for (int index : indices)
                tokens.add(_ValidDigits[index] + "");
            carry = 1;
            for (int i = indices.length - 1; i >= 0; i--) {
                if (carry == 0)
                    break;

                indices[i] += carry;
                carry = 0;

                if (indices[i] == _ValidDigits.length) {
                    carry = 1;
                    indices[i] = 0;
                }
            }
        }
        while (carry != 1); // Call this method iteratively until a carry is left over
        return tokens;
    }*/

    private List<String> generateCombinations() {
        List<String> tokens = new ArrayList<>();
        for (int i = 9999; i >= 0; i--) {
            String result = "" + i;
            for (int c = 0; c < 4; c++) {
                if (result.length() < 4) {
                    result = "0" + result;
                }
            }
            tokens.add(result);
            System.out.println(result);

        }
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
