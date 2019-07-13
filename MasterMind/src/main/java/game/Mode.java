package main.java.game;

import main.java.Main;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

import static main.java.Main.saisir;

public abstract class Mode {

    protected int[] combinaison;
    protected int[] propositionIa;
    protected List<String> _PossibleTokens; //combinaisons possibles
    protected String[] _IndicesPossibles = {"B0W0", "B0W1", "B0W2", "B0W3", "B0W4", "B1W0", "B1W1", "B1W2", "B1W3", "B2W0", "B2W1", "B2W2", "B3W0", "B3W1", "B4W0"};
    protected String indice;
    protected boolean alreadyExecuted;
    protected int nbEssais;
    protected int nbEssaisMax;
    protected int codeSize;
    protected int modDev;

    private static Logger logger = Logger.getLogger(Main.class);


    public Mode() {
        DOMConfigurator.configure("log4j2.xml");
        logger.info("Bonjour bienvenu.");

        Properties prop = new Properties();
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
            codeSize = Integer.valueOf(prop.getProperty("code.size"));
            nbEssaisMax = Integer.valueOf(prop.getProperty("nombre.essais"));
            modDev = Integer.valueOf(prop.getProperty("mod.dev"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void message(String message) {
        logger.info(message);
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

    /**
     * @param combinaison le code secret à comparer
     * @param proposition avec la proposition
     * @param gameType    le type de jeu Plus moins ou Mastermind
     * @return
     */
    protected String verifCombi(int[] combinaison, int[] proposition, int gameType) {
        int B = 0;
        int W = 0;
        if (gameType == 0) {
            indice = "";
            //cette boucle permet de comparer la combinaison à la proposition dans le cas du jeu Plus moins
            //et de retourner l'indice pour chaque chiffre +/-/=
            for (int i = 0; i < combinaison.length; i++) {
                if (combinaison[i] < proposition[i]) {
                    indice = indice + "-";
                } else if (combinaison[i] == proposition[i]) {
                    indice = indice + "=";
                } else {
                    indice = indice + "+";
                }
            }
        } else {
            boolean[] marque = new boolean[codeSize];
            //boucle permetttant de trouver les bien placés (B). Le boolean "marque" permet de les repérer
            // pour ne pas les compter 2 fois.
            for (int i = 0; i < combinaison.length; i++) {
                if (combinaison[i] == proposition[i]) {
                    B++;
                    marque[i] = true;
                } else {
                    marque[i] = false;
                }
            }
            // la deuxième boucle suivante permet de trouver les mal placés (W)
            for (int i = 0; i < combinaison.length; i++) {
                if (combinaison[i] != proposition[i]) {
                    int j = 0;
                    boolean trouveMalPlace = false;
                    while ((j < codeSize) && !trouveMalPlace) {
                        if (!marque[j] && (combinaison[i] == proposition[j])) {
                            W++;
                            marque[j] = true;
                            trouveMalPlace = true;
                        }
                        j++;
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

    /**
     * @param indiceIn l'indice retourné par verifCombi suite à la dernière proposition faite par la machine.
     * @param gameType définit le jeu: 0 Plus ou moins, 1 Mastermind
     * @return la nouvelle proposition de code secret trouvée par la machine
     */
    protected int[] computerTest(String indiceIn, int gameType) {
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
                _PossibleTokens = generateCombinations();
                alreadyExecuted = true;
            }
            //boucle servant à retirer toutes les combinaisons de chiffres qui ne donneraient pas le même indice
            // exemple: si propositionIa/code secret, donne indice B1W2, alors toutes les combinaisons (_PossibleTokens)
            //comparées à cette même proposition donnant un indice différent sont alors éliminées de la liste _PossibleTokens
            int i;
            for (i = 0; i < _PossibleTokens.size(); i++) {
                int[] token = convertir(Integer.parseInt(_PossibleTokens.get(i)));
                if (score(verifCombi(token, propositionIa, 1)) != score(indiceIn)) {
                    _PossibleTokens.remove(i);
                }
            }
            //il s'agit ici d'enlever les combinaisons de chiffres inexistants dans le code secret
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
                //cette boucle retire les chiffres mal placés des possibles, seulement lorsqu'ils sont placés de même manière,
                //et s'il n'y a aucun bien placé.
            } else if (score(indiceIn) >= 1 && score(indiceIn) <= 4) {
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
            if (_PossibleTokens.size() < 1) {
                propositionIa = convertir(Integer.parseInt(_PossibleTokens.get(0)));
            }
            Random rand = new Random(); // bound must be positive
            propositionIa = convertir(Integer.parseInt(_PossibleTokens.get(rand.nextInt(_PossibleTokens.size()))));

        }
        return propositionIa;
    }


    protected int rdmProposition() {
        double rdmProposition = Math.random() * ((10 ^ codeSize) - 1);
        return (int) rdmProposition;

    }

    protected int propositionInitMaster() {
        double propositionInit = 1122;
        switch (codeSize) {
            case 4:
                propositionInit = 1122;
                break;
            case 5:
                propositionInit = 11223;
                break;
        }
        return (int) propositionInit;
    }

    protected int propositionInit() {
        double propositionInit = 4444;
        switch (codeSize) {
            case 4:
                propositionInit = 4444;
                break;
            case 5:
                propositionInit = 44444;
                break;
        }
        return (int) propositionInit;
    }

    protected List<String> generateCombinations() {
        List<String> tokens = new ArrayList<>();
        int e = (int) Math.pow(10, codeSize) - 1;
        for (int i = e; i >= 0; i--) {
            String result = "" + i;
            for (int c = 0; c < codeSize; c++) {
                if (result.length() < codeSize) {
                    result = "0" + result;
                }
            }
            tokens.add(result);
        }
        return tokens;
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
