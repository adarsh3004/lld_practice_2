package practice.cache_lld.exception;

public class StorageFullException extends RuntimeException{

    public StorageFullException(String message) {
        super(message);
    }
}
