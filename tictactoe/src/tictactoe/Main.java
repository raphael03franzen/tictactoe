
package tictactoe;

public class Main {

	public static void main(String[] args) {

		print(0b000101000, 0b101000101);

	}

	@SuppressWarnings("unused")
	private static void print(Game g) {
		print(g.getPlayer_A(), g.getPlayer_B());
	}

	private static void print(int Player_A, int Player_B) {

		for (int y = 1; y <= 3; y++) {
			for (int x = 1; x <= 3; x++) {
				int k = lookup(x + 3 * (y - 1));
				System.out.print((Player_A & k) == k ? "X" : (Player_B & k) == k ? "O" : "_");
			}
			System.out.println();
		}
	}

	final static int lookup(int n) {
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

}
