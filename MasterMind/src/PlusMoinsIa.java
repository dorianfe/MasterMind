public class PlusMoinsIa extends PlusMoins {

    private int[] derniereTentative = null;


    @Override
    protected int demanderAttaquant() {
        int random = (int) (Math.random() * 9999); // prévoir un while ou autre pour ne faire proposition initiale qu'une seule fois
        derniereTentative = convertir(random);
        System.out.println("Je fais une proposition : ");


        /*int i;
        for (i = 0; i < 4; i++) {
            char indice = verifCombi().charAt(i);
            switch (indice) {
                case '=':
                    if (i == 0) {
                        int nvRand0 = (int) (Math.random() * 900) + 100;
                        random = nvRand0 + (randomInit / 1000) * 1000;
                    } else if (i == 1) {
                        int nvRand1 = (int) (Math.random() * 90) + 10;
                        random = nvRand1 + (randomInit / 100) * 100;
                    } else if (i == 2) {
                        int nvRand2 = (int) (Math.random() * 9) + 1;
                        random = nvRand2 + (randomInit / 10) * 10;
                    } else {
                        int nvRand3 = (int) (Math.random() * 900) + 100;
                        random = nvRand3 * 10 + randomInit % 10;
                    }


                case '+':
                    if (i == 0) {

                    } else if (i == 1) {

                    }


            }

        }*/

        return randomInit;
    }

    @Override
    protected int demanderDefenseur() {
        System.out.println("Entrez une combinaison de 4 chiffres : ");
        int x = sc.nextInt();
        return x;
    }

}
