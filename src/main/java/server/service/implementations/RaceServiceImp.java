package server.service.implementations;

import javassist.NotFoundException;
import server.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.model.RaceEntity;
import server.service.interfaces.RaceService;

import javax.naming.directory.InvalidAttributesException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RaceServiceImp implements RaceService {
    @Autowired
    private RaceRepository raceRepository;

    @Override
    @Transactional
    public List<RaceEntity> findAll() {
        return raceRepository.findAll();
    }

    @Override
    @Transactional
    public RaceEntity findById(Long id) throws NotFoundException {
        Optional<RaceEntity> race = raceRepository.findById(id);
        if (!race.isPresent()) throw new NotFoundException("Race with that id do not exists");
        return race.get();
    }

    @Override
    @Transactional
    public RaceEntity save(RaceEntity race)throws InvalidAttributesException {
        if(!race.validate()) throw new InvalidAttributesException("");
        return raceRepository.save(race);
    }

    @Override
    @Transactional
    public RaceEntity update(Long id, RaceEntity race) throws NotFoundException, InvalidAttributesException {
        RaceEntity raceDB = findById(id);
        raceDB.set(race);
        return save(raceDB);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        raceRepository.delete(findById(id));
    }

    @Override
    public RaceEntity getNextRace() throws NotFoundException {
        Optional<RaceEntity> race = raceRepository.getNextRace();
        if (!race.isPresent()) {
            throw new NotFoundException("There is no next race.");
        }
        return race.get();
    }

}
