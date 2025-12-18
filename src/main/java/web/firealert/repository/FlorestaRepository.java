package web.firealert.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.firealert.model.Floresta;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlorestaRepository extends JpaRepository<Floresta, Long> {

    Optional<Floresta> findByName(String name);

    Page<Floresta> findByNameContainingIgnoreCase(String name, Pageable pageable);

    @Query("SELECT f FROM Floresta f WHERE " +"LOWER(f.name) LIKE LOWER(CONCAT('%', :busca, '%')) OR " + "LOWER(f.endereco) LIKE LOWER(CONCAT('%', :busca, '%'))")
    Page<Floresta> buscarGeral(@Param("busca") String busca, Pageable pageable);
}