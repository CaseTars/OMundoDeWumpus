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
      
      boolean montagemOK = bobMontador.montar();
      if(montagemOK) { 
          ControleDoJogo controle = new ControleDoJogo();
          controle.conectaHeroi(bobMontador.getHeroi());
          controle.conectaWumpus(bobMontador.getWumpus());
    	  boolean teste = false;
          //arquivoMovimentos == null
          if(teste) { //modo interativo
        	  Scanner keyboard = new Scanner(System.in);
        	  Impressao.pegarNome();
        	  controle.setNome(keyboard.nextLine());
        	  
        	  Impressao.estado(controle.getCaverna(), controle.getNome(), controle.getScore());
    		  Impressao.inventario(controle.getHeroi());

        	  while(controle.getRodando()) {
        		  String command = keyboard.nextLine();
        		  int erro = controle.executa(command);
        		  
        		  if(erro != 0) {
        			  Impressao.erro(erro);
        			  continue;
        		  }
        		  
        		  Impressao.estado(controle.getCaverna(), controle.getNome(), controle.getScore());
        		  Impressao.inventario(controle.getHeroi());
        		  Impressao.mensagem("");
        		  Impressao.imprimeMensagens();
        	  }
        	  
        	  Impressao.fimDeJogo(controle.getStatus());
        	  keyboard.close();
          }
   
          else { // modo arquivo
        	  //String movements = tk.retrieveMovements();
        	  String movements = "ddkscwaa";
        	  int caracAtual = 1;
        	  controle.setNome("Alcebiades");
        	  
        	  while(controle.getRodando() && caracAtual < movements.length()) {
        		  char command = movements.charAt(caracAtual++);
        		  System.out.println(command);
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
      else { //arquivo de montagem inadequado
    	  Impressao.mensagem("Erro na montagem do mapa.");
      }
      tk.stop();
   }

}
