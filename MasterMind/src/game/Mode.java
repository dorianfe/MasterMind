package game;

import java.util.Scanner;

public abstract class Mode {
    private Scanner sc = new Scanner(System.in);
    private String[] set = new String[2];
    private boolean alreadyExecuted;
    private int[] derniereTentative;

    protected abstract void run();

    protected int[] convertir(int nb) {  //méthode servant à convertir les int en int[]
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

    protected String[] verifCombi(int[] combinaison, int[] proposition, int gameType) {
        //gameType = PlusMoins ou Mastermind
// blackPeg = bien placé  -- whitePeg = mal placé mais présent -- Pour gameType PlusMoins seulement blackPeg
        int blackPeg = 0;
        int whitePeg = 0;
        String indice = "";
        for (int i = 0; i < combinaison.length; i++) {
            if (combinaison[i] < proposition[i]) {
                indice = indice + "-";
            } else if (combinaison[i] == proposition[i]) {
                indice = indice + "=";
                blackPeg++;
            } else {
                indice = indice + "+";
            }
            for (int j = 0; j < proposition.length; j++) {
                if (combinaison[i] == proposition[j] && combinaison[i] != proposition[i]) {
                    whitePeg++;
                    break;
                }
            }
        }
        if (gameType == 0) { //0 = PlusMoins
            set[0] = indice;
        } else {
            set[0] = "" + blackPeg;
            set[1] = "" + whitePeg
        }
        return set;
    }


    protected int saisir() {
        int x = sc.nextInt();
        return x;
    }

    protected int randomProposition() {
        double proposition = Math.random() * 9999;
        return (int)proposition;
    }

    protected int[] computerTest(int gameType) {
        if (gameType == 0) {
            if (!alreadyExecuted) {
                derniereTentative = convertir(randomProposition())
                alreadyExecuted = true;
                return derniereTentative;
            }
            do {
                int i;
                for (i = 0; i < 4; i++) {
                    char indice = set[0].charAt(i);
                    switch (indice) {
                        case '=':
                            derniereTentative[i] = derniereTentative[i];
                            break;
                        case '+':
                            derniereTentative[i] = derniereTentative[i] + 1; // ajouter dicho https://openclassrooms.com/fr/courses/1089536-recherche-dichotomique
                            break;
                        case '-':
                            derniereTentative[i] = derniereTentative[i] - 1; //""
                            break;
                    }
                }

            }while (alreadyExecuted = true);
        }
        return derniereTentative;
    }

    /*int rechercheDicho(int tab[], int nbVal, int val){

        *//* déclaration des variables locales à la fonction *//*
        bool trouve;  //vaut faux tant que la valeur "val" n'aura pas été trouvée
        int id;  //indice de début
        int ifin;  //indice de fin
        int im;  //indice de "milieu"

        *//* initialisation de ces variables avant la boucle de recherche *//*
        trouve = false;  //la valeur n'a pas encore été trouvée
        id = 0;  //intervalle de recherche compris entre 0...
        ifin = nbVal;  //...et nbVal

        *//* boucle de recherche *//*
        while(!trouve && ((ifin - id) > 1)){

            im = (id + ifin)/2;  //on détermine l'indice de milieu

            trouve = (tab[im] == val);  //on regarde si la valeur recherchée est à cet indice

            if(tab[im] > val) ifin = im;  //si la valeur qui est à la case "im" est supérieure à la valeur recherchée, l'indice de fin "ifin" << devient >> l'indice de milieu, ainsi l'intervalle de recherche est restreint lors du prochain tour de boucle
            else id = im;  //sinon l'indice de début << devient >> l'indice de milieu et l'intervalle est de la même façon restreint
        }

        *//* test conditionnant la valeur que la fonction va renvoyer *//*
        if(tab[id] == val) return(id);  //si on a trouvé la bonne valeur, on retourne l'indice
        else return(-1);  //sinon on retourne -1

    }*/
}
