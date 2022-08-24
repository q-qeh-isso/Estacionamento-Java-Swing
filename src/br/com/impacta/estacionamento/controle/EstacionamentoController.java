package br.com.impacta.estacionamento.controle;

import java.time.LocalDateTime;
import java.util.Date;

import br.com.impacta.estacionamento.entidades.Movimentacao;
import br.com.impacta.estacionamento.entidades.Vaga;
import br.com.impacta.estacionamento.entidades.Veiculo;
import br.com.impacta.estacionamento.persistencia.EstacionamentoDAO;
import br.com.impacta.estacionamento.utilitario.EstacionamentoUtil;

/**
 * Classe que cont�m as regras de neg�cio e conhece
 * todo o fluxo de informa��es das opera��es do sistema
 * de estacionamento.
 * 
 */
public class EstacionamentoController {
	/**
	 * Realiza a entrada de um veiculo cujo dados foram informados como
	 * parametros. Este metodo gera um novo conjunto de dados de movimentacao
	 * no estacionamento.
	 * 
	 * @param placa 	A placa do veiculo estacionado
	 * @param cor 		A cor do veiculo estacionado
	 * @param marca		A marca do veiculo estacionado
	 * @param modelo 	O modelo do veiculo estacionado
	 * 
	 * @throws EstacionamentoException Se o estacionamento estiver lotado.
	 */
	public void entrar(String placa, String cor, String marca, String modelo) throws EstacionamentoException {
		
		//verifica se pode entrar com um novo veiculo
		if (Vaga.lotado()){
			throw new EstacionamentoException("Est� Lotado!");
		}
		
		if(placa.isEmpty()){
			throw new EstacionamentoException("Placa n�o informada!");
		}
		
		//ocupa uma vaga nova
		Vaga.entrou();
		
		Veiculo carro = new Veiculo();
		carro.setPlaca(placa);
		carro.setMarca(marca);
		carro.setModelo(modelo);
		carro.setCor(cor);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setVeiculo(carro);
		movimentacao.setDataHoraEntrada(LocalDateTime.now());
		
		//Grava as informacoes da movimentacoe no repositorio
		EstacionamentoDAO dao = EstacionamentoDAO.getInstance();
		dao.criar(movimentacao);
		
	}

	/**
	 * Realiza o procedimento de sa�da do veiculo do estacionamento
	 * cujo a placa foi informada no parametro
	 * 
	 * @param placa	Placa do veiculo que est� saindo do estacionamento.
	 * 
	 * @return Movimenta��o com todos os dados para cobran�a
	 * 
	 * @throws EstacionamentoException  Se o estacionamento estiver vazio
	 * @throws VeiculoException Se o ve�culo em quest�o n�o estiver estacionado.
	 */
	public Movimentacao sair(String placa) throws EstacionamentoException, VeiculoException {
		
		if(Vaga.vazio()){
			throw new EstacionamentoException("Estacionamento vazio!!");
		}
		
		//Busca movimentacao aberta para a placa informada
		EstacionamentoDAO dao = EstacionamentoDAO.getInstance();
		Movimentacao movimentacao = dao.buscaMovimentacaoAberta(placa);
		
		if(movimentacao == null){
			throw new VeiculoException("Veiculo n�o encontrado! Placa: " + placa + "\n");
		}
		
		Vaga.saiu();
		
		movimentacao.setDataHoraSaida(LocalDateTime.now());
		EstacionamentoUtil.calcularValor(movimentacao);
		
		//armazena dados atualizados da movimentacao = fecha movimentacao
		dao.atualizar(movimentacao);
		
		return movimentacao;
	}

}
