 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

/**
 * EllipseNode class draws an Ellipse given two points and a predefined height
 * and width.
 * 
 * @author Hamzeh Jaafar
 * @studentID 5006936919
 * @version 1.0
 */
public class EllipseNode extends GraphElement {
	private Ellipse2D.Double e;
	private static final int ELLIPSE_WIDTH = 100;
	private static final int ELLIPSE_HEIGHT = 50;

	/**
	 * Constructor for EllipseNode class, this initializes a ellipse object
	 * given x and y cordinate.
	 * 
	 * @param x
	 *            X cordinate for the top left corner of ellipse
	 * @param y
	 *            Y cordinate for the top left corner of ellipse
	 **/
	public EllipseNode(int x, int y) {
		super(x, y);
	}

	/**
	 * Draw method draws and updates the Ellipse object.
	 * 
	 * @param g2
	 *            Graphics2D object of frame
	 * @return void nothing
	 */
	@Override
	void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.setColor(color);
		e = new Ellipse2D.Double((int) getXPos(), (int) getYPos(), ELLIPSE_WIDTH, ELLIPSE_HEIGHT);
		g2.drawOval((int) e.x - 8, (int) e.y - 96, (int) e.width, (int) e.height);
		g2.drawString(this.getLabel(), (int) getXPos() + 10, (int) getYPos() - 65);

	}

	/**
	 * Checks if a given point lies on the Ellipse.
	 * 
	 * @param x
	 *            X cordinate for point to check
	 * @param y
	 *            Y cordinate for point to check
	 * @return whether the point lies on the Ellipse or not.
	 */
	@Override
	boolean isClicked(double x, double y) {
		if (e.contains(x, y)) {
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
		return true;
	}

}

/**
 * EllipseListener class contains mouse listeners for the GraphDrawComponent.
 * 
 * @author Hamzeh Jaafar
 * @studentID 5006936919
 * @version 1.0
 */
class EllipseListener implements MouseListener {
	private int x, y;
	boolean enabled = true;
	private GraphDrawComponent e2;

	/**
	 * mousePressed creates the ellipse component at the point where the mouse
	 * was pressed.
	 * 
	 * @param e
	 *            MouseEvent the indicates the action of the mouse
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
		e2 = new GraphDrawComponent(x, y, "Ellipse");
		Assignment.frame.add(e2, BorderLayout.CENTER);
		e2.revalidate();
		enabled = false;
		Assignment.clicked = 0; // Allows another button to get pressed
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