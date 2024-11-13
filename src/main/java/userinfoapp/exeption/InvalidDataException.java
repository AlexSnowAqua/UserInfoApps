package userinfoapp.exception;

public class InvalidDataException extends Exception {

    // Конструктор с сообщением
    public InvalidDataException(String message) {
        super(message);
    }

    // Конструктор с сообщением и причиной
    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}

