package server.controller.RESTapi;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.model.CarEntity;
import server.service.interfaces.CarService;

import javax.naming.directory.InvalidAttributesException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/cars")
public class CarAPIController {
    @Autowired
    private CarService carService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getCar(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok(carService.findById(id));
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> createCar(@RequestBody CarEntity car) {
        try {
            return ResponseEntity.ok(carService.save(car));
        } catch (InvalidAttributesException e) {
            //e.printStackTrace();
            return ResponseEntity.ok().build();
            //return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> updateCar(@PathVariable(value = "id") Long id, @Valid @RequestBody CarEntity car) {
        try {
            return ResponseEntity.ok(carService.update(id, car));
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (InvalidAttributesException e) {
            //e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> deleteCar(@PathVariable(value = "id") Long id) {
        try {
            carService.delete(id);
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
