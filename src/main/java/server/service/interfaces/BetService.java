package server.service.interfaces;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import server.model.BetEntity;
import server.model.UserEntity;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

@Service
public interface BetService {
    List<BetEntity> findAll();

    BetEntity findById(Long id) throws NotFoundException;

    BetEntity save(BetEntity bet) throws InvalidAttributesException;

    BetEntity update(Long id, BetEntity bet) throws NotFoundException, InvalidAttributesException;

    void delete(Long id) throws NotFoundException;

    List<BetEntity> findAllByUser(UserEntity user);
}
