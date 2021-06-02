import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DiagramaGeral extends JFrame{
	public static void main(String[] args) {
		JFrame janela = new JFrame("Digrama Geral");
		janela.setLayout(null);
		janela.setSize(795,529);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//BufferedImage image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("imoveis.png"));
		//String path = DiagramaImoveis.class.getClassLoader().getResource("imoveis.png").toString();
//		ClassLoader cldr = DiagramaImoveis.class.getClassLoader();
//		URL url = cldr.getResource("imoveis.png");
		ImageIcon imagem = new ImageIcon("/home/erlonbie/ubuntu-backup/faculdade/5_periodo/TAP/Trabalho1/Tp1-TAP/TP1-Implementacao/src/geral.png");
		janela.setContentPane(new JLabel(imagem));
		janela.setVisible(true);
	}
}
