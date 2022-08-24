package br.com.impacta.estacionamento.entidades;

import br.com.impacta.estacionamento.persistencia.EstacionamentoDatabaseDAO;

/**
 * Representa o conceito de vagas do estacionamento.
 * As vagas do estacionamento n�o s�o identificadas, sendo,
 * em teoria, semelhantes entre si.
 * 
 * Esta classe possui a informa��o de total de vagas do
 * estacionamento, bem como a quantidade de vagas ocupadas
 * at� o momento presente.
 * 
 * @author 21no0813
 *
 */
public class Vaga {

	// ATRIBUTOS
	public static final int TOTAL_DE_VAGAS = 100;
	private static int vagasOcupadas = 0;
	
	static {
		
		int ocupadas = EstacionamentoDatabaseDAO.getInstance().getVagasOcupadas();
		inicializaVagasOcupadas(ocupadas);
		
	}
	
	
	public static void inicializaVagasOcupadas(int valor){
		if(valor >= 0 && valor <= TOTAL_DE_VAGAS){
			vagasOcupadas = valor;
		}
	}

	public static int mostraOcupadas() {
		return vagasOcupadas;
	}

	public static boolean lotado() {
		return (vagasOcupadas == TOTAL_DE_VAGAS); //retorna TRUE qnd vagasOcupadas forem igual ao TOTAL_DE_VAGAS
	}

	public static void entrou() {
		vagasOcupadas++;		
	}

	public static int livres() {
		return (TOTAL_DE_VAGAS - vagasOcupadas);
	}

	public static boolean vazio() {
		return (vagasOcupadas == 0);
	}

	public static void saiu() {
		vagasOcupadas--;		
	}

}
