package com.j4ltechnologies.formation.spring.utils;

import java.time.LocalDate;
import java.time.Period;

public class JpaUtils {

	public static boolean isNullOrEmpty(String chaine) {
		return chaine == null || chaine.trim().isBlank();
	};

	public static String capitalize(String mot) {
		return mot.toUpperCase().substring(0, 1) + mot.toLowerCase().substring(1);
	}

	public static int calculeAge(LocalDate ddn) {
		LocalDate now = LocalDate.now();
		return Period.between(ddn, now).getYears();
	}
}