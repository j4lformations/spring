package com.j4ltechnologies.formation.spring.orm.jee.utils;

import java.time.LocalDate;
import java.time.Period;

/**
 * Classe AppUtils, créée le 29/04/2021 à 13:23
 *
 * @author Joachim Zadi
 * @version 1.0 du 29/04/2021
 */

public class AppUtils {
    public static boolean isNullOrEmpty(String chaine) {
        return chaine == null || chaine.trim().isBlank();
    }

    public static String capitalize(String mot) {
        if (!isNullOrEmpty(mot)) {
            return mot.toUpperCase().charAt(0) + mot.toLowerCase().substring(1);
        }
        return "";
    }

    public static int calculeAge(LocalDate ddn) {
        return ddn.until(LocalDate.now()).getYears();
    }
}
