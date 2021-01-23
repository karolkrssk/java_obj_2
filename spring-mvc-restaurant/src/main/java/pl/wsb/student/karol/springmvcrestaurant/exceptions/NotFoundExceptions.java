package pl.wsb.student.karol.springmvcrestaurant.exceptions;

public class NotFoundExceptions extends Exception {
    public NotFoundExceptions() {
        super("Not Found");
    }

    public NotFoundExceptions(String message) {
        super(message);
    }
}
