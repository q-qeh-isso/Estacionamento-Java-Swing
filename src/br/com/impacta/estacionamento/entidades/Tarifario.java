package br.com.impacta.estacionamento.entidades;
/**
 * RepresentA a politica de cobrança do estacionamento.
 * 
 * A primeira hora tem um valor fixo e após a primeira hora 
 * é aplicado um valor incremental a partir de uma quantidade
 * de minutos pré-estabelecida. 
 * 
 * @author 21no0813
 *
 */
public class Tarifario {

	// ATRIBUTOS
	public static final double VALOR_PRIMEIRA_HORA = 20;
	public static final double VALOR_INCREMENTAL = 2;
	public static final int INCREMENTO_EM_MINUTOS = 15;

}
