package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Institution;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    Optional<Institution> findById(Long id);
    List<Institution> findAll();
    @Query(value = "select i.name from Institution i", nativeQuery = true)
    List<String> findAllByName();
    @Query(value = "select i.description from Institution i", nativeQuery = true)
    List<String> findAllByDescription();
}
