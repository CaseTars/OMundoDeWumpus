package pt.c40task.l05wumpus.componentes;

public class Buraco extends Componente {
	
	public Buraco(int x, int y) {
		super(x, y, 'B', 3);
	}
	
	public void criaBrisa() {
		int[][] dpos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		for(int i = 0; i<dpos.length; i++) {
			Brisa brisa = new Brisa(getX() + dpos[i][0], getY() +  dpos[i][1]);
			getCaverna().inserirCompInicial(brisa);
		}
	}

	@Override
	public void interagir(Heroi heroi) {
		heroi.matar();
	}

}
