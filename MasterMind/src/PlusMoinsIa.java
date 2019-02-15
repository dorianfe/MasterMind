public class PlusMoinsIa extends PlusMoins {

    @Override
    protected int demanderAttaquant() {
        double random = Math.random() * 9999;
        System.out.println("Je fais une proposition : ");
        do {
            int i;
            for (i = 0; i < 3; i++) {
                verifCombi().charAt(i);
                switch () {

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
