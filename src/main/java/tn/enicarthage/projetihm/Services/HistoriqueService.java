package tn.enicarthage.projetihm.Services;

import tn.enicarthage.projetihm.Entity.Historique;
import jakarta.persistence.EntityNotFoundException;
import tn.enicarthage.projetihm.Entity.Medicament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.projetihm.Entity.Personne;
import tn.enicarthage.projetihm.Repositories.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoriqueService {

    @Autowired
    private HistoriqueRepository historiqueRepository;

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private MedicamentRepository medicamentRepository;

    public Historique marquerPriseOuRate(Long personneId, Long medicamentId, boolean pris) {
        Personne personne = personneRepository.findById(personneId)
                .orElseThrow(() -> new RuntimeException("Personne introuvable"));
        Medicament medicament = medicamentRepository.findById(medicamentId)
                .orElseThrow(() -> new RuntimeException("Médicament introuvable"));

        Historique historique = new Historique(personne, medicament, LocalDateTime.now(), pris);
        return historiqueRepository.save(historique);
    }

    public List<Historique> getHistoriqueByPersonne(Long personneId) {
        return historiqueRepository.findByPersonneId(personneId);
    }

    public List<Historique> getHistoriqueByMedicament(Long medicamentId) {
        return historiqueRepository.findByMedicamentId(medicamentId);
    }
}
