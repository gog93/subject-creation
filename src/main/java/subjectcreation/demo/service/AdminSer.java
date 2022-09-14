package subjectcreation.demo.service;

import java.util.List;

public interface AdminSer {
    void create(Subject admin);

    List<Subject> findAllAdmins();

}
