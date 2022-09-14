package subjectcreation.demo.service;


import java.util.List;

public interface TeacherService {
    void create(Teacher teacher);

    List<Teacher> findAll();

    Teacher getTeacherById(Long id);
}
