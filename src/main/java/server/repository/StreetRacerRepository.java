package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import server.model.StreetRacerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRacerRepository extends JpaRepository<StreetRacerEntity, Long> {
    @Query(value = "select * from street_racer order by win_counter", nativeQuery = true)
    List<StreetRacerEntity> findAllSortedByWins();
}

