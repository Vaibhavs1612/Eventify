package com.example.Eventify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Eventify.entity.Student;
import com.example.Eventify.repo.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepository;

    
    // get all
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    
    //get by id
    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found with id " + studentId));
    }

    
    // add new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    
    //update
    public Student updateStudent(int studentId, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(studentId);

        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setPassword(updatedStudent.getPassword());
            student.setPhoneNumber(updatedStudent.getPhoneNumber());
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found with id " + studentId);
        }
    }

    
    //delete
    public void deleteStudent(int studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
        } else {
            throw new RuntimeException("Student not found with id " + studentId);
        }
    }
}
