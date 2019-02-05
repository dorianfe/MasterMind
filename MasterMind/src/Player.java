import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private Scanner sc = new Scanner(System.in);
    private int x; // représente le nb d'entiers dans la combinaison
    private int chiffre;


    public List<Integer> createCombinaison() {
        System.out.println("De combien de chiffres de 0 à 9 votre combinaison est-elle constituée ? ");
        x = sc.nextInt();
        List<Integer> chiffres = new ArrayList<Integer>();
        for (int i = 1; i <= x; i++) {
            System.out.println("Choisissez un chiffre :");
            chiffre = sc.nextInt();
            chiffres.add(chiffre);
        }
        return combinaison();
    }

    public void combinaison() {
        System.out.println("Veuillez faire une proposition de chiffre");
        int c = sc.nextInt();
        for (int b = 1; b <= x; b++) {
            createCombinaison().get(chiffre);
            if (c < chiffre) {
                System.out.println("+");
            }
                else if (c == chiffre) {
                System.out.println("=");
        } else  {
                System.out.println("-");
            }

    }
}


}


