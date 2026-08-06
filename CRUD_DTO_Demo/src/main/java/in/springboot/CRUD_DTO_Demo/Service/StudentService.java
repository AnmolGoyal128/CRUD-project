package in.springboot.CRUD_DTO_Demo.Service;

import com.sun.jdi.request.DuplicateRequestException;
import in.springboot.CRUD_DTO_Demo.DTO.CreateStudentRequestDTO;
import in.springboot.CRUD_DTO_Demo.DTO.CreateStudentResponseDTO;
import in.springboot.CRUD_DTO_Demo.DTO.UpdateStudentRequestDto;
import in.springboot.CRUD_DTO_Demo.DTO.UpdateStudentResponseDto;
import in.springboot.CRUD_DTO_Demo.Entity.Student;
import in.springboot.CRUD_DTO_Demo.Exception.ResourceNotFoundException;
import in.springboot.CRUD_DTO_Demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService {

    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public CreateStudentResponseDTO createStudent(@RequestBody CreateStudentRequestDTO studentRequestDTO) {
        Student student = mapToEntity(studentRequestDTO);

        if(emailExist(student)){
            throw new DuplicateRequestException("Email already exists " + student.getEmail());
        }


        Student studentResp = studentRepository.save(student);

        return mapToDto(studentResp);
    }



    public CreateStudentResponseDTO getStudent(Long id) {

        Student studentResp = studentRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id " + id +"not found"));


//        Student studentResp = studentRepository
//                .findById(id)
//                .orElse((null));
        return mapToDto(studentResp);

//        Optional<Student> studentResp = studentRepository.findById(id);
//        if(studentResp.isPresent()) {
//            return studentResp.get();
//        }
//        return null;

//        return mapToDto(studentResp.get());

    }
    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
            return studentList;
    }
    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentResp){
            Student existingStudent = studentRepository
                    .findByIdAndDeletedIsFalse(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Student with id " + id +"not found"));

//        if(existingStudent.isEmpty()) {
//            return null;
//
//        }
//        Student studentToSave = existingStudent;

        existingStudent.setName(studentResp.getName());
        existingStudent.setRollNo(studentResp.getRollNo());
        existingStudent.setSubject(studentResp.getSubject());
        //studentToSave.setEmail(studentResp.getEmail());
        existingStudent.setAge(studentResp.getAge());
        //studentToSave.setMobileNo(studentResp.getMobileNo());
        existingStudent.setDeleted(false);
        existingStudent.setUpdatedDate(LocalDateTime.now());

        Student saveStudent =  studentRepository.save(existingStudent);
        return mapToUpdateDto(saveStudent);
    }



    public void deleteStudent(Long id) {
        Student StudentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id " + id +"not found"));
//        if(isStudent) {
//            studentRepository.deleteById(id);
//            return true;
//        }
//        return false;

        studentRepository.delete(StudentToBeDeleted);



    }

    public void deleteStudentSoftly(Long id){

        Student StudentToBeDeleted = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Student with id " + id +"not found"));

//        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
//        if(existingStudent.isPresent()) {
//            return true;
//        }

//        Student studentToSave = existingStudent.get();
        StudentToBeDeleted.setDeleted(true);
        studentRepository.save(StudentToBeDeleted);

//        return true;
    }

    private Student mapToEntity(CreateStudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setRollNo(studentRequestDTO.getRollNo());
        student.setSubject(studentRequestDTO.getSubject());
        student.setEmail(studentRequestDTO.getEmail());
        student.setAge(studentRequestDTO.getAge());
        student.setMobileNo(studentRequestDTO.getMobileNo());
        student.setDeleted(false);
        student.setCreatedDate(LocalDateTime.now());
        student.setUpdatedDate(LocalDateTime.now());
        return student;
    }
    private CreateStudentResponseDTO mapToDto(Student studentResp) {

        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();
        createStudentResponseDTO.setName(studentResp.getName());
        createStudentResponseDTO.setId(studentResp.getId());
        createStudentResponseDTO.setRollNo(studentResp.getRollNo());
        createStudentResponseDTO.setSubject(studentResp.getSubject());
        createStudentResponseDTO.setEmail(studentResp.getEmail());
        createStudentResponseDTO.setAge(studentResp.getAge());
        createStudentResponseDTO.setMessage("Student Saved Successfully");
        createStudentResponseDTO.setCreatedDate(studentResp.getCreatedDate());
        createStudentResponseDTO.setUpdatedDate(studentResp.getUpdatedDate());

        return createStudentResponseDTO;

    }
    private UpdateStudentResponseDto mapToUpdateDto(Student saveStudent) {

        UpdateStudentResponseDto updateStudentResponseDTO = new UpdateStudentResponseDto();
        updateStudentResponseDTO.setName(saveStudent.getName());
        updateStudentResponseDTO.setId(saveStudent.getId());
        updateStudentResponseDTO.setRollNo(saveStudent.getRollNo());
        updateStudentResponseDTO.setSubject(saveStudent.getSubject());
//        updateStudentResponseDTO.setEmail(saveStudent.getEmail());
        updateStudentResponseDTO.setAge(saveStudent.getAge());
        updateStudentResponseDTO.setMessage("Student Updated Successfully");
//        updateStudentResponseDTO.setCreatedDate(saveStudent.getCreatedDate());
        updateStudentResponseDTO.setUpdatedDate(saveStudent.getUpdatedDate());

        return updateStudentResponseDTO;

    }
    private boolean emailExist(Student student) {
       return studentRepository.existsByEmail(student.getEmail());
    }



}
