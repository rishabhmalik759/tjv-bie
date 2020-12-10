package server.service.implementations;

import javassist.NotFoundException;
import server.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.model.ResultEntity;
import server.service.interfaces.ResultService;

import javax.naming.directory.InvalidAttributesException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImp implements ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Override
    @Transactional
    public List<ResultEntity> findAll() {
        return resultRepository.findAll();
    }

    @Override
    @Transactional
    public ResultEntity findById(Long id) throws NotFoundException {
        Optional<ResultEntity> result = resultRepository.findById(id);
        if (!result.isPresent()) throw new NotFoundException("Result with that id do not exists");
        return result.get();
    }

    @Override
    @Transactional
    public ResultEntity save(ResultEntity result)throws InvalidAttributesException {
        if(!result.validate()) throw new InvalidAttributesException("");
        return resultRepository.save(result);
    }

    @Override
    @Transactional
    public ResultEntity update(Long id, ResultEntity result) throws NotFoundException, InvalidAttributesException {
        ResultEntity resultDB = findById(id);
        resultDB.set(result);
        return save(resultDB);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        resultRepository.delete(findById(id));
    }
}
