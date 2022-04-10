package fr.finn.model;

import fr.finn.cli.CLI;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Portefeuille {

    //Attributs
    private Map<String,Possession> possessions;                   //Contient les noms des actions et les actions

    //Constructeur
    public Portefeuille() {
        possessions = new HashMap<>();
    }

    /**
     * Ajoute une action à l'application.
     *
     * Si l'action est déjà possédée, on ajoute le nombre de titres correspondant à l'application
     *
     */
    public void addAction() {

        //On réalise une saisie utilisateur de l'action
        Action action = CLI.saisirAction();
        int nombre = CLI.saisirNombreActions();

        if (possessions.get(action.getNom()) == null) {
            possessions.put(action.getNom(),new Possession(action,nombre));
        }
        else possessions.replace(action.getNom(),new Possession(action, possessions.get(action.getNom()).getNbTitres() + nombre));

        //On ajoute un nouvel achat
        //TODO : ajouter une structure permettant d'aller chercher le prix sur internet
        possessions.get(action.getNom()).addAchat(new Date(System.currentTimeMillis()),0);
    }


    public Collection<Possession> getPossessions() {
        return possessions.values();
    }
}
