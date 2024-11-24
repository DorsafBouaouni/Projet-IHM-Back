package tn.enicarthage.projetihm.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
import org.springframework.stereotype.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

@Entity
public class Historique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "personne_id", nullable = false)
    private Personne personne;

    @ManyToOne
    @JoinColumn(name = "medicament_id", nullable = false)
    private Medicament medicament;

    private LocalDateTime datePrise;

    private boolean pris; // true = pris, false = raté

    // Getters, Setters, Constructeurs
    public Historique() {}

    public Historique(Personne personne, Medicament medicament, LocalDateTime datePrise, boolean pris) {
        this.personne = personne;
        this.medicament = medicament;
        this.datePrise = datePrise;
        this.pris = pris;
    }

    // Getters et setters...
}
