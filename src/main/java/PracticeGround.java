
public class PracticeGround {

    public void finalize() {
        System.out.println("Object has been garbage collected");
    }

    public static void main(String args[]) {

        PracticeGround ob1 = new PracticeGround();
        PracticeGround ob2 = new PracticeGround();

        ob1 = null;
        ob2 = null;

        System.gc();
    }
}
