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
      
      if(bobMontador.montar()) { //so vai funcionar o jogo se isso der bom, colocar mensagens de erros e tals
    	  
      }
      
      //Execucao
      ControleDoJogo controle = new ControleDoJogo();
      controle.conectaHeroi(bobMontador.getHeroi());
      
	  char command;
	  
      if(arquivoMovimentos == null) { //modo interativo
    	  Scanner keyboard = new Scanner(System.in);
    	  Impressao.pegarNome();
    	  controle.setNome(keyboard.nextLine());
    	  
    	  while(controle.getRodando()) {
    		  command = keyboard.nextLine().charAt(0);
    		  int erro = controle.executa(command);
    		  if(erro != 0) {
    			  Impressao.mensagem("Movimento Inválido!");
    			  continue;
    		  }
    		  Impressao.jogo(controle);
    	  }
    	  keyboard.close();
      }
      else { // modo arquivo
    	  String movements = tk.retrieveMovements();
    	  int caracAtual = 0;
    	  controle.setNome("Alcebiades");
    	  
    	  while(controle.getRodando()) {
    		  command = movements.charAt(caracAtual++);
    		  int erro = controle.executa(command);
    		  if(erro != 0)
    			  continue;
    		  char caverna[][] = controle.getCaverna();
    		  int score = controle.getScore();
    		  char status = controle.getStatus();
    		  tk.writeBoard(caverna, score, status);
    	  }
      }
      tk.stop();
   }

}
