import java.util.Scanner;

public class PlusMoinsChallenger extends PlusMoins {
    Scanner sc = new Scanner(System.in);

    //joueur humain attaque
    @Override
    protected int demanderAttaquant() {
        System.out.println("Entrez une proposition de 4 chiffres : ");
        int x = sc.nextInt();
        return x;
    }

    @Override
    protected int demanderDefenseur() {
        double random = Math.random() * 9999;
        return (int)random;
    }


}
