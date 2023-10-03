package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    Student add(Student student);

    Student get(Long id);

    Student update(Long id, Student student);

    void delete(Long id);

    List<Student> getAllStudents();

    List<Student> findByAge(int age);

    List<Student> findByAgeBetween(int min, int max);
    List<Student> getByFacultyId(Long id);

    Faculty getFacultyByStudentId(Long id);
}
