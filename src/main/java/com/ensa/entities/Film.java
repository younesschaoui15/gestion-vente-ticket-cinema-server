package com.ensa.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Film {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String titre,genre,acteur,realisateur;
	
	
	@JsonManagedReference
	@OneToMany (mappedBy="pk.film")
	private Set<Film_Affiche> filmAffiches =new HashSet<Film_Affiche>();
	
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
	public Set<Film_Affiche> getFilmAffiche() {
		return filmAffiches;
	}
	public void setFilmAffiche(Set<Film_Affiche> filmAffiche) {
		this.filmAffiches = filmAffiche;
	}
	
	
	
	
}
