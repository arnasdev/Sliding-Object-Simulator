import java.util.ArrayList;

public class Object {
	// Object
	private float mass;

	// Initial Conditions
	private Vector3 position;
	private Vector3 velocity;
	private Vector3 normal;
	private float kineticFriction;
	private float staticFriction;

	// Printout
	private Vector3 forceGravity;
	private Vector3 forceGravityNormal;
	private Vector3 forceGravityPlane;
	private Vector3 forceNormal;
	private Vector3 downhill;
	private float c;
	private Vector3 netForce;
	
	// Holds a value to determine 
	
	// Constructor taking in all information to do with an object
	public Object(float mass, Vector3 position, Vector3 velocity, Vector3 normal, float kineticFriction, float staticFriction) {
		this.mass = mass;
		this.position = position;
		this.velocity = velocity;
		this.normal = normal;
		this.kineticFriction = kineticFriction;
		this.staticFriction = staticFriction;
	}

	// Blank object
	public Object(){
	}
	
	/**
	 *	Below methods are for calculating various attributes of the object	 
	 **/
	
	// Returns acceleration of the object in Vector form by using acceleration formula + initial acceleration
	// A = 1/M * Fnet
	public Vector3 CalculateAcceleration(){
		float friction = staticFriction;
		
		Vector3 forceGravity = Vector3.Multiply(new Vector3(0,0,-1),this.mass*9.81f);
		this.forceGravity = forceGravity;
		
		Vector3 forceGravityNormal = Vector3.Multiply(normal, Vector3.dotProduct(forceGravity, normal));
		this.forceGravityNormal = forceGravityNormal;
		
		Vector3 forceGravityPlane = Vector3.Subtract(forceGravity, forceGravityNormal);
		this.forceGravityPlane = forceGravityPlane;
		
		Vector3 forceNormal = Vector3.Multiply(forceGravityNormal, -1);
		this.forceNormal = forceNormal;
		
		float forceGravityPlaneLength = forceGravityPlane.getMagnitude();
		
		float forceNormalLength = forceNormal.getMagnitude();
		
		Vector3 downhill = forceGravityPlane.getDirection();
		this.downhill = downhill;
		
		float c = forceGravityPlaneLength - (friction * forceNormalLength);
		this.c = c;
		
		Vector3 netForce;
		if(c >= 0){
			friction = kineticFriction;
			c = forceGravityPlaneLength - (friction * forceNormalLength);
			netForce = Vector3.Multiply(downhill, c);
		}
		else{
			c = 0;
			netForce = new Vector3();
		}
		this.netForce = netForce;
		
		Vector3 acceleration = Vector3.Multiply(netForce, 1/mass);
		
		return acceleration;
	}

	/** 
	 *	Getters & Setters
	 **/
	
	public float getMass() {
		return mass;
	}

	public void setMass(float mass) {
		this.mass = mass;
	}

	public Vector3 getPosition() {
		return position;
	}

	public void setPosition(Vector3 position) {
		this.position = position;
	}

	public Vector3 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector3 velocity) {
		this.velocity = velocity;
	}

	public String print() {
		String output = "";
		/**
		 * 	// Printout
			private Vector3 forceGravity;
			private Vector3 forceGravityNormal;
			private Vector3 forceGravityPlane;
			private Vector3 forceNormal;
			private Vector3 downhill;
			private float c;
			private Vector3 netForce;
		 */
		output += "\nForce of gravity: "+forceGravity;
		output += "\nForce of gravity in normal: "+forceGravityNormal;
		output += "\nForce of gravity in plane: "+forceGravityPlane;
		output += "\nForce of normal: "+forceNormal;
		output += "\nDownhill vector hat: "+downhill;
		output += "\nc: "+c;
		output += "\nNet force: "+netForce;
		return output;
	}
	
}
