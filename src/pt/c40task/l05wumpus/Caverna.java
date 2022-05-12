package pt.c40task.l05wumpus;

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
	
	public boolean inserir(Componente aInserir, int posX, int posY) { //retorno?
		if(sala[posX][posY].inserirComponente(aInserir)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void mover() { //talvez precise de retorno se caso o movimento for invalido
		
	}
	
	public void interagir() { //retornar resultados neh
		
	}
}
