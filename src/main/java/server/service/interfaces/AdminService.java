package server.service.interfaces;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import server.model.AdminEntity;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

@Service
public interface AdminService {
    List<AdminEntity> findAll();

    AdminEntity findById(Long id) throws NotFoundException;

    AdminEntity save(AdminEntity admin) throws InvalidAttributesException;

    AdminEntity update(Long id, AdminEntity admin) throws NotFoundException, InvalidAttributesException;

    void delete(Long id) throws NotFoundException;
}
