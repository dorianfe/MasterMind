public class PlusMoinsIa extends PlusMoins {

    @Override
    protected int demanderAttaquant() {
        double random = Math.random() * 9999;
        System.out.println("Je fais une proposition : ");
        do {
            int i;
            for (i = 0; i < 3; i++) {
                char indice = verifCombi().charAt(i);
                switch (indice) {
                    case '=':
                       if (i == 0) {
                           convertir((int)random);


                       }

                }

            }
        }
        return (int) random;
    }

    @Override
    protected int demanderDefenseur() {
        System.out.println("Entrez une combinaison de 4 chiffres : ");
        int x = sc.nextInt();
        return x;
    }

}
