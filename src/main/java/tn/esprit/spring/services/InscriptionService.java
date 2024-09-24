package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Cours;
import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.entity.Skieur;
import tn.esprit.spring.entity.typeCours;
import tn.esprit.spring.repositories.CoursRepository;
import tn.esprit.spring.repositories.InscriptionRepository;
import tn.esprit.spring.repositories.SkieurRepository;

@Service
@Slf4j
public class InscriptionService implements IInscriptionService{
    @Autowired
    SkieurRepository SkieurRepo;
    @Autowired
    InscriptionRepository InsRep;
    @Autowired
    CoursRepository CourRep;
    @Override
    public Inscription addRegistrationAndAssignToSkier(Inscription registration, Long numSkier) {
        Skieur skier = SkieurRepo.findById(numSkier).orElse(null);
        registration.setSkieur(skier);
        return InsRep.save(registration);
    }

    @Override
    public Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse) {

        Inscription registration = InsRep.findById(numRegistration).orElse(null);

        Cours course = CourRep.findById(numCourse).orElse(null);

        registration.setCour(course);

        return InsRep.save(registration);
    }
    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
        Skieur skieur=SkieurRepo.findById(numSkieur).orElse(null);
        Cours cours=CourRep.findById(numCours).orElse(null);
        inscription.setCour(cours);
        inscription.setSkieur(skieur);
        if(cours.getTypecours()== typeCours.Collectif_Adule || cours.getTypecours()== typeCours.Collectif_Enfant)
        {
            if(cours.getInscriptions().size()<6){
                return InsRep.save(inscription);
            }else{
                return null;
            }
        }else{
            return InsRep.save(inscription);
        }
    }
}
