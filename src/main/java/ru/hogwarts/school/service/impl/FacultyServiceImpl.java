package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.service.FacultyService;
import ru.hogwarts.school.service.StudentService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;
    private final StudentService studentService;

    public FacultyServiceImpl(FacultyRepository facultyRepository, StudentService studentService) {
        this.facultyRepository = facultyRepository;
        this.studentService = studentService;
    }


    @Override
    public Faculty add(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty get(Long id) {
        return facultyRepository.findById(id).get();
    }

    @Override
    public Faculty update(Long id, Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void delete(Long id) {
        facultyRepository.deleteById(id);
    }
    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
    @Override
    public List<Faculty> findByColorIgnoreCase(String color) {
        return facultyRepository.findByColorIgnoreCase(color);
    }

    @Override
    public Set<Faculty> getByColorOrNameIgnoreCase(String param) {
        Set<Faculty> result = new HashSet<>();
        result.addAll(facultyRepository.findByColorIgnoreCase(param));
        result.addAll(facultyRepository.findByNameIgnoreCase(param));
        return result;
    }
    @Override
    public List<Student> getStudentsByFacultyId(Long id) {
        return studentService.getByFacultyId(id);
    }
}
