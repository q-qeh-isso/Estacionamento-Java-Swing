package br.com.impacta.estacionamento.persistencia;

import br.com.impacta.estacionamento.entidades.Movimentacao;
import br.com.impacta.estacionamento.entidades.Vaga;

public class EstacionamentoArrayDAO extends EstacionamentoDAO {

	private static Movimentacao[] movimentacoes = new Movimentacao[Vaga.TOTAL_DE_VAGAS];
	
	@Override
	public void criar(Movimentacao movimentacao) {
		
		for(int i = 0; i < movimentacoes.length; i++){
			if(movimentacoes[i] == null){
				movimentacoes[i] = movimentacao;
				break;
			}
		}
		
	}

	@Override
	public Movimentacao buscaMovimentacaoAberta(String placa) {
		for(Movimentacao movimentacao : movimentacoes){
			if(movimentacao != null && 
					movimentacao.getVeiculo().getPlaca().equals(placa) &&
					movimentacao.getDataHoraSaida() == null){
				
				return movimentacao;
			}
		}
		return null;
	}

	@Override
	public void atualizar(Movimentacao movimentacao) {
		for(int i = 0; i < movimentacoes.length; i++){
			if(movimentacao == movimentacoes[i]){
				movimentacoes[i] = null; //libera a vaga
			}
		}
	}

	@Override
	public int getVagasOcupadas() {
		return 0;
	}

}
