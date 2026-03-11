public class BookNotFoundException extends Exception {
  public BookNotFoundException(String message) {
    //if book doesnt exist
    super(message);
  }
  
}
