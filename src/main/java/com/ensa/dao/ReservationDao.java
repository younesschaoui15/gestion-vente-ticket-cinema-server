package com.ensa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Film_Affiche;
import com.ensa.entities.Reservation;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Long>{

	List<Reservation> findAllByFilmAffiche(Film_Affiche fa);
}
