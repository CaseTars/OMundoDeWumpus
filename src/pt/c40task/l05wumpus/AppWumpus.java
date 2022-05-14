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
      MontadorDaCaverna bobMontador = new MontadorDaCaverna(cave);
      
      if(bobMontador.montar()) { 
          ControleDoJogo controle = new ControleDoJogo();
          controle.conectaHeroi(bobMontador.getHeroi());
          controle.conectaWumpus(bobMontador.getWumpus());
          
    	  char command;
    	  
          if(arquivoMovimentos == null) { //modo interativo
        	  Scanner keyboard = new Scanner(System.in);
        	  Impressao.pegarNome();
        	  controle.setNome(keyboard.nextLine());
        	  
        	  Impressao.estado(controle.getCaverna(), controle.getNome(), controle.getScore());

        	  while(controle.getRodando()) {
        		  command = keyboard.nextLine().charAt(0);
        		  int erro = controle.executa(command);
        		  if(erro != 0) {
        			  Impressao.mensagem("Movimento Inválido!");
        			  continue;
        		  }
        		  Impressao.estado(controle.getCaverna(), controle.getNome(), controle.getScore());
        	  }
        	  Impressao.mensagem("Volte sempre!! ;)");
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
      }
      else { //arquivo zuado
    	  Impressao.mensagem("Erro");
      }
      tk.stop();
   }

}
