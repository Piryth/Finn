package fr.finn.model;

import fr.finn.donnees.DonneeUtilitaire;
import yahoofinance.YahooFinance;

import java.io.*;
import java.util.Scanner;

import static yahoofinance.YahooFinance.*;

/**
 * Représente une action d'une entreprise.
 */
public class Action {

    //Attributs
    private String nom;
    private String symbole;
    private String place;


    //Constructeurs
    public Action(String place,String nom, String symbole) {
        setPlace(place);
        setNom(nom);
        setSymbole(symbole);
    }

    public Action(String symbole) {
        setSymbole(symbole);
        try {
            this.nom = get(symbole).getName();
            this.place = get(symbole).getStockExchange();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Action(String place,String nom) {
        setPlace(place);
        setNom(nom);
        setSymbole(generateSymbol(this));
    }

    //Méthodes

    /**
     * Retourne le symbole associé au titre. Les symboles sont stockés dans des fichiers .csv.
     *
     * Crée pour nasdaq et euronext.
     *
     * De plus la fonction corrige le nom de l'entreprise et met le nom complet.
     *
     * @return Le symbole associé au titre (ex : Apple Inc. → AAPL)
     */
    public String generateSymbol(Action action) {

        //Le but est de générer un symbole à partir d'un nom d'entreprise. On a à disposition plusieurs fichiers csv qui associent les noms aux symboles.
        //Localisation du fichier csv des symboles
        final String symbolsUrl = "asset/symbole_action_" + place + ".csv";

        //On ouvre un flux vers le CSV.
        File f = new File(symbolsUrl);

        //On va stocker les données dans un tableau de String. Le but est de spliter les lignes du fichier avec un regex ',' et de les stocker ici.
        String[] ligne = {"",""};
        try {

            //On ouvre le fichier en lecture.
            InputStream ins = new FileInputStream(symbolsUrl);
            Scanner sc = new Scanner(ins);

            /* On parcourt le fichier à la recherche de l'entreprise.
             * Les fichiers CSV sont structurés de la manière suivante : (Nom de l'entreprise, symbole de l'action)
             * Ainsi : ligne[0] -> ,nom et ligne[1] -> symbole
             */

            //On regarde à chaque itération si la ligne en cours correspond au nom de l'action.
            while(!(DonneeUtilitaire.containsIgnoreCase(ligne[0],action.getNom())) && sc.hasNext()) {
                ligne = sc.nextLine().split(",");
            } // le fichier est parcouru || ligne[1].equals(stock)

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //
        if(!action.getNom().equals(ligne[0])) {
            action.setNom(ligne[0]);
        }

        //Le symbole n'est pas placé au même endroit dans le fichier
        return ligne[1];

        //TODO : rechercher dans les différents fichiers pour ne pas avoir à renseigner le nom de la place
    }

    //Getters et Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
