package com.threeintelligence.hr.demodu.model;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "proracun")
public class Proracun {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "godina")
    private int godina;

    @Column(name = "naziv_vrste_plana")
    private String nazivVrstePlana;

    @Column(name = "iznos")
    private double iznos;

    @Column(name = "naziv_org_jedinice")
    private String nazivOrgJedinice;

    @Column(name = "naziv_ustanove")
    private String nazivUstanove;

    @Column(name = "naziv_razdjel")
    private String nazivRazdjel;

    @Column(name = "naziv_glave")
    private String nazivGlave;

    @Column(name = "naziv_programske_klasifikacije")
    private String nazivProgramskeKlasifikacije;

    @Column(name = "naziv_izvora")
    private String nazivIzvora;

    @Column(name = "naziv_konta")
    private String nazivKonta;

    @Column(name = "naziv_funkcijske")
    private String nazivFunkcijske;

    public Proracun() {
    }

    public Proracun(Long id, int godina, String nazivVrstePlana, double iznos, String nazivOrgJedinice, String nazivUstanove, String nazivRazdjel, String nazivGlave, String nazivProgramskeKlasifikacije, String nazivIzvora, String nazivKonta, String nazivFunkcijske) {
        this.id = id;
        this.godina = godina;
        this.nazivVrstePlana = nazivVrstePlana;
        this.iznos = iznos;
        this.nazivOrgJedinice = nazivOrgJedinice;
        this.nazivUstanove = nazivUstanove;
        this.nazivRazdjel = nazivRazdjel;
        this.nazivGlave = nazivGlave;
        this.nazivProgramskeKlasifikacije = nazivProgramskeKlasifikacije;
        this.nazivIzvora = nazivIzvora;
        this.nazivKonta = nazivKonta;
        this.nazivFunkcijske = nazivFunkcijske;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getNazivVrstePlana() {
        return nazivVrstePlana;
    }

    public void setNazivVrstePlana(String nazivVrstePlana) {
        this.nazivVrstePlana = nazivVrstePlana;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public String getNazivOrgJedinice() {
        return nazivOrgJedinice;
    }

    public void setNazivOrgJedinice(String nazivOrgJedinice) {
        this.nazivOrgJedinice = nazivOrgJedinice;
    }

    public String getNazivUstanove() {
        return nazivUstanove;
    }

    public void setNazivUstanove(String nazivUstanove) {
        this.nazivUstanove = nazivUstanove;
    }

    public String getNazivRazdjel() {
        return nazivRazdjel;
    }

    public void setNazivRazdjel(String nazivRazdjel) {
        this.nazivRazdjel = nazivRazdjel;
    }

    public String getNazivGlave() {
        return nazivGlave;
    }

    public void setNazivGlave(String nazivGlave) {
        this.nazivGlave = nazivGlave;
    }

    public String getNazivProgramskeKlasifikacije() {
        return nazivProgramskeKlasifikacije;
    }

    public void setNazivProgramskeKlasifikacije(String nazivProgramskeKlasifikacije) {
        this.nazivProgramskeKlasifikacije = nazivProgramskeKlasifikacije;
    }

    public String getNazivIzvora() {
        return nazivIzvora;
    }

    public void setNazivIzvora(String nazivIzvora) {
        this.nazivIzvora = nazivIzvora;
    }

    public String getNazivKonta() {
        return nazivKonta;
    }

    public void setNazivKonta(String nazivKonta) {
        this.nazivKonta = nazivKonta;
    }

    public String getNazivFunkcijske() {
        return nazivFunkcijske;
    }

    public void setNazivFunkcijske(String nazivFunkcijske) {
        this.nazivFunkcijske = nazivFunkcijske;
    }

    @Override
    public String toString() {
        return "Proracun{" +
                "id=" + id +
                ", godina=" + godina +
                ", nazivVrstePlana='" + nazivVrstePlana + '\'' +
                ", iznos=" + iznos +
                ", nazivOrgJedinice='" + nazivOrgJedinice + '\'' +
                ", nazivUstanove='" + nazivUstanove + '\'' +
                ", nazivRazdjel='" + nazivRazdjel + '\'' +
                ", nazivGlave='" + nazivGlave + '\'' +
                ", nazivProgramskeKlasifikacije='" + nazivProgramskeKlasifikacije + '\'' +
                ", nazivIzvora='" + nazivIzvora + '\'' +
                ", nazivKonta='" + nazivKonta + '\'' +
                ", nazivFunkcijske='" + nazivFunkcijske + '\'' +
                '}';
    }
}
