package tn.enicarthage.projetihm.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.projetihm.Entity.Medicament;
import tn.enicarthage.projetihm.Entity.RendezVous;
import tn.enicarthage.projetihm.Repositories.MedicamentRepository;
import tn.enicarthage.projetihm.Repositories.RendezVousRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    @Autowired
    private RendezVousRepository rendezVousRepository;

    public List<Medicament> getUpcomingMedicaments(Long personneId, int minutesAhead) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextTime = now.plusMinutes(minutesAhead);

        return medicamentRepository.findMedicamentsToNotify(personneId, now, nextTime);
    }

    public List<RendezVous> getUpcomingRendezVous(Long personneId, int hoursAhead) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextTime = now.plusHours(hoursAhead);

        return rendezVousRepository.findRendezVousToNotify(personneId, now, nextTime);
    }
}

