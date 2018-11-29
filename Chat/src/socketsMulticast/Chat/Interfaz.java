package socketsMulticast.Chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Interfaz extends JFrame{
	
	User user;
	final private int ancho = 1000;
	final private int alto = 1000;
	final private int x = 250;
	final private int y = 250;
	PanelReceptor receptor;
	PanelEnvio envio;
	
	public Interfaz(String name, String pass) {
		
		user = new User(this, name, pass);
		Thread th = new Thread (user);
		
		th.start();
		
		setVisible(true);
		
		setTitle("Chat");
		
		setBounds(x,y,ancho,alto);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		receptor = new PanelReceptor(this);
		envio = new PanelEnvio(this);
				
		add(receptor, BorderLayout.CENTER);
		add(envio, BorderLayout.SOUTH);
		
		repaint();
		
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PanelReceptor getReceptor() {
		return receptor;
	}

	public void setReceptor(PanelReceptor receptor) {
		this.receptor = receptor;
	}

	public PanelEnvio getEnvio() {
		return envio;
	}

	public void setEnvio(PanelEnvio envio) {
		this.envio = envio;
	}
	
	
	
	
	
}
