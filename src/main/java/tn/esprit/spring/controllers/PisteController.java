package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Piste;
//import tn.esprit.spring.services.IPisteService;
//import tn.esprit.spring.services.PisteService;
import tn.esprit.spring.services.*;
import tn.esprit.spring.repositories.*;

@RestController
@RequestMapping("/PisteC")
public class PisteController {
    @Autowired
    IPisteService ps;

    @GetMapping("/")
    public String sayHello() {
        return "Hello";
    }

    @PostMapping("/addPiste")
    @ResponseBody
    public void addPiste(@RequestBody Piste p) {
        ps.ajouter_piste(p);
    }


//    @PutMapping("/updatePiste{numPiste}")
//    public Piste updatePiste(@PathVariable("numPiste") Long numPiste, @RequestBody Piste piste){
//        return ps.updatePiste(numPiste, piste);
//    }


    @PutMapping("/updatepiste")
    @ResponseBody
    public void updatepiste(@RequestBody Piste p){
        ps.updatePiste(p);
    }

    @GetMapping("/pisteid")
    @RequestMapping("/{ID}")
    public Piste pistebyid(@PathVariable(value="ID") Long id){
        System.out.println(id);
        return ps.retrievePiste(id);
    }




}