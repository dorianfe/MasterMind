import java.util.Arrays;
import java.util.Scanner;

public class PlusMoins {
    int[] combinaison;
    Scanner sc = new Scanner(System.in);
    private String String;
    int[] proposition;


    public void init() {
        System.out.println("Entrez une combinaison de 4 chiffres : ");
        int x = sc.nextInt();
        combinaison = new int[4];
        int i = 3;
        while (x != 0) {
            int reste = x % 10;
            combinaison[i] = reste;
            i = i - 1;
            x = x / 10;

        }
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
        System.out.println("Faites une propostion de 4 chiffres : ");
        int x = sc.nextInt();
        proposition = new int[4];
        int i = 3;
        while (x != 0) {
            int reste = x % 10;
            proposition[i] = reste;
            i = i - 1;
            x = x / 10;

        }
        System.out.println(Arrays.toString(proposition));

    }

    public void verifCombi() {
        for (int i = 0; i < combinaison.length; i++) {
            if (combinaison[i] < proposition[i]) {
                System.out.println("-");
            } else if (combinaison[i] == proposition[i]) {
                System.out.println("=");
            } else {
                System.out.println("+");
            }
        }
        while (combinaison != proposition) { // cette condition ne vérifie pas si les 2 tableaux sont tjrs différents et ne s'arrête donc pas
            proposition();
            verifCombi();
        }

    }

}

