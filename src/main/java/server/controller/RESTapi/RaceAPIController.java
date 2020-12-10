package server.controller.RESTapi;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.model.RaceEntity;
import server.service.interfaces.RaceService;

import javax.naming.directory.InvalidAttributesException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/races")
public class RaceAPIController {
    @Autowired
    private RaceService raceService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(raceService.findAll());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getRace(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok(raceService.findById(id));
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> createRace(@Valid @RequestBody RaceEntity race) {
        try {
            return ResponseEntity.ok(raceService.save(race));
        } catch (InvalidAttributesException e) {
            //e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> updateRace(@PathVariable(value = "id") Long id, @Valid @RequestBody RaceEntity race) {
        try {
            return ResponseEntity.ok(raceService.update(id, race));
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (InvalidAttributesException e) {
            //e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> deleteRace(@PathVariable(value = "id") Long id) {
        try {
            raceService.delete(id);
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
