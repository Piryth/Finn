package fr.finn.donnees;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class TestDonnees {

    private final static String cleAccces = "15154d4d1a6057e69d6ac608cf1779a0"; //Clé d'accès à l'API

    public static void main(String[] args) {
        String url = "https://api.marketstack.com/v1/eod" +
                "    ? access_key = 15154d4d1a6057e69d6ac608cf1779a0" +
                "    & symbols = AAPL";

        try {
            BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
            Scanner sc = new Scanner(in);
            while (sc.hasNext()) {
                System.out.println(sc.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
