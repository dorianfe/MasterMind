package main.java;

import main.java.game.Challenger;
import main.java.game.Defenseur;
import main.java.game.Duel;
import main.java.game.Mode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// mettre saisir static
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenu, veuillez choisir un jeu \n 1 - Plus Moins; \n 2 - Mastermind.");
        int jeu = sc.nextInt() - 1;
        System.out.println("Choisissez maintenant un mode de jeu: \n 1 - Challenger (à vous de trouver le code secret) \n 2 - Denfenseur (vous choisissez le code secret, la machine doit le trouver en un nombre limité de coups \n 3 - Duel (vous jouez contre la machine, le premier à trouver le code secret gagne");
        int modeJeu = sc.nextInt();
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

