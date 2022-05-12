package pt.c40task.l05wumpus;
import pt.c40task.l05wumpus.componentes.Heroi;
import pt.c40task.l05wumpus.componentes.Wumpus;
import pt.c40task.l05wumpus.componentes.Buraco;
import pt.c40task.l05wumpus.componentes.Ouro;

public class MontadorDaCaverna {   //n precisa ter todos , so o wumpus e heroi
	private String cave[][];
	private Heroi heroi;
	private Wumpus wumpus;
	private Buraco[] buracos;
	private Ouro ouro;
	private Caverna caverna;
	private int posBuracos;
	private boolean posicoesOk;
	
	public MontadorDaCaverna(String cave[][]) { 
		this.cave = cave;
		this.buracos = new Buraco[3];
		this.posBuracos = 0;
		this.posicoesOk = true;
	}
	
	public boolean montar() {
		boolean saida = true;
		if(conferirArquivo()) {
			criarCaverna();		
			
			for(int i=0;i < cave.length;i++) {
				int posX = Integer.parseInt(cave[i][0]) -1;  
				int posY = Integer.parseInt(cave[i][1]) -1;
				
				switch(cave[i][2]) {
					case "P":
						this.heroi = new Heroi(posX, posY); 
						this.heroi.conectaCaverna(caverna);
						saida = caverna.inserir(heroi); 
						break;
					case "O":
						this.ouro = new Ouro(posX, posY);  
						this.ouro.conectaCaverna(caverna);
						saida = caverna.inserir(ouro);
						break;
					case "B":
						this.buracos[posBuracos] = new Buraco(posX, posY);
						this.buracos[posBuracos].conectaCaverna(caverna);
						this.buracos[posBuracos].criaBrisa();
						saida = caverna.inserir(buracos[posBuracos]); 
						posBuracos += 1;
						break;
					case "W":
						this.wumpus = new Wumpus(posX, posY);
						this.wumpus.conectaCaverna(caverna);
						this.wumpus.criaFedor();
						saida = caverna.inserir(wumpus);
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
		int qtdBuracos = 0;
		int qtdWumpus = 0;
		int qtdOuro = 0;
		int qtdHeroi = 0;
		int posX;
		int posY;
		
		for(int i=0;i < cave.length;i++) {
			posX = Integer.parseInt(cave[i][0]);  
			posY = Integer.parseInt(cave[i][1]);
			conferirPos(posX, posY);
			
			switch(cave[i][2]) {
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
					break;
				case "W":
					qtdWumpus += 1;
					break;
				default:
					break;
			}
		}
		if(qtdBuracos < 2 || qtdBuracos > 3 || qtdWumpus != 1 || qtdHeroi != 1 || qtdOuro != 1 || !posicoesOk)
			return false;
		return true;
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
	public Wumpus getWumpus() {
		return wumpus;
	}
}
