package tn.enicarthage.projetihm.Contrôleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.projetihm.Entity.Medicament;
import tn.enicarthage.projetihm.Entity.RendezVous;
import tn.enicarthage.projetihm.Services.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Notifications des médicaments à prendre
    @GetMapping("/medicaments/{personneId}")
    public ResponseEntity<List<Medicament>> notifyMedicaments(
            @PathVariable Long personneId,
            @RequestParam int minutesAhead) {
        List<Medicament> medicaments = notificationService.getUpcomingMedicaments(personneId, minutesAhead);
        return ResponseEntity.ok(medicaments);
    }

    // Notifications des rendez-vous à venir
    @GetMapping("/rendezvous/{personneId}")
    public ResponseEntity<List<RendezVous>> notifyRendezVous(
            @PathVariable Long personneId,
            @RequestParam int hoursAhead) {
        List<RendezVous> rendezVous = notificationService.getUpcomingRendezVous(personneId, hoursAhead);
        return ResponseEntity.ok(rendezVous);
    }
}

