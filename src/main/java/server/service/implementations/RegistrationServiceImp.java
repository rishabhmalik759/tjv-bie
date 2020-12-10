package server.service.implementations;

import javassist.NotFoundException;
import server.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.model.RegistrationEntity;
import server.service.interfaces.RegistrationService;

import javax.naming.directory.InvalidAttributesException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImp implements RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    @Transactional
    public List<RegistrationEntity> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    @Transactional
    public RegistrationEntity findById(Long id) throws NotFoundException {
        Optional<RegistrationEntity> registration = registrationRepository.findById(id);
        if (!registration.isPresent()) throw new NotFoundException("Registration with that id do not exists");
        return registration.get();
    }

    @Override
    @Transactional
    public RegistrationEntity save(RegistrationEntity registration)throws InvalidAttributesException {
        if(!registration.validate()) throw new InvalidAttributesException("");
        return registrationRepository.save(registration);
    }

    @Override
    @Transactional
    public RegistrationEntity update(Long id, RegistrationEntity registration) throws NotFoundException, InvalidAttributesException {
        RegistrationEntity registrationDB = findById(id);
        registrationDB.set(registration);
        return save(registrationDB);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        registrationRepository.delete(findById(id));
    }

    @Override
    public List<RegistrationEntity> getAllRegistrationsForRace(Long id) {
        return registrationRepository.findAllByRaceId(id);
    }
}
