import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
// ctrl shift o
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyMenu {

		public static void main(String[] args) 
		{  
			new MyMenu(); 
		}  

		public MyMenu() {

	final JFrame myFrame = new JFrame();
	
	// Frame title & size
	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	myFrame.setTitle("MyApplication");
	myFrame.setSize(700, 500);

	// Panels
	final JPanel menuPanel = new JPanel();
	final JPanel enterPanel = new JPanel();
	final JPanel showPanel = new JPanel();
	menuPanel.setLayout(new GridBagLayout());
	enterPanel.setLayout(new GridBagLayout());
	showPanel.setLayout(new GridBagLayout());
	
	GridBagConstraints c = new GridBagConstraints();
	
	// Button to hide menuPanel and show enterPanel
	JButton enterButton = new JButton("To write what you bought - press here");
	c.gridx = 0;
	c.gridy = 0;
	
	menuPanel.add(enterButton, c);
	
	enterButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
		
			menuPanel.setVisible(false);
			myFrame.add(enterPanel);
			enterPanel.setVisible(true);
		}
	});
	
	// Button to hide menuPanel and show showPanel
	JButton showButton = new JButton("To see what you bought - press here");
	c.gridx = 0;
	c.gridy = 2;
	
	menuPanel.add(showButton, c);
	
	showButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {

			menuPanel.setVisible(false);
			myFrame.add(showPanel);
			showPanel.setVisible(true);
		}
	});

	// Button to exit the application
	JButton exitButton = new JButton("To exit this application - press here");
	c.gridx = 0;
	c.gridy = 5;
	
	menuPanel.add(exitButton, c);
	
	exitButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			myFrame.setVisible(false);
			// How to make 100% exit? 
		}	
	});
	
	// Button to go back from enterPanel to the main menu
		JButton saveButton = new JButton("To save your answers - press here");
		c.gridx = 0;
		c.gridy = 8;

		enterPanel.add(saveButton, c);
		
		saveButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
	
	// How to export user's answer from enterPanel to showPanel ArrayLists?
				
			}	
		});
	
	// Button to go back from enterPanel to the main menu
	JButton goBack1Button = new JButton("To go back - press here");
	c.gridx = 0;
	c.gridy = 9;

	enterPanel.add(goBack1Button, c);
	
	goBack1Button.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			boolean check=enterPanel.isVisible();
			enterPanel.setVisible(!check);
			menuPanel.setVisible(check);
		}	
	});

	// Button to go back from showPanel to the main menu
	JButton goBack2Button = new JButton("To go back - press here");
	c.gridx = 0;
	c.gridy = 5;
	
	showPanel.add(goBack2Button, c);
	
	goBack2Button.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			boolean check=showPanel.isVisible();
			showPanel.setVisible(!check);
			menuPanel.setVisible(check);
		}	
	});
	
	// EnterPanel labels and text fields
	// q - question, a - answer
	final JLabel q1 = new JLabel("Please type in what did you buy and then press Enter");
	c.gridx = 0;
	c.gridy = 0;
	enterPanel.add(q1, c);
	
	JTextField a1 = new JTextField(21);
	c.gridx = 0;
	c.gridy = 1;
	enterPanel.add(a1, c);

	JLabel q2 = new JLabel("Please type in when did you buy it and then press Enter");
	c.gridx = 0;
	c.gridy = 2;
	enterPanel.add(q2, c);
	
	JTextField a2 = new JTextField(21);
	c.gridx = 0;
	c.gridy = 3;
	enterPanel.add(a2, c);

	final JLabel q3 = new JLabel("Please type in where did you buy it and then press Enter");
	c.gridx = 0;
	c.gridy = 4;
	enterPanel.add(q3, c);
	
	JTextField a3 = new JTextField(21);
	c.gridx = 0;
	c.gridy = 5;
	enterPanel.add(a3, c);

	JLabel q4 = new JLabel("Please type in how much PLN money did it cost and then press Enter");
	c.gridx = 0;
	c.gridy = 6;
	enterPanel.add(q4, c);
	
	JTextField a4 = new JTextField(21);
	c.gridx = 0;
	c.gridy = 7;
	enterPanel.add(a4, c);
	
	// ShowPanel ArrayLists
	ArrayList<String> WhatList = new ArrayList<String>();
	WhatList.add(a1.getText());

	ArrayList<String> WhenList = new ArrayList<String>();
	WhenList.add(a2.getText());
	
	ArrayList<String> WhereList = new ArrayList<String>();
	WhereList.add(a3.getText());
	
	ArrayList<String> HowMuchList = new ArrayList<String>();
	HowMuchList.add(a4.getText());
	
	
	JTextArea shoppingList = new JTextArea();
	shoppingList.setText("What you bought"+"\t"+"When you bought it"+"\t"+"Where you bought it"+"\t"+"How much you paid");
	shoppingList.setEditable(false);	
	showPanel.add(shoppingList);
	
	myFrame.add(menuPanel);
	
	myFrame.setVisible(true);
		}

	}
