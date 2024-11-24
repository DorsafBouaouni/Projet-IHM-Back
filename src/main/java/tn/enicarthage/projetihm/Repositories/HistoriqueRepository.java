package tn.enicarthage.projetihm.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enicarthage.projetihm.Entity.Historique;

import java.util.List;

@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Long> {

    // Récupérer l'historique pour une personne
    List<Historique> findByPersonneId(Long personneId);

    // Récupérer l'historique pour un médicament
    List<Historique> findByMedicamentId(Long medicamentId);
}

