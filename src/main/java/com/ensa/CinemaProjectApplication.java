package com.ensa;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.controllers.MyController;
import com.ensa.dao.AfficheDao;
import com.ensa.dao.FilmAfficheDao;
import com.ensa.dao.FilmDao;
import com.ensa.dao.ReservationDao;
import com.ensa.entities.Affiche;
import com.ensa.entities.Film;
import com.ensa.entities.Film_Affiche;
import com.ensa.entities.Reservation;

@Transactional
@SpringBootApplication
public class CinemaProjectApplication implements CommandLineRunner{

	@Autowired
	FilmDao filmDao;
	
	@Autowired
	AfficheDao afficheDao;
	
	@Autowired
	FilmAfficheDao filmAfficheDao;
	
	@Autowired
	ReservationDao reservationDao;
	
	public static void main(String[] args) {
		SpringApplication.run(CinemaProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Film f1 = filmDao.save(new Film("The Vow", "Drama", "Chris Towner", "Alex Brand"));
//		Film f2 = filmDao.save(new Film("The fault in our stars", "Romance", "Thomas Alison", "Steve Grab"));
//		Film f3 = filmDao.save(new Film("Bienvenue Au France", "Comedy", "Jeremy Papin", "Omar Rhowany"));
		
		afficheDao.save(new Affiche(new Date()));
		
		Affiche affiche1 = afficheDao.getOne(1L);
		
		Film_Affiche fa1 = filmAfficheDao.save(new Film_Affiche(f1, affiche1, LocalTime.parse("09:15") , "S1", 120.0, 33));
//		Film_Affiche fa2 = filmAfficheDao.save(new Film_Affiche(f2, affiche1, LocalTime.parse("11:15") , "S44", 135.0, 24));
//		Film_Affiche fa3 = filmAfficheDao.save(new Film_Affiche(f3, affiche1, LocalTime.parse("14:30") , "S23", 75.0, 45));
		
//		affiche1.getFilmAffiche().add(fa1);
//		affiche1.getFilmAffiche().add(fa2);
//		affiche1.getFilmAffiche().add(fa3);
//		
//		 Affiche fh =    afficheDao.getOne(1L);
//		 System.err.println(fh.getFilmAffiche().size()+"ffff");
		
		reservationDao.save(new Reservation("Benbaha", "Osama", "BO3333",fa1));
		reservationDao.save(new Reservation("Chaoui", "Youness", "CY1515",fa1));
		reservationDao.save(new Reservation("Safa7", "Taroudant", "ST2457",fa1));
	
	
	List<Film> films= filmDao.findAllByFilmAffichesPkAffiche(affiche1);
//		List<Film> films= new ArrayList<>() ;
		
//		for(int i=0;i<ff.size();i++) {
//			films.add(ff.get(i).getPk().getFilm());
//		}
		
		for(Film f : films)
			 System.err.println(f.getTitre()+"--"+f.getGenre());
		
		List<Reservation> reservs = reservationDao.findAllByFilmAffiche(fa1);
		for(Reservation r : reservs)
			 System.err.println(r.getNomClient()+"--"+r.getPrenomClient()+"--"+r.getNumCarte());
		
//		MyController mc = new MyController();
//		System.out.println(mc.getAffiches().size());
		
		
	}
}
