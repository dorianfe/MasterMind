/*
package game.mastermind;

import game.Game;

public abstract class MasterMind extends Game {

    @Override
    protected String verifCombi() { //Mettre,les 2 tableaux en param
        int present = 0;
        int bienPlace = 0;
        for (int i = 0; i < combinaison.length; i++) {
            if (combinaison[i] == proposition[i]) {
                bienPlace++;
            }
            for (int j = 0; j < proposition.length; j++) {
                if (combinaison[i] == proposition[j] && combinaison[i] != proposition[i]) {
                    present++;
                    break;
                }
            }
        }
        System.out.println("mal placé: " + present);
        System.out.println("bien placé: " + bienPlace);
        //String indice = "";
        return String.valueOf(bienPlace);
    }
}




*/
