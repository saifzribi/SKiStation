package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Cours;
import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.entity.Moniteur;
import tn.esprit.spring.entity.Support;
import tn.esprit.spring.repositories.CoursRepository;
import tn.esprit.spring.repositories.MoniteurRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class MoniteurService implements IMoniteurService{
    @Autowired
    MoniteurRepository moniteurRepo;
    @Autowired
    CoursRepository courRep;
    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepo.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        moniteurRepo.save(moniteur);
        log.info("Moniteur ajouté");
        return moniteur;
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        if(moniteurRepo.findById(moniteur.getNumMoniteur()).orElse(null)!=null) {
            moniteurRepo.save(moniteur);
            log.info("Moniteur modifié");
            return moniteur;
        }
        log.info("Moniteur inexistant");
        return null;
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepo.findById(numMoniteur).orElse(null);
    }
    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Cours cour = courRep.findById(numCourse).orElse(null);
        moniteur.getCours().add(cour);
        return moniteurRepo.save(moniteur);
    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {


        Moniteur instructor = moniteurRepo.findById(numInstructor).orElseThrow();

        Set<Cours> courses = instructor.getCours();
        List<Cours> cours = new ArrayList<>();
        List<Integer> numWeek = new ArrayList<>();
        for(Cours c:courses){
            if(c.getSupport()==support){
                cours.add(c);
            }
        }
        for(Cours c:cours){
            for(Inscription i:c.getInscriptions()){
                numWeek.add(i.getNumSemaine());
            }
        }
        return numWeek;

    }
}
