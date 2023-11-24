package tictactoe;

public class Game {
	private boolean debug = false;
	private int Player_A = 0;
	private int Player_B = 0;
	private int Gamestate = 0;
	// Winning Scenarios
	int top_row = lookup(1) + lookup(2) + lookup(3);
	int middle_row = lookup(4) + lookup(5) + lookup(6);
	int bottom_row = lookup(7) + lookup(8) + lookup(9);
	int left_collumn = lookup(1) + lookup(4) + lookup(7);
	int middle_collumn = lookup(2) + lookup(5) + lookup(8);
	int right_collumn = lookup(3) + lookup(6) + lookup(9);
	int left_diagonal = lookup(1) + lookup(5) + lookup(9);
	int right_diagoal = lookup(3) + lookup(5) + lookup(7);

	// remember: binary output is "reverse" so 0b0100 would be the 3rd Cell

	// Constructors
	public Game() {
	}

	public Game(int Player_A, int Player_B) {
		int err = 0;
		this.Player_A = Player_A;
		this.Player_B = Player_B;
		err = Player_A & Player_B;
		if (err != 0) {
			throw new IllegalArgumentException("Overlap"
					+ ((Integer.bitCount(err) > 1) ? " in " + Integer.bitCount(err) + " Locations" : " at Cell " + err)
					+ " detected:A Cell can only be used by one Player");
		}
		updateGamestate();
		
		switch(checkWin()){
		case 1://A Wins
			print();
			System.out.println("In this Possition , X winns.");
			break;
		case 2://B Wins
			print();
			System.out.println("In this Possition , O winns.");
			break;
		}
		
	}

	final int lookup(int n) { // translates grid positions to binary index
		switch (n) {
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 4;
		case 4:
			return 8;
		case 5:
			return 16;
		case 6:
			return 32;
		case 7:
			return 64;
		case 8:
			return 128;
		case 9:
			return 256;
		default:
			throw new IllegalArgumentException("Input must be 1,2,3,4,5,6,7,8 or 9");
		}
	}

	final int reverse_lookup(int n) { // translates binary index to grid position
		switch (n) {
		case 1:
			return 1;
		case 2:
			return 2;
		case 4:
			return 3;
		case 8:
			return 4;
		case 16:
			return 5;
		case 32:
			return 6;
		case 64:
			return 7;
		case 128:
			return 8;
		case 256:
			return 9;
		default:
			throw new IllegalArgumentException("Input must be 1,2,4,8,16,32.64,128 or 256");
		}
	}

	protected final int getPlayer_A() {
		return Player_A;
	}

	protected final int getPlayer_B() {
		return Player_B;
	}

	protected final int getGamestate() {
		updateGamestate();
		return Gamestate;
	}

	protected final void updateGamestate() {
		Gamestate = getPlayer_A() | getPlayer_B();
	}

	protected final int checkWin() {//XXX
		if ((Player_A & top_row) == top_row | (Player_A & middle_row) == middle_row
				| (Player_A & bottom_row) == bottom_row | (Player_A & left_collumn) == left_collumn
				| (Player_A & middle_collumn) == middle_collumn | (Player_A & right_collumn) == right_collumn
				| (Player_A & left_diagonal) == left_diagonal|(Player_A&right_collumn)==right_collumn) {
				return 1;
		}
		if ((Player_B & top_row) == top_row | (Player_B & middle_row) == middle_row
				| (Player_B & bottom_row) == bottom_row | (Player_B & left_collumn) == left_collumn
				| (Player_B & middle_collumn) == middle_collumn | (Player_B & right_collumn) == right_collumn
				| (Player_B & left_diagonal) == left_diagonal|(Player_B&right_collumn)==right_collumn) {
				return 2;
		}
		return 0;
	}
	protected void print() {
		print(this.getPlayer_A(), this.getPlayer_B());
	}
	
	protected void print(int A, int B) {

		for (int y = 1; y <= 3; y++) {
			for (int x = 1; x <= 3; x++) {
				int index = lookup(x + 3 * (y - 1));
				System.out.print(((A & index) == index ? "X" : (B & index) == index ? "O" : "_"));
			}
			System.out.println();
		}
	}

	// Index: Number between 1 and 9 identifying a Cell
	protected void Player_A_add(int index) {
		if ((Gamestate & lookup(index)) != 0) {
			throw new IllegalArgumentException("Invalid:Space already in use");
		} else {
			Player_A += lookup(index);
			System.out.println(debug ? "A played " + index : "");
			updateGamestate();
			print();
		}
		;
	}

	protected void Player_B_add(int index) {
		if ((Gamestate & lookup(index)) != 0) {
			throw new IllegalArgumentException("Invalid:Space already in use");
		} else {
			Player_B += lookup(index);
			System.out.println(debug ? "B played " + index : "");
			updateGamestate();
		}
	}

}
