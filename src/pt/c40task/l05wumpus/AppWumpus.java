package pt.c40task.l05wumpus;
import java.util.Scanner;

public class AppWumpus {

   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
      
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      
      
      //Construcao
      String cave[][] = tk.retrieveCave();
      System.out.println("=== Caverna");
      for (int l = 0; l < cave.length; l++) {
         for (int c = 0; c < cave[l].length; c++)
            System.out.print(cave[l][c] + ((c < cave[l].length-1) ? ", " : ""));
         System.out.println();
      }
      MontadorDaCaverna bobMontador = new MontadorDaCaverna(cave);
      
      ControleDoJogo controle = new ControleDoJogo();

	  char command;
	  
      if(arquivoMovimentos == null) { //modo interativo
    	  Scanner keyboard = new Scanner(System.in);
    	  Impressao.pegarNome();
    	  controle.setNome(keyboard.nextLine());
    	  
    	  while(controle.rodando()) {
    		  command = keyboard.nextLine().charAt(0);
    		  int erro = controle.executa(command);
    		  if(erro != 0) {
    			  Impressao.mensagem("Movimento Inválido!");
    			  continue;
    		  }
    		  Impressao.jogo(controle);
    	  }
      }
      else { // modo arquivo
    	  String movements = tk.retrieveMovements();
    	  int caracAtual = 0;
    	  controle.setNome("Alcebiades");
    	  
    	  while(controle.rodando()) {
    		  command = movements.charAt(caracAtual++);
    		  int erro = controle.executa(command);
    		  if(erro != 0)
    			  continue;
    		  char cave[][] = controle.caverna();
    		  int score = controle.score();
    		  char status = controle.status();
    		  tk.writeBoard(cave, score, status);
    	  }
      }
      tk.stop();
   }

}
