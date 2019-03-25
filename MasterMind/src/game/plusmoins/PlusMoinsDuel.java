package game.plusmoins;

public class PlusMoinsDuel extends PlusMoins {

    private PlusMoins PlusMoinsChallenger;
    private PlusMoins PlusMoinsDefenseur;

    @Override
    protected void tour() {
        int turn = 1;
        if (turn % 2 == 1) {
            duel(PlusMoinsChallenger, PlusMoinsDefenseur);
        } else {
            duel(PlusMoinsDefenseur, PlusMoinsChallenger);
        }
        turn++;

    }

    @Override
    protected void duel(PlusMoins attaque, PlusMoins defense) {
        attaque.demanderDefenseur();
        defense.demanderAttaquant();

    }

    @Override
    protected int demanderAttaquant() {
        return 0;
    }

    @Override
    protected int demanderDefenseur() {
        return 0;
    }
}
