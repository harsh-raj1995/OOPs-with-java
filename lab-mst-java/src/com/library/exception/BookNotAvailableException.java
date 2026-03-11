public class BookNotAvailableException extends Exception {
  public BookNotAvailableException(String message) {
    //when available copies=0
    super(message);
  }  
}
