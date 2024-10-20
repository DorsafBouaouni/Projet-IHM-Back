@RestController
@RequestMapping("/api/personnes")
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    // Créer une nouvelle personne
    @PostMapping("/creer")
    public ResponseEntity<Personne> creerPersonne(@RequestBody Personne personne) {
        Personne savedPersonne = personneService.creerPersonne(personne);
        return ResponseEntity.ok(savedPersonne);
    }

    // Obtenir une personne par ID
    @GetMapping("/{id}")
    public ResponseEntity<Personne> obtenirPersonne(@PathVariable Long id) {
        return personneService.obtenirPersonne(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Obtenir toutes les personnes
    @GetMapping
    public ResponseEntity<List<Personne>> obtenirToutesLesPersonnes() {
        List<Personne> personnes = personneService.obtenirToutesLesPersonnes();
        return ResponseEntity.ok(personnes);
    }
}
