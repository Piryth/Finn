package fr.finn.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Classe association d'une action et du nombre de titres détenus.
 */
public class Possession {

    //Attributs
    private Action action;
    private int nbTitres;
    private ArrayList<Achat> achats;



    //Constructeurs
    public Possession(Action action, int nbTitres) {
        setAction(action);
        setNbTitres(nbTitres);
        achats = new ArrayList<>();
    }

    //Méthodes
    public void addAchat(Date date, int prix) {
        achats.add(new Achat(date,prix));
    }

    //Getters et Setters
    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getNbTitres() {
        return nbTitres;
    }

    public void setNbTitres(int nbTitres) {
        this.nbTitres = nbTitres;
    }
}
