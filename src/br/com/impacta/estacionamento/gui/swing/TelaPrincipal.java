package br.com.impacta.estacionamento.gui.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setResizable(false);
		setTitle("Sistema De Estacionamento ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnEntrada = new JButton("");
		btnEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEntradaVeiculo telaEntrada = new TelaEntradaVeiculo(TelaPrincipal.this);
				telaEntrada.setVisible(true);
				dispose();
			}
		});
		btnEntrada.setIcon(new ImageIcon(getClass().getResource("/resources/getin.png")));
		contentPane.add(btnEntrada);
		
		JButton btnSaida = new JButton("");
		btnSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaSaidaVeiculo telaSaida = new TelaSaidaVeiculo(TelaPrincipal.this);
				telaSaida.setVisible(true);
				dispose();
			}
		});
		btnSaida.setIcon(new ImageIcon(getClass().getResource("/resources/getout.png")));
		contentPane.add(btnSaida);
		
		setLocationRelativeTo(null); //centraliza a tela
		
	}

}
