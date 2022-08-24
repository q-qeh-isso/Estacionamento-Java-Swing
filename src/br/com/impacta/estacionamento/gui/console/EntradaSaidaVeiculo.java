package br.com.impacta.estacionamento.gui.console;

import java.util.Scanner;

import br.com.impacta.estacionamento.controle.EstacionamentoController;
import br.com.impacta.estacionamento.controle.EstacionamentoException;
import br.com.impacta.estacionamento.controle.VeiculoException;
import br.com.impacta.estacionamento.entidades.Movimentacao;
import br.com.impacta.estacionamento.entidades.Vaga;

public class EntradaSaidaVeiculo {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
				
		//Realiza quantas entradas de veiculo o usuario desejar
		while(true){
			System.out.println("Nova Entrada? (S)im (N)ão");
			String resposta = scan.next();
			
			if(resposta.equalsIgnoreCase("N")){
				break;
			}
			
			entrar();
			
		}
		
		//Realiza quantas saidas de veiculo o usuario desejar
		while(true){
			System.out.println("Nova Saída? (S)im (N)ão");
			String resposta = scan.next();
			
			if(resposta.equalsIgnoreCase("N")){
				break;
			}
			
			sair();
			
		}
		
	} //fim main

	private static void sair() {
		System.out.println("Informe a placa: ");
		String placa = scan.next();		

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

	private static void entrar() {
		System.out.println("Informe a placa: ");
		String placa = scan.next();
		
		System.out.println("Informe a cor: ");
		String cor = scan.next();
		
		System.out.println("Informe a marca: ");
		String marca = scan.next();
		
		System.out.println("Informe o modelo: ");
		String modelo = scan.next();
		
		EstacionamentoController controller = new EstacionamentoController();		
		try {
			controller.entrar(placa, cor, marca, modelo);
		} catch (EstacionamentoException e) {
			System.out.println("ERRO: " + e.getMessage());
		}		
		System.out.println("Vagas livres agora: " + Vaga.livres());		
	}

}
