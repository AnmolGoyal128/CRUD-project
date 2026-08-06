package in.springboot.CRUD_DTO_Demo.Controller;

import in.springboot.CRUD_DTO_Demo.DTO.CreateStudentRequestDTO;
import in.springboot.CRUD_DTO_Demo.DTO.CreateStudentResponseDTO;
import in.springboot.CRUD_DTO_Demo.DTO.UpdateStudentRequestDto;
import in.springboot.CRUD_DTO_Demo.DTO.UpdateStudentResponseDto;
import in.springboot.CRUD_DTO_Demo.Entity.Student;
import in.springboot.CRUD_DTO_Demo.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//Combines @Controller and @ResponseBody. Tells Spring this class manages API endpoints and automatically converts return values into JSON/XML responses instead of rendering HTML pages.

@RequestMapping("api/students")

//Maps HTTP requests to handler methods or classes.

public class StudentController {
    StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }
    //create
    @PostMapping
    public ResponseEntity<CreateStudentResponseDTO> createStudent(
            @Valid @RequestBody CreateStudentRequestDTO studentRequestDTO) {

//        CreateStudentResponseDTO createdStudent =
//                studentService.createStudent(studentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentRequestDTO));

    }
    //Read
    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDTO> getStudent(@PathVariable Long id) {
//        CreateStudentResponseDTO StudentResp = studentService.getStudent(id);

//        if(StudentResp == null){
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.ok(studentService.getStudent(id));

    }
    //getAll
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
//        List<Student> studentList = studentService.getAllStudent();

//        if(studentList.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.ok(studentService.getAllStudent());

    }

    //update
    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id,@RequestBody UpdateStudentRequestDto studentReq) {
//        UpdateStudentResponseDto studentResp =
//                studentService.updateStudent(id, studentReq);

//        if(studentResp == null){
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.ok(studentService.updateStudent(id, studentReq));

    }

    //delete
    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
//        if(Deleted){
//            return ResponseEntity.ok("Record Deleted");
//
//        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PatchMapping("/delete_soft")
    public ResponseEntity<String> deleteStudentSoft(@RequestParam Long id) {

        studentService.deleteStudentSoftly(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

//        Boolean Deleted = studentService.deleteStudentSoftly(id);
//        if(!Deleted){
//            return ResponseEntity.notFound().build();
//
//        }
//        return ResponseEntity.ok("Record Deleted Softly");
    }
}
