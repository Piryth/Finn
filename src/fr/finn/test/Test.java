package fr.finn.test;

import fr.finn.cli.CLI;
import fr.finn.model.Application;
import fr.finn.model.Portefeuille;

public class Test {

    public static void main(String[] args) {
        Portefeuille p = new Portefeuille();
        Application app = new Application(p);

    }
}
