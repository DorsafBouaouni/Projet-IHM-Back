package tn.enicarthage.projetihm.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.enicarthage.projetihm.Entity.*;


import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {

    // Méthode pour récupérer la liste des médicaments associés à une personne
    List<Medicament> findByPersonne(Personne personne);

    // Méthode pour récupérer la liste des médicaments d'une personne par son ID
    List<Medicament> findByPersonneId(Long personneId);

    // Médicaments à prendre dans les prochaines minutes
    @Query("SELECT m FROM Medicament m WHERE m.personne.id = :personneId AND m.heurePrise BETWEEN :now AND :nextTime")
    List<Medicament> findMedicamentsToNotify(@Param("personneId") Long personneId, @Param("now") LocalDateTime now, @Param("nextTime") LocalDateTime nextTime);
}
