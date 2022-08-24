package br.com.impacta.estacionamento.gui.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.impacta.estacionamento.controle.EstacionamentoController;
import br.com.impacta.estacionamento.controle.EstacionamentoException;
import br.com.impacta.estacionamento.controle.VeiculoException;
import br.com.impacta.estacionamento.entidades.Movimentacao;

public class TelaSaidaVeiculo extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txtPlaca;
	private TelaPrincipal parent;


	/**
	 * Create the frame.
	 * @param telaPrincipal 
	 */
	public TelaSaidaVeiculo(TelaPrincipal telaPrincipal) {
		this.parent = telaPrincipal;
		setResizable(false);
		setTitle("Sa\u00EDda de Ve\u00EDculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlaca.setBounds(57, 32, 82, 14);
		contentPane.add(lblPlaca);
		
		try {
			txtPlaca = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtPlaca.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaca.setForeground(Color.BLUE);
		txtPlaca.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPlaca.setBounds(147, 24, 148, 30);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EstacionamentoController controller = new EstacionamentoController();
				String placa = txtPlaca.getText();
				try {
					Movimentacao movimentacao = controller.sair(placa);
					TelaCobranca tela = new TelaCobranca(parent,movimentacao);
					tela.setVisible(true);
				} catch (EstacionamentoException | VeiculoException e) {
					mensagemFracasso(e);
					parent.setVisible(true);
				} finally {
					dispose(); // tira a tela ativa da memoria
				}
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOk.setBounds(75, 91, 91, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opcao = JOptionPane.showConfirmDialog(null, "Abandonar?");
				if(opcao ==  JOptionPane.YES_OPTION){
					parent.setVisible(true);
					dispose();
				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(204, 91, 91, 23);
		contentPane.add(btnCancelar);
		
		setLocationRelativeTo(null); //centraliza a tela
	}
	
	private void mensagemFracasso(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	}


}
