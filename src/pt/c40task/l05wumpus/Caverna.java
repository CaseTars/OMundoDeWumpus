package pt.c40task.l05wumpus;
import pt.c40task.l05wumpus.componentes.Componente;
import pt.c40task.l05wumpus.componentes.Heroi;

public class Caverna {
	private Salas[][] sala;
	
	
	public Caverna() {
		Salas[][] salas = new Salas[4][4];
		for(int i=0;i < 4;i++) {
			for(int j=0;j < 4;j++) {
				salas[i][j] = new Salas();
			}
		}
		this.sala = new Salas[4][4];
		this.sala = salas;
	}
	
	public boolean inserir(Componente aInserir) { 
		if(aInserir.getX() < 0 || aInserir.getX() > 3 || aInserir.getY() < 0 || aInserir.getY() > 3 ) {
			return false;
		}
		return sala[aInserir.getX()][aInserir.getY()].inserir(aInserir);
	}
	
	public void mover(Heroi heroi, int posX, int posY) { //talvez precise de retorno se caso o movimento for invalido
		sala[heroi.getX()][heroi.getY()].sair();
		sala[posX][posY].entrar(heroi);
	}
	
	public void interagir(Heroi heroi) { //retornar resultados neh
		sala[heroi.getX()][heroi.getY()].interagir();
	}
	
	public char[][] getMapa(){
		char[][] mapa = new char[4][4];
		for(int x=0;x < 4;x++) {
			for(int y=0;y < 4;y++) {
				mapa[x][y] = sala[x][y].getSimbolo();
			}
		}
		return mapa;
	}
}
