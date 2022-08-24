package br.com.impacta.estacionamento.testes;
import java.time.LocalDateTime;

import br.com.impacta.estacionamento.entidades.Movimentacao;
import br.com.impacta.estacionamento.entidades.Veiculo;

public class TesteMovimentacao {

	public static void main(String[] args) {
		
		Movimentacao mov1 = new Movimentacao();
		
		Veiculo veiculo = new Veiculo();		
		veiculo.setPlaca("BBB-2222");
		veiculo.setCor("Branca");
		veiculo.setMarca("Renault");
		veiculo.setModelo("Duster");
		
		mov1.setVeiculo(veiculo);
		
		mov1.setDataHoraEntrada(LocalDateTime.of(2016,2,2,22,30));
		mov1.setDataHoraSaida(LocalDateTime.of(2016,2,2,23,40));
		mov1.setValor(20.0);
		
		System.out.println("**** DADOS DA MOVIMENTAÇÃO ****");
		System.out.println("Placa: " + mov1.getVeiculo().getPlaca());
		System.out.println("Marca: " + mov1.getVeiculo().getMarca());
		System.out.println("Modelo: " + mov1.getVeiculo().getModelo());
		System.out.println("Cor: " + mov1.getVeiculo().getCor());
		System.out.println("*******************************");
		System.out.println("Entrada: " + mov1.getDataHoraEntrada());
		System.out.println("Saída: " + mov1.getDataHoraSaida());
		System.out.println("Valor: " + mov1.getValor());
		
		

	}

}
