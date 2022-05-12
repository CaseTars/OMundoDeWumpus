package pt.c40task.l05wumpus;
import pt.c40task.l05wumpus.componentes.Heroi;

public class Salas {
	private Componente[] vComponentes;
	private Heroi heroi;
	private boolean temComponentes;
	private int posVetor;
	private int tamVetor;
	
	public Salas() {
		this.vComponentes = new Componente[10]; //pd ser menos
		this.temComponentes = false;
		this.posVetor = 0;
		this.tamVetor = 0;
	}
	
	public boolean inserirComponente(Componente aInserir) { 
		boolean saida = true;
		if(!temComponentes) {
			this.vComponentes[posVetor] = aInserir;
			this.posVetor += 1;
			this.tamVetor += 1;
			this.temComponentes = true;
		}
		else {
			for(int i = 0;i < tamVetor;i++) { //tem outros casos??
				if(aInserir.getSimbolo() == 'O' && vComponentes[i].getSimbolo() == 'W') {
					saida = false;
				}
				if(aInserir.getSimbolo() == 'O' && vComponentes[i].getSimbolo() == 'B') {
					saida = false;
				}
				if(aInserir.getSimbolo() == 'W' && vComponentes[i].getSimbolo() == 'B') {
					saida = false;
				}
				if(aInserir.getSimbolo() == 'P' && vComponentes[i].getSimbolo() == 'W') {
					saida = false;
				}
			}
			if(saida) {
				this.vComponentes[posVetor] = aInserir;
				this.posVetor += 1;
				this.tamVetor += 1;
			}
		}
		return saida;
	}
	
	public void interagir(Heroi heroi) {  //vai interagir cm td mundo?
		
	}
	
	
	public boolean getTemComponentes() {
		return temComponentes;
	}
}
