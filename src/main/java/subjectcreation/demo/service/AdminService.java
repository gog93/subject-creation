package subjectcreation.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements AdminSer {
    private final AdminRepo adminRepository;

    public AdminService(AdminRepo adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void create(Subject admin) {
        adminRepository.save(admin);
    }

    @Override
    public List<Subject> findAllAdmins() {
        return adminRepository.findAll();
    }


}
