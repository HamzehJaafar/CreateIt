 

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Assignment extends JFrame implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    public static ArrayList<GraphElement> graphArray = new ArrayList<GraphElement>();
    private static final int FRAME_WIDTH = 900;
    private static final int FRAME_HEIGHT = 400;
    public static int selected;
    public static JFrame frame = new JFrame();
    public static JTextField text = new JTextField(12);

    public static int clicked = 0;

    /**
     * Main Method initializes JFrame which includes JButtons (Rectangle,
     * Ellipse, Edge, and Label ) also includes JTextField and JPanels. This
     * method initializes ActionListeners for the JButtons and
     * MouseListeners/MouseMotionListener
     * 
     */
    public static void main(String[] args) {
        frame.setLayout(new BorderLayout());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Assignment1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel menu = new JPanel();
        JPanel lower = new JPanel();
        GraphElement element = new Edge(0, 0);
        graphArray.add(0, element);
        text.setSize(300, 40);
        selected = -1;
        JPanel main = new JPanel();

        // Menu Buttons
        JButton recButton = new JButton("Rectangle");
        JButton ellButton = new JButton("Ellipse");
        JButton edgButton = new JButton("Edge");
        JButton labButton = new JButton("Label");
        // Add Butons to upper panel
        menu.add(recButton);
        menu.add(ellButton);
        menu.add(edgButton);
        // Add LabelButton and TextField to lower panel
        lower.add(labButton);
        lower.add(text);

        // Set the upper panels
        main.setLayout(new BorderLayout());
        main.add(menu, BorderLayout.NORTH);
        main.add(lower, BorderLayout.SOUTH);
        frame.add(main, BorderLayout.NORTH);
        // Mouse to select
        MouseListener l = new Assignment();
        Assignment.frame.addMouseListener(l);
        // Mouse to move once selected
        MouseMotionListener mlistener = new Assignment();
        Assignment.frame.addMouseMotionListener(mlistener);

        // Button Listener
        ActionListener listener = new ButtonListener();
        // Rectangle button action listener
        recButton.addActionListener(listener);
        // Ellipse button action listener
        ellButton.addActionListener(listener);
        // Edge button action listener
        edgButton.addActionListener(listener);

        // Label Button Function
    
        labButton.addActionListener(listener);
        // Set frame visible
        frame.setVisible(true);
    }
     /**
     * mouseClicked checks for mouse clicks in the JFrame for selecting 
     * and deselecting GraphElement objects
     * @param  e   MouseEvent the indicates the action of the mouse
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        int x = e.getX();
        int y = e.getY();
        for (int i = 0; i < graphArray.size(); i++) {
            graphArray.get(i).selected = false;

        }
        for (int i = 0; i < graphArray.size(); i++) {

            if (graphArray.get(i).isClicked(x, y)) {

                graphArray.get(i).selected = true;
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

     /**
    * mousePressed checks for right click mouse action and for a selected 
    * GraphElement object and if both are true it deletes the object.
    * @param  e   MouseEvent the indicates the action of the mouse
    */
    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < graphArray.size(); i++) {
            if (graphArray.get(i).selected) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    graphArray.remove(i);
                    repaint();
                    frame.revalidate();
                }
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
     /**
     * mouseDragged moves a selected GraphElement object around in the JFrame
     * @param  e   MouseEvent the indicates the action of the mouse.
     */
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        int x = e.getX();
        int y = e.getY();

        for (int i = 0; i < graphArray.size(); i++) {
            if (graphArray.get(i).selected) {
                if (!graphArray.get(i).applyLabel())
                    return;
                graphArray.get(i).moveTo(x, y);
                frame.revalidate();
                frame.repaint();
            }
        }

    }
    @Override
    public void mouseMoved(MouseEvent e) {}
}
