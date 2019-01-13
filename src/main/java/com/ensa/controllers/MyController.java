package com.ensa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.dao.AfficheDao;
import com.ensa.dao.FilmAfficheDao;
import com.ensa.dao.FilmDao;
import com.ensa.dao.ReservationDao;
import com.ensa.entities.Affiche;
import com.ensa.entities.Film;

//@CrossOrigin(origins = "http://192.168.1.42:4200", maxAge = 3600) 
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class MyController {

	@Autowired
	FilmDao filmDao;
	
	@Autowired
	AfficheDao afficheDao;
	
	@Autowired
	FilmAfficheDao filmAfficheDao;
	
	@Autowired
	ReservationDao reservationDao;
	
	@GetMapping("/gets")
	public String getS() {		
		return "YES! Hello CY15 :)";
	}
	
	@GetMapping("/getFilms")
	public List<Film> getFilms() {		
		return filmDao.findAll();
	}
	
	@GetMapping("/getAffiches")
	public List<Affiche> getAffiches() {		
		return afficheDao.findAll();
	}
	
	@GetMapping("/getAffiche")
	public Affiche getAffiche() {		
		return afficheDao.findById(1L).orElse(null);
	}
	
}
