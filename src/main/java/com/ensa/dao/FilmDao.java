package com.ensa.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Affiche;
import com.ensa.entities.Film;
import com.ensa.entities.Film_Affiche;

@Repository
public interface FilmDao extends JpaRepository<Film, Long>{

		List<Film> findAllByFilmAffichesPkAffiche(Affiche a);
		Film findByFilmAffiches(Film_Affiche fa);
}
