package pt.c40task.l05wumpus;
import pt.c40task.l05wumpus.componentes.Heroi;
import pt.c40task.l05wumpus.componentes.Wumpus;
import pt.c40task.l05wumpus.componentes.Buraco;
import pt.c40task.l05wumpus.componentes.Ouro;

public class MontadorDaCaverna {
	private String cave[][];
	private Heroi heroi;
	private Wumpus wumpus;
	private Buraco[] buracos;
	private Ouro ouro;
	private Caverna caverna;
	private int posBuracos;
	private int qtdBuracos;
	private boolean posicoesOk;
	
	public MontadorDaCaverna(String cave[][]) { 
		this.cave = cave;
		this.buracos = new Buraco[3];
		this.posBuracos = 0;
		this.posicoesOk = true;
		this.qtdBuracos = 0;
	}
	
	public boolean montar() {
		boolean saida = true;
		if(conferirArquivo()) {
			criarCaverna();		
			
			for(int i=0;i < cave.length;i++) {//rever esse length
				int posX = cave[i][0] - 1;  
				int posY = cave[i][2] - 1;
				
				switch(cave[i][4]) {
					case "P":
						this.heroi = new Heroi(posX, posY); 
						saida = caverna.inserir(heroi, posX, posY); 
						break;
					case "O":
						this.ouro = new Ouro(posX, posY);  
						saida = caverna.inserir(ouro, posX, posY);
						break;
					case "B":
						this.buracos[posBuracos] = new Buraco(posX, posY);
						saida = caverna.inserir(buracos[posBuracos], posX, posY); 
						posBuracos += 1;
						break;
					case "W":
						this.wumpus = new Wumpus(posX, posY);
						saida = caverna.inserir(wumpus, posX, posY);
						break;
					default:
						break;
				}
			}
		}
		else {
			saida =  false;
		}
		return saida;
	}
	public boolean conferirArquivo() {
		int qtdBuracos;
		int qtdWumpus;
		int qtdOuro;
		int qtdHeroi;
		int posX;
		int posY;
		
		for(int i=0;i < cave.length;i++) {
			int posX = cave[i][0];  //BO de String e char
			int posY = cave[i][2];
			conferirPos(posX, posY);
			
			switch(cave[i][4]) {
				case "P":
					if(posX != 1 || posY != 1) {
						this.posicoesOk = false;
					}
					qtdHeroi += 1;
					break;
				case "O":
					qtdOuro += 1;
					break;
				case "B":
					qtdBuracos += 1;
					this.qtdBuracos += 1;
					break;
				case "W":
					qtdWumpus += 1;
					break;
				default:
					break;
			}
		}
		if(qtdBuracos < 2 || qtdBuracos > 3 || qtdWumpus != 1 || qtdHeroi != 1 || qtdOuro != 1 || !posicoesOk) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void conferirPos(int posX, int posY) {
		if(posX < 1 || posX > 4 || posY < 1 || posY > 4) {
			this.posicoesOk = false;
		}
	}
	
	public void criarCaverna() {
		this.caverna = new Caverna();
	}
	
	public Heroi getHeroi() {
		return heroi;
	}
}
