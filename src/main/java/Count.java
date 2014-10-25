import java.awt.*;
import java.awt.event.*;

public class Count extends Frame {

    Label label = new Label("Counter");
    TextField textField = new TextField("0", 10);

    Button upCounter = new Button("Count Up");
    Button downCounter = new Button("Count Down");
    Button resetOption = new Button("Reset");

    public static int count=0;

    Frame f= new Frame();

    public Count() {


        FlowLayout x= new FlowLayout();

        f.setLayout(x);
        f.setSize(400,100);
        f.setTitle("AWT Counter");
        f.setVisible(true);
        f.add(label);
        f.add(textField);
        f.add(upCounter);
        f.add(downCounter);
        f.add(resetOption);

        upCounter.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        count++;
                        textField.setText(Integer.toString(count) + " ");
                    }
                }
        );

        downCounter.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        count--;
                        textField.setText(Integer.toString(count) + " ");
                    }
                }
        );

        resetOption.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        count = 0;
                        textField.setText(Integer.toString(count) + " ");
                    }
                }
        );


        f.addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e)
                    {
                        f.dispose();
                    }
                });
    }

    public static void main(String args[]) {

        new Count();
    }
}