package game.mastermind;

import game.Game;

public abstract class MasterMind extends Game {
    @Override
    protected String verifCombi() {
        return null;
    }

    /*public int verifCombiMa() {
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
    public void proposition() {
        proposition = convertir(demanderAttaquant());
        System.out.println(Arrays.toString(proposition));
    }

    public void init() {
        combinaison = convertir(demanderDefenseur());
        System.out.println(Arrays.toString(combinaison));

    }*/

}
