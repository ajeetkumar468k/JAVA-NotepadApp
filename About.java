
package notepadapp;

import java.awt.*;

import javax.swing.*;

public class About extends JFrame{
	
	About(){
    setBounds(100,100,500,400);
	setTitle("About Notepad Application");
	setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
	
	ImageIcon icon = new ImageIcon(getClass().getResource("notepad.png"));
	setIconImage(icon.getImage());
	
	setLayout (null);
	
	
	
	
	JLabel iconLabel = new JLabel(new ImageIcon(getClass() .getResource("notepad.png")));
	iconLabel.setBounds(17, 90, 60, 60);
	add(iconLabel);
	
	JLabel textLabel1 = new JLabel("<html>Windows 10</html>");
	textLabel1.setBounds(100, 1, 250,100);
	textLabel1.setFont(new Font(Font.SERIF, Font.PLAIN,40));
	add(textLabel1);
	
	JLabel textLabel = new JLabel("<html>________________________________________________<br>Welcome to Notepad<br> Notepad is a simple text editor for Microsoft Windows and a basic text-editing program which enables computer users to create documents.<br> <br>© Microsof Corporation. All Rights Reserved @2023<br>This product is licensed under the Microsoft Software Licence Terms to: xyz@gmail.com</html>");
	textLabel.setBounds(100, 5, 350,300);
	textLabel.setFont(new Font(Font.SERIF, Font.PLAIN,14));
	add(textLabel);
	

    }
	public static void main(String[] args) {
	new About().setVisible (true);
	
    }
}
