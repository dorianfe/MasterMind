public class PlusMoinsIa extends PlusMoins {

    private int[] derniereTentative = null;


    @Override
    protected int demanderAttaquant() {
        int random = (int) (Math.random() * 9999);
        derniereTentative = convertir(random);
        System.out.println("Je fais une proposition : ");
        int i;
        for (i = 0; i < 4; i++) {
            char indice = verifCombi().charAt(i);
            switch (indice) {
                case '=':
                    derniereTentative[i] = derniereTentative[i];
                    random = Integer.valueOf(derniereTentative[i]);


                    break;
                case '+':
                    derniereTentative[i] = +1;
                    break;
                case '-':
                    derniereTentative[i] = -1;
                    break;
            }
        }
        return random;
    }

    @Override
    protected int demanderDefenseur() {
        System.out.println("Entrez une combinaison de 4 chiffres : ");
        int x = sc.nextInt();
        return x;
    }

}
