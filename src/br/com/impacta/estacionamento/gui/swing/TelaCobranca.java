package br.com.impacta.estacionamento.gui.swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.impacta.estacionamento.entidades.Movimentacao;
import br.com.impacta.estacionamento.entidades.Veiculo;
import br.com.impacta.estacionamento.utilitario.EstacionamentoUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCobranca extends JFrame {

	private JPanel contentPane;
	private JFrame parent;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movimentacao mov = new Movimentacao();
					mov.setVeiculo(new Veiculo());
					mov.getVeiculo().setPlaca("AAA-2323");
					mov.setDataHoraEntrada(LocalDateTime.now());
					mov.setDataHoraSaida(LocalDateTime.now());
					mov.setValor(23.45);
					
					TelaCobranca frame = new TelaCobranca(mov);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/


	/**
	 * Create the frame.
	 * @param parent 
	 */
	public TelaCobranca(TelaPrincipal parent, Movimentacao movimentacao) {
		this.parent = parent;
		setResizable(false);
		setTitle("Dados de Pagamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlaca.setBounds(78, 41, 100, 14);
		contentPane.add(lblPlaca);
		
		JLabel lblEntrada = new JLabel("Entrada:");
		lblEntrada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEntrada.setBounds(78, 81, 100, 14);
		contentPane.add(lblEntrada);
		
		JLabel lblSaida = new JLabel("Sa\u00EDda:");
		lblSaida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSaida.setBounds(78, 122, 100, 14);
		contentPane.add(lblSaida);
		
		JLabel lblPlacaValor = new JLabel(movimentacao.getVeiculo().getPlaca());
		lblPlacaValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlacaValor.setBounds(198, 41, 160, 14);
		contentPane.add(lblPlacaValor);
		
		JLabel lblEntradaValor = new JLabel( EstacionamentoUtil.getDataAsString(movimentacao.getDataHoraEntrada()) );
		lblEntradaValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEntradaValor.setBounds(198, 81, 160, 14);
		contentPane.add(lblEntradaValor);
		
		JLabel lblSaidaValor = new JLabel( EstacionamentoUtil.getDataAsString(movimentacao.getDataHoraSaida()) );
		lblSaidaValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSaidaValor.setBounds(198, 122, 160, 14);
		contentPane.add(lblSaidaValor);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValor.setBounds(78, 166, 100, 14);
		contentPane.add(lblValor);
		
		JLabel lblValorValor = new JLabel("R$ " + movimentacao.getValor());
		lblValorValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValorValor.setBounds(198, 166, 160, 14);
		contentPane.add(lblValorValor);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				parent.setVisible(true);
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOk.setBounds(173, 241, 91, 23);
		contentPane.add(btnOk);
		
		setLocationRelativeTo(null);
	}

}
