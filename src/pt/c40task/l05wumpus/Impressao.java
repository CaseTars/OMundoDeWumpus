package pt.c40task.l05wumpus;

public class Impressao {
	public static void caverna(char[][] caverna) {
		for(int y=0;y < 4;y++) {
			for(int x=0;x < 4;x++) {
				System.out.print("" + caverna[x][y] + (x != 3 ? ' ' : '\n'));
			}
		}
	}
	public static void mensagem(String mensagem) {
		System.out.println(mensagem);
	}
	public static void pegarNome() {
		System.out.println("Digite o seu vulgo: ");
	}
}
