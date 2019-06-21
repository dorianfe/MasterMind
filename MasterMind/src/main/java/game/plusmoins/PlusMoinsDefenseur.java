/*
package main.java.game.plusmoins;

import java.util.Scanner;

public class PlusMoinsDefenseur extends PlusMoins {

    private int[] derniereTentative;
    private int random;
    private boolean alreadyExecuted;
    private Scanner sc = new Scanner(System.in);
    
    @Override
    protected int demanderAttaquant() { //sans doute dernière tentative en entrée
        if (!alreadyExecuted) {
            random = (int) (Math.random() * 9999);
            alreadyExecuted = true;
            return random;
        }
        do {
            derniereTentative = convertir(random);
            System.out.println("Je fais une proposition : "); //en fonction de l'indice, garde la valeur ou la modifie de +1/-1
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
    protected int demanderDefenseur() { //joueur humain défend
        System.out.println("Entrez une combinaison de 4 chiffres : ");
        int x = sc.nextInt();
        return x;
    }

}

*/
