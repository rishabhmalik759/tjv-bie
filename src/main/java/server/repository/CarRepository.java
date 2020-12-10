package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.CarEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

}

