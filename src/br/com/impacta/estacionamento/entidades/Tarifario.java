package br.com.impacta.estacionamento.entidades;
/**
 * RepresentA a politica de cobran�a do estacionamento.
 * 
 * A primeira hora tem um valor fixo e ap�s a primeira hora 
 * � aplicado um valor incremental a partir de uma quantidade
 * de minutos pr�-estabelecida. 
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
