import java.awt.*;
import java.awt.event.*;

public class MultipleEventHandling extends Frame {

    Label labelForCounter = new Label("Counter");
    TextField text = new TextField("0", 10);

    Button buttonONE = new Button("Count Up");
    Button buttonTWO = new Button("Count Down");
    Button buttonTHREE = new Button("Reset");

    public static int count=0;

    public MultipleEventHandling() {

        FlowLayout flowLayout= new FlowLayout();
        Frame frame= new Frame();
        frame.setLayout(flowLayout);

        frame.setSize(400, 200);
        frame.setTitle("AWT Counter");
        frame.setVisible(true);

        frame.add(text);

        frame.add(buttonONE);
        frame.add(buttonTWO);
        frame.add(buttonTHREE);

        buttonONE.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        count++;
                        text.setText(Integer.toString(count) + " ");
                    }
                }
        );

        buttonTWO.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        count--;
                        text.setText(Integer.toString(count) + " ");
                    }
                }
        );

        buttonTHREE.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        count = 0;
                        text.setText(Integer.toString(count) + " ");
                    }
                }
        );
    }
    public static void main(String args[]) {

        new MultipleEventHandling();
    }
}