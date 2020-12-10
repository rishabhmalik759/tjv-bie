package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.BetTypeEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BetTypeRepository extends JpaRepository<BetTypeEntity, Long> {

}
