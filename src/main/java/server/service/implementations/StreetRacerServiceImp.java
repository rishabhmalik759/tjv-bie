package server.service.implementations;

import javassist.NotFoundException;
import server.repository.StreetRacerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.model.StreetRacerEntity;
import server.service.interfaces.StreetRacerService;

import javax.naming.directory.InvalidAttributesException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StreetRacerServiceImp implements StreetRacerService {
    @Autowired
    private StreetRacerRepository streetRacerRepository;

    @Override
    @Transactional
    public List<StreetRacerEntity> findAll() {
        return streetRacerRepository.findAll();
    }

    @Override
    @Transactional
    public StreetRacerEntity findById(Long id) throws NotFoundException {
        Optional<StreetRacerEntity> streetRacer = streetRacerRepository.findById(id);
        if (!streetRacer.isPresent()) throw new NotFoundException("Racer with that id do not exists");
        return streetRacer.get();
    }

    @Override
    @Transactional
    public StreetRacerEntity save(StreetRacerEntity streetRacer)throws InvalidAttributesException {
        if(!streetRacer.validate()) throw new InvalidAttributesException("");
        return streetRacerRepository.save(streetRacer);
    }

    @Override
    @Transactional
    public StreetRacerEntity update(Long id, StreetRacerEntity streetRacer) throws NotFoundException, InvalidAttributesException {
        StreetRacerEntity streetRacerDB = findById(id);
        streetRacerDB.set(streetRacer);
        return save(streetRacerDB);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        streetRacerRepository.delete(findById(id));
    }

    @Override
    public List<StreetRacerEntity> findAllSortedByWins() {
        return streetRacerRepository.findAllSortedByWins();
    }
}
