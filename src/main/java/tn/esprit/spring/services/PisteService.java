package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Piste;
import tn.esprit.spring.repositories.PisteRepository;

@Service
@Slf4j
public class PisteService implements IPisteService {
    @Autowired
    PisteRepository PisteRepo;
    @Override
    public Long ajouter_piste(Piste p) {
        PisteRepo.save(p);
        log.info("piste ajoutée");
        return p.getNumPiste();
    }



    @Override
    public  Piste updatePiste(Piste piste){
        PisteRepo.save(piste);
        log.info("piste mis a jour");
        return piste;
    }
    public Piste retrievePiste (Long numPiste){
        return PisteRepo.findById(numPiste).orElse(null);
    }

}