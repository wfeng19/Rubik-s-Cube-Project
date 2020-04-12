package rubiksCube;

public class RubiksCube {

	char[][] left = new char[3][3];
	char[][] front = new char[3][3];
	char[][] right = new char[3][3];
	char[][] up = new char[3][3];
	char[][] down = new char[3][3];
	char[][] back = new char[3][3];
	int count = 0;

	public RubiksCube(char[][] left, char[][] front, char[][] right, char[][] up, char[][] down, char[][] back) {
		this.left = left;
		this.front = front;
		this.right = right;
		this.up = up;
		this.down = down;
		this.back = back;
	}

	public static void printFace(char[][] face) {
		for (int i = 0; i < face.length; i++) {
			for (int j = 0; j < face[i].length; j++)
				System.out.print(face[i][j] + " ");
			System.out.println("");
		}
	}

	public void printCube() {
		for (int i = 0; i < 3; i++) {
			System.out.print("        ");
			for (int j = 0; j < 3; j++)
				System.out.print(up[i][j] + " ");
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				System.out.print(left[i][j] + " ");
			System.out.print("  ");
			for (int j = 0; j < 3; j++)
				System.out.print(front[i][j] + " ");
			System.out.print("  ");
			for (int j = 0; j < 3; j++)
				System.out.print(right[i][j] + " ");
			System.out.print("  ");
			for (int j = 0; j < 3; j++)
				System.out.print(back[i][j] + " ");
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 3; i++) {
			System.out.print("        ");
			for (int j = 0; j < 3; j++)
				System.out.print(down[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	// Helper Functions
	public void rotateFaceCW(char[][] face) {
		char temp = face[0][1];
		face[0][1] = face[1][0];
		face[1][0] = face[2][1];
		face[2][1] = face[1][2];
		face[1][2] = temp;

		temp = face[0][0];
		face[0][0] = face[2][0];
		face[2][0] = face[2][2];
		face[2][2] = face[0][2];
		face[0][2] = temp;
	}

	public void rotateFaceCCW(char[][] face) {
		char temp = face[1][2];
		face[1][2] = face[2][1];
		face[2][1] = face[1][0];
		face[1][0] = face[0][1];
		face[0][1] = temp;

		temp = face[0][0];
		face[0][0] = face[0][2];
		face[0][2] = face[2][2];
		face[2][2] = face[2][0];
		face[2][0] = temp;
	}

	// Moves
	public void front() {
		rotateFaceCW(front);
		for (int i = 0; i < 3; i++) {
			char temp = up[2][i];
			up[2][i] = left[2 - i][2];
			left[2 - i][2] = down[0][2 - i];
			down[0][2 - i] = right[i][0];
			right[i][0] = temp;
		}
	}

	public void frontPrime() {
		rotateFaceCCW(front);
		for (int i = 0; i < 3; i++) {
			char temp = up[2][i];
			up[2][i] = right[i][0];
			right[i][0] = down[0][2 - i];
			down[0][2 - i] = left[2 - i][2];
			left[2 - i][2] = temp;
		}
	}

	public void up() {
		rotateFaceCW(up);
		for (int i = 0; i < 3; i++) {
			char temp = front[0][i];
			front[0][i] = right[0][i];
			right[0][i] = back[0][i];
			back[0][i] = left[0][i];
			left[0][i] = temp;
		}
	}

	public void upPrime() {
		rotateFaceCCW(up);
		for (int i = 0; i < 3; i++) {
			char temp = front[0][i];
			front[0][i] = left[0][i];
			left[0][i] = back[0][i];
			back[0][i] = right[0][i];
			right[0][i] = temp;
		}
	}

	public void right() {
		rotateFaceCW(right);
		for (int i = 0; i < 3; i++) {
			char temp = up[i][2];
			up[i][2] = front[i][2];
			front[i][2] = down[i][2];
			down[i][2] = back[2 - i][0];
			back[2 - i][0] = temp;
		}
	}

	public void rightPrime() {
		rotateFaceCCW(right);
		for (int i = 0; i < 3; i++) {
			char temp = up[i][2];
			up[i][2] = back[2 - i][0];
			back[2 - i][0] = down[i][2];
			down[i][2] = front[i][2];
			front[i][2] = temp;
		}
	}

	public void left() {
		rotateFaceCW(left);
		for (int i = 0; i < 3; i++) {
			char temp = up[i][0];
			up[i][0] = back[2 - i][2];
			back[2 - i][2] = down[i][0];
			down[i][0] = front[i][0];
			front[i][0] = temp;
		}
	}

	public void leftPrime() {
		rotateFaceCCW(left);
		for (int i = 0; i < 3; i++) {
			char temp = up[i][0];
			up[i][0] = front[i][0];
			front[i][0] = down[i][0];
			down[i][0] = back[2 - i][2];
			back[2 - i][2] = temp;
		}
	}

	public void back() {
		rotateFaceCW(back);
		for (int i = 0; i < 3; i++) {
			char temp = up[0][i];
			up[0][i] = right[i][2];
			right[i][2] = down[2][2 - i];
			down[2][2 - i] = left[2 - i][0];
			left[2 - i][0] = temp;
		}
	}

	public void backPrime() {
		rotateFaceCCW(back);
		for (int i = 0; i < 3; i++) {
			char temp = up[0][i];
			up[0][i] = left[2 - i][0];
			left[2 - i][0] = down[2][i];
			down[2][i] = right[i][2];
			right[i][2] = temp;
		}
	}

	public void down() {
		rotateFaceCW(down);
		for (int i = 0; i < 3; i++) {
			char temp = front[2][i];
			front[2][i] = left[2][i];
			left[2][i] = back[2][i];
			back[2][i] = right[2][i];
			right[2][i] = temp;
		}
	}

	public void downPrime() {
		rotateFaceCCW(down);
		for (int i = 0; i < 3; i++) {
			char temp = front[2][i];
			front[2][i] = right[2][i];
			right[2][i] = back[2][i];
			back[2][i] = left[2][i];
			left[2][i] = temp;
		}
	}

	public void rotateX() {
		rotateFaceCW(right);
		rotateFaceCCW(left);
		rotateFaceCW(up);
		rotateFaceCW(up);
		rotateFaceCW(back);
		rotateFaceCW(back);
		char[][] temp = up;
		up = front;
		front = down;
		down = back;
		back = temp;
	}

	public void rotateXPrime() {
		rotateFaceCCW(right);
		rotateFaceCW(left);
		rotateFaceCW(down);
		rotateFaceCW(down);
		rotateFaceCW(back);
		rotateFaceCW(back);
		char[][] temp = up;
		up = back;
		back = down;
		down = front;
		front = temp;
	}

	public void rotateY() {
		rotateFaceCW(up);
		rotateFaceCCW(down);
		char[][] temp = left;
		left = front;
		front = right;
		right = back;
		back = temp;
	}

	public void rotateYPrime() {
		rotateFaceCCW(up);
		rotateFaceCW(down);
		char[][] temp = right;
		right = front;
		front = left;
		left = back;
		back = temp;
	}

	public void rotateZ() {
		rotateFaceCW(front);
		rotateFaceCCW(back);
		rotateFaceCW(left);
		rotateFaceCW(up);
		rotateFaceCW(down);
		rotateFaceCW(right);
		char[][] temp = left;
		left = down;
		down = right;
		right = up;
		up = temp;
	}

	public void rotateZPrime() {
		rotateFaceCCW(front);
		rotateFaceCW(back);
		rotateFaceCCW(left);
		rotateFaceCCW(up);
		rotateFaceCCW(down);
		rotateFaceCCW(right);
		char[][] temp = left;
		left = up;
		up = right;
		right = down;
		down = temp;
	}

	public void middle() {
		leftPrime();
		right();
		rotateXPrime();
	}

	public void middlePrime() {
		left();
		rightPrime();
		rotateX();
	}

	public void equatorial() {
		up();
		downPrime();
		rotateYPrime();
	}

	public void equatorialPrime() {
		upPrime();
		down();
		rotateY();
	}

	public void standing() {
		frontPrime();
		back();
		rotateZ();
	}

	public void standingPrime() {
		front();
		backPrime();
		rotateZPrime();
	}

	public void doubleFront() {
		rotateZ();
		back();
	}

	public void doubleFrontPrime() {
		rotateZPrime();
		backPrime();
	}

	public void doubleUp() {
		rotateY();
		down();
	}

	public void doubleUpPrime() {
		rotateYPrime();
		downPrime();
	}

	public void doubleRight() {
		rotateX();
		left();
	}

	public void doubleRightPrime() {
		rotateXPrime();
		leftPrime();
	}

	public void doubleLeft() {
		rotateXPrime();
		right();
	}

	public void doubleLeftPrime() {
		rotateX();
		rightPrime();
	}

	public void doubleBack() {
		rotateZPrime();
		front();
	}

	public void doubleBackPrime() {
		rotateZ();
		frontPrime();
	}

	public void doubleDown() {
		rotateYPrime();
		up();
	}

	public void doubleDownPrime() {
		rotateY();
		upPrime();
	}

	// Helper Functions
	public void performMove(String move) {
		// Consider replacing with a hash map or enum
		if(count>=1000) {
			System.out.println("The cube cannot be solved. Please check your input and rerun the program.");
			System.exit(0);
		}
		System.out.println("Performing " + move);
		switch (move) {
		case "U":
			up();
			break;
		case "D":
			down();
			break;
		case "R":
			right();
			break;
		case "L":
			left();
			break;
		case "F":
			front();
			break;
		case "B":
			back();
			break;

		case "U'":
			upPrime();
			break;
		case "D'":
			downPrime();
			break;
		case "R'":
			rightPrime();
			break;
		case "L'":
			leftPrime();
			break;
		case "F'":
			frontPrime();
			break;
		case "B'":
			backPrime();
			break;

		case "M":
			middle();
			break;
		case "E":
			equatorial();
			break;
		case "S":
			standing();
			break;
		case "M'":
			middlePrime();
			break;
		case "E'":
			equatorialPrime();
			break;
		case "S'":
			standingPrime();
			break;

		case "x":
			rotateX();
			break;
		case "y":
			rotateY();
			break;
		case "z":
			rotateZ();
			break;
		case "x'":
			rotateXPrime();
			break;
		case "y'":
			rotateYPrime();
			break;
		case "z'":
			rotateZPrime();
			break;

		case "u":
			doubleUp();
			break;
		case "d":
			doubleDown();
			break;
		case "r":
			doubleRight();
			break;
		case "l":
			doubleLeft();
			break;
		case "f":
			doubleFront();
			break;
		case "b":
			doubleBack();
			break;

		case "u'":
			doubleUpPrime();
			break;
		case "d'":
			doubleDownPrime();
			break;
		case "r'":
			doubleRightPrime();
			break;
		case "l'":
			doubleLeftPrime();
			break;
		case "f'":
			doubleFrontPrime();
			break;
		case "b'":
			doubleBackPrime();
			break;
		default:
			System.out.println("Please enter a valid move");
			break;
		}
		printCube();
		count++;
		System.out.println();
	}

	public void readMoves(String input) {
		String move = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ' ')
				move += input.charAt(i);
			if (input.charAt(i) == ' ' || i == input.length() - 1) {
				performMove(move);
				move = "";
			}
		}
	}

	public boolean alignPieces(char[][] face) {
		int count = 0;
		while (face[0][1] != face[1][1] && count < 4) {
			performMove("U");
			count++;
		}
		return face[0][1] == face[1][1];
	}

	public boolean isAligned(char[][] face) {
		return face[0][1] == face[1][1];
	}

	// Making white cross
	public int findPieceV1(char color1, char color2) {
		// Output number of rotations it takes to get there * 10 + number of front moves
		if ((front[0][1] == color1 || up[2][1] == color1) && (front[0][1] == color2 || up[2][1] == color2))
			return 02;
		else if ((front[1][2] == color1 || right[1][0] == color1) && (front[1][2] == color2 || right[1][0] == color2))
			return 01;
		else if ((front[2][1] == color1 || down[0][1] == color1) && (front[2][1] == color2 || down[0][1] == color2))
			return 00;
		else if ((right[0][1] == color1 || up[1][2] == color1) && (right[0][1] == color2 || up[1][2] == color2))
			return 12;
		else if ((right[1][2] == color1 || back[1][0] == color1) && (right[1][2] == color2 || back[1][0] == color2))
			return 11;
		else if ((right[2][1] == color1 || down[1][2] == color1) && (right[2][1] == color2 || down[1][2] == color2))
			return 10;
		else if ((back[0][1] == color1 || up[0][1] == color1) && (back[0][1] == color2 || up[0][1] == color2))
			return 22;
		else if ((back[1][2] == color1 || left[1][0] == color1) && (back[1][2] == color2 || left[1][0] == color2))
			return 21;
		else if ((back[2][1] == color1 || down[2][1] == color1) && (back[2][1] == color2 || down[2][1] == color2))
			return 20;
		else if ((left[0][1] == color1 || up[1][0] == color1) && (left[0][1] == color2 || up[1][0] == color2))
			return 32;
		else if ((left[1][2] == color1 || front[1][0] == color1) && (left[1][2] == color2 || front[1][0] == color2))
			return 31;
		else if ((left[2][1] == color1 || down[1][0] == color1) && (left[2][1] == color2 || down[1][0] == color2))
			return 30;
		return -1;
	}

	public void positionPieceV1(char color1, char color2) {
		int rotations = findPieceV1(color1, color2) / 10;
		int moves = findPieceV1(color1, color2) % 10;
		for (int i = 0; i < rotations; i++)
			performMove("y");
		for (int i = 0; i < moves; i++)
			performMove("F");
		performMove("D");
		for (int i = 0; i < moves; i++)
			performMove("F'");
		performMove("D'");
		while (front[1][1] != color1)
			performMove("u");
	}

	public void placePieceV1(char color1, char color2) {
		positionPieceV1(color1, color2);
		if (color1 == front[2][1])
			readMoves("F F");
		else
			readMoves("F' R' D' R F F");
	}

	public void whiteCross() {
		placePieceV1('R', 'W');
		placePieceV1('B', 'W');
		placePieceV1('O', 'W');
		placePieceV1('G', 'W');
	}

	// Make white face
	public int findPiece(char color1, char color2, char color3) {
		if ((up[2][2] == color1 || front[0][2] == color1 || right[0][0] == color1)
				&& (up[2][2] == color2 || front[0][2] == color2 || right[0][0] == color2)
				&& (up[2][2] == color3 || front[0][2] == color3 || right[0][0] == color3))
			return 1;
		else if ((up[0][2] == color1 || right[0][2] == color1 || back[0][0] == color1)
				&& (up[0][2] == color2 || right[0][2] == color2 || back[0][0] == color2)
				&& (up[0][2] == color3 || right[0][2] == color3 || back[0][0] == color3))
			return 2;
		else if ((up[0][0] == color1 || back[0][2] == color1 || left[0][0] == color1)
				&& (up[0][0] == color2 || back[0][2] == color2 || left[0][0] == color2)
				&& (up[0][0] == color3 || back[0][2] == color3 || left[0][0] == color3))
			return 3;
		else if ((up[2][0] == color1 || left[0][2] == color1 || front[0][0] == color1)
				&& (up[2][0] == color2 || left[0][2] == color2 || front[0][0] == color2)
				&& (up[2][0] == color3 || left[0][2] == color3 || front[0][0] == color3))
			return 4;
		else if ((down[0][2] == color1 || front[2][2] == color1 || right[2][0] == color1)
				&& (down[0][2] == color2 || front[2][2] == color2 || right[2][0] == color2)
				&& (down[0][2] == color3 || front[2][2] == color3 || right[2][0] == color3))
			return -1;
		else if ((down[2][2] == color1 || right[2][2] == color1 || back[2][0] == color1)
				&& (down[2][2] == color2 || right[2][2] == color2 || back[2][0] == color2)
				&& (down[2][2] == color3 || right[2][2] == color3 || back[2][0] == color3))
			return -2;
		else if ((down[2][0] == color1 || back[2][2] == color1 || left[2][0] == color1)
				&& (down[2][0] == color2 || back[2][2] == color2 || left[2][0] == color2)
				&& (down[2][0] == color3 || back[2][2] == color3 || left[2][0] == color3))
			return -3;
		else if ((down[0][0] == color1 || left[2][2] == color1 || front[2][0] == color1)
				&& (down[0][0] == color2 || left[2][2] == color2 || front[2][0] == color2)
				&& (down[0][0] == color3 || left[2][2] == color3 || front[2][0] == color3))
			return -4;
		return 0;
	}

	public void positionPiece(char color1, char color2, char color3) {
		System.out.println("Positioning piece");
		int location = findPiece(color1, color2, color3);
		int rotations = Math.abs(findPiece(color1, color2, color3)) - 1;
		System.out.println("Location: " + location);
		System.out.println("Rotation: " + rotations);
		if (location > 0) {
			System.out.println("Performing rotations");
			for (int i = 0; i < rotations; i++) {
				System.out.println("Rotation: " + i);
				performMove("y");
			}
			readMoves("R' D' R D");
			System.out.println("Re calling function");
			positionPiece(color1, color2, color3);
		} else if (location < 0) {
			System.out.println("Performing rotations");
			for (int i = 0; i < rotations; i++) {
				System.out.println("Rotation: " + i);
				performMove("y");
			}
			while (!((front[2][2] == front[1][1] || right[2][0] == front[1][1] || down[0][2] == front[1][1])
					&& (front[2][2] == right[1][1] || right[2][0] == right[1][1] || down[0][2] == right[1][1]))) {
				System.out.println(
						(front[2][2] != front[1][1] || right[2][0] != front[1][1] || down[0][2] != front[1][1]));
				System.out.println(
						(front[2][2] != right[1][1] || right[2][0] != right[1][1] || down[0][2] != right[1][1]));
				performMove("u");
			}
		} else // should never run
			System.out.println("Oops, something messed up");
	}

	public void placePiece(char color1, char color2, char color3) {
		System.out.println("Placing piece");
		positionPiece(color1, color2, color3);
		// Specify more for loop
		while (front[0][2] != color1 || right[0][0] != color2 || up[2][2] != color3) {
			readMoves("R' D' R D");
		}
	}

	public void whiteFace() {
		System.out.println("Placing RBW");
		placePiece('R', 'B', 'W');
		System.out.println("Placing BOW");
		placePiece('B', 'O', 'W');
		System.out.println("Placing OGW");
		placePiece('O', 'G', 'W');
		System.out.println("Placing GRW");
		placePiece('G', 'R', 'W');
	}

	// Make first 2 layers
	public int findPieceV2(char color1, char color2) {
		if ((front[1][2] == color1 || right[1][0] == color1) && (front[1][2] == color2 || right[1][0] == color2))
			return 0;
		else if ((right[1][2] == color1 || back[1][0] == color1) && (right[1][2] == color2 || back[1][0] == color2))
			return 1;
		else if ((back[1][2] == color1 || left[1][0] == color1) && (back[1][2] == color2 || left[1][0] == color2))
			return 2;
		else if ((left[1][2] == color1 || front[1][0] == color1) && (left[1][2] == color2 || front[1][0] == color2))
			return 3;
		else {
			if ((up[0][1] == color1 && back[0][1] == color2) || (up[1][0] == color1 && left[0][1] == color2)
					|| (up[2][1] == color1 && front[0][1] == color2) || (up[1][2] == color1 && right[0][1] == color2))
				return -2;
			else
				return -1;
		}
	}

	public void positionPieceV2(char color1, char color2) {
		int location = findPieceV2(color1, color2);
		if (location >= 0) {
			for (int i = 0; i < location; i++) {
				System.out.println("Rotation: " + i);
				performMove("y");
			}
			readMoves("U R U' R' U' F' U F U U");
			positionPieceV2(color1, color2);
		} else {
			if (findPieceV2(color1, color2) == -1) {
				while (front[1][1] != color1)
					performMove("y");
				while (front[0][1] != color1 || up[2][1] != color2) {
					performMove("U");
					System.out.println("Positioning piece " + color1 + color2);
				}
			} else {
				while (front[1][1] != color2)
					performMove("y");
				while (front[0][1] != color2 || up[2][1] != color1) {
					System.out.println("Positioning piece " + color1 + color2);
					performMove("U");
				}

			}
		}
	}

	public void placePieceV2(char color1, char color2) {
		System.out.println("Positioning piece " + color1 + color2);
		positionPieceV2(color1, color2);
		System.out.println("Placing piece");
		if (up[2][1] == left[1][1]) {
			readMoves("U' L' U L U F U' F'");
		} else
			readMoves("U R U' R' U' F' U F");
	}

	public void first2Layers() {
		placePieceV2('R', 'B');
		placePieceV2('B', 'O');
		placePieceV2('O', 'G');
		placePieceV2('G', 'R');
	}

	// Make yellow cross
	public boolean yellowL() {
		int count = 0;
		while ((up[0][1] != 'Y' || up[1][1] != 'Y' || up[1][0] != 'Y') && count < 4) {
			performMove("y");
			count++;
		}
		return (up[0][1] == 'Y' && up[1][1] == 'Y' && up[1][0] == 'Y');
	}

	public boolean yellowLine() {
		int count = 0;
		while ((up[1][0] != 'Y' || up[1][1] != 'Y' || up[1][2] != 'Y') && count < 2) {
			performMove("y");
			count++;
		}
		return (up[1][0] == 'Y' && up[1][1] == 'Y' && up[1][2] == 'Y');
	}

	public boolean hasYellowCross() {
		return up[1][1] == 'Y' && up[0][1] == 'Y' && up[1][0] == 'Y' && up[2][1] == 'Y' && up[1][2] == 'Y';
	}

	public void yellowCross() {
		if (hasYellowCross()) {
			// System.out.println("Has yellow cross");
			return;
		} else if (yellowLine()) {
			yellowLine();
			// System.out.println("Has yellow line");
			while (!hasYellowCross())
				readMoves("F R U R' U' F'");
		} else if (yellowL()) {
			yellowL();
			// System.out.println("Has yellow L");
			while (!hasYellowCross())
				readMoves("F R U R' U' F'");
		} else {
			// System.out.println("Has yellow dot");
			readMoves("F R U R' U' F'");
			yellowCross();
		}
	}

	// Swap last layer edges
	public boolean adjacentEdgesAligned() {
		int count = 1;
		while ((right[0][1] != right[1][1] || back[0][1] != back[1][1]) && count <= 20) {
			// System.out.println("Count: " + count);
			if (count % 5 == 0) {
				performMove("y");
				count++;
			} else {
				performMove("U");
				count++;
			}
			System.out.println(right[0][1] != right[1][1] && back[0][1] != back[1][1] && count <= 20);
		}
		return left[0][1] == left[1][1] && back[0][1] == back[1][1];
	}

	public void swapLastLayerEdges() {
		// System.out.println("Aligning front pieces");
		alignPieces(front);
		// System.out.println("Pieces have been aligned");
		if (isAligned(front) && isAligned(left) && isAligned(right) && isAligned(back)) {
			// System.out.println("All edges aligned");
			return;
		} else if (adjacentEdgesAligned()) {
			// System.out.println("Only adjacent edges aligned");
			adjacentEdgesAligned();
			readMoves("R U R' U R U U R' U");
			return;
		} else {
			readMoves("R U R' U R U U R' U");
			swapLastLayerEdges();
		}
	}

	// Position last layer corners
	public boolean isRUFInPlace() {
		boolean front = (this.front[0][2] == this.front[1][1] || this.up[2][2] == this.front[1][1]
				|| this.right[0][0] == this.front[1][1]);
		boolean right = (this.front[0][2] == this.right[1][1] || this.up[2][2] == this.right[1][1]
				|| this.right[0][0] == this.right[1][1]);
		return front && right;
	}

	public boolean isRUBInPlace() {
		boolean back = (this.back[0][0] == this.back[1][1] || this.up[0][2] == this.back[1][1]
				|| this.right[0][2] == this.back[1][1]);
		boolean right = (this.back[0][0] == this.right[1][1] || this.up[0][2] == this.right[1][1]
				|| this.right[0][2] == this.right[1][1]);
		return back && right;
	}

	public void positionLastLayerCorners() {
		int count = 0;
		while (count < 4) {
			if (isRUFInPlace()) {
				while (!isRUBInPlace())
					readMoves("U R U' L' U R' U' L");
				return;
			} else {
				readMoves("y");
				count++;
			}
		}
		readMoves("U R U' L' U R' U' L");
		positionLastLayerCorners();
	}

	// Orient last layer corners
	public void orientLastLayer() {
		for (int i = 0; i < 4; i++) {
			while (up[2][2] != 'Y') {
				readMoves("R' D' R D");
			}
			performMove("U");
		}
		alignPieces(front);
	}

	public void solveCube() {
		//Check for invalid cube
		
		printCube();
		System.out.println("Making white cross");
		whiteCross();
		System.out.println("Making white face");
		whiteFace();
		readMoves("z z");
		System.out.println("First 2 layers");
		first2Layers();
		System.out.println("Arranging yellow cross");
		yellowCross();
		System.out.println("Swapping last layer edges");
		swapLastLayerEdges();
		System.out.println("Positioning last layer corners");
		positionLastLayerCorners();
		System.out.println("Orienting last layer corners");
		orientLastLayer();

	}

}
