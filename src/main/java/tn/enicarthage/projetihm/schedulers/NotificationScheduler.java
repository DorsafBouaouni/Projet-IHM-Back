package tn.enicarthage.projetihm.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.enicarthage.projetihm.Entity.Medicament;
import tn.enicarthage.projetihm.Entity.RendezVous;
import tn.enicarthage.projetihm.Services.NotificationService;

import java.util.List;

@Component
public class NotificationScheduler {

    @Autowired
    private NotificationService notificationService;

    @Scheduled(fixedRate = 60000) // Exécution toutes les 60 secondes
    public void sendNotifications() {
        Long personneId = 1L; // Exemple pour une personne spécifique
        int minutesAhead = 30;
        int hoursAhead = 2;

        List<Medicament> medicaments = notificationService.getUpcomingMedicaments(personneId, minutesAhead);
        medicaments.forEach(med -> System.out.println("Notification Médicament : " + med.getNom()));

        List<RendezVous> rendezVous = notificationService.getUpcomingRendezVous(personneId, hoursAhead);
        rendezVous.forEach(rdv -> System.out.println("Notification Rendez-vous : " + rdv.getMotif()));
    }
}
