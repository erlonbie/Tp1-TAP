


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class VisualControleImoveis extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField endereco;
	private JTextField custo;
	private JTextField area;
	public JComboBox comboBox;
	private DefaultComboBoxModel dm = new DefaultComboBoxModel();
	public static ArrayList<String> imoveis = new ArrayList<String>();
	//Thread thread;
	
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
		imoveis.clear();
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
		setBounds(200, 200, 1000, 700);
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
		quartos.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		
		JSpinner suites = new JSpinner();
		suites.setModel(new SpinnerNumberModel(1, 0, 5, 1));
		
		JSpinner vagasEstacionamento = new JSpinner();
		vagasEstacionamento.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		
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
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JLabel lblComandos = new JLabel("Comandos");
		
		JButton btnRelatrio = new JButton("Relatório");
		btnRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImovelDAO iDAO = new ImovelDAO ();
				textArea.setText(iDAO.retornarImoveis());
			}
		});
		
		
		
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
							textArea.setText(iDAO.listaApenasUmImovel());
							//kitchenette.setSelected(false);
							//textArea.setText(iDAO.retornarImoveis());
							dispose();
							main(null);
						}
					}
					else if(casaPadrao.isSelected()) {
						if(isDouble(area.getText()) && isDouble(custo.getText()) && Integer.parseInt(quartos.getValue().toString()) >= Integer.parseInt(suites.getValue().toString())) {
							ImovelDAO iDAO = new ImovelDAO ();
							//Imovel i = new Imovel("Kitchenette", endereco.getText() , Double.parseDouble(area.getText()), Double.parseDouble(custo.getText()), Integer.parseInt(quartos.getValue().toString()), Integer.parseInt(suites.getValue().toString()), Integer.parseInt(vagasEstacionamento.getValue().toString()), 0, 0, 0, 0);
							Imovel i = new Imovel("Casa Padrão", endereco.getText() , Double.parseDouble(area.getText()), Double.parseDouble(custo.getText()), Integer.parseInt(quartos.getValue().toString()), Integer.parseInt(suites.getValue().toString()), Integer.parseInt(vagasEstacionamento.getValue().toString()), 0, 1, 0, 0);
							iDAO.adicionaImoveis(i);
							JOptionPane.showMessageDialog(null, "Casa padrão adicionada");
							endereco.setText("");
							custo.setText("");
							area.setText("");
							textArea.setText(iDAO.listaApenasUmImovel());
							//kitchenette.setSelected(false);
							//textArea.setText(iDAO.retornarImoveis());
							dispose();
							main(null);
						}
						else {
							JOptionPane.showMessageDialog(null, "Numero de quartos não pode ser menor que o de suítes!");
						}
					}
					else if(casaCondominio.isSelected()) {
						if(isDouble(area.getText()) && isDouble(custo.getText()) && Integer.parseInt(quartos.getValue().toString()) >= Integer.parseInt(suites.getValue().toString())) {
							ImovelDAO iDAO = new ImovelDAO ();
							//Imovel i = new Imovel("Kitchenette", endereco.getText() , Double.parseDouble(area.getText()), Double.parseDouble(custo.getText()), Integer.parseInt(quartos.getValue().toString()), Integer.parseInt(suites.getValue().toString()), Integer.parseInt(vagasEstacionamento.getValue().toString()), 0, 0, 0, 0);
							Imovel i = new Imovel("Casa Condomínio", endereco.getText() , Double.parseDouble(area.getText()), Double.parseDouble(custo.getText()), Integer.parseInt(quartos.getValue().toString()), Integer.parseInt(suites.getValue().toString()), Integer.parseInt(vagasEstacionamento.getValue().toString()), 1, 1, 1, 0);
							iDAO.adicionaImoveis(i);
							JOptionPane.showMessageDialog(null, "Casa condomínio adicionada");
							endereco.setText("");
							custo.setText("");
							area.setText("");
							textArea.setText(iDAO.listaApenasUmImovel());
							//kitchenette.setSelected(false);
							//textArea.setText(iDAO.retornarImoveis());
							dispose();
							main(null);
						}
						else {
							JOptionPane.showMessageDialog(null, "Numero de quartos não pode ser menor que o de suítes!");
						}
					}
					else if(apartamento.isSelected()) {
						if(isDouble(area.getText()) && isDouble(custo.getText()) && Integer.parseInt(quartos.getValue().toString()) >= Integer.parseInt(suites.getValue().toString())) {
							ImovelDAO iDAO = new ImovelDAO ();
							//Imovel i = new Imovel("Kitchenette", endereco.getText() , Double.parseDouble(area.getText()), Double.parseDouble(custo.getText()), Integer.parseInt(quartos.getValue().toString()), Integer.parseInt(suites.getValue().toString()), Integer.parseInt(vagasEstacionamento.getValue().toString()), 0, 0, 0, 0);
							Imovel i = new Imovel("Apartamento", endereco.getText() , Double.parseDouble(area.getText()), Double.parseDouble(custo.getText()), Integer.parseInt(quartos.getValue().toString()), Integer.parseInt(suites.getValue().toString()), Integer.parseInt(vagasEstacionamento.getValue().toString()), 1, 0, 1, 0);
							iDAO.adicionaImoveis(i);
							textArea.setText(iDAO.listaApenasUmImovel());
							endereco.setText("");
							custo.setText("");
							area.setText("");
							JOptionPane.showMessageDialog(null, "Apartamento adicionado");
							//kitchenette.setSelected(false);
							//textArea.setText(iDAO.retornarImoveis());
							dispose();
							main(null);
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Numero de quartos não pode ser menor que o de suítes!");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Selecione um tipo de imóvel!");
					}
				}
//				dispose();
//				main(null);
//				contentPane.invalidate();
//				fillComboBox();
//				contentPane.revalidate();
//				contentPane.repaint();
//				ImovelDAO iDAO = new ImovelDAO ();
//				String s = iDAO.ultimoImovelAdicionado();
//				comboBox.addItem(s);
//				comboBox.invalidate();
//				comboBox.revalidate();
//				comboBox.repaint();
//				comboBox.invalidate();
//				comboBox = new JComboBox();
//				comboBox.setModel(new DefaultComboBoxModel(imoveis.toArray()));
//				comboBox.removeAllItems();
//				fillComboBox();
//				comboBox = new JComboBox(imoveis.toArray());
//				ImovelDAO iDAO = new ImovelDAO();
//				imoveis.clear();
//				iDAO.listaComboBox();
//				fillComboBox();
//				comboBox = new JComboBox();
				//comboBox.setModel(dm);
//				comboBox.setModel(new DefaultComboBoxModel(imoveis.toArray()));
//				VisualControleImoveis novo = new VisualControleImoveis();
//				Thread t = new Thread(novo);
//				t.start();
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int fim = 1;
				String s = comboBox.getSelectedItem().toString();
				for(int i = fim; s.charAt(i) != '|'; i++) {
					fim++;	
				}
				s = comboBox.getSelectedItem().toString().substring(0, fim);
				ImovelDAO iDAO = new ImovelDAO ();
				if(iDAO.alugado(s)) {
					JOptionPane.showMessageDialog(null, "Imóvel possui cliente, remova-o antes");
				}
				else {
					iDAO.removeImoveis(s);
					textArea.setText("Apaguei o id: " + comboBox.getSelectedItem().toString().substring(0, fim));
					JOptionPane.showMessageDialog(null, "Imóvel removido com sucesso");
					dispose();
					main(null);
				}
			}
			
		});
		
		JToggleButton btnEditar = new JToggleButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		//fillComboBox();
		comboBox = new JComboBox();
		//comboBox.setModel(dm);
		comboBox.setModel(new DefaultComboBoxModel(imoveis.toArray()));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnEditar.isSelected() == true) {
					String[] vs = new String[8];
				    Arrays.fill(vs, "");
				    String s = comboBox.getSelectedItem().toString();
				    int x =0;
				    for(int i = 0; i < 8; i++) {
				    	while(x < s.length() && s.charAt(x) != '|') {
				    		vs[i] += s.charAt(x);
				    		x++;
				    	}
				    	x++;
				    }
				    if(vs[1].equals("Kitchenette")) {
				    	endereco.setText(vs[2]);
						custo.setText(vs[4]);
						area.setText(vs[3]);
						kitchenette.setSelected(true);
						quartos.setValue(1);
						quartos.setEnabled(false);
						suites.setEnabled(false);
						suites.setValue(1);
						vagasEstacionamento.setEnabled(false);
						vagasEstacionamento.setValue(1);
				    }
				    else if (vs[1].equals("Casa Padrão")) {
				    	endereco.setText(vs[2]);
						custo.setText(vs[4]);
						area.setText(vs[3]);
						quartos.setEnabled(true);
						suites.setEnabled(true);
						vagasEstacionamento.setEnabled(true);
						casaPadrao.setSelected(true);
						quartos.setValue(Integer.parseInt(vs[5]));
						suites.setValue(Integer.parseInt(vs[6]));
						vagasEstacionamento.setValue(Integer.parseInt(vs[7]));
				    	
				    }
				    else if (vs[1].equals("Casa Condomínio")) {
				    	endereco.setText(vs[2]);
						custo.setText(vs[4]);
						area.setText(vs[3]);
						quartos.setEnabled(true);
						suites.setEnabled(true);
						vagasEstacionamento.setEnabled(true);
						casaCondominio.setSelected(true);
						quartos.setValue(Integer.parseInt(vs[5]));
						suites.setValue(Integer.parseInt(vs[6]));
						vagasEstacionamento.setValue(Integer.parseInt(vs[7]));
				    }
				    else if (vs[1].equals("Apartamento")) {
				    	endereco.setText(vs[2]);
						custo.setText(vs[4]);
						area.setText(vs[3]);
						quartos.setEnabled(true);
						suites.setEnabled(true);
						vagasEstacionamento.setEnabled(true);
						apartamento.setSelected(true);
						quartos.setValue(Integer.parseInt(vs[5]));
						suites.setValue(Integer.parseInt(vs[6]));
						vagasEstacionamento.setValue(Integer.parseInt(vs[7]));
				    }
					
				}
			}
		});
		
		JButton btnSobreOsImveis = new JButton("Confirmar");
		btnSobreOsImveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnEditar.isSelected() == true) {
					String[] vs = new String[8];
				    Arrays.fill(vs, "");
				    String s = comboBox.getSelectedItem().toString();
				    int x =0;
				    for(int i = 0; i < 1; i++) {
				    	while(x < s.length() && s.charAt(x) != '|') {
				    		vs[i] += s.charAt(x);
				    		x++;
				    	}
				    	x++;
				    }
				    if(kitchenette.isSelected()) {
				    	vs[1] = kitchenette.getText();
				    }
				    else if(casaPadrao.isSelected()) {
				    	vs[1] = casaPadrao.getText();
				    }
				    else if(casaCondominio.isSelected()) {
				    	vs[1] = casaCondominio.getText();
				    }
				    else if(apartamento.isSelected()) {
				    	vs[1] = apartamento.getText();
				    }
				    vs[2] = endereco.getText();
				    vs[3] = area.getText();
				    vs[4] = custo.getText();
				    vs[5] = quartos.getValue().toString();
				    vs[6] = suites.getValue().toString();
				    vs[7] = vagasEstacionamento.getValue().toString();
				    ImovelDAO iDAO = new ImovelDAO ();
				    iDAO.atualizaImovel(vs);
				    JOptionPane.showMessageDialog(null, "Imóvel atualizado");
				    dispose();
					main(null);
				}
			}
		});
		
		JLabel lblId = new JLabel("id | categoria | endereço | area (m2) | custo (R$) | quartos | suites | estacionamento");
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)
							.addGap(204))
						.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.TRAILING)
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
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(btnRelatrio)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(btnAdicionar))
											.addComponent(lblComandos))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnRemover)
										.addGap(18)
										.addComponent(btnEditar)
										.addGap(18)
										.addComponent(comboBox, 0, 315, Short.MAX_VALUE)
										.addGap(18)
										.addComponent(btnSobreOsImveis))))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(85)
								.addComponent(kitchenette)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(casaPadrao)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(casaCondominio)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(apartamento)
								.addGap(183)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(294, Short.MAX_VALUE)
							.addComponent(lblId)))
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
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblComandos)
							.addGap(18))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblId)
							.addGap(33)))
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

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//	}
}
