package subjectcreation.demo.service;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "subject")

public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Please, fill the required fields")    private String name;
    @ManyToMany(mappedBy = "subjectSet")
    private Set<Teacher> teacherSet;


    public Subject(Long id, String username, Set<Teacher> teacherSet) {
        this.id = id;
        this.name = username;
        this.teacherSet = teacherSet;
    }

    public Set<Teacher> getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set<Teacher> teacherSet) {
        this.teacherSet = teacherSet;
    }

    public Subject() {
    }

       public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }


      @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
