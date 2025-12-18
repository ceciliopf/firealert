package web.firealert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.firealert.model.Alert;
import web.firealert.model.Status;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {

    long countByStatusNot(Status status);

    List<Alert> findByStatus(Status status);

    List<Alert> findByFlorestaId(Long id);
}