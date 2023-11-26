package tictactoe;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game game = new Game();

		int next;
		boolean player = true;// true=Player_A false=Player_B
		while (game.checkWin() == 0 && (game.getGamestate() < 0b111_111_111)) {

			System.out.print(player ? "Player A:" : "Player B:");
			next = sc.nextInt();
			try {
				game.Play(player, next);
				player = !player;
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
		}
		switch (game.checkWin()) {
		case 0:
			System.out.println("Draw!");
			break;
		case 1:
			System.out.println("X Winns!");
			break;
		case 2:
			System.out.println("O Winns!");
			break;
		}
		sc.close();
	}

}
