package game.plusmoins;

import game.Game;

public abstract class PlusMoins extends Game {

    @Override
    protected String verifCombi() {
        String indice = "";
        for (int i = 0; i < combinaison.length; i++) {
            if (combinaison[i] < proposition[i]) {
                indice = indice + "-";
            } else if (combinaison[i] == proposition[i]) {
                indice = indice + "=";
            } else {
                indice = indice + "+";
            }
        }
        System.out.println(indice);
        return indice;
    }


}


