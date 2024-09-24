package tn.esprit.spring.services;

import tn.esprit.spring.entity.Skieur;
import tn.esprit.spring.entity.TypeAbonnement;

import java.util.List;

public interface ISkieurService {
    Long ajouter_skieur(Skieur p);

    Skieur updateSkieur(Skieur skieur);
    Skieur retrieveSkieur (Long numSkieur);

    void removeSkieur(Long numSkieur);

    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);

    Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse);

    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
}
