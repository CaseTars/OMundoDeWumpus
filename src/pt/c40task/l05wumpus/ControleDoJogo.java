package pt.c40task.l05wumpus;
import pt.c40task.l05wumpus.componentes.Heroi;

public class ControleDoJogo {
	private String nomeJogador;
	private int pontuacao;
	private char status;
	private boolean rodando;	
	private Heroi heroi;
	
	public ControleDoJogo() {
		this.pontuacao = 0;
		this.rodando = true;
	}
	
	public int executa(char command) { 
		if(command == 'w' || command == 's' || command == 'a' || command == 'd') {
			heroi.mover(command);
		}
		if(command == 'k') {
			heroi.armarFlecha();
		}
		if(command == 'c') {
			heroi.pegarOuro;
		}
		if(command == 'q') {
			heroi.sairJogo(); // ??
			rodando = false;
		}
		return 0;
	}
	
	public boolean getRodando() { // qndo alterar 
		return rodando;
	}
	
	public void setNome(String nome) {
		this.nomeJogador = nome;
	}
	
	public char getStatus() {
		return status;
	}
	
	public int getScore() {
		return pontuacao;
	}
	
	public char[][] getCaverna(){ //iterar sobre a caverna e salas e imprimir a galera toda, pegar caverna com o heroi
		
	}
	
	public void conectaHeroi(Heroi heroi) {
		this.heroi = heroi;
	}
}
