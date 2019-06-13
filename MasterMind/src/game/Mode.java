package game;

import java.util.*;

public abstract class Mode {
    private Scanner sc = new Scanner(System.in);
    protected int[] combinaison;
    protected int[] propositionIa;
    protected List<String> _PossibleTokens; //combinaisons possibles
    protected String[] _IndicesPossibles = {"B0W0", "B0W1", "B0W2", "B0W3", "B0W4", "B1W0", "B1W1", "B1W2", "B1W3", "B2W0", "B2W1", "B2W2", "B3W0", "B3W1", "B4W0"};
    protected List<Integer> _LastIndice = new ArrayList<>();
    protected String indice;
    protected boolean alreadyExecuted;
    protected int nbEssais;
    protected int codeSize;

    protected int codeSize() {
        System.out.println("Veuillez saisir la taille du code secret par un chiffre compris en 4 et 6: ");
        int codeSize = saisir();
        if (codeSize < 4 && codeSize > 6){
            System.out.println("Entrée non valide, veuillez resaisir la taille du code secret, comprise entre 4 et 6 chiffres");
            codeSize = saisir();
        }
        return codeSize;
    }

    protected int[] convertir(int nb) {  //méthode servant à convertir les int en int[]
        int[] retVal = new int[codeSize];
        int i = codeSize - 1;
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

    protected String verifCombi(int[] combinaison, int[] proposition, int gameType, int codeSize) {
        //gameType = PlusMoins ou Mastermind
        // blackPeg (B) = bien placé  -- whitePeg (W) = mal placé mais présent
        int B = 0;
        int W = 0;
        indice = "";
        int[] indiceB = new int[codeSize];
        for (int i = 0; i < combinaison.length; i++) {
            if (combinaison[i] < proposition[i]) {
                indice = indice + "-";
            } else if (combinaison[i] == proposition[i]) {
                indice = indice + "=";
                B++;
                indiceB[i] = i;
            } else {
                indice = indice + "+";
            }
        }
        for (int i = 0; i < combinaison.length; i++) {
            if (combinaison[i] != proposition[i]) {
                for (int j = 0; j < proposition.length; j++) {
                    if (i != j && j != indiceB[j] && combinaison[i] == proposition[j]) {
                        W++;
                    }
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

    protected int rdmProposition(int codeSize) {
        double rdmProposition = Math.random() * ((10 ^ codeSize) - 1);
        return (int) rdmProposition;

    }

    protected int propositionInit(int codeSize) {
        double propositionInit = 4444;
        switch (codeSize) {
            case 4:
                propositionInit = 4444;
                break;
            case 5:
                propositionInit = 44444;
                break;
            case 6:
                propositionInit = 444444;
        }
        return (int) propositionInit;
    }

    protected int[] computerTest(String indiceIn, int gameType, int codeSize) {
        if (gameType == 0) {
            int i;
            for (i = 0; i < codeSize; i++) {
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
                _PossibleTokens = generateCombinations(codeSize);
                alreadyExecuted = true;
            }

            int i;
            for (i = 0; i < _PossibleTokens.size(); i++) {
                int[] token = convertir(Integer.parseInt(_PossibleTokens.get(i)));
                if (score(verifCombi(token, propositionIa, 1, 4)) != score(indiceIn)) {
                    _PossibleTokens.remove(i);
                }
            }
            int c;
            int d;
            if (indiceIn.equals("B0W0")) {
                for (c = 0; c < codeSize; c++) {
                    String e = Integer.toString(propositionIa[c]);
                    for (d = 0; d < _PossibleTokens.size(); d++) {
                        if (_PossibleTokens.get(d).indexOf(e) >= 0) {
                            _PossibleTokens.remove(d--);
                        }
                    }
                }
            } else if (score(indiceIn) >= 1 && score(indiceIn) <= 4) { //si mal placés uniquement
                for (c = 0; c < codeSize; c++) {
                    String e = Integer.toString(propositionIa[c]);
                    for (d = 0; d < _PossibleTokens.size(); d++) {
                        char w = _PossibleTokens.get(d).charAt(c);
                        if (e.equals(Character.toString(w))) {
                            _PossibleTokens.remove(d--);
                        }
                    }
                }
            }
            /*if (nbEssais <= 4 && nbEssais != 1) {
                int o = _LastIndice.indexOf(0);
                if (o == -1) {
                    int j;
                    for (j = 0; j < _PossibleTokens.size(); j++) {
                        int[] token = convertir(Integer.parseInt(_PossibleTokens.get(j)));
                        if (score(verifCombi(token, propositionIa, 1)) == score(indiceIn)) {
                            propositionIa = token;

                            return propositionIa;
                        }
                    }
                }
            }*/
            Random rand = new Random();
            propositionIa = convertir(Integer.parseInt(_PossibleTokens.get(rand.nextInt(_PossibleTokens.size()))));
            //propositionIa = convertir(Integer.parseInt(_PossibleTokens.get(_PossibleTokens.size()/2-1)));
        }
        return propositionIa;
    }

    protected List<String> generateCombinations(int codeSize) {
        List<String> tokens = new ArrayList<>();
        int i = (10 ^ codeSize) - 1;
        for (i = i; i >= 0; i--) {
            String result = "" + i;
            for (int c = 0; c < 4; c++) {
                if (result.length() < 4) {
                    result = "0" + result;
                }
            }
            tokens.add(result);
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

    protected int score(String indiceIn) {
        int j;
        int score = 0;
        for (j = 0; j < _IndicesPossibles.length; j++) {
            if (indiceIn.equals(_IndicesPossibles[j])) {
                score = j;
            }
        }
        return score;
    }

    public abstract void run(int gameType);
}
