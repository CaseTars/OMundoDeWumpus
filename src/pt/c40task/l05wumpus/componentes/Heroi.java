package pt.c40task.l05wumpus.componentes;

public class Heroi extends SerVivo {
	private boolean temFlecha = true;
	private boolean flechaArmada = false;
	private boolean pegandoOuro = false;
	private Ouro ouro = null;
	
	public Heroi(int x, int y) {
		super(x, y, 'P', 2);
	}
	
	@Override
	public void interagir(Heroi heroi) {
		// Heroi não interagi com si propio
	}
	
	// --------------------------------- Movimentacao
	@Override
	public void mover(int xf, int yf) {
		super.mover(xf, yf);
		cave.interagir();
		
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
	
	//------------------------------ Flecha
	public void armarFlecha() {
		if(temFlecha) 
			flechaArmada = true;
	}
	
	public boolean getFlechaArmada() {
		return flechaArmada;
	}
	
	// -------------------------------- Ouro
	public void pegarOuro() {
		pegandoOuro = true;
		getCaverna().interagir();
		pegandoOuro = false;
	}
	
	public boolean getPegandoOuro() {
		return pegandoOuro;
	}
	
	public Ouro getOuro() {
		return ouro;
	}
	
	public void setOuro(Ouro ouro) {
		this.ouro = ouro;
	}
	
	public boolean carregandoOuro() {
		if(ouro == null)
			return false;
		return true;
	}
}
