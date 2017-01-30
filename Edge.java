 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

/**
 * Edge class draws a line given two points.
 * 
 * @author Hamzeh Jaafar
 * @studentID 5006936919
 * @version 1.0
 */

public class Edge extends GraphElement {
	private int x2, y2;
	Line2D.Double segment;

	/**
	 * Constructor for Edge class, initializes a edge object given intial point.
	 * 
	 * @param x
	 *            X cordinate for start of the line
	 * @param y
	 *            Y cordinate for start of the line
	 */
	public Edge(int x, int y) {
		super(x, y);
		this.x2 = x;
		this.y2 = y;
	}

	/**
	 * Draw method draws and updates the line.
	 * 
	 * @param g2
	 *            Graphics2D object of frame
	 * @return void return nothing
	 */
	@Override
	void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.setColor(color);
		Point2D.Double from = new Point2D.Double(this.getXPos(), this.getYPos());
		Point2D.Double to = new Point2D.Double(x2, y2);
		segment = new Line2D.Double(from, to);
		g2.drawLine((int) this.getXPos() - 8, (int) this.getYPos() - 96, (int) x2 - 8, (int) y2 - 96);

	}

	/**
	 * Checks if a given point lies on the line or near it.
	 * 
	 * @param x
	 *            X cordinate for point to check
	 * @param y
	 *            Y cordinate for point to check
	 * @return whether the point lies on the line or not
	 */
	@Override
	boolean isClicked(double x, double y) {

		if (segment.ptLineDist(x, y) < 10 && segment.ptLineDist(x, y) > -10) {
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
	 *
	 * @return whether this object can have a label
	 */
	@Override
	boolean applyLabel() {

		return false;
	}

	/**
	 * Moves the second point of line to given point
	 * 
	 * @param x
	 *            X cordinate for second point of line
	 * @param y
	 *            Y cordinate for second point of line
	 * @return nothing
	 */
	public void moveTo(int x, int y) {
		x2 = x;
		y2 = y;
	}
}

/**
 * EdgeListener class contains mouse listeners for the GraphDrawComponent.
 * 
 * @author Hamzeh Jaafar
 * @studentID 5006936919
 * @version 1.0
 */
class EdgeListener implements MouseListener, MouseMotionListener {
	private int x, y, x2, y2;
	boolean enabled = true, enabler2 = true;
	private GraphDrawComponent edg;
	boolean done = false;

	/**
	 * mousePressed initializes the edge component with initial point thats the
	 * location where the mouse was pressed
	 * @param e
	 *            MouseEvent the indicates the action of the mouse
	 */
	@Override
	public void mousePressed(MouseEvent e) throws NullPointerException {
		if (!enabler2) {
			return;
		}
		x = e.getX();
		y = e.getY();
		edg = new GraphDrawComponent(x, y, "Edge");
		Assignment.frame.add(edg);
		edg.revalidate();
		enabler2 = false;

	}

	/**
	 * mouseReleased finalizes the edge component with the second point at the
	 * point where the mouse was released
	 * 
	 * @param e
	 *            MouseEvent the indicates the action of the mouse
	 */
	@Override
	public void mouseReleased(MouseEvent e) {

		if (!enabled) {
			return;
		}
		x2 = e.getX();
		y2 = e.getY();
		edg.newCords(x2, y2);
		edg.repaint();
		edg.revalidate();
		enabled = false;
		Assignment.clicked = 0; // Allows another button to get pressed
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

	/**
	 * mouseDragged follows the mouse and updates the second point of the edge
	 * component with the x and y cordinate of where the mouse is being dragged
	 * 
	 * @param e
	 *            MouseEvent the indicates the action of the mouse
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if (!enabled) {
			return;
		}
		x2 = e.getX();
		y2 = e.getY();
		edg.newCords(x2, y2);
		edg.repaint();
		edg.revalidate();

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

}