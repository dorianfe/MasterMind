package game.mastermind;

import game.Game;

public abstract class MasterMind extends Game {

    @Override
    protected String verifCombi() {
        int present = 0;
        int bienPlace = 0;
        for (int i = 0; i < combinaison.length; i++) {
            if (combinaison[i] == proposition[i]) {
                bienPlace++;
            }
            for (int j = 0; j < proposition.length; j++) {
                if (combinaison[i] == proposition[j] && combinaison[i] != proposition[i]) {
                    present++;
                    break; // devrait empêcher de compter plusieurs fois le même présent
                }
            }
        }
        System.out.println("présent: " + present);
        System.out.println("bien placé: " + bienPlace);
        //String indice = "";
        return String.valueOf(bienPlace);
    }
}

    /*public int verifCombi() {
    int present = 0;
        for (int i = 0; i < combinaison.length; i++) {
            for (int j = 0; j < proposition.length; j++) {
                if (combinaison[i] == proposition[j]) {
                    present++;
                    break; // devrait empêcher de compter plusieurs fois le même présent
                }
            }
        }
        System.out.println("présent: " + present);
        return present;
    }

    }

    }*/



