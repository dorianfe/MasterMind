package game.plusmoins;

import java.util.Scanner;

public class PlusMoinsIa extends PlusMoins {

    private int[] derniereTentative;
    private int random;
    private boolean alreadyExecuted;
    private Scanner sc = new Scanner(System.in);



    @Override
    protected int demanderAttaquant() {
        if (!alreadyExecuted) {
            random = (int) (Math.random() * 9999);
            alreadyExecuted = true;
            return random;
        }
        do {
            derniereTentative = convertir(random);
            System.out.println("Je fais une proposition : ");
            int i;
            for (i = 0; i < 4; i++) {
                char indice = verifCombi().charAt(i);
                switch (indice) {
                    case '=':
                        derniereTentative[i] = derniereTentative[i];
                        break;
                    case '+':
                        derniereTentative[i] = derniereTentative[i]+1;
                        break;
                    case '-':
                        derniereTentative[i] = derniereTentative[i]-1;
                        break;
                }
            }
            random = convertir(derniereTentative);
            return random;
        } while (alreadyExecuted = true);
    }

    @Override
    protected int demanderDefenseur() {
        System.out.println("Entrez une combinaison de 4 chiffres : ");
        int x = sc.nextInt();
        return x;
    }

}

