package game.plusmoins;

import game.Game;

public abstract class PlusMoins extends Game {

    private PlusMoins PlusMoinsChallenger;
    private PlusMoins PlusMoinsDefenseur;


    protected abstract void tour();
    /*{
        int turn = 1;
        if (turn % 2 == 1) {
            duel(PlusMoinsChallenger, PlusMoinsDefenseur);
        } else {
            duel(PlusMoinsDefenseur, PlusMoinsChallenger);
        }
        turn++;

    }*/

    protected abstract void duel(PlusMoins attaque, PlusMoins defense);
    /*{
        attaque.demanderDefenseur();
        defense.demanderAttaquant();

    }*/

    @Override
    protected String verifCombi() { // vérifie la combinaison en retournant un indice
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


