package tn.enicarthage.projetihm.Contrôleurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.projetihm.Services.*;
import tn.enicarthage.projetihm.Entity.*;
import tn.enicarthage.projetihm.Repositories.*;

import java.util.List;

@RestController
@RequestMapping("/api/rendezvous")
public class RendezVousController {

    @Autowired
    private RendezVousService rendezVousService;
//ajouter un rendez vous pour une personne
    @PostMapping("/personne/{personneId}/ajouter")
    public ResponseEntity<RendezVous> ajouterRendezVous(@PathVariable Long personneId, @RequestBody RendezVous rendezVous) {
        RendezVous nouveauRendezVous = rendezVousService.ajouterRendezVous(personneId, rendezVous);
        return ResponseEntity.ok(nouveauRendezVous);
    }
// recuperer la liste des rendezvous
    @GetMapping("/personne/{personneId}")
    public ResponseEntity<List<RendezVous>> obtenirRendezVous(@PathVariable Long personneId) {
        List<RendezVous> rendezVous = rendezVousService.obtenirRendezVousParPersonne(personneId);
        return ResponseEntity.ok(rendezVous);
    }
}
