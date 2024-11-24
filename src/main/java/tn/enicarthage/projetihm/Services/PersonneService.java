package tn.enicarthage.projetihm.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.projetihm.Entity.Medicament;
import tn.enicarthage.projetihm.Entity.Personne;
import tn.enicarthage.projetihm.Entity.RendezVous;
import tn.enicarthage.projetihm.Repositories.PersonneRepository;

import java.util.List;

@Service
public class PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private MedicamentService medicamentService;

    @Autowired
    private RendezVousService rendezVousService;

    // Méthode pour créer une personne
    public Personne createPersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    // Méthode pour récupérer une personne par son ID
    public Personne getPersonneById(Long id) {
        return personneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personne non trouvée"));
    }

    // Méthode pour ajouter un médicament à une personne
    public Medicament addMedicamentToPersonne(Long personneId, Medicament medicament) {
        Personne personne = getPersonneById(personneId);
        return medicamentService.addMedicamentToPersonne(personne, medicament);
    }

    // Méthode pour récupérer les médicaments d'une personne par son ID
    public List<Medicament> getMedicamentsByPersonneId(Long personneId) {
        return medicamentService.getMedicamentsByPersonneId(personneId);
    }

    // Méthode pour ajouter un rendez-vous à une personne
    public RendezVous addRendezVousToPersonne(Long personneId, RendezVous rendezVous) {
        Personne personne = getPersonneById(personneId);
        return rendezVousService.addRendezVousToPersonne(personne, rendezVous);
    }

    // Méthode pour récupérer les rendez-vous d'une personne
    public List<RendezVous> getRendezVousByPersonne(Long personneId) {
        Personne personne = getPersonneById(personneId);
        return personne.getRendezVous();
    }
}
