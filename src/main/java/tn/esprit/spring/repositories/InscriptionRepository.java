package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Cours;
import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.entity.Skieur;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
//    List<Inscription> findBySkieur(Skieur skieur);
//    List<Inscription> findByCours(Cours cours);
//    List<Inscription> findByNumSemaine(int numsemaine);
//
//    @Query("SELECT i FROM Inscription i WHERE i.skieur =: skieur AND i.numSemaine =: numsem")
//    List<Inscription> findInscriptionBySkieurAndNumSemaine(@Param("skieur") Skieur skieur, @Param("numsem") int numsem);
//    @Query("SELECT i FROM Inscription i WHERE i.numInscription =: numinsc")
//    Inscription findInscriptionByNumInscription(@Param("numinsc") Long numinsc);
}
