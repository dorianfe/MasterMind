package game.plusmoins;

public class PlusMoinsDuel extends PlusMoins {


    @Override
    protected int demanderAttaquant() {


        return 0;
    }

    @Override
    protected int demanderDefenseur() {
        double random = Math.random() * 9999;
        return (int)random;
    }
}
