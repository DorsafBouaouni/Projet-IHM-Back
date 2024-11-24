package tn.enicarthage.projetihm.Contrôleurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.projetihm.Services.*;
import tn.enicarthage.projetihm.Entity.*;

import java.util.List;

@RestController
@RequestMapping("/api/historique")
public class HistoriqueController {

    @Autowired
    private HistoriqueService historiqueService;

    @PostMapping("/{personneId}/{medicamentId}")
    public ResponseEntity<Historique> enregistrerPriseOuRate(
            @PathVariable Long personneId,
            @PathVariable Long medicamentId,
            @RequestParam boolean pris) {
        Historique historique = historiqueService.marquerPriseOuRate(personneId, medicamentId, pris);
        return ResponseEntity.ok(historique);
    }

    @GetMapping("/personne/{personneId}")
    public ResponseEntity<List<Historique>> getHistoriqueByPersonne(@PathVariable Long personneId) {
        List<Historique> historique = historiqueService.getHistoriqueByPersonne(personneId);
        return ResponseEntity.ok(historique);
    }

    @GetMapping("/medicament/{medicamentId}")
    public ResponseEntity<List<Historique>> getHistoriqueByMedicament(@PathVariable Long medicamentId) {
        List<Historique> historique = historiqueService.getHistoriqueByMedicament(medicamentId);
        return ResponseEntity.ok(historique);
    }
}

