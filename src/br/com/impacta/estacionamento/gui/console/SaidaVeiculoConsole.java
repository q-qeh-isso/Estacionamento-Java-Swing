package br.com.impacta.estacionamento.gui.console;

import java.util.Scanner;

import br.com.impacta.estacionamento.controle.EstacionamentoController;
import br.com.impacta.estacionamento.controle.EstacionamentoException;
import br.com.impacta.estacionamento.controle.VeiculoException;
import br.com.impacta.estacionamento.entidades.Movimentacao;
import br.com.impacta.estacionamento.entidades.Vaga;

public class SaidaVeiculoConsole {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe a placa: ");
		String placa = scan.next();
		
		
		Vaga.inicializaVagasOcupadas(0); //inicializando para teste.
		
		
		EstacionamentoController controller = new EstacionamentoController();
		Movimentacao movimentacao = null;
		try {
			movimentacao = controller.sair(placa);
		} catch (EstacionamentoException | VeiculoException e) {
			System.out.println(e.getMessage());
		} 
		
		if(movimentacao != null){
			System.out.println("**Dados de Pagamento**");
			movimentacao.mostraDados();
			System.out.println("Imprimindo cupor fiscal...");
			System.out.println("Volte sempre!!!");
		}
		
		System.out.println("Vagas livres agora: " + Vaga.livres());
	}

}
