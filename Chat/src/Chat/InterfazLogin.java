package Chat;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class InterfazLogin extends JFrame{

		
	final private int ancho = 250;
	final private int alto = 250;
	final private int x = 250;
	final private int y = 250;
	PanelReceptor receptor;
	PanelEnvio envio;
	
	public InterfazLogin() {
		
		setVisible(true);
		
		setTitle("Login");
		
		setBounds(x,y,ancho,alto);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new PanelLogin());
		
	}
	
}
