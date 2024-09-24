package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.*;
//import tn.esprit.spring.services.*;
//import tn.esprit.spring.services.*;
import tn.esprit.spring.services.*;
import tn.esprit.spring.repositories.*;

import java.util.List;

@RestController
@RequestMapping("/SkieurC")
public class SkieurController {
    @Autowired
    ISkieurService ss;
    @GetMapping("/")
    public String sayHello() {
        return "Hello";
    }
    @PostMapping("/addSkieur")
    @ResponseBody
    public void addSkieur(@RequestBody Skieur p) {
        ss.ajouter_skieur(p);
    }
    @PutMapping("/updateSkieur")
    @ResponseBody
    public void updateSkieur(@RequestBody Skieur p){
        ss.updateSkieur(p);
    }
    @GetMapping("/pisteid")
    @RequestMapping("/{ID}")
    public Skieur pistebyid(@PathVariable(value="ID") Long id){
        System.out.println(id);
        return ss.retrieveSkieur(id);
    }
    @GetMapping("/removeSkieur/{id}")
    public void removeSkieur (@PathVariable(value = "id") Long id){ ss.removeSkieur(id);}

    @PostMapping("/assignSkierToPiste/{numSkieur}/{numPiste}")
    public void assignRegistrationToCourse(@PathVariable Long numSkieur, @PathVariable Long numPiste) {
        ss.assignSkierToPiste(numSkieur,numPiste);
    }
    @PostMapping("/addSkierAndAssignToCourse/{ID}")
    @ResponseBody
    public void addinscri(@RequestBody Skieur p,@PathVariable(value="ID") Long id) {
        ss.addSkierAndAssignToCourse(p,id);
    }
    @GetMapping("/SkieurByAbonnement/{typeabo}")
    public List<Skieur> SkieurByAbonnement(@PathVariable(value = "typeabo") TypeAbonnement typeabo){return ss.retrieveSkiersBySubscriptionType(typeabo); }

}
