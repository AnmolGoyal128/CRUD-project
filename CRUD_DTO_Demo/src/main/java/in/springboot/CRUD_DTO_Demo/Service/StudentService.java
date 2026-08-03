package in.springboot.CRUD_DTO_Demo.Service;

import in.springboot.CRUD_DTO_Demo.Entity.Student;
import in.springboot.CRUD_DTO_Demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {

    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student createStudent(@RequestBody Student studentReq) {
        return studentRepository.save(studentReq);
    }

    public Student getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findById(id);
        if(studentResp.isPresent()) {
            return studentResp.get();
        }
        return null;
    }
    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
            return studentList;
    }
    public Student updateStudent(Long id, Student studentResp){
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()) {
            return null;

        }
        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentResp.getName());
        studentToSave.setRollNo(studentResp.getRollNo());
        studentToSave.setSubject(studentResp.getSubject());
        studentToSave.setEmail(studentResp.getEmail());
        studentToSave.setAge(studentResp.getAge());
        studentToSave.setMobileNo(studentResp.getMobileNo());
        studentToSave.setDeleted(false);

        return studentRepository.save(studentToSave);
    }

    public boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);
        if(isStudent) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean deleteStudentSoftly(Long id){
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isPresent()) {
            return true;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);

        return true;
    }



}
