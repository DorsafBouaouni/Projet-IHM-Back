@Service


//Spring Boot propose un système de planification via l'annotation @Scheduled.
// Cela nous permet de configurer des tâches qui s'exécutent périodiquement,
// comme l'envoi des notifications à intervalles réguliers
public class NotificationScheduler {

    @Autowired
    private NotificationService notificationService;

    @Scheduled(fixedRate = 60000) // Vérification toutes les 60 secondes (1 minute)
    public void envoyerNotificationsMedicaments() {
        List<Medicament> medicaments = notificationService.getMedicamentsAPrendreDansLesProchainesMinutes(15); // Vérifier pour les 15 prochaines minutes
        for (Medicament medicament : medicaments) {
            String message = "Rappel: Prenez votre médicament " + medicament.getNom() + " à " + medicament.getHeurePrise();
            notificationService.envoyerNotification(message, medicament.getPersonne().getNom());
        }
    }

    @Scheduled(fixedRate = 3600000) // Vérification toutes les heures
    public void envoyerNotificationsRendezVous() {
        List<RendezVous> rendezVous = notificationService.getRendezVousDansLesProchainesHeures(2); // Vérifier pour les 2 prochaines heures
        for (RendezVous rdv : rendezVous) {
            String message = "Rappel: Vous avez un rendez-vous pour " + rdv.getMotif() + " à " + rdv.getDateRendezVous();
            notificationService.envoyerNotification(message, rdv.getPersonne().getNom());
        }
    }
}
