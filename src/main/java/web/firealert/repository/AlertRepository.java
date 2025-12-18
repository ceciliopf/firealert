package web.firealert.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.firealert.model.Alert;
import web.firealert.model.Gravidade;
import web.firealert.model.Status;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {

    long countByStatusNot(Status status);

    List<Alert> findByStatus(Status status);
    List<Alert> findByPessoaCodigo(Long codigo);
    List<Alert> findByFlorestaId(Long id);
    
    @Query("SELECT a FROM Alert a WHERE " +
           "(:status IS NULL OR a.status = :status) AND " +
           "(:tipo IS NULL OR a.tipo = :tipo)")
    Page<Alert> filtrar(@Param("status") Status status, 
                        @Param("tipo") Gravidade tipo, 
                        Pageable pageable);
}