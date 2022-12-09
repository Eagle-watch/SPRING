package edu.francois.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import edu.francois.demo.view.VueCompetence;
import edu.francois.demo.view.VueUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter

public class Competence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({VueUtilisateur.class , VueCompetence.class})
    private Integer id;
    @JsonView({VueUtilisateur.class, VueCompetence.class})
    private String nom;
    @ManyToMany (mappedBy = "listeCompetence")
    @JsonView({VueCompetence.class})
    private Set<Utilisateur> listeUtilisateur = new HashSet<>();

}
