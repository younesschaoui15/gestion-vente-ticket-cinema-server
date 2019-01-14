package com.ensa.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Film {

	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titre,genre,acteur,realisateur;
	
	//@JsonManagedReference /*il duplique les 'filmsAffiche'*/
	@OneToMany //(mappedBy="pk.film")
	@JoinColumn(name="pk.film") 
	private List<Film_Affiche> filmAffiches = new ArrayList<Film_Affiche>();
	
	public Film() {	}
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
	public void setFilmAffiche(ArrayList<Film_Affiche> filmAffiche) {
		this.filmAffiches = filmAffiche;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acteur == null) ? 0 : acteur.hashCode());
		result = prime * result + ((filmAffiches == null) ? 0 : filmAffiches.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((realisateur == null) ? 0 : realisateur.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (acteur == null) {
			if (other.acteur != null)
				return false;
		} else if (!acteur.equals(other.acteur))
			return false;
		if (filmAffiches == null) {
			if (other.filmAffiches != null)
				return false;
		} else if (!filmAffiches.equals(other.filmAffiches))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (realisateur == null) {
			if (other.realisateur != null)
				return false;
		} else if (!realisateur.equals(other.realisateur))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
}
