package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Donation;

import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Override
    Optional<Donation> findById(Long id);
    @Query(value = "SELECT sum(d.quantity) FROM Donation d")
    Long sumAllQuantity();
    @Query(value = "SELECT count(d.id) FROM Donation d")
    Long countAllById();
}
