package tn.esprit.spring.services;

import tn.esprit.spring.entity.Piste;

public interface IPisteService {
    public Long ajouter_piste(Piste p);
    Piste updatePiste ( Piste b);
    Piste retrievePiste (Long numPiste);
}
