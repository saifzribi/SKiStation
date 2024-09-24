
package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Cours;
import tn.esprit.spring.services.IAbonnementService;
import tn.esprit.spring.services.ICoursService;

import java.util.List;

@RestController
@RequestMapping("/CoursC")
public class CoursController {
    @Autowired
    ICoursService ics;
    @GetMapping("/")
    public String hello(){return "HELLO";}
    @PostMapping("/addcours")
    @ResponseBody
    public void addCours(@RequestBody Cours c){
        ics.addCours(c);
    }
    @GetMapping("/allcours")
    public List<Cours> afficherCours(){
        return ics.retrieveAllCours();
    }
    @PutMapping("/updatecours")
    @ResponseBody
    public void updateCours(@RequestBody Cours a){
        ics.updateCours(a);
    }
    @GetMapping("/coursid/{ID}")
    public Cours coursbyid(@PathVariable(value="ID") Long id){
        return ics.retrieveCours(id);
    }
}
