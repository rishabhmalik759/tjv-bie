package server.service.interfaces;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import server.model.StreetRacerEntity;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

@Service
public interface StreetRacerService {
    List<StreetRacerEntity> findAll();

    StreetRacerEntity findById(Long id) throws NotFoundException;

    StreetRacerEntity save(StreetRacerEntity streetRacer) throws InvalidAttributesException;

    StreetRacerEntity update(Long id, StreetRacerEntity streetRacer) throws NotFoundException, InvalidAttributesException;

    void delete(Long id) throws NotFoundException;

    List<StreetRacerEntity> findAllSortedByWins();
}
