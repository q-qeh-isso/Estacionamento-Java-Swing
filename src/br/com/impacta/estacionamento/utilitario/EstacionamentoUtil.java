package br.com.impacta.estacionamento.utilitario;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

import br.com.impacta.estacionamento.entidades.Movimentacao;
import br.com.impacta.estacionamento.entidades.Tarifario;

public class EstacionamentoUtil {
	
	//TODO apagar antes de implantar o sistema
	public static void main(String[] args) {
		System.out.println(get("persistencia"));
	}

	public static void calcularValor(Movimentacao movimentacao) {
		long diffHoras = movimentacao.getDataHoraEntrada().
				until(movimentacao.getDataHoraSaida(), ChronoUnit.HOURS);
		long diffMinutos = movimentacao.getDataHoraEntrada().
				until(movimentacao.getDataHoraSaida(), ChronoUnit.MINUTES);
		
		double valor = 0;
		
		if(diffMinutos > 15){
			if(diffMinutos > 60){ // ou >= 60
				valor += Tarifario.VALOR_PRIMEIRA_HORA;
				diffMinutos -= 60;
			}			
			valor += ( (diffMinutos/Tarifario.INCREMENTO_EM_MINUTOS) 
					* Tarifario.VALOR_INCREMENTAL );
		}
		movimentacao.setValor(valor);
	}

	public static String get(String chave) {
		Properties prop = new Properties();
		try {
			//prop.load(new FileInputStream("configuration.txt"));
			prop.load(EstacionamentoUtil.class.getResourceAsStream("/resources/configuration.txt"));
			String valor = prop.getProperty(chave);
			return valor;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static String getDataAsString(LocalDateTime data) {
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	}
	public static LocalDateTime getDate(String dataAsString){
		return LocalDateTime.parse(dataAsString,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
	}

}
