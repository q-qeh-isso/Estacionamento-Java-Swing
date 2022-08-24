package br.com.impacta.estacionamento.gui.console;
import java.util.Scanner;

import br.com.impacta.estacionamento.controle.EstacionamentoController;
import br.com.impacta.estacionamento.controle.EstacionamentoException;
import br.com.impacta.estacionamento.entidades.Vaga;

public class EntradaVeiculoConsole {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
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
			System.out.println(e.getMessage());
		}
		
		System.out.println("Vagas livres agora: " + Vaga.livres());
		
	}

}
