package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.TypeAbonnement;
import tn.esprit.spring.services.IAbonnementService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/AbonnementC")
public class AbonnementController {
    @Autowired
    IAbonnementService as;

    @PostMapping("/addAbonnement")
    @ResponseBody
    public void addAbonnement(@RequestBody Abonnement a){ as.addAbonnement(a); }
    @GetMapping("/allAbonnement")
    public List<Abonnement> allAbonnement(){ return as.retrieveAllAbonnements(); }
    @PostMapping("/updateAbonnement")
    @ResponseBody
    public void updateAbonnement (@RequestBody Abonnement a){ as.updateAbonnement(a);}
    @GetMapping("/AbonnementbyId/{id}")
    public Abonnement AbonnementbyId(@PathVariable(value = "id") Long id){ return as.retrieveAbonnement(id); }

    @GetMapping("/AbonnementByType/{typeabo}")
    public void AbonnementByType(@PathVariable(value = "typeabo") TypeAbonnement typeabo){ as.getSubscriptionByType(typeabo); }

    @GetMapping("/by-dates")
    public ResponseEntity<List<Abonnement>> retrieveSubscriptionsByDates(
            @RequestParam(name = "start-date") LocalDate startDate,
            @RequestParam(name = "end-date") LocalDate endDate) {

        List<Abonnement> abonnements = as.retrieveSubscriptionsByDates(startDate, endDate);
        return ResponseEntity.ok(abonnements);
    }
}