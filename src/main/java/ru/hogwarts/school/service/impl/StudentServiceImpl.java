package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student add(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public Student get(Long id) {
        return studentRepository.findById(id).get();
    }
    @Override
    public Student update(Long id, Student student) {
        return studentRepository.save(student);
    }
    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findByAge(int age) {
        return studentRepository.findByAge(age);
    }

    @Override
    public List<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    @Override
    public Collection<Student> findByFacultyId(Long id) {
        return studentRepository.findByFacultyId(id);
    }
}
