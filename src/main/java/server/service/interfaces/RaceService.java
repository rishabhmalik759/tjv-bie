package server.service.interfaces;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import server.model.RaceEntity;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

@Service
public interface RaceService {
    List<RaceEntity> findAll();

    RaceEntity findById(Long id) throws NotFoundException;

    RaceEntity save(RaceEntity race) throws InvalidAttributesException;

    RaceEntity update(Long id, RaceEntity race) throws NotFoundException, InvalidAttributesException;

    void delete(Long id) throws NotFoundException;

    RaceEntity getNextRace() throws NotFoundException;
}
