package pt.c40task.l05wumpus;

import pt.c40task.l05wumpus.componentes.Heroi;
import pt.c40task.l05wumpus.componentes.Wumpus;

public abstract class Componente {
	private int x, y;
	private boolean vivo;
	protected Caverna cave;
	private char simbolo;
	private int prioridadeSimbolo;
	
	public static void main(String[] args) {
		Heroi heroi = new Heroi(0,0);
		Wumpus wumpus = new Wumpus(0,1);
		heroi.armarFlecha();
		wumpus.interagir(heroi);
		System.out.println(heroi.getVivo());
		System.out.println(wumpus.getVivo());
	}
	
	public Componente(int x, int y, char simbolo, int prioridade) {
		this.x = x;
		this.y = y;
		this.simbolo = simbolo;
		this.prioridadeSimbolo = prioridade;
		this.vivo = true;
	}
	
	public void conectaCaverna(Caverna cave) {
		this.cave = cave;
	}
	
	public Caverna getCaverna() {
		return cave;
	}
	
	public void mover(int xf, int yf) {
		cave.mover(this, xf, yf);
		x = xf;
		y = yf;
	}
	
	public abstract void interagir(Heroi heroi);
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public char getSimbolo() {
		return simbolo;
	}
	
	public int getPrioridade() {
		return prioridadeSimbolo;
	}
	
	public boolean getVivo() {
		return vivo;
	}
	
	public void matar() {
		vivo = false;
	}
}
