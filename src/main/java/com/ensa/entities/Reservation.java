package com.ensa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nomClient,prenomClient,numCarte;
	
	@ManyToOne
	//@JoinColumn(name="film_Affiche_Code")
	@JoinColumns({
		  @JoinColumn(name = "film"),
		  @JoinColumn(name = "affiche")
		})
	private Film_Affiche filmAffiche;
	
	
	public Reservation() {
		super();
	}
	public Reservation(String nomClient, String prenomClient, String numCarte) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.numCarte = numCarte;
	}
	
	public Reservation(String nomClient, String prenomClient, String numCarte, Film_Affiche filmAffiche) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.numCarte = numCarte;
		this.filmAffiche = filmAffiche;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getNumCarte() {
		return numCarte;
	}
	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}
	public Film_Affiche getFilmAffiche() {
		return filmAffiche;
	}
	public void setFilmAffiche(Film_Affiche filmAffiche) {
		this.filmAffiche = filmAffiche;
	}
	
	
	
}
