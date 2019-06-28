package main.java;

import main.java.game.Challenger;
import main.java.game.Defenseur;
import main.java.game.Duel;
import main.java.game.Mode;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.Scanner;


public class Main {




    public static int saisir() {
        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            System.out.println("Veuillez entrer un entier.");
            sc.nextLine();
        }
        int x = sc.nextInt();
        return x;
    }

    public static void main(String[] args) {


        System.out.println("Bienvenu, veuillez choisir un jeu \n 1 - Plus Moins \n 2 - Mastermind");
        int jeu = saisir() - 1;
        while (jeu != 0 && jeu != 1){
            System.out.println("veuillez choisir un jeu \n 1 - Plus Moins \n 2 - Mastermind");
            jeu = saisir() - 1;
        }
        System.out.println("Choisissez maintenant un mode de jeu: \n 1 - Challenger (à vous de trouver le code secret) \n 2 - Denfenseur (vous choisissez le code secret, la machine doit le trouver en un nombre limité de coups \n 3 - Duel (vous jouez contre la machine, le premier à trouver le code secret gagne");
        int modeJeu = saisir();
        while (modeJeu != 1 && modeJeu !=2 && modeJeu != 3){
            System.out.println("Choisissez un chiffre de 1 à 3, correspondant au mode souhaité.");
            modeJeu = saisir();
        }
        if(jeu == 0){
            switch (modeJeu){
                case 1:
                    Mode mode = new Challenger();
                    mode.run(0);
                    break;
                case 2:
                    mode = new Defenseur();
                    mode.run(0);
                    break;
                case 3:
                    mode = new Duel();
                    mode.run(0);
                    break;
            }
        }else{
            switch (modeJeu){
                case 1:
                    Mode mode = new Challenger();
                    mode.run(1);
                    break;
                case 2:
                    mode = new Defenseur();
                    mode.run(1);
                    break;
                case 3:
                    mode = new Duel();
                    mode.run(1);
                    break;
            }
        }
    }
}

