package in.springboot.CRUD_DTO_Demo.Exception;

public class DublicateResourceException extends RuntimeException {

    public DublicateResourceException(String message) {
        super(message);
    }
}
