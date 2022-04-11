package fr.finn.cli;
import fr.finn.model.*;

import java.util.Collection;
import java.util.Scanner;

/**
 * Classe d'utilitaire de saisie et d'affichage en CLI.
 */
public class CLI {

    public static void afficherPossessionsActions(Collection<Possession> possessions) {

        //On procède à l'affichage pour chaque possession
        for (Possession poss: possessions) {
            System.out.println("=================================");
            System.out.println(poss.getAction().getNom());
            System.out.println("=================================");
            System.out.println("Symbole : " + poss.getAction().getSymbole());
            System.out.println("Nombre de titres possédés : " + poss.getNbTitres());
        }
    }

    /**
     * Effectue la saisie utilisateur d'une action.
     *
     * Saisie d'un nom d'entreprise et d'un symbole.
     *
     * @return Une action correspondant à la saisie.
     */
    public static Action saisirAction() {
        //On initialise la saisie
        Scanner sc = new Scanner(System.in);

        //Saisie du nom
        System.out.println("Saisissez un nom d'entreprise : ");
        String nom = sc.nextLine();

        //Saisie du symbole
        System.out.println("Saisissez un symbole d'action : ");
        String symbole = sc.nextLine();

        return new Action(nom,symbole);
    }

    /**
     * Effectue la saisie utilisateur d'un nombre d'actions. Ce nombre doit être positif et supérieur à 0.
     *
     * @return Le nombre saisi par l'utilisateur.
     */
    public static int saisirNombreActions() {
        //On initialise la saisie
        Scanner sc = new Scanner(System.in);
        //Saisie
        int nombre;
        do {
            System.out.println("Combien de titres souhaitez-vous ajouter ?");
            nombre = sc.nextInt();
            //On nettoie le buffer
            sc.nextLine();
        } while(nombre <= 0); //On reecommence tant que le nombre est nul ou négatif

        return nombre;
    }

    /**
     * Effectue une saisie utilisateur permettant de choisir une action a réaliser.
     *
     * Permet à l'utilisateur de naviguer dans le menu de l'application.
     *
     * @see Application
     *
     * @return L'action saisie par l'utilisateur
     */
    public static int saisirMenu() {
        //On ouvre en saisie
        Scanner sc = new Scanner(System.in);
        int choix;

        //Explications à l'utilisateur
        System.out.println("Choisir une action : ");
        System.out.println("----------------------------------");
        System.out.println("1 - Ajouter une action");
        System.out.println("2 - Visualiser le portefeuille");
        System.out.println("0 - Quitter");

        do {
            //On lance la saisie
            choix = sc.nextInt();
            //On nettoie
            sc.nextLine();
        } while(choix < 0 | choix > 2);

        return choix;
    }

    /**
     * Informe l'utilisateur de la réusite ou de l'échec d'une action.
     *
     * @param bool Indique si le traitement a été effctué (true) ou non (false)
     *
     * @param msg Le message à indiquer à l'utilisateur
     */
    public static void informerUtilisateur(boolean bool, String msg) {
        System.out.println( bool ? "[OK] " : "[KO] " + msg);
    }
}
