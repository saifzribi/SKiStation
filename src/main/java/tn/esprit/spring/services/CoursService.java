package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Cours;
import tn.esprit.spring.repositories.CoursRepository;

import java.util.List;

@Service
@Slf4j
public class CoursService implements ICoursService{
    @Autowired
    CoursRepository coursrepo;
    @Override
    public List<Cours> retrieveAllCours() {
        return coursrepo.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        coursrepo.save(cours);
        log.info("Cours ajouté");
        return cours;
    }

    @Override
    public Cours updateCours(Cours cours) {
        coursrepo.save(cours);
        log.info("Cours modifié");
        return cours;
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return coursrepo.findById(numCours).orElse(null);
    }
}