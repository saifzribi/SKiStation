package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.*;

import java.util.List;

@Repository
public interface CoursRepository extends JpaRepository<Cours,Long> {


//    List<Cours> findByniveau(int niveau);
//    List<Cours> findbyType(typeCours typecours);
//    List<Cours> findByPrixCours(Float prix);
//    @Query("SELECT a FROM Cours a WHERE a.prix <=: prix AND a.typecours =: type")
//    List<Abonnement> findCoursByPrixAndType(@Param("prix") Float prix, @Param("typecours") typeCours type);
//@Query("SELECT c FROM Cours c WHERE c..id = :instructeurId AND c.support = :support")
//List<Cours> findByInstructorAndSupport(@Param("instructeurId") Long instructeurId, @Param("support") Support support);



}
