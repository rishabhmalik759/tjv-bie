package server.controller.RESTapi;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.model.ResultEntity;
import server.service.interfaces.ResultService;

import javax.naming.directory.InvalidAttributesException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultAPIController {
    @Autowired
    private ResultService resultService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(resultService.findAll());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getResult(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok(resultService.findById(id));
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> createResult(@Valid @RequestBody ResultEntity result) {
        try {
            return ResponseEntity.ok(resultService.save(result));
        } catch (InvalidAttributesException e) {
            //e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> updateResult(@PathVariable(value = "id") Long id, @Valid @RequestBody ResultEntity result) {
        try {
            return ResponseEntity.ok(resultService.update(id, result));
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (InvalidAttributesException e) {
            //e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> deleteResult(@PathVariable(value = "id") Long id) {
        try {
            resultService.delete(id);
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
