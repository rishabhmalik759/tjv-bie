package server.service.interfaces;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import server.model.ResultEntity;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

@Service
public interface ResultService {
    List<ResultEntity> findAll();

    ResultEntity findById(Long id) throws NotFoundException;

    ResultEntity save(ResultEntity result) throws InvalidAttributesException;

    ResultEntity update(Long id, ResultEntity result) throws NotFoundException, InvalidAttributesException;

    void delete(Long id) throws NotFoundException;
}
