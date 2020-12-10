package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import server.model.RaceEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<RaceEntity, Long> {
    @Query(value = "select DATE_R from RACE where DATE_R>=current_date", nativeQuery = true)
    Optional<RaceEntity> getNextRace();
}

