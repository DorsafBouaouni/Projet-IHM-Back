package tn.enicarthage.projetihm.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.enicarthage.projetihm.Entity.Personne;
import tn.enicarthage.projetihm.Entity.RendezVous;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

    // Méthode pour récupérer les rendez-vous d'une personne triés par date
    List<RendezVous> findByPersonneOrderByDateRendezVousAsc(Personne personne);


    // Alternative : Si vous voulez rechercher par l'ID de la personne
    @Query("SELECT r FROM RendezVous r WHERE r.personne.id = :personneId ORDER BY r.dateRendezVous ASC")
    List<RendezVous> findByPersonneIdOrderByDateRendezVousAsc(@Param("personneId") Long personneId);

    // Rendez-vous dans les prochaines heures
    @Query("SELECT r FROM RendezVous r WHERE r.personne.id = :personneId AND r.dateRendezVous BETWEEN :now AND :nextTime")
    List<RendezVous> findRendezVousToNotify(@Param("personneId") Long personneId, @Param("now") LocalDateTime now, @Param("nextTime") LocalDateTime nextTime);
}
