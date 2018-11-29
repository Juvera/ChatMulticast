package socketsMulticast.Chat;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.xmldb.api.base.XMLDBException;

import daw.com.Teclado;

public class PanelLogin extends JPanel implements ActionListener{

	JTextField name;
	JPasswordField pass;
	JButton boton;
	JLabel text1;
	JLabel text2;
	
	public PanelLogin () {
	
		name = new JTextField("",10);
		pass = new JPasswordField("",10);
		boton = new JButton("Enviar");
		text1 = new JLabel("Usuario");
		text2 = new JLabel("Contraseña");
		
		setLayout(new GridLayout(0,1));
		
		boton.addActionListener(this);
		
		JPanel panel1 = new JPanel();
		panel1.add(text1);
		panel1.add(name);
		
		JPanel panel2 = new JPanel();
		panel2.add(text2);
		panel2.add(pass);
		
		JPanel panel3 = new JPanel();
		panel3.add(boton);
		
		add(panel1);
		add(panel2);
		add(panel3);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		ArrayList<String> user;
		
		String consulta = "for $a in /login/user\n" + 
				"where $a/name = \"" + name.getText() + "\" and $a/pass = \"" + pass.getText() + "\"\n" + 
				"return " +
				"$a/name/text() |\n" + 
				"$a/pass/text()";
		
		user = CDXExists.consultaCompuesta(consulta);
		
		if (user.size() > 0) {
			
			Interfaz frame = new Interfaz(user.get(0), user.get(1));
			
		}
		else {
			
			JOptionPane.showMessageDialog(null, "Usuario inexistente/ Contraseña erronea", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		
		
		
	}
	
}
