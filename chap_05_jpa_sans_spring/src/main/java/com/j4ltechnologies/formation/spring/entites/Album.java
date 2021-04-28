package com.j4ltechnologies.formation.spring.entites;

import java.util.ArrayList;
import java.util.List;

public class Album {

	private Integer id;
	private String titre;
	private List<Artiste> artistes;

	public Album(Integer id, String titre) {
		this.id = id;
		this.titre = titre;
		artistes = new ArrayList<Artiste>();
	}

	public Album(String titre) {
		this(null, titre);
	}
	
	public Album() {
		this(null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Artiste> getArtistes() {
		return artistes;
	}

	public void setArtistes(List<Artiste> artistes) {
		this.artistes = artistes;
	}

}
