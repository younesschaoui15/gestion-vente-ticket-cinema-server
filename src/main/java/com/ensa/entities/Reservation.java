package com.ensa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nomClient,prenomClient,numCarte;
	
	@JsonBackReference
	@ManyToOne
	//@JoinColumn(name="film_Affiche_Code")
	@JoinColumns({
		  @JoinColumn(name = "film"),
		  @JoinColumn(name = "affiche")
		})
	private Film_Affiche filmAffiche;
	
	
	public Reservation() {	}
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmAffiche == null) ? 0 : filmAffiche.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomClient == null) ? 0 : nomClient.hashCode());
		result = prime * result + ((numCarte == null) ? 0 : numCarte.hashCode());
		result = prime * result + ((prenomClient == null) ? 0 : prenomClient.hashCode());
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
		Reservation other = (Reservation) obj;
		if (filmAffiche == null) {
			if (other.filmAffiche != null)
				return false;
		} else if (!filmAffiche.equals(other.filmAffiche))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomClient == null) {
			if (other.nomClient != null)
				return false;
		} else if (!nomClient.equals(other.nomClient))
			return false;
		if (numCarte == null) {
			if (other.numCarte != null)
				return false;
		} else if (!numCarte.equals(other.numCarte))
			return false;
		if (prenomClient == null) {
			if (other.prenomClient != null)
				return false;
		} else if (!prenomClient.equals(other.prenomClient))
			return false;
		return true;
	}
	
}
