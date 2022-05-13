package pt.c40task.l05wumpus.componentes;

public class Ouro extends Componente {
	public Heroi heroiCarregando = null;

	public Ouro(int x, int y) {
		super(x, y, 'O', 3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void interagir(Heroi heroi) {
		if(!heroi.getPegandoOuro()) return;
		cave.remover(this);
		heroi.setOuro(this);
		heroiCarregando = heroi;
	}
	
	// ---------------------- Reescreve as classes getX e getY para que o a posicao do ouro seja igual
	// ---------------------- a posicao do heroi
	@Override
	public int getX() {
		if(heroiCarregando == null)
			return super.getX();
		return heroiCarregando.getX();
	}
	
	@Override
	public int getY() {
		if(heroiCarregando == null)
			return super.getY();
		return heroiCarregando.getY();
	}
	
}
