package fr.istic.taa.jaxrs.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Fiche implements Serializable {
    private Long id;
    private String libelle;
    private Date dateButoire;
    private User user;
    private String temps;
    private String tags;
    private  String Lieu;
    private String url;
    private String noteExplicative;

    public Fiche() {
    }

    public Fiche(Long id, String libelle,User user, String temps, String tags, String lieu, String url, String noteExplicative) {
        this.id = id;
        this.libelle = libelle;
        //this.dateButoire = dateButoire;
        this.user = user;
        this.temps = temps;
        this.tags = tags;
        Lieu = lieu;
        this.url = url;
        this.noteExplicative = noteExplicative;
    }
    public Fiche(String libelle,String temps, String tags, String lieu, String url, String noteExplicative) {
        this.libelle = libelle;
        //this.dateButoire = dateButoire;
        this.temps = temps;
        this.tags = tags;
        Lieu = lieu;
        this.url = url;
        this.noteExplicative = noteExplicative;
    }

    public Fiche(String libelle) {
        this.libelle = libelle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDateButoire() {
        return dateButoire;
    }

    public void setDateButoire(Date dateButoire) {
        this.dateButoire = dateButoire;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String lieu) {
        Lieu = lieu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNoteExplicative() {
        return noteExplicative;
    }

    public void setNoteExplicative(String noteExplicative) {
        this.noteExplicative = noteExplicative;
    }
}
