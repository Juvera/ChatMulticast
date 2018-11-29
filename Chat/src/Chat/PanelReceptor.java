package Chat;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class PanelReceptor extends JPanel{

	JTextPane box;
	Interfaz frame;
	String hex;
	
	public PanelReceptor (Interfaz frame) {
		
		this.frame = frame;
		
		box = new JTextPane();
		box.setPreferredSize(new Dimension (500,500));
		box.setEditable(false);
		box.setContentType("text/html");
		add(box);
		
		
		
	}
	
	public void recibir (String mensaje) throws BadLocationException {
		
		String aux = box.getText();

		aux = aux.replaceAll("<html>", "");
		aux = aux.replaceAll("</html>", "");
		aux = aux.replaceAll("<head>", "");
		aux = aux.replaceAll("</head>", "");
		aux = aux.replaceAll("<body>", "");
		aux = aux.replaceAll("</body>", "");
		
		mensaje = aux + mensaje;
		
		box.setText(mensaje);
		
	}
	
}
