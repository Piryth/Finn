package fr.finn.model;

import fr.finn.cli.CLI;

public class Application {

    //Attributs
    private Portefeuille portefeuille;


    //Constructeur
    public Application(Portefeuille portefeuille) {
        this.portefeuille = portefeuille;
        run();
    }

    //Méthodes

    /**
     * Méthode principale de l'application en CLI.
     *
     * Permet à l'utilisateur de naviguer dans les différentes fonctionnalités disponibles.
     *
     * Fonctionnalités disponibles :
     *
     * # 1 - Ajouter un titre en portefeuille.
     *
     * # 2 - Afficher le portefeuille.
     *
     * # 0 - Quitter l'application
     *
     */
    public void run() {

        int choix;
        //On lance la boucle principale
        do {

            //On commence par demander à l'utilisateur de choisir une action à effectuer
            //L'action choisie est forcément un menu disponible, car la contrainte à déjà été prise
            //en compte dans le CLI.
            choix = CLI.saisirMenu();
            //Selon l'action choisie par l'utilisateur, on navigue dans les menus.
            switch (choix) {
                case 1:
                    portefeuille.addAction();
                    break;
                case 2 :
                    CLI.afficherPossessionsActions(portefeuille.getPossessions());
                    break;
                case 0 :
                    break;

            }
        } while (choix != 0);


    }

}
