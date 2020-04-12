package rubiksCube;

import java.util.Scanner;

public class CubeApp {

	public static void assignFace(char[][] face, String name) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(name + "[" + i + "][" + j + "]");
				face[i][j] = IO.readChar();
			}
		}
	}

	public static String generateScramble() {
		String[] moves = { "F", "F'", "L", "L'", "R", "R'", "U", "U'", "D", "D'", "B", "B'", "x", "y", "z" };
		String output = "";
		for (int i = 0; i < 20; i++) {
			int index = (int) (Math.random() * 15);
			output += moves[index] + " ";
		}
		return output;
	}

	public static void cubeScrambler() {
		System.out.println();
		System.out.println("Welcome to the Rubik's Cube scramble generator. What would you like to do?");
		System.out.println("1. Generate a scramble");
		System.out.println("2. Exit the program");
		System.out.println();
		System.out.println("Enter \"1\" or \"2\"");

		int choice = -1;
		Scanner myScanner = new Scanner(System.in);
		choice = myScanner.nextInt();
		while (true) {
			if (choice == 2) {
				System.out.println("Exiting the program");
				return;
			} else if (choice == 1) {
				System.out.println("Here is a scramble:");
				System.out.println(generateScramble());
				System.out.println();
				System.out.println("What would you like to do?");
				System.out.println("1. Generate another scramble");
				System.out.println("2. Exit the program");
				choice = myScanner.nextInt();
			} else {
				System.out.println("Enter \"1\" or \"2\"");
				choice = myScanner.nextInt();
			}
		}
	}

	public static void cubeSimulator() {
		System.out.println("Welcome to the Rubik's Cube simulator.");
		System.out.println("Enter a string to perform a move.");
		System.out.println();
		System.out.println(
				"Here is a list of viable strings and their corresponding moves. Their prime counterparts are not shown.");
		System.out.println("|| String | Move  || String | Move         || String | Move       ||");
		System.out.println("|| \"U\"    | Up    || \"u\"    | Double up    || \"M\"    | Middle     ||");
		System.out.println("|| \"D\"    | Down  || \"d\"    | Double down  || \"E\"    | Equatorial ||");
		System.out.println("|| \"R\"    | Right || \"r\"    | Double right || \"S\"    | Standing   ||");
		System.out.println("|| \"L\"    | Left  || \"l\"    | Double left  || \"x\"    | Rotate X   ||");
		System.out.println("|| \"F\"    | Front || \"f\"    | Double front || \"y\"    | Rotate Y   ||");
		System.out.println("|| \"B\"    | Back  || \"b\"    | Double back  || \"z\"    | Rotate Z   ||");
		System.out.println(
				"Visit https://ruwix.com/the-rubiks-cube/notation/advanced/ to get an indepth overview of valid moves.");
		System.out.println();
		System.out.println("Type \"Exit\" to leave the program.");
		System.out.println();

		char[][] left = { { 'G', 'G', 'G' }, { 'G', 'G', 'G' }, { 'G', 'G', 'G' } };
		char[][] front = { { 'R', 'R', 'R' }, { 'R', 'R', 'R' }, { 'R', 'R', 'R' } };
		char[][] right = { { 'B', 'B', 'B' }, { 'B', 'B', 'B' }, { 'B', 'B', 'B' } };
		char[][] up = { { 'W', 'W', 'W' }, { 'W', 'W', 'W' }, { 'W', 'W', 'W' } };
		char[][] down = { { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' } };
		char[][] back = { { 'O', 'O', 'O' }, { 'O', 'O', 'O' }, { 'O', 'O', 'O' } };

		RubiksCube cube = new RubiksCube(left, front, right, up, down, back);
		cube.printCube();

		String input = IO.readString();
		while (true) {
			if (input.equalsIgnoreCase("Exit")) {
				System.out.println("Exiting the program");
				return;
			}
			cube.performMove(input);
			input = IO.readString();
		}
	}

	public static void cubeSolver() {
		System.out.println("Welcome to the Rubik's Cube solver.");
		System.out.println("Each face is represented by a 3x3 matrix.");
		System.out.println("The six matrices are \"connected\" in this manner:");
		System.out.println("        ______ ");
		System.out.println("       |      |");
		System.out.println("       |  U   |");
		System.out.println(" ______|______|_____________");
		System.out.println("|      |      |      |      |");
		System.out.println("|  L   |  F   |  R   |  B   |");
		System.out.println("|______|______|______|______|");
		System.out.println("       |      |");
		System.out.println("       |  D   |");
		System.out.println("       |______|");
		System.out.println();
		System.out.println("Each element of the arrays is a character that represents the color of the square.");
		System.out.println("For instance, green is represented by \"G\", blue is represented by \"B\", etc.");
		System.out.println("A completely unscrambled cube would look like this:");
		System.out.println();
		
		char[][] left = { { 'G', 'G', 'G' }, { 'G', 'G', 'G' }, { 'G', 'G', 'G' } };
		char[][] front = { { 'R', 'R', 'R' }, { 'R', 'R', 'R' }, { 'R', 'R', 'R' } };
		char[][] right = { { 'B', 'B', 'B' }, { 'B', 'B', 'B' }, { 'B', 'B', 'B' } };
		char[][] up = { { 'W', 'W', 'W' }, { 'W', 'W', 'W' }, { 'W', 'W', 'W' } };
		char[][] down = { { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' } };
		char[][] back = { { 'O', 'O', 'O' }, { 'O', 'O', 'O' }, { 'O', 'O', 'O' } };
		RubiksCube unscrambled = new RubiksCube(left, front, right, up, down, back);
		unscrambled.printCube();
		System.out.println();
		System.out.println("When inputting values, please make sure that the center front face is red and the center up face is white.");
		System.out.println("Please input the following values:");
		
		assignFace(left, "Left");
		assignFace(front, "Front");
		assignFace(right, "Right");
		assignFace(up, "Up");
		assignFace(down, "Down");
		assignFace(back, "Back");
		System.out.println("Solving cube...");
		try {
		    Thread.sleep(2000);
		} catch(InterruptedException ex){
			
		}
		RubiksCube cube = new RubiksCube(left, front, right, up, down, back);
		cube.solveCube();
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Rubik's Cube program. What would you like to access?");
		System.out.println("1. Rubik's Cube Scramble Generator");
		System.out.println("2. Rubik's Cube Simulator");
		System.out.println("3. Rubik's Cube Solver");
		System.out.println("4. Exit the program");
		System.out.println();

		Scanner myScanner = new Scanner(System.in);
		int choice = -1;

		while (choice < 1 || choice > 4) {
			System.out.println("Enter \"1\", \"2\", \"3\" or \"4\"");
			choice = myScanner.nextInt();
		}
		switch (choice) {
		case 1:
			cubeScrambler();
			break;
		case 2:
			cubeSimulator();
			break;
		case 3:
			cubeSolver();
			break;
		case 4:
			System.out.println("Exiting the program.");
			return;
		}
	}

}
