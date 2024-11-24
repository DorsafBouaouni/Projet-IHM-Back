package tn.enicarthage.projetihm.Services;

import jakarta.persistence.EntityNotFoundException;
import tn.enicarthage.projetihm.Entity.Medicament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.projetihm.Entity.Personne;
import tn.enicarthage.projetihm.Repositories.*;


import java.util.List;
import java.util.Optional;

@Service
public class MedicamentService {


    @Autowired
    private PersonneRepository PersonneRepository;
    @Autowired
    private MedicamentRepository medicamentRepository;

    // Méthode pour ajouter un médicament à une personne
    public Medicament addMedicamentToPersonne(Personne personne, Medicament medicament) {
        medicament.setPersonne(personne);
        return medicamentRepository.save(medicament);
    }

    // Méthode pour récupérer la liste des médicaments d'une personne
    public List<Medicament> getMedicamentsByPersonne(Personne personne) {
        return medicamentRepository.findByPersonne(personne);
    }

    // Méthode pour récupérer la liste des médicaments par ID de la personne
    public List<Medicament> getMedicamentsByPersonneId(Long personneId) {
        Personne personne = new Personne();
        personne.setId(personneId); // On crée un objet Personne avec seulement l'ID
        return getMedicamentsByPersonne(personne); // Récupération des médicaments pour cette personne
    }

    public Medicament ajouterMedicament(Long personneId, Medicament medicament) {
        // Vérifier si la personne existe
        Optional<Personne> personneOpt = PersonneRepository.findById(personneId);
        if (personneOpt.isEmpty()) {
            throw new EntityNotFoundException("Personne avec l'ID " + personneId + " introuvable.");
        }

        // Récupérer la personne
        Personne personne = personneOpt.get();

        // Lier le médicament à la personne
        medicament.setPersonne(personne);

        // Ajouter le médicament à la liste de la personne
        personne.addMedicament(medicament);

        // Sauvegarder le médicament dans la base de données
        return medicamentRepository.save(medicament);
    }

    public List<Medicament> obtenirMedicamentsParPersonne(Long personneId) {
        // Vérifier si la personne existe
        Optional<Personne> personneOpt = PersonneRepository.findById(personneId);
        if (personneOpt.isEmpty()) {
            throw new EntityNotFoundException("Personne avec l'ID " + personneId + " introuvable.");
        }

        // Récupérer la liste des médicaments pour cette personne
        return medicamentRepository.findByPersonneId(personneId);
    }
}
