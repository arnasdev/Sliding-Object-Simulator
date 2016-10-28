import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		MainApp theApp = new MainApp();
		theApp.start();
	}

	private void start() {
		calculationInput();
	}
	
	private void calculationInput(){
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("\nEnter object mass");
		float mass = keyboard.nextFloat();

		System.out.print("\nEnter object position");
		System.out.print("\nx\n");
		float xPos = keyboard.nextFloat();
		System.out.print("\ny\n");
		float yPos = keyboard.nextFloat();
		System.out.print("\nz\n");
		float zPos = keyboard.nextFloat();
		Vector3 position = new Vector3(xPos,yPos,zPos);
		
		System.out.print("\nEnter normal hat");
		System.out.print("\nx\n");
		float xNormal = keyboard.nextFloat();
		System.out.print("\ny\n");
		float yNormal = keyboard.nextFloat();
		System.out.print("\nz\n");
		float zNormal = keyboard.nextFloat();
		Vector3 normal = new Vector3(xNormal,yNormal,zNormal);
		
		System.out.print("\nEnter kinetic friction\n");
		float kFriction = keyboard.nextFloat();

		System.out.print("\nEnter static friction\n");
		float sFriction = keyboard.nextFloat();
		
		System.out.print("\nEnter step size\n");
		float stepSize = keyboard.nextFloat();
		
		System.out.print("\nEnter steps\n");
		int steps = keyboard.nextInt();
		
		Vector3 velocity = new Vector3();
		
		String output = "";
		Setup setup = new Setup();
		
		output = setup.start(mass, position, velocity, normal, kFriction, sFriction, stepSize, steps);
		System.out.println(output);
		
		//writing string to a file encoded as modified UTF-8 
	      DataOutputStream dos;
		try {
			File file = new File("C:/temp/physics_output.txt");
			file.getParentFile().mkdirs();
			if(!file.exists()){
				file.createNewFile();
			}
			
		    FileWriter fw = new FileWriter( file.getAbsoluteFile( ) );
		    BufferedWriter bw = new BufferedWriter( fw );
		    bw.write( output );
		    bw.close( );
		} 
		catch (IOException e){
			e.printStackTrace();
		}
	}

}
