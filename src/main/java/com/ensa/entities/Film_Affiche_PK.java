package com.ensa.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable
public class Film_Affiche_PK implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonBackReference
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="film")
	private Film film;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="affiche")
	private Affiche affiche;

	public Film_Affiche_PK() {
		super();
	}

	public Film_Affiche_PK(Film film, Affiche affiche) {
		super();
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
	
	
	
}
