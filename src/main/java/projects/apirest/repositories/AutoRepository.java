package projects.apirest.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.apirest.models.Auto;

import java.util.List;
@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {
    List<Auto> findByMarca(String marca);
    List<Auto> findByColor(String color);
}

