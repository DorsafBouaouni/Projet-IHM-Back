@Service
public class NotificationService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    @Autowired
    private RendezVousRepository rendezVousRepository;

    // Vérification des médicaments à notifier
    public List<Medicament> getMedicamentsAPrendreDansLesProchainesMinutes(int minutes) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime limite = now.plusMinutes(minutes);
        return medicamentRepository.findAll().stream()
                .filter(medicament -> medicament.getHeurePrise().isAfter(now) && medicament.getHeurePrise().isBefore(limite))
                .collect(Collectors.toList());
    }

    // Vérification des rendez-vous à notifier
    public List<RendezVous> getRendezVousDansLesProchainesHeures(int heures) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime limite = now.plusHours(heures);
        return rendezVousRepository.findAll().stream()
                .filter(rdv -> rdv.getDateRendezVous().isAfter(now) && rdv.getDateRendezVous().isBefore(limite))
                .collect(Collectors.toList());
    }
}
