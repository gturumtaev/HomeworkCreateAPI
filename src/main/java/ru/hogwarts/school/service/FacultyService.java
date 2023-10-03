package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface FacultyService {
    Faculty add(Faculty faculty);

    Faculty get(Long id);

    Faculty update(Long id, Faculty faculty);

    void delete(Long id);

    List<Faculty> getAllFaculties();

    List<Faculty> findByColorIgnoreCase(String color);
    Set<Faculty> getByColorOrNameIgnoreCase(String param);

    List<Student> getStudentsByFacultyId(Long id);


}
