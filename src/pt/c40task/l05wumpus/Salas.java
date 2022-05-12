package pt.c40task.l05wumpus;
import pt.c40task.l05wumpus.componentes.Heroi;
import pt.c40task.l05wumpus.componentes.Componente;


public class Salas {
	private Componente[] vComponentes;
	private Heroi heroi;
	private boolean temComponentes;
	private boolean descoberta;
	private int posVetor;
	
	public Salas() {
		this.vComponentes = new Componente[10]; //pd ser menos
		this.temComponentes = false;
		this.descoberta = false;
		this.posVetor = 0;
	}
	
	public boolean inserir(Componente aInserir) { 
		boolean saida = true;
		if(!temComponentes) {
			this.vComponentes[posVetor] = aInserir;
			this.posVetor += 1;
			this.temComponentes = true;
		}
		else {
			for(int i = 0;i < posVetor;i++) { //tem outros casos??
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
			}
		}
		return saida;
	}
	
	public void entrar(Heroi heroi) {
		this.heroi = heroi; 
		this.descoberta = true;
	}
	
	public void sair() {
		heroi = null;
	}
	
	public void interagir() {  
		for(int i=0;i < vComponentes.length;i++) {
			vComponentes[i].interagir(heroi);
		}
	}
	
	public boolean getDescoberta() {
		return descoberta;
	}
	
	public char getSimbolo() {
		if(!descoberta) return '-';
		int maior = -1;
		char caract = '#';
		for(int i=0;i < posVetor;i++) {
			maior = vComponentes[i].getPrioridade() > maior ? vComponentes[i].getPrioridade() : maior;
		}
		for(int i=0;i < posVetor;i++) {
			if(vComponentes[i].getPrioridade() == maior) {
				caract = vComponentes[i].getSimbolo();
			}
		}
		return caract;
	}
	
	public boolean getTemComponentes() {
		return temComponentes;
	}
}
