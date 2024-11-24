package tn.enicarthage.projetihm.Entity;
import jakarta.persistence.*;
import org.springframework.stereotype.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateRendezVous;
    private String motif; // Exemple : "Consultation annuelle"

    // Many-to-One relation with Personne
    @ManyToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;

    // Constructeurs, getters, setters, etc.
    public RendezVous() {}

    public RendezVous(LocalDateTime dateRendezVous, String motif, Personne personne) {
        this.dateRendezVous = dateRendezVous;
        this.motif = motif;
        this.personne = personne;
    }

    public void setPersonne(Personne personne) {

    }


    public String getMotif() {
        return  this.motif;
    }
}
