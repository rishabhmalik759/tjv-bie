package server.service.implementations;

import javassist.NotFoundException;
import server.repository.BetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.model.BetTypeEntity;
import server.service.interfaces.BetTypeService;

import javax.naming.directory.InvalidAttributesException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BetTypeServiceImp implements BetTypeService {
    @Autowired
    private BetTypeRepository betTypeRepository;

    @Override
    @Transactional
    public List<BetTypeEntity> findAll() {
        return betTypeRepository.findAll();
    }

    @Override
    @Transactional
    public BetTypeEntity findById(Long id) throws NotFoundException {
        Optional<BetTypeEntity> betType = betTypeRepository.findById(id);
        if (!betType.isPresent()) throw new NotFoundException("Type of bet with that id do not exists");
        return betType.get();
    }

    @Override
    @Transactional
    public BetTypeEntity save(BetTypeEntity betType)throws InvalidAttributesException {
        if(!betType.validate()) throw new InvalidAttributesException("");
        return betTypeRepository.save(betType);
    }

    @Override
    @Transactional
    public BetTypeEntity update(Long id, BetTypeEntity betType) throws NotFoundException, InvalidAttributesException {
        BetTypeEntity betTypeDB = findById(id);
        betTypeDB.set(betType);
        return save(betTypeDB);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        betTypeRepository.delete(findById(id));
    }
}
