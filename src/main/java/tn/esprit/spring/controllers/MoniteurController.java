package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.entity.Moniteur;
import tn.esprit.spring.entity.Support;
import tn.esprit.spring.services.IMoniteurService;

import java.util.List;

@RestController
@RequestMapping("/MoniteurC")
public class MoniteurController {
    @Autowired
    IMoniteurService ms;
    @GetMapping("/")
    public String sayHello(){ return "Hello"; }
    @PostMapping("/addMoniteur")
    @ResponseBody
    public void addMoniteur(@RequestBody Moniteur m){ ms.addMoniteur(m); }
    @GetMapping("/allMoniteur")
    public List<Moniteur> allMoniteur(){ return ms.retrieveAllMoniteurs(); }
    @PutMapping("/updateMoniteur")
    @ResponseBody
    public void updateMoniteur (@RequestBody Moniteur m){ ms.updateMoniteur(m);}
    @GetMapping("/MoniteurbyId/{id}")
    public Moniteur MoniteurbyId(@PathVariable(value = "id") Long id){ return ms.retrieveMoniteur(id); }
    @PostMapping("/addInstructorAndAssignToCourse/{ID}")
    @ResponseBody
    public void addinscri(@RequestBody Moniteur p, @PathVariable(value="ID") Long id) {
        ms.addInstructorAndAssignToCourse(p,id);
    }
    @GetMapping("/numWeek/{NumMoniteur}/{support}")
    public List<Integer> numWeek(@PathVariable(value = "NumMoniteur") Long numInstructor,@PathVariable(value = "support") Support support)
    {
        return ms.numWeeksCourseOfInstructorBySupport(numInstructor,support);
    }

}
