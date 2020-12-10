package server.service.interfaces;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import server.model.RegistrationEntity;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

@Service
public interface RegistrationService {
    List<RegistrationEntity> findAll();

    RegistrationEntity findById(Long id) throws NotFoundException;

    RegistrationEntity save(RegistrationEntity registration) throws InvalidAttributesException;

    RegistrationEntity update(Long id, RegistrationEntity registration) throws NotFoundException, InvalidAttributesException;

    void delete(Long id) throws NotFoundException;

    List<RegistrationEntity> getAllRegistrationsForRace(Long id);

}
