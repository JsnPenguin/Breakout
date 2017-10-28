/*
 * Name: Justin Peng
 * Section Leader: Katherine Erdman
 * Displays a picture of the beach
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Artistry2 extends GraphicsProgram {
	public void run() {
			drawSky();
			drawBeach();
			drawOcean();
			drawSun();
			drawName();
	}
	private void drawOcean() {
		GRect ocean = new GRect(0, getHeight()/2, getWidth(), getHeight()*(2.0/3.0) - getHeight()/2);
		ocean.setFilled(true);
		ocean.setFillColor(new Color(51,51,255));
		add(ocean);
	}
	private void drawSky() {
		 setBackground(new Color(0,204,255));
	}
	private void drawBeach() {
		GRect sand = new GRect (0, getHeight()*(2.0/3.0),getWidth(),getHeight()*(1.0/3.0));
		sand.setFilled(true);
		sand.setFillColor(new Color(255,221,153));
		add(sand);
	}
	private void drawSun() {
		GLine ray1 = new GLine(0,getHeight()*(3.0/20.0)+getHeight()*(1.0/10.0), getWidth()*(2.0/5.0),getHeight()*(3.0/20.0)+getHeight()*(1.0/10.0));
		add(ray1);
		GLine ray2 = new GLine(getWidth()*(1.0/5.0),0,getWidth()*(1.0/5.0),getHeight()*(3.0/5.0));
		add(ray2);
		GOval sun = new GOval(getWidth()*(1.0/10.0),getHeight()*(1.0/10.0),getWidth()*(1.0/5.0),getWidth()*(1.0/5.0));
		sun.setFilled(true);
		sun.setFillColor(Color.YELLOW);
		add(sun);
	}
	private void drawName() {
		GLabel name = new GLabel("Artistry by Justin Peng", getWidth()*(8.35/10.0), getHeight()*(9.9/10.0) );
		add(name);
	}
}
