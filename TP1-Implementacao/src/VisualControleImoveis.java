


import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class VisualControleImoveis extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtTeste;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualControleImoveis frame = new VisualControleImoveis();
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
	public VisualControleImoveis() {
		setResizable(false);
		setTitle("Imóveis");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblComandos = new JLabel("Comandos");
		
		JRadioButton kitchenette = new JRadioButton("Kitchenette");
//		kitchenette.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(kitchenette.isSelected()) {
//					
//				}
//			}
//		});
		buttonGroup.add(kitchenette);
		
		JRadioButton casaPadrao = new JRadioButton("Casa Padrão");
		buttonGroup.add(casaPadrao);
		
		JRadioButton casaCondominio = new JRadioButton("Casa Condromínio");
		buttonGroup.add(casaCondominio);
		
		JRadioButton apartamento = new JRadioButton("Apartamento");
		buttonGroup.add(apartamento);
		
		JButton btnRelatrio = new JButton("Relatório");
		
		txtTeste = new JTextField();
		txtTeste.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		
		JLabel lblCusto = new JLabel("Custo:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblArea = new JLabel("Area:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblQuartos = new JLabel("Quartos:");
		
		JLabel lblQuartos_1 = new JLabel("Suítes:");
		
		JLabel lblQuartos_2 = new JLabel("Vagas de Estacionamento:");
		
		JSpinner quartos = new JSpinner();
		
		JSpinner suites = new JSpinner();
		
		JSpinner vagasEstacionamento = new JSpinner();
		
		JButton btnSobreOsImveis = new JButton("Sobre ");
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kitchenette.isSelected()) {
					ImovelDAO iDAO = new ImovelDAO ();
					Imovel i = new Imovel("Kitchenette", txtTeste.getText() , 12.2, 150.00, 2, 2, 1, 0, 1, 1, 0);
					iDAO.adicionaImoveis(i);
				}
				else if(casaPadrao.isSelected()) {
					
				}
				else if(casaCondominio.isSelected()) {
					
				}
				else if(apartamento.isSelected()) {
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione um tipo de imóvel!");
				}
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		
		JButton btnEditar = new JButton("Editar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(139)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(kitchenette)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(casaPadrao)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(casaCondominio)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(apartamento))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEndereo)
										.addComponent(lblCusto)
										.addComponent(lblArea))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtTeste, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(29)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblQuartos)
												.addComponent(lblQuartos_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblQuartos_2, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(vagasEstacionamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(suites, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(quartos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnRelatrio)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAdicionar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnRemover)
							.addGap(18)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
							.addComponent(btnSobreOsImveis))
						.addComponent(lblComandos))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(kitchenette)
						.addComponent(casaPadrao)
						.addComponent(casaCondominio)
						.addComponent(apartamento))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTeste, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEndereo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCusto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblArea))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuartos)
								.addComponent(quartos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuartos_1)
								.addComponent(suites, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuartos_2)
								.addComponent(vagasEstacionamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 360, Short.MAX_VALUE)
					.addComponent(lblComandos)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRelatrio)
						.addComponent(btnSobreOsImveis)
						.addComponent(btnAdicionar)
						.addComponent(btnRemover)
						.addComponent(btnEditar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
