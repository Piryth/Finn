package fr.finn.model;

import java.util.Date;

public class Achat {

    //Attributs
    private Date dateAchat;
    private int prixUnitaire;

    //Constructeur
    Achat(Date dateAchat, int prixUnitaire) {
        setDateAchat(dateAchat);
        setPrixUnitaire(prixUnitaire);
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
}
