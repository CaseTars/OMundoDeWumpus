package pt.c40task.l05wumpus.componentes;

public class Wumpus extends SerVivo {

	public Wumpus(int x, int y) {
		super(x, y, 'W', 3);
	}
	
	public void criaFedor() {
		int[][] dpos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		for(int i = 0; i<dpos.length; i++) {
			Fedor fedor = new Fedor(getX() + dpos[i][0], getY() +  dpos[i][1]);
			getCaverna().inserirCompInicial(fedor);
		}
	}

	@Override
	public void interagir(Heroi heroi) {
		if(heroi.getFlechaArmada()) { // Heroi com flecha armada 
			//boolean acertouTiro = Math.random() > 0.5 ? true : false;
			boolean acertouTiro = true;
			if(acertouTiro) {
				this.matar();
				return;
			}
		}
		heroi.matar(); // sem flecha aramaada ou perdeu na batalha
	}
}
