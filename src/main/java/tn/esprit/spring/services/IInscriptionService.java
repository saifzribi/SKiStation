package tn.esprit.spring.services;

import tn.esprit.spring.entity.Inscription;

public interface IInscriptionService {
    Inscription addRegistrationAndAssignToSkier(Inscription registration, Long numSkier);

    Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse);

    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);
}
