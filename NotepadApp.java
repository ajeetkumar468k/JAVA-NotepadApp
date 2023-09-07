package notepadapp;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
//import java.io.FileWriter;
//import java.io.*;

//import java.io.File;
//import java.io.FilenameFilter;

public class NotepadApp extends JFrame implements ActionListener{
	JMenuBar menubar = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenu edit = new JMenu("Edit");
	JMenu help = new JMenu("Help"); 
	
	JMenuItem newFile = new JMenuItem("New");
	JMenuItem openFile = new JMenuItem("Open");
	JMenuItem saveFile = new JMenuItem("Save");
	JMenuItem print = new JMenuItem("Print");
	JMenuItem exit = new JMenuItem("Exit");
	
	JMenuItem cut = new JMenuItem("Cut");
	JMenuItem copy = new JMenuItem("Copy");
	JMenuItem paste = new JMenuItem("Paste");
	JMenuItem selectall = new JMenuItem("Select All");
	
	JMenuItem about = new JMenuItem("About");
	
	JTextArea textArea = new JTextArea();
	
	
	NotepadApp(){
		setTitle("Notepad Application");
		setBounds(100,100,800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("notepad.png"));
		setIconImage(icon.getImage());
		
		setJMenuBar(menubar);
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		
		file.add(newFile);
		file.add(openFile);
		file.add(saveFile);
		file.add(print);
		file.add(exit);
		
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectall);
		
		help.add(about);
		
		JScrollPane scrollpane = new JScrollPane(textArea);
		add(scrollpane);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                
                scrollpane.setBorder(BorderFactory.createEmptyBorder());
		
		textArea.setFont(new Font(Font.SERIF,Font.PLAIN,20));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
                
                newFile.addActionListener(this);
                openFile.addActionListener(this);
                saveFile.addActionListener(this);
                print.addActionListener(this);
                exit.addActionListener(this);
                cut.addActionListener(this);
                copy.addActionListener(this);
                paste.addActionListener(this);
                selectall.addActionListener(this);
                about.addActionListener(this);
                
                newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
                openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
                saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
                print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
                exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,KeyEvent.CTRL_DOWN_MASK));
                cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
                copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
                paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
                selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
                about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
		
	}
	
		

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("New")){
            textArea.setText(null);
            
        }else if(e.getActionCommand().equalsIgnoreCase("Open")){
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Only Text Files(.txt)","txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);
            
            int action  = fileChooser.showOpenDialog(null);
            
            if(action != JFileChooser.APPROVE_OPTION){
                return;
            }else{ 
                try{
                    BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                    textArea.read(reader,null);
                    
                }catch(IOException ex){
                        ex.printStackTrace();
                }
            
            }
                
        }else if(e.getActionCommand().equalsIgnoreCase("Save")){
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Only Text Files(.txt)","txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);
            int action=fileChooser.showSaveDialog(null);
            if(action != JFileChooser.APPROVE_OPTION){
                return;
            }else{
                String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
                if(!fileName.contains("txt"))
                    fileName = fileName+"txt";
                try{
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    textArea.write(writer);
                    
                }catch(IOException ex){
                        ex.printStackTrace();
                }
            }
            
        }else if(e.getActionCommand().equalsIgnoreCase("Print")){
            try {
                textArea.print();
            } catch (PrinterException ex) {
                Logger.getLogger(NotepadApp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(e.getActionCommand().equalsIgnoreCase("Exit")){
            System.exit(0);
            
        }else if(e.getActionCommand().equalsIgnoreCase("Cut")){
            textArea.cut();
            
        }else if(e.getActionCommand().equalsIgnoreCase("Copy")){
            textArea.copy();
            
        }else if(e.getActionCommand().equalsIgnoreCase("Paste")){
            textArea.paste();
            
        }else if(e.getActionCommand().equalsIgnoreCase("Select All")){
            textArea.selectAll();
            
        }else if(e.getActionCommand().equalsIgnoreCase("About")){
            new About().setVisible(true);
            
        }
    }
    
    public static void main(String[] args) throws Exception{
        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new NotepadApp().setVisible(true);
	}
}


