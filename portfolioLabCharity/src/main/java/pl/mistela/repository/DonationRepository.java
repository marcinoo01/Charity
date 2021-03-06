package pl.mistela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.mistela.model.Donation;

import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Override
    Optional<Donation> findById(Long id);
    @Query("SELECT sum (d.quantity) from Donation d")
    Integer sumQuantity();
    @Query(value = "SELECT count(d.id) FROM Donation d")
    Long countAllById();
}
