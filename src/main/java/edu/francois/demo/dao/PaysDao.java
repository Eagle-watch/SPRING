package edu.francois.demo.dao;

import edu.francois.demo.model.Pays;
import edu.francois.demo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysDao extends JpaRepository<Pays, Integer>
{



}
