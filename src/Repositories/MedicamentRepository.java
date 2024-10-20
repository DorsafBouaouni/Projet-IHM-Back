@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
    List<Medicament> findByPersonneId(Long personneId);
}