@Service
public class RendezVousService {

    @Autowired
    private RendezVousRepository rendezVousRepository;

    @Autowired
    private PersonneRepository personneRepository;

    public RendezVous ajouterRendezVous(Long personneId, RendezVous rendezVous) {
        Personne personne = personneRepository.findById(personneId)
                .orElseThrow(() -> new ResourceNotFoundException("Personne non trouvée"));
        rendezVous.setPersonne(personne);
        return rendezVousRepository.save(rendezVous);
    }

    public List<RendezVous> obtenirRendezVousParPersonne(Long personneId) {
        return rendezVousRepository.findByPersonneId(personneId);
    }
}
