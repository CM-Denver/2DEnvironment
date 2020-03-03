package landscape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class DrawStuff extends JComponent {

	//Sets the size of the sprite (height and width are the same).
	public int size;
	
	void setSize(int size) {
		this.size = size;
	}

	//Displays the background and sprite to JFrame.
	public void paint(Graphics g) {
		
		Graphics2D graph2 = (Graphics2D)g;
		graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//Draws background.
		g.drawImage(Landscape.imageLandscape, 0, 0, this);
		
		//Draws sprite (circle). Subtracts x,y location by half the objects size to line up the 
		//actual x,y location with the center of the circle instead of the corner.
		Shape drawEllipse = new Ellipse2D.Float(Location.x - (size / 2), Location.y - (size / 2), size, size);
		graph2.draw(drawEllipse);
		graph2.setPaint(Color.GRAY);
		graph2.fill(drawEllipse);
		
	}
}
