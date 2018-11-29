package socketsMulticast.Chat;

import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class User implements Runnable{

	Scanner teclado;
	final String grupoAddr = "224.0.0.3";
	MulticastSocket socket;
	InetAddress grupo;
	Interfaz frame;
	String usuario;
	String pass;
	String hex;
	
	public User (Interfaz frame) {
		
		this.frame = frame;
		teclado = new Scanner (System.in);
		usuario = "Desconocido";
		pass = "";
		
		Color color = new Color((int)(Math.random() * 0x1000000));
		
		String rgb = Integer.toHexString(color.getRGB());
		
		hex = rgb.substring(2, rgb.length());
		
		
	}
	
	public User (Interfaz frame, String usuario, String pass) {
		
		this.frame = frame;
		teclado = new Scanner (System.in);
		this.usuario = usuario;
		this.pass = pass;
		
		Color color = new Color((int)(Math.random() * 0x1000000));
		
		String rgb = Integer.toHexString(color.getRGB());
		
		hex = rgb.substring(2, rgb.length());
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			System.out.println("Uniendose al grupo...");
			grupo = InetAddress.getByName(grupoAddr);
			socket = new MulticastSocket(6789);
			socket.joinGroup(grupo);
			System.out.println("Bienvenido al grupo");
			
			byte[] bufer = new byte[10000];
			
			boolean aux = true;
			while (aux) {
				
				String mensaje;
				
				DatagramPacket mensajeEntrada =  new DatagramPacket(bufer, bufer.length);
		    	socket.receive(mensajeEntrada);
		    	mensaje = new String(mensajeEntrada.getData(), 0, mensajeEntrada.getLength());
		    	
				frame.getReceptor().recibir(mensaje);
		    	
			}
			
			socket.leaveGroup(grupo);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	public void enviar (String mensaje){
		
    	try {
    		
    		String texto = "<font color='#" + hex + "'>" + usuario + ": " + "</font>" + mensaje + "<br/>";
    		
    		byte[] m = texto.getBytes();
        	DatagramPacket mensajeSalida = new DatagramPacket(m, m.length, grupo, 6789);
			socket.send(mensajeSalida);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public Scanner getTeclado() {
		return teclado;
	}


	public void setTeclado(Scanner teclado) {
		this.teclado = teclado;
	}


	public MulticastSocket getSocket() {
		return socket;
	}


	public void setSocket(MulticastSocket socket) {
		this.socket = socket;
	}


	public InetAddress getGrupo() {
		return grupo;
	}


	public void setGrupo(InetAddress grupo) {
		this.grupo = grupo;
	}


	public Interfaz getFrame() {
		return frame;
	}


	public void setFrame(Interfaz frame) {
		this.frame = frame;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getHex() {
		return hex;
	}


	public void setHex(String hex) {
		this.hex = hex;
	}


	public String getGrupoAddr() {
		return grupoAddr;
	}
	
	
	
	
}
