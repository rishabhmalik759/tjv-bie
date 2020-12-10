package server.service.interfaces;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import server.model.CarEntity;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

@Service
public interface CarService {
    List<CarEntity> findAll();

    CarEntity findById(Long id) throws NotFoundException;

    CarEntity save(CarEntity car) throws InvalidAttributesException;

    CarEntity update(Long id, CarEntity car) throws NotFoundException, InvalidAttributesException;

    void delete(Long id) throws NotFoundException;
}
