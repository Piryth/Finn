package fr.finn.donnees;

import fr.finn.model.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * La classe Donnees actions permet de récolter les données de la bourse sur Internet afin de les retransmettre à l'utilisateur.
 *
 * L'API marketstack est utilisé.
 */
public class DonneesAction {

    private String interval;
    private Date dateDebut;
    private Date dateFin;
    private ArrayList<ArrayList<String>> histoData;
    private ArrayList<ArrayList<String>> divData;
    private String urlHisto;
    private String urlDiv;


    //Méthodes




}
