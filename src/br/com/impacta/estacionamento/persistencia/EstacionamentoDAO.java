package br.com.impacta.estacionamento.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.impacta.estacionamento.entidades.Movimentacao;
import br.com.impacta.estacionamento.utilitario.EstacionamentoUtil;

/**
 * Classe que mapeia as opera��es de persistencia
 * do objeto para o repositorio de dados escolhido.
 * 
 * DAO = Data Access Object
 * 
 */

public abstract class EstacionamentoDAO {

	/**
	 * Armazena a informacao da movimentacao no repositorio de dados.
	 * 
	 * @param movimentacao	A movimentacao com dados de entrada somente
	 */
	public abstract void criar(Movimentacao movimentacao);

	
	/**
	 * Busca uma movimentacao ainda aberta no repositorio de dados cuja
	 * placa foi informada no parametro.
	 * 
	 * Movimenta��o aberta � aquela que n�o tem data de sa�da definida.(nula)
	 * 
	 * @param placa	Placa do veiculo que vai sair
	 * @return	A movimentacao aberta para o veiculo com a placa informada.
	 */
	public abstract Movimentacao buscaMovimentacaoAberta(String placa);

	
	/**
	 * Atualiza a movimentacao com dados da saida do veiculo
	 * Dados atualizados: valor e data/hora de saida
	 * 
	 * @param movimentacao Movimentacao com dados atualizados
	 */

	public abstract void atualizar(Movimentacao movimentacao);


	public static EstacionamentoDAO getInstance() {
		String tipoPersistencia = EstacionamentoUtil.get("persistencia"); 
		switch(tipoPersistencia){
		case "ARRAY":
			return new EstacionamentoArrayDAO();
		case "DATABASE":
			return new EstacionamentoDatabaseDAO();
		default:
			return null;
		}
		
	}


	public abstract int getVagasOcupadas();
	

}
