import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private Scanner sc = new Scanner(System.in);


    public void Combinaison() {
        System.out.println("De combien de chiffres de 0 à 9 votre combinaison est-elle constituée ? ");
        int x = sc.nextInt();
        for (int i = 1; i <= x; i++) {
            System.out.println("Choisissez un chiffre :");
            int chiffre = sc.nextInt();
            List<Integer> chiffres = new ArrayList<Integer>();
            chiffres.add(chiffre);
        }

    }


}
