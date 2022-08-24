package br.com.impacta.estacionamento.testes;
import br.com.impacta.estacionamento.entidades.*;

public class TesteVeiculo {
	
	public static void main(String[] args) {
		
		Veiculo veic1 = new Veiculo();
		veic1.setPlaca("AAA-1111");
		veic1.setCor("Azul");
		veic1.setMarca("Mercedes");
		veic1.setModelo("C120");
		
		System.out.println("*** Dados do Veículo ***");
		System.out.println("Placa: " + veic1.getPlaca());
		System.out.println("Marca: " + veic1.getMarca());
		System.out.println("Modelo: " + veic1.getModelo());
		System.out.println("Cor: " + veic1.getCor());
		
	}

}
