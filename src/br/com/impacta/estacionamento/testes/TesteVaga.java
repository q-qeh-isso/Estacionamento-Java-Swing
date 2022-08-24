package br.com.impacta.estacionamento.testes;
import br.com.impacta.estacionamento.entidades.*;

public class TesteVaga {
	
	public static void main(String[] args) {
	
		System.out.println("Vagas totais: " + Vaga.TOTAL_DE_VAGAS);
		Vaga.inicializaVagasOcupadas(23);
		System.out.println("Ocupadas: " + Vaga.mostraOcupadas());
		
	}

}
