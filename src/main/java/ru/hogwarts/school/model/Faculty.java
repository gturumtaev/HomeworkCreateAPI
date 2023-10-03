package ru.hogwarts.school.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String color;

    @OneToMany(mappedBy = "student")
    private List<Student> students;



    public Faculty(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
    public Faculty() {

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

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty)) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(getId(), faculty.getId()) && Objects.equals(getName(), faculty.getName()) && Objects.equals(getColor(), faculty.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getColor());
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
