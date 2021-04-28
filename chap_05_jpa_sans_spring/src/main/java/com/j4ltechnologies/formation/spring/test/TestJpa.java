package com.j4ltechnologies.formation.spring.test;

import javax.persistence.Persistence;

public class TestJpa {
	public static void main(String[] args) {
		Persistence.generateSchema("MYSQL_ASTON_PU", null);
	}
}