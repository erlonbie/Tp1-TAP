


import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import javax.swing.DebugGraphics;
import java.awt.ComponentOrientation;
import javax.swing.DropMode;

public class VisualControleImoveis extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField endereco;
	private JTextField custo;
	private JTextField area;
	private static JComboBox comboBox;
	public static ArrayList<String> imoveis = new ArrayList<String>();
	
	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	
//	private static String url = "jdbc:mysql://localhost:3306/AluguelBD";
//	private static String user = "aluguel";
//	private static String pass = "abc123";
//	protected static Connection conexao = null;
	
	
	/**
	 * Launch the application.
	 */
	public static boolean isInt(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	    	JOptionPane.showMessageDialog(null, "Formato numérico inválido");
	        return false;
	    }
	    return true;
	}
	
	public static boolean isDouble(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	    	JOptionPane.showMessageDialog(null, "Formato numérico inválido");
	        return false;
	    }
	    return true;
	}
	
	public static void fillComboBox() {
		ImovelDAO iDAO = new ImovelDAO();
		iDAO.listaComboBox();
	}
	
	public static void main(String[] args) {
		fillComboBox();
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
		setTitle("Imóveis");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		endereco = new JTextField();
		endereco.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		
		JLabel lblCusto = new JLabel("Custo:");
		
		custo = new JTextField();
		custo.setColumns(10);
		
		JLabel lblArea = new JLabel("Area:");
		
		area = new JTextField();
		area.setColumns(10);
		
		JLabel lblQuartos = new JLabel("Quartos:");
		
		JLabel lblQuartos_1 = new JLabel("Suítes:");
		
		JLabel lblQuartos_2 = new JLabel("Vagas de Estacionamento:");
		
		JSpinner quartos = new JSpinner();
		quartos.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		
		JSpinner suites = new JSpinner();
		suites.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		
		JSpinner vagasEstacionamento = new JSpinner();
		vagasEstacionamento.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		
		JRadioButton kitchenette = new JRadioButton("Kitchenette");
		kitchenette.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kitchenette.isSelected()) {
					quartos.setValue(1);
					quartos.setEnabled(false);
					suites.setEnabled(false);
					suites.setValue(1);
					vagasEstacionamento.setEnabled(false);
					vagasEstacionamento.setValue(1);
				}
			}
		});
		buttonGroup.add(kitchenette);
		
		JRadioButton casaPadrao = new JRadioButton("Casa Padrão");
		casaPadrao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kitchenette.isSelected() == false) {
					quartos.setEnabled(true);
					suites.setEnabled(true);
					vagasEstacionamento.setEnabled(true);
				}
			}
		});
		buttonGroup.add(casaPadrao);
		
		JRadioButton casaCondominio = new JRadioButton("Casa Condromínio");
		casaCondominio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kitchenette.isSelected() == false) {
					quartos.setEnabled(true);
					suites.setEnabled(true);
					vagasEstacionamento.setEnabled(true);
				}
			}
		});
		buttonGroup.add(casaCondominio);
		
		JRadioButton apartamento = new JRadioButton("Apartamento");
		apartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kitchenette.isSelected() == false) {
					quartos.setEnabled(true);
					suites.setEnabled(true);
					vagasEstacionamento.setEnabled(true);
				}
			}
		});
		buttonGroup.add(apartamento);
		
		JScrollPane scrollPane = new JScrollPane();
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblComandos = new JLabel("Comandos");
		
		JButton btnRelatrio = new JButton("Relatório");
		btnRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImovelDAO iDAO = new ImovelDAO ();
				textArea.setText(iDAO.retornarImoveis());
			}
		});
		
		JButton btnSobreOsImveis = new JButton("Sobre ");
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(endereco.getText().length() == 0 || area.getText().length() == 0 || custo.getText().length() == 0) {
					//btnAdicionar.setEnabled(false);
					JOptionPane.showMessageDialog(null, "preencha todos os campos");
				}
				else {
					if(kitchenette.isSelected()) {
						if(isDouble(area.getText()) && isDouble(custo.getText())) {
							ImovelDAO iDAO = new ImovelDAO ();
							//Imovel i = new Imovel("Kitchenette", endereco.getText() , Double.parseDouble(area.getText()), Double.parseDouble(custo.getText()), Integer.parseInt(quartos.getValue().toString()), Integer.parseInt(suites.getValue().toString()), Integer.parseInt(vagasEstacionamento.getValue().toString()), 0, 0, 0, 0);
							Imovel i = new Imovel("Kitchenette", endereco.getText() , Double.parseDouble(area.getText()), Double.parseDouble(custo.getText()), 1, 1, 1, 0, 0, 0, 0);
							iDAO.adicionaImoveis(i);
							JOptionPane.showMessageDialog(null, "Kitchenette adicionado");
							endereco.setText("");
							custo.setText("");
							area.setText("");
							//kitchenette.setSelected(false);
							//textArea.setText(iDAO.retornarImoveis());
						}
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
				
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		
		JButton btnEditar = new JButton("Editar");
		//fillComboBox();
		comboBox = new JComboBox(imoveis.toArray());
		//comboBox.setModel(new DefaultComboBoxModel(imoveis));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ImovelDAO iDAO = new ImovelDAO ();
				//comboBox.addItem(iDAO.listaComboBox().toString());
				
			}
		});
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(161)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
							.addGap(204))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(153)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblEndereo)
											.addComponent(lblCusto)
											.addComponent(lblArea))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(endereco, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(custo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(area, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(29)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(lblQuartos)
													.addComponent(lblQuartos_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblQuartos_2, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(vagasEstacionamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(suites, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(quartos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnRelatrio)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnAdicionar)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnRemover)
										.addGap(18)
										.addComponent(btnEditar)
										.addGap(18)
										.addComponent(comboBox, 0, 238, Short.MAX_VALUE)
										.addGap(18)
										.addComponent(btnSobreOsImveis))
									.addComponent(lblComandos)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(85)
								.addComponent(kitchenette)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(casaPadrao)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(casaCondominio)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(apartamento)
								.addGap(183))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(endereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEndereo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCusto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblArea))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(custo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(area, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
					.addGap(78)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(kitchenette)
						.addComponent(casaPadrao)
						.addComponent(casaCondominio)
						.addComponent(apartamento))
					.addGap(50)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(lblComandos)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRelatrio)
						.addComponent(btnSobreOsImveis)
						.addComponent(btnAdicionar)
						.addComponent(btnRemover)
						.addComponent(btnEditar)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
