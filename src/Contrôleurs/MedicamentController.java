@RestController
@RequestMapping("/api/medicaments")
public class MedicamentController {

    @Autowired
    private MedicamentService medicamentService;

    @PostMapping("/personne/{personneId}/ajouter")
    public ResponseEntity<Medicament> ajouterMedicament(@PathVariable Long personneId, @RequestBody Medicament medicament) {
        Medicament nouveauMedicament = medicamentService.ajouterMedicament(personneId, medicament);
        return ResponseEntity.ok(nouveauMedicament);
    }

    @GetMapping("/personne/{personneId}")
    public ResponseEntity<List<Medicament>> obtenirMedicaments(@PathVariable Long personneId) {
        List<Medicament> medicaments = medicamentService.obtenirMedicamentsParPersonne(personneId);
        return ResponseEntity.ok(medicaments);
    }
}
