import box.BoxContainer;
import peasy.PeasyCam;
import processing.core.PApplet;

public class Main extends PApplet {
	PeasyCam cam;
	BoxContainer container;

	int dimension = 20;
	int boxSize = 5;

	public void setup() {
		size(600, 600, OPENGL);
		frameRate(300);
		colorMode(RGB, 255);

		container = new BoxContainer(this, dimension, boxSize);
		cam = new PeasyCam(this, 200);

		randomize();
	}

	private void randomize() {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				for (int k = 0; k < dimension; k++) {
					float randomNr = random(2);
					if (randomNr > 0.5) {
						container.boxes[i][j][k].setVisible(false);
					} else {
						container.boxes[i][j][k].setVisible(true);
					}
				}
			}
		}
	}

	float rot = 0.0f;

	public void draw() {
		rot += 0.01;
		background(0);
		defineLights(false);
		pushMatrix();
		rotateX(rot);
		rotateZ(rot);
		translate(-50, -50, -50);
		container.draw();
		popMatrix();
	}

	/**
	 * todo: color scheme generator benutzen und mit licht spielen um die szene
	 * rotieren.
	 */
	void defineLights(boolean rotate) {
		if (rotate) {
			pushMatrix();
			rotateX(rot);
			rotateZ(rot);
		}

		// point light on the right
		//pointLight(330, 56, 46, // Color
		//		200, -150, 0); // Position

		//  directional light from the left
		directionalLight(255, 255, 49, // Color
				1, 0, 0); // The x-, y-, z-axis direction

		// Yellow spotlight from the front
		//spotLight(72, 56, 54, // Color
		//		0, 40, 200, // Position
		//		0, -0.5f, -0.5f, // Direction
		//		PI / 2, 2); // Angle, concentration

		if (rotate) {
			popMatrix();
		}
	}

	public void keyPressed() {
		randomize();
	}
}
