package tn.enicarthage.projetihm.Entity;
import  tn.enicarthage.projetihm.Entity.*;
import jakarta.persistence.*;
import org.springframework.stereotype.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String Email;
    private String Password;

    // One-to-Many relation with Medicament
    @OneToMany(mappedBy = "personne", cascade = CascadeType.ALL)
    private List<Medicament> medicaments = new ArrayList<>();

    // One-to-Many relation with RendezVous
    @OneToMany(mappedBy = "personne", cascade = CascadeType.ALL)
    private List<RendezVous> rendezVous = new ArrayList<>();


    // Getter et Setter pour id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter et Setter pour nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter et Setter pour prenom
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Getter et Setter pour dateNaissance
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    // Getter et Setter pour Email
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    // Getter et Setter pour Password
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    // Getter et Setter pour medicaments
    public List<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<Medicament> medicaments) {
        this.medicaments = medicaments;
    }

    // Ajouter un medicament à la liste
    public void addMedicament(Medicament medicament) {
        medicaments.add(medicament);
        medicament.setPersonne(this);
    }

    // Supprimer un medicament de la liste
    public void removeMedicament(Medicament medicament) {
        medicaments.remove(medicament);
        medicament.setPersonne(null);
    }

    // Getter et Setter pour rendezVous
    public List<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(List<RendezVous> rendezVous) {
        this.rendezVous = rendezVous;
    }

    // Ajouter un rendez-vous à la liste
    public void addRendezVous(RendezVous rdv) {
        rendezVous.add(rdv);
        rdv.setPersonne(this);
    }

    // Supprimer un rendez-vous de la liste
    public void removeRendezVous(RendezVous rdv) {
        rendezVous.remove(rdv);
        rdv.setPersonne(null);
    }
}





