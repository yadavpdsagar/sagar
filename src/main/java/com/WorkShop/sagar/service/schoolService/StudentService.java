package com.WorkShop.sagar.service.schoolService;


import com.WorkShop.sagar.models.school.StudentScho;
import com.WorkShop.sagar.repo.schoolRepo.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentScho getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("StudentScho not found with ID: " + id));
    }

    public StudentScho addStudent(StudentScho student) {

        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("StudentScho not found with ID: " + id);
        }
        studentRepository.deleteById(id);
    }
}
