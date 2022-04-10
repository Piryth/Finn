package fr.finn.model;

import java.util.Date;

/**
 * La classe Achat représente un achat. Il lie une action avec une date et un prix unitaire.
 *
 * Le prix unitaire est calculé à partir des données cherchées sur internet en fonction de la date et du symbole.
 *
 */
public class Achat {

    //Attributs
    private Action action;
    private Date dateAchat;
    private int prixUnitaire;

    //Constructeur
    Achat(Action action,Date dateAchat, int prixUnitaire) {
        setDateAchat(dateAchat);
        setPrixUnitaire(prixUnitaire);
        setAction(action);
    }

    //Getters et Setters
    public Date getDateAchat() {
        return dateAchat;
    }

    private void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public int getPrixUnitaire() {
        return prixUnitaire;
    }

    private void setPrixUnitaire(int prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
