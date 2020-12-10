package server.service.implementations;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import server.repository.AdminRepository;
import server.model.AdminEntity;
import server.service.interfaces.AdminService;

import javax.naming.directory.InvalidAttributesException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    @Transactional
    public List<AdminEntity> findAll() {
        return adminRepository.findAll();
    }

    @Override
    @Transactional
    public AdminEntity findById(Long id) throws NotFoundException {
        Optional<AdminEntity> admin = adminRepository.findById(id);
        if (!admin.isPresent()) throw new NotFoundException("Admin with that id do not exists");
        return admin.get();
    }

    @Override
    @Transactional
    public AdminEntity save(AdminEntity admin) throws InvalidAttributesException {
        if(!admin.validate()) throw new InvalidAttributesException("");
        return adminRepository.save(admin);
    }

    @Override
    @Transactional
    public AdminEntity update(Long id, AdminEntity admin) throws NotFoundException, InvalidAttributesException {
        AdminEntity adminDB = findById(id);
        adminDB.set(admin);
        return save(adminDB);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        adminRepository.delete(findById(id));
    }
}
