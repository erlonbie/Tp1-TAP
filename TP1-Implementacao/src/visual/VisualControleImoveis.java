package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class VisualControleImoveis extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualControleImoveis window = new VisualControleImoveis();
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
	public VisualControleImoveis() {
		super("Teste 123!");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		//this.setSize(260, 180);
		this.setBounds(500, 500, 400, 100);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		JButton btnNewButton = new JButton("New button");
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		this.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		getContentPane().add(btnNewButton_2);
	}

}
