package Chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelEnvio extends JPanel implements ActionListener{

	JButton boton;
	JTextField mensaje;
	Interfaz frame;
	
	public PanelEnvio (Interfaz frame) {
		
		this.frame = frame;
		boton = new JButton("Enviar");
		mensaje = new JTextField("", 25);
		
		
		boton.addActionListener(this);
		
		add(mensaje);
		add(boton);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		frame.getUser().enviar(mensaje.getText());
		mensaje.setText("");
		
	}
	
}
