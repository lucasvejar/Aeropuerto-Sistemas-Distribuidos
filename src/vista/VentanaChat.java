package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;


import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaChat extends JFrame{

	
	private JTextField textMensaje;
	private JButton btnEnviar;
	private JTextArea textoChat;
	private JLabel lblTitulo;
	
	/**
	 * Create the application.
	 */
	public VentanaChat() {
		initialize();
		setBounds(100, 100, 527, 401);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		lblTitulo = new JLabel("Chat SD");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(208, 11, 70, 45);
		getContentPane().add(lblTitulo);
		
		textoChat = new JTextArea();
		textoChat.setBounds(34, 71, 467, 166);
		textoChat.setEditable(false);
		getContentPane().add(textoChat);
		
		textMensaje = new JTextField();
		textMensaje.setToolTipText("Escriba un mensaje");
		textMensaje.setBounds(34, 248, 368, 23);
		getContentPane().add(textMensaje);
		textMensaje.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setToolTipText("Presione para enviar el mensaje");
		btnEnviar.setBounds(412, 248, 89, 23);
		getContentPane().add(btnEnviar);
	}

	
	
	
	//------- Getters y Setters -----------------//
	
	
	public JTextField getTextMensaje() {
		return textMensaje;
	}

	public void setTextMensaje(JTextField textMensaje) {
		this.textMensaje = textMensaje;
	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public void setBtnEnviar(JButton btnEnviar) {
		this.btnEnviar = btnEnviar;
	}

	public JTextArea getTextoChat() {
		return textoChat;
	}

	public void setTextoChat(JTextArea textoChat) {
		this.textoChat = textoChat;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}
}
