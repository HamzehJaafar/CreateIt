 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
/**
 * RectangleNode class draws a Rectangle given two points 
 * and a predefined height and width.
 * 
 * 
 * @author Hamzeh Jaafar
 * @version 1.0
 */
public class RectangleNode extends GraphElement {

	private Rectangle r;
	int count = 0;
	private static final int REC_WIDTH = 100;
	private static final int REC_HEIGHT = 50;
	/**
	 * Constructor for RectangleNode class, this initializes a Rectangle object
	 * given x and y cordinate.
	 * 
	 * @param x
	 *            X cordinate for the top left corner of the Rectangle
	 * @param y
	 *            Y cordinate for the top left corner of the Rectangle
	 **/
	
	public RectangleNode(int i, int j) {

		super(i, j);

	}
	/**
	 * Draw method draws and updates the Rectangle object.
	 * 
	 * @param g2
	 *            Graphics2D object for frame
	 * @return void nothing
	 */
	@Override
	void draw(Graphics2D g2) {

		g2.setColor(color);
		r = new Rectangle((int) getXPos() + 1, (int) getYPos(),REC_WIDTH , REC_HEIGHT);
		g2.drawRect(r.x - 8, r.y - 96, r.width, r.height);
		g2.drawString(this.getLabel(), (int) getXPos(), (int) getYPos() - 70);

	}
	/**
	 * Checks if a given point lies on the Rectangle.
	 * 
	 * @param x
	 *            X cordinate for point to check
	 * @param y
	 *            Y cordinate for point to check
	 * @return whether the point lies on the Rectangle or not.
	 */
	@Override
	public boolean isClicked(double x, double y) {

		if (r.contains(x, y)) {
			this.setColor(Color.BLUE);
			Assignment.frame.repaint();
			return true;
		} else {
			this.setColor(Color.BLACK);
			Assignment.frame.repaint();
			return false;
		}

	}
	/**
	 * Checks if object allows label to be applied
	 * 
	 * @return whether this object can have a label
	 */
	@Override
	boolean applyLabel() {
		// TODO Auto-generated method stub
		return true;
	}

}
/**
 * RectangleListener class contains mouse listener for the GraphDrawComponent.
 * 
 * @author Hamzeh Jaafar
 * @studentID 5006936919
 * @version 1.0
 */
class RectangleListener implements MouseListener {
	private int x, y;
	boolean enabled = true;
	private GraphDrawComponent r2;

	/**
	 * mousePressed creates the Rectangle component at the point where the mouse
	 * was pressed.
	 * @param e
	 *            MouseEvent that indicates the action of the mouse
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (!enabled) {
			return;
		}
		
		if (e.getY() < 98)
			return;
		x = e.getX();
		y = e.getY();
		r2 = new GraphDrawComponent(x, y, "Rectangle");
		Assignment.frame.add(r2);
		r2.revalidate();
		enabled = false;
		Assignment.clicked = 0;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
