package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualMain window = new VisualMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VisualMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Controle de Aluguel 1.0");
		frame.setBounds(500, 500, 400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_3 = new JButton("Imóveis");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Funcionou!");
				VisualControleImoveis imoveis = new VisualControleImoveis();
				imoveis.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Aluguéis");
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("Clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VisualControleClientes clientes = new VisualControleClientes();
				clientes.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Relatório Mensal");
		frame.getContentPane().add(btnNewButton_2);
	}

}
