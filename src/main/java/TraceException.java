
public class TraceException extends Exception {

    private String displayMessage = null;

    public TraceException() {
        displayMessage = "Trace is defined only for square matrix.";
        System.out.println(displayMessage);
    }
}


