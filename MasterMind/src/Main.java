import game.mastermind.MasterMind;
import game.mastermind.MasterMindChallenger;
import game.plusmoins.PlusMoins;
import game.plusmoins.PlusMoinsChallenger;
import game.plusmoins.PlusMoinsDefenseur;

public class Main {

    public static void main(String[] args) {

        MasterMind masterMind = new MasterMindChallenger();
        masterMind.init();
        masterMind.jouer();
        PlusMoins plusMoins = new PlusMoinsDefenseur();
        plusMoins.init();
        plusMoins.jouer();
    }
}
