package com.threeintelligence.hr.demodu.repository;

import com.threeintelligence.hr.demodu.model.Proracun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface ProracunRepository extends JpaRepository<Proracun, Long> {
   /* Optional<Proracun> findByKorisnickoIme(String korisnickoIme);

    int countByKorisnickoIme(String korisnickoIme);

    boolean existsByKorisnickoImeAndIdNot(String korisnickoIme, Long id);

    Optional<Proracun> findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);*/

   List<Proracun> findAllByNazivVrstePlanaAndNazivRazdjel(String vrstaPlana, String razdjel);

   List<Proracun> findAllByNazivVrstePlana(String vrstaPlana);

   List<Proracun> findAllByNazivVrstePlanaAndNazivRazdjelAndNazivGlave(String vrstaPlana, String razdjel, String glava);

   List<Proracun> findAllByNazivVrstePlanaAndNazivRazdjelAndNazivGlaveAndNazivUstanove(String vrstaPlana, String razdjel, String glava, String ustanova);

   List<Proracun> findAllByNazivGlave(String glava);

   List<Proracun> findAllByNazivOrgJedinice(String orgJedinica);

   List<Proracun> findAllByNazivVrstePlanaAndNazivRazdjelAndNazivGlaveAndNazivOrgJedinice(String vrstaPlana, String razdjel, String glava, String orgJedinica);

   List<Proracun> findAllByNazivVrstePlanaAndNazivRazdjelAndNazivGlaveAndNazivUstanoveAndNazivOrgJedinice(String vrstaPlana, String razdjel, String glava, String ustanova, String orgJedinica);
}
