public class MasterMindChallenger extends PlusMoins {

    @Override
    protected int demanderAttaquant() {
        System.out.println("Entrez une proposition de 4 chiffres : ");
        int x = sc.nextInt();
        /*int bienPlace = 0;
        int i;
        for (i = 0; i < 4; i++) {
            char indice = verifCombi().charAt(i);
            if (indice == '=') {
                bienPlace++;
            } else {
                return x;
            }
        }
        System.out.println(bienPlace);*/
        return x;
    }

    @Override
    protected int demanderDefenseur() {
        double random = Math.random() * 9999;
        return (int)random;
    }
}
