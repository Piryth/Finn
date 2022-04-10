package fr.finn.model;

public class Action {

    //Attributs
    private String nom;
    private String symbole;


    //Constructeurs
    public Action(String nom, String symbole) {
        setNom(nom);
        setSymbole(symbole);
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
}
