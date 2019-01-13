package com.ensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Affiche;

@Repository
public interface AfficheDao extends JpaRepository<Affiche, Long>{

}
