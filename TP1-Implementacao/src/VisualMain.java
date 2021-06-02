

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		frame.setResizable(false);
		frame.setBounds(500, 500, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setBackground();
		
		JButton btnNewButton_3 = new JButton("Imóveis");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_3.setToolTipText("Cliqui aqui para controle de imóveis");
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Funcionou!");
				VisualControleImoveis imoveis = new VisualControleImoveis();
				//imoveis.setVisible(true);
				imoveis.main(null);
			}
		});
		
		JButton btnNewButton = new JButton("Clientes e Alugueis");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setToolTipText("Cliqui aqui para controle Clientes e Alugueis");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VisualControleClientes clientes = new VisualControleClientes();
				//clientes.setVisible(true);
				clientes.main(null);
			}
		});
		
		JLabel label = new JLabel("-------------------------->");
		
		JLabel label_1 = new JLabel("-------->");
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				ImageIcon icon = new ImageIcon("imoveis.png");
//				new JLabel(new ImageIcon("imoveis.png"));
//				JLabel lab = new JLabel(icon);
//				frame.add(lab);
				DiagramaImoveis di = new DiagramaImoveis();
				di.main(null);
			}
		});
		
		JButton btnSobre_1 = new JButton("Sobre");
		btnSobre_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DiagramaGeral di = new DiagramaGeral();
				di.main(null);
			}
		});
		
		JLabel lblBemVindoAo = new JLabel("Bem vindo ao sitema de Controle de Alugueis 1.0");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBemVindoAo)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_3)
									.addGap(12)
									.addComponent(label))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSobre_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSobre))))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(label)
						.addComponent(btnSobre))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_1)
							.addComponent(btnSobre_1))
						.addComponent(btnNewButton))
					.addGap(30)
					.addComponent(lblBemVindoAo)
					.addContainerGap(105, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
