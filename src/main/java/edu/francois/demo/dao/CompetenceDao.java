package edu.francois.demo.dao;

import edu.francois.demo.model.Competence;
import edu.francois.demo.model.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceDao extends JpaRepository<Competence, Integer>
{



}
