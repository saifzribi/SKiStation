package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Cours;
import tn.esprit.spring.entity.Moniteur;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface MoniteurRepository extends JpaRepository<Moniteur,Long> {
//    List<Moniteur> findByNomM(String nom);
//    List<Moniteur> findByPrenomM(String prenom);
//    List<Moniteur> findByDateRecru(Date daterec);
//    List<Moniteur> findByPrenomMAndDateRecru(String prenom, Date daterec);
//    List<Moniteur> findByCours(Set<Cours> cours);
//    List<Moniteur> findByCoursAndDateRecru(Set<Cours> cours, Date daterec);
//    List<Moniteur> findByCoursAndPrenomMAndNomM(Set<Cours> cours, String prenom, String nom);
//
//    @Query("SELECT m FROM Moniteur m WHERE m.nomM =: nom AND m.prenomM =: prenom")
//    List<Moniteur> findMoniteurByNomMAndPrenomM(@Param("nom") String nom, @Param("prenom") String prenom);
//    @Query("SELECT m FROM Moniteur m WHERE m.numMoniteur =: numMon")
//    Moniteur findMoniteurByNumMoniteur(@Param("numMon") Long numMon);
}
