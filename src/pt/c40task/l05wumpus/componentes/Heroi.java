package pt.c40task.l05wumpus.componentes;

import pt.c40task.l05wumpus.Componente;

public class Heroi extends Componente {
	private boolean temFlecha = true;
	private boolean flechaArmada = false;
	
	public Heroi(int x, int y) {
		super(x, y, 'P', 2);
	}
	
	@Override
	public void interagir(Heroi heroi) {
		// Heroi não interagi com si propio
	}
	
	@Override
	public void mover(int xf, int yf) {
		super.mover(xf, yf);
		cave.interagir(getX(), getY());
		
		if(flechaArmada) {
			temFlecha = false;
			flechaArmada = false;
		}
	}
	
	public void mover(char tecla) {
		switch(Character.toLowerCase(tecla)) {
		case 'w':
			if(getY() > 0)
				mover(getX(), getY() - 1);
			break;
		case 's':
			if(getY() < 3)
				mover(getX(), getY() + 1);
			break;
		case 'a':
			if(getX() > 0)
				mover(getX() - 1, getY());
			break;
		case 'd':
			if(getX() < 3)
				mover(getX() + 1, getY());
			break;
		}
	}
	
	public void armarFlecha() {
		if(temFlecha) 
			flechaArmada = true;
	}
	
	public boolean getFlechaArmada() {
		return flechaArmada;
	}
}
