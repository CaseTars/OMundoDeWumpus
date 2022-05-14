package pt.c40task.l05wumpus;

public class Impressao {
	public static void estado(char[][] caverna, String player, int score) {
		System.out.println(' ');
		for(int y=0;y < 4;y++) {
			for(int x=0;x < 4;x++) {
				System.out.print("" + caverna[x][y] + (x != 3 ? ' ' : '\n'));
			}
		}
		player(player);
		score(score);
		System.out.println(' ');
	}
	public static void mensagem(String mensagem) {
		System.out.println(mensagem);
	}
	
	public static void player(String player) {
		System.out.println("Player: " + player);
	}
	
	public static void score(int score) {
		System.out.println("Score: " + score);
	}
	
	public static void pegarNome() {
		System.out.println("Digite o seu nick: ");
	}
}
