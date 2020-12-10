package server.controller.RESTapi;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import server.model.BetEntity;
import server.service.interfaces.BetService;

import javax.naming.directory.InvalidAttributesException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/bets")
public class BetAPIController {
    @Autowired
    private BetService betService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(betService.findAll());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getBet(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok( betService.findById(id));
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> createBet(@Valid @RequestBody BetEntity bet) {
        try {
            return ResponseEntity.ok(betService.save(bet));
        } catch (InvalidAttributesException e) {
            //e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> updateBet(@PathVariable(value = "id") Long id, @Valid @RequestBody BetEntity bet) {
        try {
            return ResponseEntity.ok(betService.update(id, bet));
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (InvalidAttributesException e) {
            //e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> deleteBet(@PathVariable(value = "id") Long id) {
        try {
            betService.delete(id);
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
