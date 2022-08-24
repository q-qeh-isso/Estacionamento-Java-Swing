package br.com.impacta.estacionamento.entidades;
/**
 * Representa o veiculo que faz uso do estacionamento.
 * 
 * @author 21no0813
 *
 */
public class Veiculo {

	// ATRIBUTOS
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	
	public Veiculo(){}
	
	public Veiculo(String rplaca, String rmarca, String rmodelo, String rcor) {
		this.placa = rplaca;
		this.marca = rmarca;
		this.modelo = rmodelo;
		this.cor = rcor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public void mostraDados() {
		System.out.println("Placa: " + this.placa);
		System.out.println("Marca: " + this.marca);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Cor: " + this.cor);
	}
	
	

}
