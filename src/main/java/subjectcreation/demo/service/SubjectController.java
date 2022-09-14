package subjectcreation.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/subjects")
public class SubjectController {

    private final AdminSer adminService;
    private final TeacherService teacherService;

    @Autowired
    public SubjectController(AdminSer adminService, TeacherService teacherService) {
        this.adminService = adminService;
        this.teacherService = teacherService;
    }

    @GetMapping()
    public String getAll(ModelMap modelMap) {
        List<Teacher> teachers = teacherService.findAll();
        modelMap.addAttribute("teachers", teachers);
        modelMap.addAttribute("subject", new Subject());

        return "subjectSection";
    }

    @PostMapping
    public String createTeacher(@ModelAttribute("teacher") @Valid Subject subject,
                                BindingResult result, Model model) {
        List<Subject> all = adminService.findAllAdmins();
        model.addAttribute("subjects", all);

        for (Subject subject1 : all) {
            if (subject1.getName().equals(subject.getName())) {
                model.addAttribute("duplicated", "A user with the specified email already exists");
                return "teacherSection";
            }
        }

        if (result.hasErrors()) {

            return "subjectSection";

        }else adminService.create(subject);
        return "redirect:/subjects";
    }
}
