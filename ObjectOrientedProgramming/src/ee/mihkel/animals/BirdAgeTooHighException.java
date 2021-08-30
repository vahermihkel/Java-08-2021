package ee.mihkel.animals;

public class BirdAgeTooHighException extends Exception {
    public BirdAgeTooHighException(String message) {
        super(message);
    }
}
