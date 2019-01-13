package com.ensa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Affiche;
import com.ensa.entities.Film;
import com.ensa.entities.Film_Affiche;
import com.ensa.entities.Film_Affiche_PK;
import com.ensa.entities.Reservation;

@Repository
public interface FilmAfficheDao extends JpaRepository<Film_Affiche, Film_Affiche_PK>{

	List<Film> findPkFilmByPkAffiche(Affiche a);
	List<Film_Affiche> findAllByPkAffiche(Affiche a);
	List<Film_Affiche> findAllByPkFilm(Film f);
	List<Film_Affiche> findAllByReservations(Reservation r);
}
