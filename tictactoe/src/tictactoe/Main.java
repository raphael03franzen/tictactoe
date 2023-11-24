
package tictactoe;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(0b001_010_001,0b100_100_100);
		
		
	}

	@SuppressWarnings("unused")
	

	

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
