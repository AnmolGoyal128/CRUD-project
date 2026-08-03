package in.springboot.CRUD_DTO_Demo.Controller;

import in.springboot.CRUD_DTO_Demo.Entity.Student;
import in.springboot.CRUD_DTO_Demo.Service.StudentService;
import in.springboot.CRUD_DTO_Demo.repository.StudentRepository;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }
    //create
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);

    }
    //Read
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id) {
        Student StudentResp = studentService.getStudent(id);

        if(StudentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(StudentResp);

    }
    //getAll
    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);

    }

    //update
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Long id,@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);

        if(updatedStudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudent);

    }

    //delete
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        Boolean Deleted = studentService.deleteStudent(id);
        if(Deleted){
            return ResponseEntity.ok("Record Deleted");

        }
        return ResponseEntity.notFound().build();
    }
    @PatchMapping("/delete_soft")
    public ResponseEntity<String> deleteStudentSoft(@RequestParam Long id) {
        Boolean Deleted = studentService.deleteStudentSoftly(id);
        if(!Deleted){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok("Record Deleted Softly");
    }
}
