package com.ensa.controllers;

import java.time.LocalTime;
import java.util.Date;
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
import com.ensa.entities.Film_Affiche;
import com.ensa.entities.Film_Affiche_PK;
import com.ensa.entities.Reservation;

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
	public Film getFilm(@PathVariable long id) {		
		return filmDao.findById(id).orElse(null);
	}
	
	@GetMapping("/filmAffiche/{idf}/{ida}")
	public Film_Affiche getFilmAffiche(@PathVariable long idf, @PathVariable long ida) 
	{
		Film f = filmDao.findById(idf).orElse(null);
		Affiche a = afficheDao.findById(ida).orElse(null);
		return filmAfficheDao.findByPk(new Film_Affiche_PK(f, a));
	}
	
//	@PostMapping("/reserver/{id}")
//	public boolean reserver(@RequestParam String nomC ,@RequestParam String prenomC
//								 ,@RequestParam String numC,@PathVariable long id) {	
//		
//		  Reservation reservation = reservationDao.findById(id).orElse(null);
//		  int nbrPlace = reservation.getFilmAffiche().getNbrPlaces();
//		  if(reservation != null && nbrPlace>0) {
//			  reservation.getFilmAffiche().setNbrPlaces(nbrPlace-1)  ;
//			  return true;
//		  }
//		  
//		return false ;
//	}
	
	@PostMapping("/addFilm")
	public boolean AddFilm(@RequestParam String titre ,@RequestParam String genre
								 ,@RequestParam String acteur,@RequestParam String realisateur) {	
		
		  Film film = new Film(titre, genre, acteur, realisateur);
		  filmDao.save(film);
		  
		return true ;
	}
	
	@PostMapping("/addAffiche")
	public boolean addAffiche(@RequestParam Date date ) {	
		
		  Affiche affiche = new Affiche(date);
		  afficheDao.save(affiche);
		  
		return true ;
	}
	
	@PostMapping("/affecterFilmToAffiche")
	public boolean affecterFilmToAffiche(@RequestParam long idF,@RequestParam long idA,
										 @RequestParam LocalTime horaire,@RequestParam String salle,
										 @RequestParam double prix,@RequestParam int nbrPlaces) {	
		
		  Affiche affiche = afficheDao.findById(idA).orElse(null);
		  Film film = filmDao.findById(idF).orElse(null);
		  filmAfficheDao.save(new Film_Affiche(film, affiche, horaire, salle, prix, nbrPlaces));
		  
		return true ;
	}
	
	@PostMapping("/deleteFilm/{title}")
	public boolean deleteFilm(@PathVariable String titre ) {	
		List<Film> lf = filmDao.findAllByTitre(titre);
		if (lf!=null) {
			for(Film f : lf)
				filmDao.delete(f);
			return true;
		}		  
		return false ;
	}
	
	@GetMapping("/reserverPlace/{idf}/{ida}")
	public boolean reserverPlace(@PathVariable long idf, @PathVariable long ida)
	{
		Film f = filmDao.findById(idf).orElse(null);
		Affiche a = afficheDao.findById(ida).orElse(null);
		Film_Affiche fa = filmAfficheDao.findByPk(new Film_Affiche_PK(f,a));
		if(fa != null && fa.getNbrPlaces()>0) 
		{
			  Reservation reservation = new Reservation();
			  fa.setNbrPlaces(fa.getNbrPlaces()-1)  ;
			  reservation.setFilmAffiche(fa);
			  fa.getReservations().add(reservation);
			  reservationDao.save(reservation);
			  filmAfficheDao.save(fa);
			  return true;
		  }
		return false ;
	}
	
//	@PostMapping("/reserverPlace")
//	public boolean reserverPlace(@RequestParam long idf, @RequestParam long ida)
//	{
//		Film f = filmDao.findById(idf).orElse(null);
//		Affiche a = afficheDao.findById(ida).orElse(null);
//		Film_Affiche fa = filmAfficheDao.findByPk(new Film_Affiche_PK(f,a));
//		if(fa != null && fa.getNbrPlaces()>0) 
//		{
//			  Reservation reservation = new Reservation();
//			  fa.setNbrPlaces(fa.getNbrPlaces()-1)  ;
//			  reservation.setFilmAffiche(fa);
//			  fa.getReservations().add(reservation);
//			  reservationDao.save(reservation);
//			  filmAfficheDao.save(fa);
//			  return true;
//		  }
//		return false ;
//	}
}
