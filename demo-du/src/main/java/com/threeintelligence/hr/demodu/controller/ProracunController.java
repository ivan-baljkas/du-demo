package com.threeintelligence.hr.demodu.controller;

import com.threeintelligence.hr.demodu.model.Proracun;
import com.threeintelligence.hr.demodu.service.ProracunService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/proracuni")
public class ProracunController {

    private final ProracunService proracunService;

    public ProracunController(ProracunService proracunService) {
        this.proracunService = proracunService;
    }

    @GetMapping
    public List<Proracun> listAll(){
        return proracunService.listAll();
    }

    @GetMapping(path="/{id}")
    public Proracun getProracun(@PathVariable("id") long id){
        return proracunService.get(id);
    }

    @PostMapping
    public Proracun createProracun(@RequestBody Proracun proracun){
        return proracunService.createProracun(proracun);
    }

    @PutMapping(path="/{id}")
    public Proracun updateProracun(@PathVariable("id") Long id, @RequestBody Proracun proracun){
        if(!proracun.getId().equals(id)){
            throw new IllegalArgumentException();
        }

        return proracunService.updateProracun(proracun);
    }

    @DeleteMapping(path="/{id}")
    public Proracun deleteProracun(@PathVariable("id") Long id){
        return proracunService.deleteProracun(id);
    }

    @GetMapping(path="/razdjeli")
    public List<String> getRazdjeli(@RequestParam(required = false) String vrstaPlana){
        return proracunService.getRazdjeli(vrstaPlana);
    }

    @GetMapping(path = "/glave")
    public List<String> getGlave(@RequestParam(required = false) String vrstaPlana,
                                 @RequestParam(required = false) String razdjel){
        return proracunService.getGlave(vrstaPlana, razdjel);
    }

    @GetMapping(path = "/ustanove")
    public List<String> getUstanove(@RequestParam(required = false) String vrstaPlana,
                                       @RequestParam(required = false) String razdjel,
                                       @RequestParam(required = false) String glava){
        return proracunService.getUstanove(vrstaPlana, razdjel, glava);
    }

    @GetMapping(path = "/orgJedinice")
    public List<String> getOrgJedinice(@RequestParam(required = false) String vrstaPlana,
                                 @RequestParam(required = false) String razdjel,
                                 @RequestParam(required = false) String glava,
                                 @RequestParam(required = false) String ustanova){
        return proracunService.getOrgJedinice(vrstaPlana, razdjel, glava, ustanova);
    }

    @GetMapping(path = "/iznos")
    public Double getIznos(@RequestParam(required = false) String vrstaPlana,
                                   @RequestParam(required = false) String razdjel,
                                   @RequestParam(required = false) String glava,
                                   @RequestParam(required = false) String ustanova,
                                   @RequestParam(required = false) String orgJedinica){
        return proracunService.getIznos(vrstaPlana, razdjel, glava, ustanova, orgJedinica);
    }

    @GetMapping(path = "/iznos/prosjek")
    public Double getIznosProsjek(@RequestParam(required = false) String vrstaPlana,
                           @RequestParam(required = false) String razdjel,
                           @RequestParam(required = false) String glava,
                           @RequestParam(required = false) String ustanova,
                           @RequestParam(required = false) String orgJedinica){
        return proracunService.getIznosProsjek(vrstaPlana, razdjel, glava, ustanova, orgJedinica);
    }
}
