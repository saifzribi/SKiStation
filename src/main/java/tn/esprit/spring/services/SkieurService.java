package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.repositories.*;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class SkieurService implements ISkieurService{
    @Autowired
    SkieurRepository SkieurRepo;
    @Autowired
    PisteRepository PisteRep;
    @Autowired
    AbonnementRepository Abre;
    @Autowired
    CoursRepository corp;
    @Autowired
    InscriptionRepository inrp;
    @Override
    public Long ajouter_skieur(Skieur p) {
        SkieurRepo.save(p);
        log.info("skieur ajoutée");
        return p.getNumSkieur();
    }

    @Override
    public  Skieur updateSkieur(Skieur skieur){
        if(SkieurRepo.findById(skieur.getNumSkieur()).orElse(null)!=null){
            SkieurRepo.save(skieur);
            log.info("piste mis a jour");
            return skieur;
        }
        log.info("Piste inexistante");
        return null;
    }

    public Skieur retrieveSkieur (Long numSkieur){
        return SkieurRepo.findById(numSkieur).orElse(null);
    }

    @Override
    public void removeSkieur(Long numSkieur) {
        Skieur skieur = SkieurRepo.findById(numSkieur).orElse(null);
        if (skieur == null){
            log.info("Skieur inexistant");
        }
        else {
            SkieurRepo.delete(skieur);
        }
    }
    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {

        Skieur skieur = SkieurRepo.findById(numSkieur).orElse(null);

        Piste piste = PisteRep.findById(numPiste).orElse(null);

        skieur.getPistes().add(piste);

        return SkieurRepo.save(skieur);
    }
    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse){
        Abre.save(skier.getAbonnement());
        Optional<Cours> cour = corp.findById(numCourse);
        Inscription i = new Inscription();
        i.setNumSemaine(LocalDate.now().get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
        i.setSkieur(skier);
        i.setCour(cour.get());
        SkieurRepo.save(skier);
        inrp.save(i);
        return skier;

    }
    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return SkieurRepo.findSkieurByAbonnement_TypeAbonnement(typeAbonnement);
    }

}
