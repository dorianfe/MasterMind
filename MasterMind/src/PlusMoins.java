import java.util.Arrays;
import java.util.Scanner;

public abstract class PlusMoins {
    int[] combinaison;
    Scanner sc = new Scanner(System.in);
    private String String;
    int[] proposition;


    public void init() {
        combinaison = convertir(demanderDefenseur());
        System.out.println(Arrays.toString(combinaison));

    }

    private int[] convertir(int nb) {
        int[] retVal = new int[4];
        int i = 3;
        while (nb != 0) {
            int reste = nb % 10;
            retVal[i] = reste;
            i = i - 1;
            nb = nb / 10;
        }
        return retVal;
    }

    public void jouer() {
        while (true) {
            System.out.println("combinaison");
        }
    }

    public void proposition() {
        proposition = convertir(demanderAttaquant());
        System.out.println(Arrays.toString(proposition));
    }

    public String verifCombi() {
        do {
            proposition();
            for (int i = 0; i < combinaison.length; i++) {
                if (combinaison[i] < proposition[i]) {
                    System.out.print("-");
                } else if (combinaison[i] == proposition[i]) {
                    System.out.print("=");
                } else {
                    System.out.print("+");
                }
            }
            System.out.println();
        }
        while (!Arrays.equals(combinaison, proposition));
    return "";
    }

    protected abstract int demanderAttaquant();
    protected abstract int demanderDefenseur();


}
//3em methode abstraite, param indice envoyé par arbitre
