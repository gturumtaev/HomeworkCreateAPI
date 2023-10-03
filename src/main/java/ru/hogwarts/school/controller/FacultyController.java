package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping("{id}")
    public Faculty get(@PathVariable("id") Long id) {
        return facultyService.get(id);
    }
    @PostMapping
    public Faculty add(@RequestBody Faculty faculty) {
        return facultyService.add(faculty);
    }
    @PutMapping("{id}")
    public Faculty update(@PathVariable("id") Long id,
                          @RequestBody Faculty faculty) {
        return facultyService.update(id, faculty);
    }
    @DeleteMapping("{id}")
    void delete(@PathVariable("id") Long id) {
        facultyService.delete(id);
    }
    @GetMapping
    public List<Faculty> findFaculties(@RequestParam (required = false) String color) {
        if (color != null && !color.isBlank()) {
            return facultyService.findByColorIgnoreCase(color);
        }
        return facultyService.getAllFaculties();
    }
    @GetMapping("/name-or-color")
    public Set<Faculty> getByColorOrNameIgnoreCase(@RequestParam String param) {
        return facultyService.getByColorOrNameIgnoreCase(param);
    }

    @GetMapping("/students-faculty-id")
    public List<Student> getStudentsByFacultyId(@RequestParam Long id) {
        return facultyService.getStudentsByFacultyId(id);
    }
}
