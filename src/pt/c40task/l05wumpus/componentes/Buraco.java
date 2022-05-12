package pt.c40task.l05wumpus.componentes;

public class Buraco extends Componente {
	
	public Buraco(int x, int y) {
		super(x, y, 'B', 3);
	}
	
	public void criaBrisa() {
		for(int dx = -1; dx <= 1; dx++)
		for(int dy = -1; dy <= 1; dy++) {
			if(dx == 0 && dy == 0) continue; // sem brisa na posicao do Buraco
			Brisa brisa = new Brisa(getX() + dx, getY() + dy);
			getCaverna().adicionarElemento(brisa);
		}
	}

	@Override
	public void interagir(Heroi heroi) {
		heroi.matar();
	}

}
