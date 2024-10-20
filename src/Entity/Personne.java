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


    public Personne() {}


}



}
