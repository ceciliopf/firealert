package web.firealert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.firealert.model.Floresta;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlorestaRepository extends JpaRepository<Floresta, Long> {

    Optional<Floresta> findByName(String name);


    List<Floresta> findByNameContainingIgnoreCase(String name);
}