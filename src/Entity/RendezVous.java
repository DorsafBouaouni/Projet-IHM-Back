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

    // Getters and setters

    // ...
}
