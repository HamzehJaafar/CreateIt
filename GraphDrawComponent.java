 

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * GraphDrawComponent contains components of RectangleNode, EllipseNode and Edge
 * classes for Jframe
 * 
 * @author Hamzeh Jaafar
 * @version 1.0
 */
public class GraphDrawComponent extends JComponent {

	private EllipseNode ell;
	private RectangleNode rec;
	private Edge line;

	/**
	 * Constructor for GraphDrawComponent class, this initializes either a
	 * Rectangle, a Ellipse or an Edge depending on given type
	 * 
	 * @param x
	 *            X cordinate where the mouse was clicked
	 * @param y
	 *            Y cordinate where the mouse was clicked
	 * @param type
	 *            The component type to be created
	 **/

	public GraphDrawComponent(int x, int y, String type) {

		for (int i = 0; i < Assignment.graphArray.size(); i++) {
			Assignment.graphArray.get(i).selected = false;
			Assignment.frame.repaint();
		}
		if (type.equals("Ellipse")) {
			ell = new EllipseNode(x, y);
			repaint();
			Assignment.graphArray.add(ell);
		}
		if (type.equals("Rectangle")) {

			rec = new RectangleNode(x, y);
			repaint();
			Assignment.graphArray.add(rec);
		}
		if (type.equals("Edge")) {

			line = new Edge(x, y);
			repaint();
			Assignment.graphArray.add(line);
		}
	}

	private static final long serialVersionUID = 1L;

	/**
	 * Moves GraphElement object to a new location given point.
	 * 
	 * @param x
	 *            X cordinate where the object will be moved to.
	 * @param y
	 *            Y cordinate where the object will be moved to.
	 * @return void nothing
	 */
	public void newCords(int x, int y)

	{
		line.moveTo(x, y);
		repaint();
		revalidate();
	}

	/**
	 * Paint method for the graphic interface and paints the components into the
	 * JFrame
	 * 
	 * @param g
	 *            The graphics object GUI.
	 * @return void nothing
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (GraphElement graphArray : Assignment.graphArray) {
			graphArray.draw(g2);
		}
	}
}
