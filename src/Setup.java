// TODO ADD TIME

// Class which takes data from the input fields, converts it to objects and begins euler's
import java.util.ArrayList;

public class Setup {

	public Setup(){
	}
	public String start(float mass, Vector3 position, Vector3 velocity, Vector3 normal, float kineticFriction, float staticFriction, float stepSize, int steps) {
		// Projectile
		Object ball = new Object(mass, position, velocity, normal, kineticFriction, staticFriction);
		String output = "";
		Euler c = new Euler(stepSize, ball, 0);
		output = c.InitiateWithSteps(steps);
			
		// Returns data
		return output;
	}

}
