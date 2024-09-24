package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Cours;
import tn.esprit.spring.entity.TypeAbonnement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
//    List<Abonnement> findByDateDebut(Date date_debut);
//    List<Abonnement> findByDateFin(Date date_fin);
//    List<Abonnement> findByPrixAbo(Float prixAbon);
    @Query("SELECT a FROM Abonnement a WHERE a.TypeAbonnement =:type")
    Set<Abonnement> findByTypeAbonnement(@Param("type") TypeAbonnement typeAbonnement);
    @Query("SELECT a FROM Abonnement a WHERE a.date_debut > :startDate")
    List<Abonnement> findByStartDateAfter(@Param("startDate") LocalDate startDate);

//    List<Abonnement> findByDateFinAndDateFin(Date date_debut,Date date_fin);
//    List<Abonnement> findByPrixAboAndTypeAbon(Float prixAbon,TypeAbonnement typeAbonnement);
//    List<Abonnement> findByPrixAboAndTypeAbonAndDateDebut(Float prixAbon,TypeAbonnement typeAbonnement,Date date_debut);
//    @Query("SELECT a FROM Abonnement a WHERE a.date_debut =: datedeb")
//    List<Abonnement> findAbonnementByDateDebut(@Param("datedeb") Date datedeb);
//    @Query("SELECT a FROM Abonnement a WHERE a.prixAbon <=: prix AND a.TypeAbonnement =: type")
//    List<Abonnement> findAbonnementByPrixAboAndTypeAbon(@Param("prix") Float prix, @Param("type") TypeAbonnement type);
}
