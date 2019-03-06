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

    public int convertir(int[] thisIsAnArray) {
        String delimiter = "";
        StringBuilder sb = new StringBuilder();
        for (int element : thisIsAnArray) {
            if (sb.length() > 0) {
                sb.append(delimiter);
            }
            sb.append(element);
        }
        String theString = sb.toString();
        int result = Integer.parseInt(theString);

        return result;
    }

    public void jouer() {
        do {
            proposition();
            verifCombiMaster();
            //verifCombi();
        }
        while (!Arrays.equals(combinaison, proposition));
    }

    public void proposition() {
        proposition = convertir(demanderAttaquant());
        System.out.println(Arrays.toString(proposition));
    }

    public String verifCombi() {
        String indice = "";
        for (int i = 0; i < combinaison.length; i++) {
            if (combinaison[i] < proposition[i]) {
                indice = indice + "-";
            } else if (combinaison[i] == proposition[i]) {
                indice = indice + "=";
            } else {
                indice = indice + "+";
            }
        }
        //System.out.println(indice);
        return indice;
    }

    public int verifCombiMaster() {
        int present = 0;
        for (int i = 0; i < combinaison.length; i++) {
            for (int j = 0; j < proposition.length; j++) {
                if (combinaison[i] == proposition[j]) {
                    present++;
                    break;
                }
            }
        }
        System.out.println("présent: " + present);
        return present;
    }

    protected abstract int demanderAttaquant();

    protected abstract int demanderDefenseur();

}


