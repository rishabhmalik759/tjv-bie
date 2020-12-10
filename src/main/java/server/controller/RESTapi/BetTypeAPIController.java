package server.controller.RESTapi;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.model.BetTypeEntity;
import server.service.interfaces.BetTypeService;

import javax.naming.directory.InvalidAttributesException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/betTypes")
public class BetTypeAPIController {
    @Autowired
    private BetTypeService betTypeService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(betTypeService.findAll());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getBetType(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok(betTypeService.findById(id));
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> createBetType(@Valid @RequestBody BetTypeEntity betType) {
        try {
            return ResponseEntity.ok(betTypeService.save(betType));
        } catch (InvalidAttributesException e) {
            //e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> updateBetType(@PathVariable(value = "id") Long id, @Valid @RequestBody BetTypeEntity betType) {
        try {
            return ResponseEntity.ok(betTypeService.update(id, betType));
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (InvalidAttributesException e) {
            //e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> deleteBetType(@PathVariable(value = "id") Long id) {
        try {
            betTypeService.delete(id);
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
