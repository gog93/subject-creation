package subjectcreation.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository1) {
        this.teacherRepository = teacherRepository1;
    }

    @Override
    public void create(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        return  teacherRepository.findAll();

    }

    @Override
    public Teacher getTeacherById(Long id) {
        return  teacherRepository.getTeacherById(id);
    }
}
