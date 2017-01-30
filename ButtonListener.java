 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ButtonListener implements ActionListener {
	boolean enabled = true;
	public String source = "";
	int x, y;

	/**
	 * Listens for button presses and performs an action depending on which
	 * button was pressed.
	 * 
	 * @param e
	 *            Button action event that indicates the action of the button
	public void actionPerformed(ActionEvent e) {
		
		// gets button type (Rectangle,)
		source = e.getActionCommand();

		if (source.equals("Rectangle")) {
			if (Assignment.clicked == 1)
				return;
			MouseListener listener = new RectangleListener();
			Assignment.frame.addMouseListener(listener);
			Assignment.clicked = 1;
		}

		else if (source.equals("Ellipse")) {
			if (Assignment.clicked == 1)
				return;
			MouseListener listener = new EllipseListener();
			Assignment.frame.addMouseListener(listener);
			Assignment.clicked = 1;
		}

		else if (source.equals("Edge")) {
			if (Assignment.clicked == 1)
				return;
			MouseListener listener = new EdgeListener();
			Assignment.frame.addMouseListener(listener);
			MouseMotionListener edgL = (MouseMotionListener) listener;
			Assignment.frame.addMouseMotionListener(edgL);
			Assignment.clicked = 1;

		} else if (source.equals("Label")) {
			for (int i = 0; i < Assignment.graphArray.size(); i++) {
				if (Assignment.graphArray.get(i).selected) {
					if (Assignment.graphArray.get(i).applyLabel()) {
						Assignment.graphArray.get(i).setLabel(Assignment.text.getText());
						Assignment.frame.repaint();
					}
				}

			}
		}

	}

}
