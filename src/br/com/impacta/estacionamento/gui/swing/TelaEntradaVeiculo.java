package br.com.impacta.estacionamento.gui.swing;

import java.awt.Component;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.impacta.estacionamento.controle.EstacionamentoController;
import br.com.impacta.estacionamento.controle.EstacionamentoException;

public class TelaEntradaVeiculo extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txtPlaca;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtCor;
	private TelaPrincipal parent;


	/**
	 * Create the frame.
	 * @param telaPrincipal 
	 */
	public TelaEntradaVeiculo(TelaPrincipal telaPrincipal) {
		this.parent = telaPrincipal;
		setResizable(false);
		setTitle("Entrada de Ve\u00EDculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			txtPlaca = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtPlaca.setBounds(182, 41, 144, 20);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(182, 72, 144, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(182, 103, 144, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setBounds(182, 134, 144, 20);
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlaca.setBounds(81, 42, 64, 14);
		contentPane.add(lblPlaca);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarca.setBounds(81, 73, 64, 14);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModelo.setBounds(81, 104, 64, 14);
		contentPane.add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCor.setBounds(81, 135, 64, 14);
		contentPane.add(lblCor);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EstacionamentoController controller = new EstacionamentoController();
				String placa = txtPlaca.getText();
				String marca = txtMarca.getText();
				String modelo = txtModelo.getText();
				String cor = txtCor.getText();
				
				try {
					controller.entrar(placa, cor, marca, modelo);
					mensagemSucesso("Entrada de Veículo ok!");
				} catch (EstacionamentoException e) {
					mensagemFracasso(e);
				} finally {
					parent.setVisible(true);
					dispose();
				}
			}
			
		});
		btnOk.setMnemonic('O');
		btnOk.setBounds(104, 241, 91, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opcao = JOptionPane.showConfirmDialog(null,"Abandonar?");
				if(opcao ==  JOptionPane.YES_OPTION){
					parent.setVisible(true);
					dispose();
				}
			}
		});
		btnCancelar.setMnemonic('C');
		btnCancelar.setBounds(235, 241, 91, 23);
		contentPane.add(btnCancelar);
		
		setLocationRelativeTo(null); //centraliza a janela!
	}
	
	private void mensagemFracasso(EstacionamentoException e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	private void mensagemSucesso(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.PLAIN_MESSAGE);
	}

}
