package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.services.IInscriptionService;

@RestController
@RequestMapping("/Inscription")
public class InscriptionController {
    @Autowired
    IInscriptionService ss;
    @PostMapping("/addInscription/{ID}")
    @ResponseBody
    public void addinscri(@RequestBody Inscription p,@PathVariable(value="ID") Long id) {
        ss.addRegistrationAndAssignToSkier(p,id);
    }

    @PostMapping("/assignRegistrationToCourse/{numRegistration}/{numCourse}")
    public void assignRegistrationToCourse(@PathVariable Long numRegistration, @PathVariable Long numCourse) {
        ss.assignRegistrationToCourse(numRegistration,numCourse);
    }

    @PostMapping("/addRegistrationAndAssignToSkierAndCourse/{numSkieur}/{numCours}")
    @ResponseBody
    public void addRegistrationAndAssignToSkierAndCourse(@RequestBody Inscription ins,@PathVariable(value="numSkieur") Long numSkieur,@PathVariable(value="numCours") Long numCours){
        ss.addRegistrationAndAssignToSkierAndCourse(ins,numSkieur,numCours);
    }

}
