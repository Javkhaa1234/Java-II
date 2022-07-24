package Pro;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	
    
	String pin = "1024";
	int attempts = 3;
	public Login(){
		//Basic Constructor Setup
		super("Нэвтрэх");
		setLayout(new BorderLayout());
		setResizable(false);
		setLocationRelativeTo(null);
		buildApp();
		pack();
		setSize(250, 110);
		setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
	}
	
	public static void main(String[] args){
		new Login();		
	}
	
	void buildApp(){
		//===================================================
		//GUI Setup
		//===================================================		
		JLabel pinInstruction = new JLabel("Нууц үгээ оруулна уу");
		JPasswordField pinText = new JPasswordField(4);
		JButton entPin = new JButton("Оруулах");
		JButton quit = new JButton("Гарах");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(quit);
		buttonPanel.add(entPin);
		pinText.setBackground(Color.white);
		add(pinInstruction, BorderLayout.NORTH);
		add(pinText, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		//===================================================
		//Action Listener Setup
		//===================================================
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}	
		});
		
		pinText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				char[] pinGuess = pinText.getPassword();
				String pinString = new String(pinGuess);
				if(pinString.equals(pin)){
					JOptionPane.showMessageDialog(null, "Нууц үг амжилттай! Нэвтэрч байна...");
					dispose();
					new ATM();
				} else{
					if(attempts != 1){
						attempts--;
						JOptionPane.showMessageDialog(null, "Нууц үг буруу! \n" + attempts 
						+ " attempts remaining!");
					} else {
						JOptionPane.showMessageDialog(null, "No Attempts remaining! \n Closing Program");
						System.exit(0);
					}
				}
			}	
		});
		entPin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				char[] pinGuess = pinText.getPassword();
				String pinString = new String(pinGuess);
				if(pinString.equals(pin)){
					JOptionPane.showMessageDialog(null, "That pin is correct! Opening Account...");
					dispose();
					new ATM();
				} else{
					if(attempts != 1){
						attempts--;
						JOptionPane.showMessageDialog(null, "That pin is incorrect! \n" + attempts 
						+ " attempts remaining!");
					} else {
						JOptionPane.showMessageDialog(null, "No Attempts remaining! \n Closing Program");
						System.exit(0);
					}
				}
			}	
		});
	}
}