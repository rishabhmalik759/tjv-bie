package server.service.implementations;

import javassist.NotFoundException;
import server.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.model.CarEntity;
import server.service.interfaces.CarService;

import javax.naming.directory.InvalidAttributesException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImp implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    @Transactional
    public List<CarEntity> findAll() {
        return carRepository.findAll();
    }

    @Override
    @Transactional
    public CarEntity findById(Long id) throws NotFoundException {
        Optional<CarEntity> car = carRepository.findById(id);
        if (!car.isPresent()) throw new NotFoundException("Car with that id do not exists");
        return car.get();
    }

    @Override
    @Transactional
    public CarEntity save(CarEntity car)throws InvalidAttributesException {
        if(!car.validate()) throw new InvalidAttributesException("");
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public CarEntity update(Long id, CarEntity car) throws NotFoundException, InvalidAttributesException {
        CarEntity carDB = findById(id);
        carDB.set(car);
        return save(carDB);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        carRepository.delete(findById(id));
    }
}
