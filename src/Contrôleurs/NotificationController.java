@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/medicaments")
    public List<Medicament> getNotificationsMedicaments() {
        // Obtenir les médicaments à prendre dans les 15 prochaines minutes
        return notificationService.getMedicamentsAPrendreDansLesProchainesMinutes(15);
    }

    @GetMapping("/rendezvous")
    public List<RendezVous> getNotificationsRendezVous() {
        // Obtenir les rendez-vous dans les 2 prochaines heures
        return notificationService.getRendezVousDansLesProchainesHeures(2);
    }
    // Endpoint pour récupérer les notifications d'un utilisateur
    @GetMapping("/{destinataire}")
    public List<String> getNotifications(@PathVariable String destinataire) {
        return notificationService.getNotifications(destinataire);
    }
}
