


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

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
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;

public class VisualControleClientes extends JFrame {

	/**
	 * 
	 */
	//com
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField nome;
	private JTextField idade;
	private static JComboBox comboBox;
	private static JComboBox comboBox1;
	public static ArrayList<String> imoveis1 = new ArrayList<String>();
	public static ArrayList<String> clientes = new ArrayList<String>();
	private JTextField custo;
	private JTextField total;
	private double seguroV = 0.0;
	private double chaveExtraV = 0.0;
	private double mobiliadoV = 0.0;
	private DecimalFormat dec = new DecimalFormat("#0.00");
	
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
		ClienteDAO cDAO = new ClienteDAO();
		cDAO.listaComboBox();
	}
	
	public static void fillComboBox2() {
		ClienteDAO cDAO = new ClienteDAO();
		cDAO.listaComboBox2();
	}
	
	public static void main(String[] args) {
		fillComboBox();
		fillComboBox2();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualControleClientes frame = new VisualControleClientes();
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
	
	
	public VisualControleClientes() {
		setTitle("Imóveis");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		nome = new JTextField();
		nome.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Nome:");
		
		JLabel lblCusto = new JLabel("Idade:");
		
		idade = new JTextField();
		idade.setColumns(10);
		
		JLabel lblId = new JLabel("id | imovel_id | nome | idade");
		
		
		
		JLabel lblCusto_1 = new JLabel("Selecione o imóvel:");
		
		JCheckBox seguro = new JCheckBox("Seguro");
		seguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem() != null) {
					if(seguro.isSelected()) {
						seguroV = Double.parseDouble(custo.getText()) * 0.1;
						double tot = Double.parseDouble(custo.getText()) + seguroV +chaveExtraV +mobiliadoV;
						total.setText(dec.format(tot));
					}
					else {
						seguroV = 0;
						double tot = Double.parseDouble(custo.getText()) +chaveExtraV +mobiliadoV;
						total.setText(dec.format(tot));
					}
				}
			}
		});
		
		JCheckBox chaveExtra = new JCheckBox("Chave extra");
		chaveExtra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() != null) {
					if(chaveExtra.isSelected()) {
						chaveExtraV = 200;
						double tot = Double.parseDouble(custo.getText()) +seguroV +chaveExtraV +mobiliadoV;
						total.setText(dec.format(tot));
					}
					else {
						chaveExtraV = 0;
						double tot = Double.parseDouble(custo.getText()) +seguroV +mobiliadoV;
						total.setText(dec.format(tot));
					}
				}
			}
		});
		
		JCheckBox mobiliado = new JCheckBox("Mobiliado");
		mobiliado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() != null) {
					if(mobiliado.isSelected()) {
						mobiliadoV = Double.parseDouble(custo.getText()) * 0.3;
						double tot = Double.parseDouble(custo.getText()) + seguroV +chaveExtraV +mobiliadoV;
						total.setText(dec.format(tot));
					}
					else {
						mobiliadoV = 0;
						double tot = Double.parseDouble(custo.getText()) +seguroV +chaveExtraV;
						total.setText(dec.format(tot));
					}
				}
			}
		});
		
		JLabel lblEndereo_1 = new JLabel("Seguro = 10% do custo do imóvel");
		
		JLabel lblEndereo_1_1 = new JLabel("Chave extra = R$ 200,00");
		
		JLabel lblEndereo_1_1_1 = new JLabel("Mobiliado = 30% do custo do imóvel");
		
		JLabel lblCusto_2 = new JLabel("inicio");
		
		JLabel lblCusto_2_1 = new JLabel("termino");
		
		JDateChooser inicio = new JDateChooser();
		inicio.setDateFormatString("yyyy-MM-dd");
		
		
		JDateChooser termino = new JDateChooser();
		termino.setDateFormatString("yyyy-MM-dd");
		
		custo = new JTextField();
		
		custo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				
			}
		});
		custo.setColumns(10);
		
		total = new JTextField();
		total.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Custo");
		
		JLabel lblNewLabel_1 = new JLabel("Total");
		
		JSeparator separator = new JSeparator();
		
		JLabel lblCliente = new JLabel("CLIENTE");
		
		JLabel lblCliente_1 = new JLabel("ALUGUEL");
		
		JYearChooser ano = new JYearChooser();
		
		JMonthChooser mes = new JMonthChooser();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JLabel lblComandos = new JLabel("Comandos");
		
		JButton btnRelatrio = new JButton("Relatório");
		btnRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int mesV = mes.getMonth()+1;
				int anoV = ano.getYear();
				AluguelDAO a = new AluguelDAO();
				String texto = a.textoRelatorio(String.valueOf(mesV), String.valueOf(anoV));
				textArea.setText(texto);
			}
		});
		
		
		
		JButton btnAdicionar = new JButton("Alugar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nome.getText().length() == 0 || idade.getText().length() == 0) {
					//btnAdicionar.setEnabled(false);
					JOptionPane.showMessageDialog(null, "preencha todos os campos");
				}
				else {
					try {
						if(inicio.getDate().compareTo(termino.getDate()) >0) {
							JOptionPane.showMessageDialog(null, "Data de início deve ser antes da data de término");
								
						}
					}
					catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(null, "preencha as datas");
					}
					int fim = 1;
					String s1 = comboBox.getSelectedItem().toString();
					for(int i = fim; s1.charAt(i) != '|'; i++) {
						fim++;	
					}
					s1 = s1.substring(0, fim);
					ImovelDAO iDAO = new ImovelDAO();
					if(iDAO.alugado(s1)) {
						JOptionPane.showMessageDialog(null, "imóvel já está alugado");
					}
					else {
						Cliente c = new Cliente(Integer.parseInt(s1), nome.getText(), Integer.parseInt(idade.getText()));
						ClienteDAO cDAO = new ClienteDAO();
						cDAO.adicionaCliente(c);
						
						//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						int ult_id = cDAO.idUltimoCliente();
						int ult_imovel = cDAO.imovelUltimoCliente();
						Aluguel a = new Aluguel(ult_id, ult_imovel, inicio.getDate(), termino.getDate(), seguroV, chaveExtraV, mobiliadoV);
						AluguelDAO aDAO = new AluguelDAO();
						aDAO.adicionaAluguel(a);
						
						
						iDAO.alugaImovel(String.valueOf(ult_imovel));
						JOptionPane.showMessageDialog(null, "Parabéns pela aquisição!");
					}
					
				}
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int fim = 1;
				String s = comboBox1.getSelectedItem().toString();
				for(int i = fim; s.charAt(i+1) != '-'; i++) {
					fim++;	
				}
				textArea.setText("Apaguei o id: " + comboBox1.getSelectedItem().toString().substring(0, fim));
				s = comboBox1.getSelectedItem().toString().substring(0, fim);
				ImovelDAO iDAO = new ImovelDAO ();
				iDAO.removeImoveis(s);
				JOptionPane.showMessageDialog(null, "Imóvel removido com sucesso");
			}
		});
		
		JToggleButton btnEditar = new JToggleButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		comboBox = new JComboBox(imoveis1.toArray());
		comboBox.setSelectedItem(null);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seguro.setSelected(false);
				chaveExtra.setSelected(false);
				mobiliado.setSelected(false);
				{
				int fim = 1;
				String s1 = comboBox.getSelectedItem().toString();
				for(int i = fim; s1.charAt(i) != '|'; i++) {
					fim++;	
				}
				s1 = s1.substring(0, fim);
				//System.out.println(s1);
				ImovelDAO iDAO = new ImovelDAO ();
				String s2 = iDAO.retornaCusto(s1);
				custo.setText(s2);
				}
				
				{
					double tot = Double.parseDouble(custo.getText()) +seguroV +chaveExtraV +mobiliadoV;
					total.setText(String.valueOf(tot));
				}
			}
		});
		
		comboBox1 = new JComboBox(clientes.toArray());
		
		JButton btnSobreOsImveis = new JButton("Confirmar");
		btnSobreOsImveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnEditar.isSelected() == true) {
					String[] vs = new String[8];
				    Arrays.fill(vs, "");
				    String s = comboBox1.getSelectedItem().toString();
				    int x =0;
				    for(int i = 0; i < 1; i++) {
				    	while(x < s.length() && s.charAt(x) != '|') {
				    		vs[i] += s.charAt(x);
				    		x++;
				    	}
				    	x++;
				    }
				    ImovelDAO iDAO = new ImovelDAO ();
				    iDAO.atualizaImovel(vs);
				    JOptionPane.showMessageDialog(null, "Imóvel atualizado");
				}
			}
		});
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblComandos)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnRelatrio)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnAdicionar))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCliente_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(56)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnRemover)
							.addGap(18)
							.addComponent(btnEditar)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox1, 0, 733, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(btnSobreOsImveis))
								.addComponent(lblId)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(153)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblEndereo)
												.addComponent(lblCusto))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(nome, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
												.addComponent(idade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(8)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(8)
													.addComponent(lblCusto_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(seguro)
													.addGap(18)
													.addComponent(chaveExtra)
													.addGap(18)
													.addComponent(mobiliado))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblCusto_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
													.addGap(160)
													.addComponent(lblCusto_2_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(custo, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel))
													.addGap(18)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
														.addComponent(total, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(inicio, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(termino, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(41)
									.addComponent(lblCliente)))
							.addGap(153)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEndereo_1_1_1, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEndereo_1_1, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEndereo_1, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)))
					.addGap(208))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(mes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(806, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEndereo))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCusto)
								.addComponent(idade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEndereo_1)
							.addGap(2)
							.addComponent(lblEndereo_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEndereo_1_1_1))
						.addComponent(lblCliente))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(176)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCliente_1)
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCusto_2)
								.addComponent(lblCusto_2_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(inicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(termino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(seguro)
								.addComponent(chaveExtra)
								.addComponent(mobiliado))
							.addGap(18)
							.addComponent(lblCusto_1)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(custo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(total, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addGap(122)
							.addComponent(ano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(mes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(15)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblComandos)
						.addComponent(lblId))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRelatrio)
						.addComponent(btnSobreOsImveis)
						.addComponent(btnAdicionar)
						.addComponent(btnRemover)
						.addComponent(btnEditar)
						.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
