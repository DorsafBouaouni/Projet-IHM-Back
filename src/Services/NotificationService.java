@Service
public class NotificationService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    @Autowired
    private RendezVousRepository rendezVousRepository;

    // Méthode pour vérifier les médicaments dont l'heure de prise est proche
    public List<Medicament> getMedicamentsAPrendreDansLesProchainesMinutes(int minutes) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime limite = now.plusMinutes(minutes);
        return medicamentRepository.findAll().stream()
                .filter(medicament -> medicament.getHeurePrise().isAfter(now) && medicament.getHeurePrise().isBefore(limite))
                .collect(Collectors.toList());
    }

    // Méthode pour vérifier les rendez-vous à venir dans les prochaines heures
    public List<RendezVous> getRendezVousDansLesProchainesHeures(int heures) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime limite = now.plusHours(heures);
        return rendezVousRepository.findAll().stream()
                .filter(rdv -> rdv.getDateRendezVous().isAfter(now) && rdv.getDateRendezVous().isBefore(limite))
                .collect(Collectors.toList());
    }

    // Méthode qui renvoie toutes les notifications sous forme de liste
    public List<String> getNotifications(String destinataire) {
        // Pour l'exemple, on retourne une liste statique de notifications
        List<String> notifications = new ArrayList<>();
        notifications.add("Prendre votre médicament à 10:00");
        notifications.add("Vous avez un rendez-vous à 14:00");
        return notifications;
    }
}
