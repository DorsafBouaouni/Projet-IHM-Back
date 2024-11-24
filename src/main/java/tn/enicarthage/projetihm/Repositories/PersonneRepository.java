package tn.enicarthage.projetihm.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.enicarthage.projetihm.Entity.Personne;


public interface PersonneRepository extends JpaRepository<Personne, Long> {}
