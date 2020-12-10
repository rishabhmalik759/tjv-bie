package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.ResultEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Long> {

}

