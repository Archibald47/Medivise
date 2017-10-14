package utils;

public class ValidationError extends Exception {

    public ValidationError() {
        super();
        }

    public ValidationError(String message)
    {
       super(message);
    }
}
