@Service
public class PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    // Ajouter une nouvelle personne (lors de la première utilisation de l'application)
    public Personne creerPersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    // Récupérer une personne par son identifiant
    public Optional<Personne> obtenirPersonne(Long id) {
        return personneRepository.findById(id);
    }

    // Récupérer toutes les personnes
    public List<Personne> obtenirToutesLesPersonnes() {
        return personneRepository.findAll();
    }
}
