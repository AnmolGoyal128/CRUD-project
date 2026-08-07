package in.SpringBoot.Filters.Service;

import in.SpringBoot.Filters.Entity.Student;
import org.springframework.stereotype.Service;

@Service
public class studentService {

    public void createStudent(Student student) {
        System.out.println("Student Created");
        System.out.println(student.getName());
        System.out.println(student.getEmail());

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
