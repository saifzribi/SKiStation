package tn.esprit.spring.services;

import tn.esprit.spring.entity.Moniteur;
import tn.esprit.spring.entity.Support;

import java.util.List;

public interface IMoniteurService {
    List<Moniteur> retrieveAllMoniteurs();

    Moniteur addMoniteur(Moniteur moniteur);

    Moniteur updateMoniteur(Moniteur moniteur);

    Moniteur retrieveMoniteur(Long numMoniteur);

    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);

    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);
}
