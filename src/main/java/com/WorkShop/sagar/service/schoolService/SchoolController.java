package com.WorkShop.sagar.service.schoolService;

import com.WorkShop.sagar.models.school.Course;
import com.WorkShop.sagar.models.school.StudentScho;
import com.WorkShop.sagar.models.school.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/student/{id}")
    public StudentScho getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id); // Throws EntityNotFoundException if not found
    }

    @PostMapping("/student")
    public StudentScho addStudent(@RequestBody StudentScho student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id); // Throws EntityNotFoundException if not found
    }

    @GetMapping("/teacher/{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return teacherService.getTeacherById(id); // Throws EntityNotFoundException if not found
    }

    @PostMapping("/teacher")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @DeleteMapping("/teacher/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id); // Throws EntityNotFoundException if not found
    }

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getCourseById(id); // Throws EntityNotFoundException if not found
    }

    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id); // Throws EntityNotFoundException if not found
    }
}