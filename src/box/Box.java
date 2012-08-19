package box;

import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

public class Box {
	private PVector location;
	private PApplet parent;
	private int boxSize;

	private boolean visible;

	public Box(PApplet p, PVector location, int boxSize) {
		this.parent = p;
		this.location = location;
		this.boxSize = boxSize;
		this.visible = true;
	}

	public void draw() {
		if (visible) {
			parent.pushMatrix();
			parent.noStroke();
			parent.fill(120);
			parent.translate(location.x, location.y, location.z);
			parent.box(boxSize);
			parent.popMatrix();
		}
	}
	
	public void setVisible(boolean state){
		this.visible = state;
	}
}
