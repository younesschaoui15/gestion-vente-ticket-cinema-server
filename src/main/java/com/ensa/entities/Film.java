package com.ensa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Film {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String titre,genre,acteur,realisateur;
	
	@OneToMany (mappedBy="pk.film")
	private List<Film_Affiche> filmAffiches =new ArrayList<>();
	
	public Film() {
		super();
	}
	public Film(String titre, String genre, String acteur, String realisateur) {
		super();
		this.titre = titre;
		this.genre = genre;
		this.acteur = acteur;
		this.realisateur = realisateur;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getActeur() {
		return acteur;
	}
	public void setActeur(String acteur) {
		this.acteur = acteur;
	}
	public String getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	public List<Film_Affiche> getFilmAffiche() {
		return filmAffiches;
	}
	public void setFilmAffiche(List<Film_Affiche> filmAffiche) {
		this.filmAffiches = filmAffiche;
	}
	
	
	
	
}
