package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface SkieurRepository extends JpaRepository<Skieur,Long> {
    @Query("SELECT s FROM Skieur s WHERE s.abonnement.TypeAbonnement =:typeAbo")
    List<Skieur> findSkieurByAbonnement_TypeAbonnement(@Param("typeAbo") TypeAbonnement typeAbo);
    @Query("SELECT s FROM Skieur s WHERE s.abonnement.date_debut BETWEEN :startDate AND :endDate")
    List<Skieur> findByStartDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate")LocalDate endDate);


//    List<Skieur> findByNomS(String nom);
//    List<Skieur> findByPrenomS(String prenom);
//    List<Skieur> findByDateNaissance(Date dateNaissance);
//    List<Skieur> findByVille(String ville);
//    List<Skieur> findByPistes(Set<Piste> pistes);
//    List<Skieur> findByAbonnement(Abonnement abonnement);
//    List<Skieur> findByInscriptions(Set<Inscription> inscriptions);
//    List<Skieur> findByInscriptionsAndAbonnement(Set<Inscription> inscriptions,Abonnement abonnement);
//    List<Skieur> findByPistesAndVille(Set<Piste> pistes,String ville);
//    List<Skieur> findByPistesAndAbonnement(Set<Piste> pistes,Abonnement abonnement);
//    List<Skieur> findByPistesAndInscriptions(Set<Piste> pistes, Set<Inscription> inscriptions);
//    List<Skieur> findByPistesAndVilleAndAbonnement(Set<Piste> pistes, String ville, Abonnement abonnement);
//    @Query("SELECT s FROM Skieur s WHERE s.nomS =: nom AND s.prenomS =: prenom")
//    List<Skieur> findSkieurByNomSAndPrenomS(@Param("nom") String nom, @Param("prenom") String prenom);
//    @Query("SELECT s FROM Skieur s WHERE s.dateNaissance =: dateN AND s.ville =: ville")
//    List<Skieur> findSkieurByDateNaissanceAndVille(@Param("dateN") Date dateN, @Param("ville") String ville);
//    @Query("SELECT s FROM Skieur s WHERE s.abonnement.TypeAbonnement =: typeAbo AND s.ville =: ville")
//    List<Skieur> findSkieurByAbonnement_TypeAbonAndVille(@Param("typeAbo") TypeAbonnement typeAbo, @Param("ville") String ville);
}
