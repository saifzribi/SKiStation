package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Skieur;
import tn.esprit.spring.entity.TypeAbonnement;
import tn.esprit.spring.repositories.AbonnementRepository;
import tn.esprit.spring.repositories.SkieurRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

    @Service
    @Slf4j
public class AbonnementService implements IAbonnementService{
    @Autowired
    AbonnementRepository aboRepo;
    @Autowired
    SkieurRepository skieurRepo;
    @Override
    public List<Abonnement> retrieveAllAbonnements() {
        return aboRepo.findAll();
    }

    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        aboRepo.save(abonnement);
        log.info("Abonnement ajouté");
        return abonnement;
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        aboRepo.save(abonnement);
        log.info("Abonnement modifié");
        return abonnement;
    }

    @Override
    public Abonnement retrieveAbonnement(Long numAbo) {
        return aboRepo.findById(numAbo).orElse(null);
    }

    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        Set<Abonnement> abos= aboRepo.findByTypeAbonnement(type);
        Set<Abonnement>result=abos.stream().sorted((a,b)->a.getDate_debut().compareTo(b.getDate_fin())).collect(Collectors.toSet());
        return result;
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        if(startDate.isAfter(endDate)){
            System.out.println("La date de debut doit etre superieure a la date de fin ");
        }
        List<Abonnement> abos=aboRepo.findAll();
        List<Abonnement> abonnementsFiltres = new ArrayList<>();
        for (Abonnement abonnement : abos) {
            if (abonnement.getDate_debut().after(Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                    && abonnement.getDate_fin().before(Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
                abonnementsFiltres.add(abonnement);
            }
        }

        return abonnementsFiltres;
    }
    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void retrieveSubscriptions() {
        List<Skieur> skieurs= skieurRepo.findByStartDateBetween(LocalDate.now(),LocalDate.now().plusDays(7));
        //List<Abonnement> abonnementExpires= aboRepo.findByStartDateBetween(LocalDate.now(),LocalDate.now().plusDays(7));
        if(skieurs.size()==0){
            System.out.println("Aucun abonnement est arrivé a son écheance");
        }else{
            for(Skieur s:skieurs){
                System.out.println("ID de l'abonnement : "+ s.getAbonnement().getNum_abon());
                System.out.println("ID du Skieur : "+ s.getNumSkieur());
                System.out.println("Nom du Skieur : "+ s.getNomS());
                System.out.println("Prenom du Skieur : "+ s.getPrenomS());
            }
        }
    }

    @Scheduled(cron = "0 0 0 1 * ?")
    @Override
    public void showMonthlyRecurringRevenue() {
        int currentMonth = LocalDate.now().getMonthValue();
        int currentYear = LocalDate.now().getYear();
        double totalMRR = 0;
        List<Abonnement> abonnementValides=aboRepo.findByStartDateAfter(LocalDate.of(currentYear,currentMonth,1));
        for(Abonnement a:abonnementValides){
            if(a.getTypeAbonnement()==TypeAbonnement.Mensuel){
                totalMRR += a.getPrixAbon();
            } else if (a.getTypeAbonnement()==TypeAbonnement.Semestriel) {
                totalMRR += a.getPrixAbon()/2;
            }else {
                totalMRR += a.getPrixAbon()/12;
            }
        }
        System.out.println("Le MRR du mois "+currentMonth+"/"+currentYear+" est : "+totalMRR);
    }


}