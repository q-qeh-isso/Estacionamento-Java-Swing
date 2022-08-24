package br.com.impacta.estacionamento.entidades;

import java.time.LocalDateTime;

/**
 * Representa uma movimenta��o de um ve�culo espec�fico no estacionamento.
 * 
 * Movimenta��o � o conceito que representa uma entrada de um ve�culo no
 * estacionamento, a perman�ncia deste ve�culo um determinado tempo e
 * sua sa�da, gerando desta forma um valor a pagar de acordo com o
 * per�odo de perman�ncia.
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
		System.out.println("Sa�da: " + this.dataHoraSaida);
		System.out.printf("Valor: R$ %.2f \n", this.valor);
		
	}

}
