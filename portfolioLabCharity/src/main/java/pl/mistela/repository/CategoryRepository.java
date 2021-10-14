package pl.mistela.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mistela.model.Category;

import java.util.List;
import java.util.Optional;

@Repository
@ComponentScan
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    Optional<Category> findById(Long id);

    List<Category> findAll();
}
