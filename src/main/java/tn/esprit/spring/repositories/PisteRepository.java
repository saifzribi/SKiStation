package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Couleur;
import tn.esprit.spring.entity.Cours;
import tn.esprit.spring.entity.Piste;
import tn.esprit.spring.entity.Skieur;

import java.util.List;
import java.util.Set;

@Repository
public interface PisteRepository extends JpaRepository<Piste,Long> {
//    List<Piste> findByCouleur(Couleur couleur);
//    List<Piste> findByLongeur(int longeur);
//    List<Piste> findByPerte(int perte);
//    List<Piste> findBySkieur(Set<Skieur> skieur);
//    List<Piste> findByCouleurAndLongeur(Couleur couleur,int longeur);
//    List<Piste> findByCouleurAndPerte(Couleur couleur,int perte);
//    List<Piste> findByCouleurAndLongeurAndPerte(Couleur couleur,int longeur,int perte);
//
//    @Query("SELECT p FROM Piste p WHERE p.longueur =: longeur")
//    List<Piste> findPisteByLongeur(@Param("longeur") int longeur);
//    @Query("SELECT p FROM Piste p WHERE p.longueur >=: longeur AND p.pente <= :pente")
//    List<Piste> findPisteByLongeurAndPerte(@Param("longeur") int longeur,@Param("pente") int pente);
//    @Query("SELECT p FROM Piste p WHERE p.numPiste =: id")
//    Piste findByNumPiste(@Param("id") Long id);
}
