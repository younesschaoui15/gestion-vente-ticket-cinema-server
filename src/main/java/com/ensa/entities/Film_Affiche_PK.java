package com.ensa.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Embeddable
public class Film_Affiche_PK implements Serializable{

	private static final long serialVersionUID = 1L;

	//@JsonBackReference
	@ManyToOne //(fetch=FetchType.LAZY)
	@JoinColumn(name="film")
	private Film film;
	
	@JsonBackReference
	@ManyToOne //(fetch=FetchType.LAZY)
	@JoinColumn(name="affiche")
	private Affiche affiche;

	public Film_Affiche_PK() {	}

	public Film_Affiche_PK(Film film, Affiche affiche) {
		this.film = film;
		this.affiche = affiche;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Affiche getAffiche() {
		return affiche;
	}

	public void setAffiche(Affiche affiche) {
		this.affiche = affiche;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((affiche == null) ? 0 : affiche.hashCode());
		result = prime * result + ((film == null) ? 0 : film.hashCode());
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
		Film_Affiche_PK other = (Film_Affiche_PK) obj;
		if (affiche == null) {
			if (other.affiche != null)
				return false;
		} else if (!affiche.equals(other.affiche))
			return false;
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film))
			return false;
		return true;
	}

	
}
