package com.threeintelligence.hr.demodu.service;

import com.threeintelligence.hr.demodu.model.Proracun;

import java.util.List;

public interface ProracunService {

    List<Proracun> listAll();

    Proracun get(long id);

    Proracun createProracun(Proracun korisnik);

    Proracun updateProracun(Proracun korisnik);

    Proracun deleteProracun(long id);

    List<String> getRazdjeli(String vrstaPlana);

    List<String> getGlave(String vrstaPlana, String razdjel);

    List<String> getOrgJedinice(String vrstaPlana, String razdjel, String glava, String ustanova);

    Double getIznos(String vrstaPlana, String razdjel, String glava, String ustanova, String orgJedinica);

    List<String> getUstanove(String vrstaPlana, String razdjel, String glava);

    Double getIznosProsjek(String vrstaPlana, String razdjel, String glava, String ustanova, String orgJedinica);
}
