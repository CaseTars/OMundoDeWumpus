package pt.c40task.l05wumpus;
import pt.c40task.l05wumpus.componentes.Heroi;
import pt.c40task.l05wumpus.componentes.Wumpus;

public class ControleDoJogo {
	private String nomeJogador;
	private int pontuacao;
	private char status;
	private boolean rodando;
	private boolean wumpusMorto;
	private Heroi heroi;
	private Wumpus wumpus;
	
	public ControleDoJogo() {
		this.pontuacao = 0;
		this.rodando = true;
		this.wumpusMorto = false;
	}
	
	public int executa(char command) { 
		command = Character.toLowerCase(command);
		if(command == 'w' || command == 's' || command == 'a' || command == 'd') { 
			if(heroi.getFlechaArmada()) {
				pontuacao += -100; 
			}
			if(heroi.mover(command)) { 
				pontuacao += -15;
			}
			if(!wumpus.getVivo() && !wumpusMorto) {
				pontuacao += 500;
				wumpusMorto = true;
			}
		}
		if(command == 'k') {
			heroi.armarFlecha();
		}
		if(command == 'c') {
			heroi.pegarOuro();
		}
		if(command == 'q') {
			if(heroi.carregandoOuro() && heroi.getX() == 0 && heroi.getY() == 0) {
				pontuacao += 1000;
			}
			rodando = false; 
		}
		if(!heroi.getVivo()){
			pontuacao += -1000;
			rodando = false;
		}
		return 0;
	}
	
	public boolean getRodando() { 
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
	
	public char[][] getCaverna(){ 
		char[][] caverna = heroi.getMapa();
		return caverna;
	}
	
	public void conectaHeroi(Heroi heroi) {
		this.heroi = heroi;
	}
	
	public void conectaWumpus(Wumpus wumpus) {
		this.wumpus = wumpus;
	}
}
