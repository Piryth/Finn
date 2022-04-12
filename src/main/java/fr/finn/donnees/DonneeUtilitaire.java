package fr.finn.donnees;

import java.util.Locale;

public class DonneeUtilitaire {

    /**
     * Vérifie si str contient str2. Similaire à String.contains(), mais ne prend pas la casse en compte.
     * @param str La chaine a laquelle comparer
     * @param str2 La chaine a comparer
     * @return true si str contient str2, false sinon
     */
    public static boolean containsIgnoreCase(String str, String str2) {
        return str.toLowerCase(Locale.ROOT).contains(str2.toLowerCase(Locale.ROOT));
    }
}
