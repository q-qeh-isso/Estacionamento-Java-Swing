package br.com.impacta.estacionamento.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import br.com.impacta.estacionamento.entidades.Movimentacao;
import br.com.impacta.estacionamento.entidades.Veiculo;
import br.com.impacta.estacionamento.utilitario.EstacionamentoUtil;


public class EstacionamentoDatabaseDAO extends EstacionamentoDAO {

	@Override
	public void criar(Movimentacao movimentacao) {
		Connection conexao = getConnection();
		String cmd = EstacionamentoUtil.get("insertMovimentacao");
		
		try(PreparedStatement pStmt = conexao.prepareStatement(cmd)){		
			pStmt.setString(1, movimentacao.getVeiculo().getPlaca());
			pStmt.setString(2, movimentacao.getVeiculo().getMarca());
			pStmt.setString(3, movimentacao.getVeiculo().getModelo());
			pStmt.setString(4, movimentacao.getVeiculo().getCor());
			pStmt.setString(5, movimentacao.getDataHoraEntrada().toString());
			
			pStmt.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			closeConnection(conexao);
		}
	}

	@Override
	public Movimentacao buscaMovimentacaoAberta(String placa) {
		Movimentacao movimentacao = null;
		Connection conexao = getConnection();		
		String cmd = EstacionamentoUtil.get("selectMovAberta");
		
		try(PreparedStatement pStmt = conexao.prepareStatement(cmd))
		{
			pStmt.setString(1, placa);
			ResultSet result = pStmt.executeQuery();
			if(result.next()){
				String rplaca = result.getString("placa");
				String rmarca = result.getString("marca");
				String rmodelo = result.getString("modelo");
				String rcor = result.getString("cor");
				String rdataEntrada = result.getString("dataEntrada");
				String rdataSaida = result.getString("dataSaida");
				double valor = result.getDouble("valor");
								
				Veiculo veiculo = new Veiculo(rplaca,rmarca,rmodelo,rcor);
				LocalDateTime dataEntrada = EstacionamentoUtil.getDate(rdataEntrada);				
				movimentacao = new Movimentacao(veiculo, dataEntrada);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnection(conexao);
		}
		
		
		
		return movimentacao;
	}

	@Override
	public void atualizar(Movimentacao movimentacao) {
		Connection conexao = getConnection();
		String cmd = EstacionamentoUtil.get("updateMovimentacao");
		
		try(PreparedStatement pStmt = conexao.prepareStatement(cmd)){
			pStmt.setString(1, movimentacao.getDataHoraSaida().toString());
			pStmt.setDouble(2, movimentacao.getValor());
			pStmt.setString(3, movimentacao.getVeiculo().getPlaca());
			
			pStmt.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			closeConnection(conexao);
		}
	}
	
	private static Connection getConnection(){
		String url = EstacionamentoUtil.get("urlConexao");
		String usuario = EstacionamentoUtil.get("usuarioBanco");
		String senha = EstacionamentoUtil.get("senhaBanco");
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url,usuario,senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	private static void closeConnection(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getVagasOcupadas() {
		Connection conexao = getConnection();		
		String cmd = EstacionamentoUtil.get("selectOcupadas");
		
		try(PreparedStatement pStmt = conexao.prepareStatement(cmd))
		{
			ResultSet result = pStmt.executeQuery();
			
			if(result.next()){
				int ocupadas = result.getInt(1);
				return ocupadas;				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnection(conexao);
		}
		
		return 0;
	}

}
