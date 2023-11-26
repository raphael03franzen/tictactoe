package tictactoe;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game game = new Game();
	
	
	int next;
	for(int i = 0;game.checkWin()==0&&(game.getGamestate()<0b111_111_111);i++){
		
		System.out.print((i%2==0)?"Player A:":"Player B:");
		next = sc.nextInt();
		game.Play(i%2,next);
	}
	switch (game.checkWin()) {
		case 0:
			System.out.println("Draw!");
			break;
		case 1:
			System.out.println("Player A Winns!Congratulations");
			break;
		case 2:
			System.out.println("Player B Winns!Congratulations");
			break;
	}
	sc.close();
	}


}
