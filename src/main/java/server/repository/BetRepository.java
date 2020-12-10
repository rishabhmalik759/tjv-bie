package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import server.model.BetEntity;
import org.springframework.stereotype.Repository;
import server.model.UserEntity;

import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<BetEntity, Long> {
    List<BetEntity> findAllByUser(UserEntity user);
}
