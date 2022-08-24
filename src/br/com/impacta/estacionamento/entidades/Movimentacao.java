package br.com.impacta.estacionamento.entidades;

import java.time.LocalDateTime;

/**
 * Representa uma movimentação de um veículo específico no estacionamento.
 * 
 * Movimentação é o conceito que representa uma entrada de um veículo no
 * estacionamento, a permanência deste veículo um determinado tempo e
 * sua saída, gerando desta forma um valor a pagar de acordo com o
 * período de permanência.
 * 
 * @author 21no0813
 *
 */
public class Movimentacao {

	// ATRIBUTOS
	private Veiculo veiculo;
	private LocalDateTime dataHoraEntrada;
	private LocalDateTime dataHoraSaida;
	private double valor = 0;
	
	public Movimentacao(){}
	
	public Movimentacao(Veiculo veiculo, LocalDateTime dataEntrada) {
		this.veiculo = veiculo;
		this.dataHoraEntrada = dataEntrada;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public LocalDateTime getDataHoraEntrada() {
		return dataHoraEntrada;
	}
	public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}
	public LocalDateTime getDataHoraSaida() {
		return dataHoraSaida;
	}
	public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		if(valor >= 0){
			this.valor = valor;
		}
	}
	public void mostraDados() {
		this.veiculo.mostraDados();
		System.out.println("Entrada: " + this.dataHoraEntrada);
		System.out.println("Saída: " + this.dataHoraSaida);
		System.out.printf("Valor: R$ %.2f \n", this.valor);
		
	}

}
