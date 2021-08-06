package com.threeintelligence.hr.demodu.service.impl;

import com.threeintelligence.hr.demodu.model.Proracun;
import com.threeintelligence.hr.demodu.repository.ProracunRepository;
import com.threeintelligence.hr.demodu.service.ProracunService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ProracunServiceImpl implements ProracunService {

    private final ProracunRepository proracunRepository;

    public ProracunServiceImpl(ProracunRepository proracunRepository) {
        this.proracunRepository = proracunRepository;
    }


    @Override
    public List<Proracun> listAll() {
        return proracunRepository.findAll();
    }

    @Override
    public Proracun get(long id) {
        return proracunRepository.findById(id)
                .orElseThrow(()->new NullPointerException("Ne postoji proračun s tim ID-om."));
    }

    @Override
    public Proracun createProracun(Proracun korisnik) {
        return null;
    }

    @Override
    public Proracun updateProracun(Proracun korisnik) {
        return null;
    }

    @Override
    public Proracun deleteProracun(long id) {
        return null;
    }

    @Override
    public List<String> getRazdjeli(String vrstaPlana) {
        return proracunRepository.findAllByNazivVrstePlana(vrstaPlana)
                .stream()
                .map(proracun-> proracun.getNazivRazdjel())
                .distinct().collect(Collectors.toList());
    }

    @Override
    public List<String> getGlave(String vrstaPlana, String razdjel) {
        return proracunRepository.findAllByNazivVrstePlanaAndNazivRazdjel(vrstaPlana, razdjel.toUpperCase())
                .stream()
                .map(proracun -> proracun.getNazivGlave())
                .distinct().collect(Collectors.toList());
    }

    @Override
    public List<String> getOrgJedinice(String vrstaPlana, String razdjel, String glava, String ustanova) {
        return proracunRepository.findAllByNazivVrstePlanaAndNazivRazdjelAndNazivGlaveAndNazivUstanove(
                vrstaPlana, razdjel.toUpperCase(), glava.toUpperCase(), ustanova.toUpperCase()
        )
                .stream()
                .map(proracun -> proracun.getNazivOrgJedinice())
                .distinct().collect(Collectors.toList());
    }

    @Override
    public Double getIznos(String vrstaPlana, String razdjel, String glava, String ustanova, String orgJedinica) {

        List<Double> iznosiProracuna;

        if(razdjel == null){
            iznosiProracuna = proracunRepository.findAllByNazivVrstePlana(
                    vrstaPlana
            )
                    .stream()
                    .map(proracun -> proracun.getIznos())
                    .collect(Collectors.toList());
        }
        else if( glava == null){
            iznosiProracuna = proracunRepository.findAllByNazivVrstePlanaAndNazivRazdjel(
                    vrstaPlana, razdjel
            )
                    .stream()
                    .map(proracun -> proracun.getIznos())
                    .collect(Collectors.toList());
        }
        else if(ustanova == null){
            iznosiProracuna = proracunRepository.findAllByNazivVrstePlanaAndNazivRazdjelAndNazivGlave(
                    vrstaPlana, razdjel, glava
            )
                    .stream()
                    .map(proracun -> proracun.getIznos())
                    .collect(Collectors.toList());
        }
        else if( orgJedinica == null){
            iznosiProracuna = proracunRepository.findAllByNazivVrstePlanaAndNazivRazdjelAndNazivGlaveAndNazivUstanove(
                    vrstaPlana, razdjel, glava, ustanova
            )
                    .stream()
                    .map(proracun -> proracun.getIznos())
                    .collect(Collectors.toList());
        }
        else{
            iznosiProracuna = proracunRepository.findAllByNazivVrstePlanaAndNazivRazdjelAndNazivGlaveAndNazivUstanoveAndNazivOrgJedinice(
                    vrstaPlana, razdjel, glava, ustanova, orgJedinica
            )
                    .stream()
                    .map(proracun -> proracun.getIznos())
                    .collect(Collectors.toList());
        }
        double sum = 0.0;
        for(Double iznos: iznosiProracuna){
            sum+=iznos;
        }

        return sum;
    }

    @Override
    public List<String> getUstanove(String vrstaPlana, String razdjel, String glava) {
        return proracunRepository.findAllByNazivVrstePlanaAndNazivRazdjelAndNazivGlave(vrstaPlana, razdjel.toUpperCase(), glava.toUpperCase())
                .stream()
                .map(proracun -> proracun.getNazivUstanove())
                .distinct().collect(Collectors.toList());
    }

    @Override
    // uzeti npr ukupno iz ustanove i onda count od orgJed distinct i podijeliti
    public Double getIznosProsjek(String vrstaPlana, String razdjel, String glava, String ustanova, String orgJedinica) {
        Double iznosProracuna = this.getIznos(vrstaPlana, razdjel, glava, ustanova, orgJedinica);
        Long brojac = 1L;

        if(razdjel == null){
            brojac = brojacRazdjel(vrstaPlana);
        }
        else if( glava == null){
            brojac = brojacGlava(vrstaPlana, razdjel);
        }
        else if(ustanova == null){
            brojac = brojacUstanova(vrstaPlana, razdjel, glava);
        }
        else{
            brojac = brojacOrgJedinica(vrstaPlana, razdjel, glava, ustanova);
        }

        return (double)iznosProracuna/(double)brojac;
    }

    private Long brojacRazdjel(String vrstaPlana) {
        Long brojac = 0L;
        List<String> razdjeli = proracunRepository.findAllByNazivVrstePlana(
                        vrstaPlana
                )
                .stream()
                .map(proracun -> proracun.getNazivRazdjel())
                .distinct()
                .collect(Collectors.toList());

        for(String razdjelNaziv: razdjeli){
            brojac+= brojacGlava(vrstaPlana, razdjelNaziv);
        }

        return brojac;
    }

    private Long brojacOrgJedinica(String vrstaPlana, String razdjel, String glava, String ustanova){
        return proracunRepository.findAllByNazivVrstePlanaAndNazivRazdjelAndNazivGlaveAndNazivUstanove(
                        vrstaPlana, razdjel.toUpperCase(), glava.toUpperCase(), ustanova.toUpperCase()
                )
                .stream()
                .map(proracun -> proracun.getNazivOrgJedinice())
                .distinct()
                .count();
    }

    private Long brojacUstanova(String vrstaPlana, String razdjel, String glava){
        Long brojac = 0L;
        List<String> ustanove = proracunRepository.findAllByNazivVrstePlanaAndNazivRazdjelAndNazivGlave(
                        vrstaPlana, razdjel, glava
                )
                .stream()
                .map(proracun -> proracun.getNazivUstanove())
                .distinct()
                .collect(Collectors.toList());

        for(String ustanovaNaziv: ustanove){
            brojac+= brojacOrgJedinica(vrstaPlana, razdjel, glava, ustanovaNaziv);
        }

        return brojac;
    }

    private Long brojacGlava(String vrstaPlana, String razdjel){
        Long brojac = 0L;
        List<String> glave = proracunRepository.findAllByNazivVrstePlanaAndNazivRazdjel(
                        vrstaPlana, razdjel
                )
                .stream()
                .map(proracun -> proracun.getNazivGlave())
                .distinct()
                .collect(Collectors.toList());

        for(String glavaNaziv: glave){
            brojac+= brojacUstanova(vrstaPlana, razdjel, glavaNaziv);
        }

        return brojac;
    }
}
