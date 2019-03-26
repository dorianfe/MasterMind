package game.plusmoins;

public class PlusMoinsDuel {


    public PlusMoins PlusMoinsChallenger;
    public PlusMoins PlusMoinsDefenseur;

    protected void tour() {
        int turn = 1;
        if (turn % 2 == 1) {
            duel(PlusMoinsChallenger, PlusMoinsDefenseur);
        } else {
            duel(PlusMoinsDefenseur, PlusMoinsChallenger);
        }
        turn++;

    }

    protected void duel(PlusMoins attaque, PlusMoins defense) {
        attaque.demanderDefenseur();
        defense.demanderAttaquant();
    }


}

