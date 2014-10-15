
public class AdditionException extends Exception {

    private String displayMessage = null;

    public AdditionException() {
        displayMessage = "Addition is not possible";
        System.out.println(displayMessage);
    }
}
