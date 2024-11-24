package tn.enicarthage.projetihm.Services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.projetihm.Entity.Personne;
import tn.enicarthage.projetihm.Entity.RendezVous;
import tn.enicarthage.projetihm.Repositories.PersonneRepository;
import tn.enicarthage.projetihm.Repositories.RendezVousRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RendezVousService {

    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private PersonneRepository PersonneRepository;
    // Méthode pour ajouter un rendez-vous à une personne
    public RendezVous addRendezVousToPersonne(Personne personne, RendezVous rendezVous) {
        rendezVous.setPersonne(personne);
        return rendezVousRepository.save(rendezVous);
    }

    // Méthode pour récupérer les rendez-vous d'une personne ordonnés par date
    public List<RendezVous> getRendezVousByPersonne(Personne personne) {
        return rendezVousRepository.findByPersonneOrderByDateRendezVousAsc(personne);
    }

    // Méthode pour récupérer les rendez-vous par ID de la personne, ordonnés par date
    public List<RendezVous> getRendezVousByPersonneId(Long personneId) {
        return rendezVousRepository.findByPersonneIdOrderByDateRendezVousAsc(personneId);
    }

    public RendezVous ajouterRendezVous(Long personneId, RendezVous rendezVous) {
        // Vérifier si la personne existe
        Optional<Personne> personneOpt = PersonneRepository.findById(personneId);
        if (personneOpt.isEmpty()) {
            throw new EntityNotFoundException("Personne avec l'ID " + personneId + " introuvable.");
        }

        // Récupérer la personne
        Personne personne = personneOpt.get();

        // Associer le rendez-vous à la personne
        rendezVous.setPersonne(personne);

        // Ajouter le rendez-vous à la liste des rendez-vous de la personne
        personne.addRendezVous(rendezVous);

        // Sauvegarder le rendez-vous dans la base de données
        return rendezVousRepository.save(rendezVous);
    }

    public List<RendezVous> obtenirRendezVousParPersonne(Long personneId) {
        // Vérifier si la personne existe
        Optional<Personne> personneOpt = PersonneRepository.findById(personneId);
        if (personneOpt.isEmpty()) {
            throw new EntityNotFoundException("Personne avec l'ID " + personneId + " introuvable.");
        }

        // Récupérer la liste des rendez-vous triés par date pour cette personne
        return rendezVousRepository.findByPersonneIdOrderByDateRendezVousAsc(personneId);
    }
}

