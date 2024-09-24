package tn.esprit.spring.services;

import tn.esprit.spring.entity.Cours;

import java.util.List;

public interface ICoursService {
    List<Cours> retrieveAllCours();

    Cours addCours(Cours cours);

    Cours updateCours(Cours cours);

    Cours retrieveCours(Long numCours);
}
