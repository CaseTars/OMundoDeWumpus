package pt.c40task.l05wumpus.componentes;

public class Wumpus extends SerVivo {

	public Wumpus(int x, int y) {
		super(x, y, 'W', 3);
	}
	
	public void criaFedor() {
		for(int dx = -1; dx <= 1; dx++)
		for(int dy = -1; dy <= 1; dy++) {
			if(dx == 0 && dy == 0) continue; // sem fedor na posicao do Wumpus
			Fedor fedor = new Fedor(getX() + dx, getY() + dy);
			getCaverna().adicionarElemento(fedor);
		}
	}

	@Override
	public void interagir(Heroi heroi) {
		if(heroi.getFlechaArmada()) { // Heroi com flecha armada 
			boolean acertouTiro = Math.random() > 0.5 ? true : false;
			if(acertouTiro) {
				this.matar();
				return;
			}
		}
		heroi.matar(); // sem flecha aramaada ou perdeu na batalha
	}
}
