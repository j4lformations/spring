package com.j4ltechnologies.formation.spring.entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album extends AbstractEntity{

	private String titre;

	@ManyToMany(mappedBy = "albums")
	private List<Artiste> artistes;

	public Album() {
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}
