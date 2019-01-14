package com.ensa.entities;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Film_Affiche implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Film_Affiche_PK pk;
	private LocalTime horaire;
	private String salle;
	private Double prix;
	private int nbrPlaces;

	//@JsonManagedReference
	@OneToMany (mappedBy="filmAffiche")
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	public Film_Affiche() {	}
	
	public Film_Affiche(Film film,Affiche affiche,LocalTime horaire, String salle, Double prix, int nbrPlaces) {
		this.pk = new Film_Affiche_PK(film, affiche);
		this.horaire=horaire;
		this.salle = salle;
		this.prix = prix;
		this.nbrPlaces = nbrPlaces;
	}

	public Film_Affiche_PK getPk() {
		return pk;
	}

	public void setPk(Film_Affiche_PK pk) {
		this.pk = pk;
	}
	
	public LocalTime getHoraire() {
		return horaire;
	}

	public void setHoraire(LocalTime horaire) {
		this.horaire = horaire;
	}

	public String getSalle() {
		return salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public int getNbrPlaces() {
		return nbrPlaces;
	}

	public void setNbrPlaces(int nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horaire == null) ? 0 : horaire.hashCode());
		result = prime * result + nbrPlaces;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + ((prix == null) ? 0 : prix.hashCode());
		result = prime * result + ((reservations == null) ? 0 : reservations.hashCode());
		result = prime * result + ((salle == null) ? 0 : salle.hashCode());
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
		Film_Affiche other = (Film_Affiche) obj;
		if (horaire == null) {
			if (other.horaire != null)
				return false;
		} else if (!horaire.equals(other.horaire))
			return false;
		if (nbrPlaces != other.nbrPlaces)
			return false;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (prix == null) {
			if (other.prix != null)
				return false;
		} else if (!prix.equals(other.prix))
			return false;
		if (reservations == null) {
			if (other.reservations != null)
				return false;
		} else if (!reservations.equals(other.reservations))
			return false;
		if (salle == null) {
			if (other.salle != null)
				return false;
		} else if (!salle.equals(other.salle))
			return false;
		return true;
	}
}
