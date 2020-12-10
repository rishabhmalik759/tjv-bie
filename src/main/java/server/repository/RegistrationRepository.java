package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.RegistrationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long> {
    List<RegistrationEntity> findAllByRaceId(Long id);
}

