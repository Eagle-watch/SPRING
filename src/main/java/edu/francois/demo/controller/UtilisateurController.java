package edu.francois.demo.controller;


import com.fasterxml.jackson.annotation.JsonView;
import edu.francois.demo.dao.UtilisateurDao;
import edu.francois.demo.model.Utilisateur;
import edu.francois.demo.view.VueUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UtilisateurController
{

    @Autowired
    private UtilisateurDao utilisateurDao;

    @GetMapping("/utilisateur/{id}")
    @JsonView(VueUtilisateur.class)
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable int id) {


        Optional<Utilisateur>utilisateurExistant = utilisateurDao.findById(id);
        if (utilisateurExistant.isPresent()){

            return new ResponseEntity<>(utilisateurExistant.get(), HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

        @GetMapping("/liste-utilisateurs")
        @JsonView(VueUtilisateur.class)
        public List<Utilisateur> getUtilisateur() {

            return utilisateurDao.findAll();
        }

        @PostMapping("/utilisateur")
        public ResponseEntity<Utilisateur> ajoutUtilisateurs(@RequestBody Utilisateur utilisateur){

        if (utilisateur.getId() != null) {

             Optional <Utilisateur> utilisateurExistant = utilisateurDao.findById(utilisateur.getId());

            if (utilisateurExistant.isPresent()) {

                utilisateurDao.save(utilisateur);
                return new ResponseEntity<>(utilisateur, HttpStatus.OK);

            } else {

                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            } else {
            utilisateurDao.save(utilisateur);
            return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
                }

        }

        @DeleteMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> supprimerUtilisateur(@PathVariable int id)
        {


        Optional<Utilisateur> utilisateurExistant = utilisateurDao.findById(id);

        if (utilisateurExistant.isPresent()){

            utilisateurDao.deleteById(id);
            return new ResponseEntity<>(utilisateurExistant.get(),HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }


        }

}
