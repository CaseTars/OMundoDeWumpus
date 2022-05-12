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
		if(command == 'w' || command == 's' || command == 'a' || command == 'd') { //pontos matar wumpus, 
			if(heroi.mover(command)) { //pegar retorno
				pontuacao += -15;
			}
		}
		if(command == 'k') {
			if(heroi.armarFlecha()) {
				pontuacao += -100; //ou esperar proximo movimento??
			}
		}
		if(command == 'c') {
			if(heroi.pegarOuro()) { //pegar retorno se deu bom, pra pontuacao
				pontuacao += 
			}
		}
		if(command == 'q') {
			heroi.sairJogo(); // jogo pd acabar antes??
			if(heroi.carregandoOuro()) {
				pontuacao += 1000;
			}
			rodando = false; // tem a questao se tiver com o ouro a
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
		char[][] caverna = heroi.getCaverna();
		return caverna;
	}
	
	public void conectaHeroi(Heroi heroi) {
		this.heroi = heroi;
	}
}
