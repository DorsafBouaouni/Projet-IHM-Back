package tn.enicarthage.projetihm.Contrôleurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.projetihm.Services.*;
import tn.enicarthage.projetihm.Entity.*;
import tn.enicarthage.projetihm.Repositories.*;

import java.util.List;
@RestController
@RequestMapping("/api/medicaments")
public class MedicamentController {

    @Autowired
    private MedicamentService medicamentService;


    //ajouter un medicament dans la liste d'une personne
    @PostMapping("/personne/{personneId}/ajouter")
    public ResponseEntity<Medicament> ajouterMedicament(@PathVariable Long personneId, @RequestBody Medicament medicament) {
        Medicament nouveauMedicament = medicamentService.ajouterMedicament(personneId, medicament);
        return ResponseEntity.ok(nouveauMedicament);
    }
    //Retourner la liste des médicaments par idpersonne
    @GetMapping("/personne/{personneId}")
    public ResponseEntity<List<Medicament>> obtenirMedicaments(@PathVariable Long personneId) {
        List<Medicament> medicaments = medicamentService.obtenirMedicamentsParPersonne(personneId);
        return ResponseEntity.ok(medicaments);
    }
}
