package in.springboot.CRUD_DTO_Demo.DTO;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDTO {
    @NotBlank(message = "Name can not be Null/Empty or blank")
    @Size(min = 2, max = 50, message = "Student name must be 2 to 50 character long")
    private String name;

    @NotBlank(message = "Student Email Cannot be blank")
    @Email(message = "Email must be valid")
    private String email;

    private String Subject;
    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Student Must Be atleast 18 years old" )
    private int age;

    private int mobileNo;
    @NotNull(message = "RollNo is required")
    private Long rollNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getRollNo() {
        return rollNo;
    }

    public void setRollNo(Long rollNo) {
        this.rollNo = rollNo;
    }
}
