package tn.esprit.spring.services;

import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IAbonnementService {
    List<Abonnement> retrieveAllAbonnements();

    Abonnement addAbonnement(Abonnement abonnement);

    Abonnement updateAbonnement(Abonnement abonnement);

    Abonnement retrieveAbonnement(Long numAbo);

    Set<Abonnement> getSubscriptionByType(TypeAbonnement type);

    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);

    @Scheduled(cron = "0 0 0 * * ?")
    void retrieveSubscriptions();

    @Scheduled(cron = "0 0 0 1 * ?")
    void showMonthlyRecurringRevenue();
}
