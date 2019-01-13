package com.ensa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.ensa.dao.AfficheDao;
import com.ensa.dao.FilmAfficheDao;
import com.ensa.dao.FilmDao;
import com.ensa.dao.ReservationDao;
import com.ensa.entities.Affiche;
import com.ensa.entities.Film;

//@CrossOrigin(origins = "http://192.168.1.42:4200", maxAge = 3600) 
@CrossOrigin(origins = "*", maxAge = 3600,
methods= {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping(value="/api-ws")
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
	
	@GetMapping("/films")
	public List<Film> getFilms() {		
		return filmDao.findAll();
	}
	
	@GetMapping("/affiches")
	public List<Affiche> getAffiches() {		
		return afficheDao.findAll();
	}
	
	@GetMapping("/affiches/{id}")
	public Affiche getAffiche(@PathVariable long id) {		
		return afficheDao.findById(id).orElse(null);
	}
	
	@GetMapping("/films/{id}")
	public Affiche getFilm(@PathVariable long id) {		
		return afficheDao.findById(id).orElse(null);
	}
	
}
