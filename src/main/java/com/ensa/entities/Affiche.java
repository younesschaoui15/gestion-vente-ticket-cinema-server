package com.ensa.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Affiche {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date date;
	
	@JsonManagedReference
	@OneToMany (mappedBy="pk.affiche")
	private List<Film_Affiche> filmAffiches = new ArrayList<>();
	
	public Affiche() {
		super();
	}

	public Affiche(Date date) {
		super();
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Film_Affiche> getFilmAffiche() {
		return filmAffiches;
	}

	public void setFilmAffiche(List<Film_Affiche> filmAffiche) {
		this.filmAffiches = filmAffiche;
	}
	
	
	
	
	
	
}
