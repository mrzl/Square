package box;

import processing.core.PApplet;
import processing.core.PVector;

public class BoxContainer {
	private PApplet parent;

	public Box[][][] boxes;
	private int dimension;

	public BoxContainer(PApplet p, int dimension, int boxSize) {
		this.parent = p;
		
		boxes = new Box[dimension][dimension][dimension];
		this.dimension = dimension;

		initBoxes(dimension, boxSize);
	}

	private void initBoxes(int dimension, int boxSize) {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				for (int k = 0; k < dimension; k++) {
					boxes[i][j][k] = new Box(parent, new PVector(i * boxSize, j
							* boxSize, k * boxSize), boxSize);
				}
			}
		}
	}

	public void draw() {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				for (int k = 0; k < dimension; k++) {
					boxes[i][j][k].draw();
				}
			}
		}
	}
	
}
