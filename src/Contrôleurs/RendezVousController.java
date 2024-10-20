@RestController
@RequestMapping("/api/rendezvous")
public class RendezVousController {

    @Autowired
    private RendezVousService rendezVousService;

    @PostMapping("/personne/{personneId}/ajouter")
    public ResponseEntity<RendezVous> ajouterRendezVous(@PathVariable Long personneId, @RequestBody RendezVous rendezVous) {
        RendezVous nouveauRendezVous = rendezVousService.ajouterRendezVous(personneId, rendezVous);
        return ResponseEntity.ok(nouveauRendezVous);
    }

    @GetMapping("/personne/{personneId}")
    public ResponseEntity<List<RendezVous>> obtenirRendezVous(@PathVariable Long personneId) {
        List<RendezVous> rendezVous = rendezVousService.obtenirRendezVousParPersonne(personneId);
        return ResponseEntity.ok(rendezVous);
    }
}
