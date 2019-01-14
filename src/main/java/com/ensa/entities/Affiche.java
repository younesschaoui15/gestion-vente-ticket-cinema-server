package com.ensa.entities;

import java.util.ArrayList;
import java.util.Date;
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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
public class Affiche {

	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date date;
	
	
	//@JsonManagedReference /*il duplique les 'filmsAffiche'*/
	@OneToMany(mappedBy="pk.affiche")
	//@JoinColumn(name="pk.affiche")
	private List<Film_Affiche> filmAffiches = new ArrayList<Film_Affiche>();
	
	public Affiche() {
		super();
	}

	public Affiche(Date date) {
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

	public void setFilmAffiche(ArrayList<Film_Affiche> filmAffiche) {
		this.filmAffiches = filmAffiche;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((filmAffiches == null) ? 0 : filmAffiches.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Affiche other = (Affiche) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (filmAffiches == null) {
			if (other.filmAffiches != null)
				return false;
		} else if (!filmAffiches.equals(other.filmAffiches))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
