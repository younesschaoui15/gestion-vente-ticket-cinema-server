package com.ensa.entities;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Film_Affiche {

	@Id
	private Film_Affiche_PK pk;
	private LocalTime horaire;
	private String salle;
	private Double prix;
	private int nbrPlaces;

	@OneToMany (mappedBy="filmAffiche")
	private Set<Reservation> reservations =new HashSet<>();
	
	public Film_Affiche() {
		super();
	}
	
	public Film_Affiche(Film film,Affiche affiche,LocalTime horaire, String salle, Double prix, int nbrPlaces) {
		super();
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

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
	
	
}
