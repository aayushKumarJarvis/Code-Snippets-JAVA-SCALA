
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class MouseEventListener extends JPanel implements MouseListener,ActionListener {

    private static float xCordniateONE, yCordinateONE, xCordinateTWO, yCordinateTWO,a=1;
    private static int count=0;
    Color colour;

    public MouseEventListener() {

        super();
        addMouseListener(this);
    }

    public void paint(Graphics g) {

        if(count == 2){

            drawGraphics(g, xCordniateONE, yCordinateONE, xCordinateTWO, yCordinateTWO, colour);

            count=0;

            xCordniateONE =0;
            yCordinateONE =0;
            xCordinateTWO =0;
            yCordinateTWO =0;
        }
    }
    void drawGraphics(Graphics g, float x0, float y0, float x1, float y1, Color colour) {

        float dx = x1 - x0;
        float dy = y1 - y0;

        int sx = dx > 0 ? 1 : -1;
        int sy = dy > 0 ? 1 : -1;

        dx = dx*sx;
        dy = dy*sy;

        float dxdy = dx/dy;
        float dydx = dy/dx;

        dxdy *= sx;
        dydx *= sy;

        float py = y0;
        float px = x0;

        if( dx > dy ) {

            for(int x=0; x<dx; x++) {

                setPixel( g, (int)px, (int)py, colour);
                px+=sx;
                py+=dydx;
            }
        }

        else {

            for(int y=0; y<dy; y++) {

                setPixel(g, (int)px, (int)py, colour);
                py+=sy;
                px+=dxdy;
            }
        }

    }

    public void setPixel(Graphics g, int x, int y, Color color ) {

        g.setColor(Color.RED);
        g.fillRect(x, y, 1,1);

    }

    public void mouseClicked(MouseEvent mouse){

        count++;

        if(count==1){
            xCordniateONE =mouse.getX();
            yCordinateONE =mouse.getY();
        }

        if(count==2){
            xCordinateTWO = mouse.getX();
            yCordinateTWO = mouse.getY();
        }

        repaint();
    }

    public void mouseEntered(MouseEvent mouse){ }
    public void mouseExited(MouseEvent mouse){ }
    public void mousePressed(MouseEvent mouse){ }
    public void mouseReleased(MouseEvent mouse){ }

    public static void main(String arg[]){
        JFrame frame = new JFrame("MousePanel");
        frame.setSize(640,640);

        MouseEventListener panel = new MouseEventListener();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }
}