package fr.finn.donnees;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class TestDonnees {


    public static void main(String[] args) {
        /*
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://yfapi.net/v8/finance/chart/AAPL"))
                .header("x-api-key", "UUZM3jqObS38oPsT6GwPY9WWWrPKAdRv3ZKEFSqd")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());
*/

        //Nettoyage


        try {
            File clean = new File("asset/symbole_action_euronext.csv");
            File old = new File("asset/stocks_symbol_euronext.csv");

            if (clean.createNewFile()) {
                System.out.println("Un fichier propre à été crée.");
            } else {
                System.out.println("Le fichier existe déjà");
            }

            InputStream ins = new FileInputStream(old);
            Scanner sc = new Scanner(ins);

            FileWriter fw = new FileWriter(clean);

            String[] ligne = {"",""};

            while (sc.hasNext()) {
                //On prend les données
                ligne = sc.nextLine().split(",");
                ligne[0].replaceAll("\"", "");
                fw.write(ligne[0] + "," + ligne[2] + System.lineSeparator()); // nom, symbole
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Succès : fichier nettoyé");


    }
}
