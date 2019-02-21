import java.util.Arrays;
import java.util.Scanner;

public abstract class PlusMoins {
    private int[] combinaison;
    Scanner sc = new Scanner(System.in);
    private int[] proposition;


    public void init() {
        combinaison = convertir(demanderDefenseur());
        System.out.println(Arrays.toString(combinaison));

    }

    public int[] convertir(int nb) {
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
        do {
            proposition();
            verifCombi();
        }
        while (!Arrays.equals(combinaison, proposition));
    }

    public void proposition() {
        proposition = convertir(demanderAttaquant());
        System.out.println(Arrays.toString(proposition));
    }

    public String verifCombi() {
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
        return "";
    }


    protected abstract int demanderAttaquant();

    protected abstract int demanderDefenseur();

}
//3em methode abstraite, param indice envoyé par arbitre
