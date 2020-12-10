package server.service.implementations;

import javassist.NotFoundException;
import server.model.UserEntity;
import server.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.model.BetEntity;
import server.service.interfaces.BetService;

import javax.naming.directory.InvalidAttributesException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BetServiceImp implements BetService {
    @Autowired
    private BetRepository betRepository;

    @Override
    @Transactional
    public List<BetEntity> findAll() {
        return betRepository.findAll();
    }

    @Override
    @Transactional
    public BetEntity findById(Long id) throws NotFoundException {
        Optional<BetEntity> bet = betRepository.findById(id);
        if (!bet.isPresent()) throw new NotFoundException("Bet with that id do not exists");
        return bet.get();
    }

    @Override
    @Transactional
    public BetEntity save(BetEntity bet) throws InvalidAttributesException {
        if(!bet.validate()) throw new InvalidAttributesException("");
        return betRepository.save(bet);
    }

    @Override
    @Transactional
    public BetEntity update(Long id, BetEntity bet) throws NotFoundException, InvalidAttributesException {
        BetEntity betDB = findById(id);
        betDB.set(bet);
        return save(betDB);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        betRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public List<BetEntity> findAllByUser(UserEntity user) {
        return betRepository.findAllByUser(user);
    }
}
