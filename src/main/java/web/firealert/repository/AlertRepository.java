package web.firealert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.firealert.model.Alert;
import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {



    List<Alert> findByTipo(String tipo);


    List<Alert> findByFlorestaId(Long florestaId);
}