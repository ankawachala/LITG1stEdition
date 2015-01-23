import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
// ctrl shift o
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MyMenu {

	final JFrame myFrame;
	final JPanel menuPanel, enterPanel, showPanel;
	JButton enterButton, showButton, exitButton, saveButton, goBack1Button, goBack2Button;
	JLabel q1, q2, q3, q4;
	JTextField a1, a2, a3, a4;
	ArrayList<String> WhatList, WhenList, WhereList, HowMuchList;
	JTable showTable;
	JMenuBar menuBar;
	JMenu menuFile, menuSettings, menuHelp;
	JMenuItem option1, option2, option3, option4, option5, option6, option7;
	
		public static void main(String[] args) 
		{  
			new MyMenu(); 
		}  

		public MyMenu() {
	
	// Frame title & size
	myFrame = new JFrame();
	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	myFrame.setTitle("MyApplication");
	myFrame.setSize(700, 500);
	myFrame.getContentPane().setBackground(Color.WHITE);
	
	menuBar = new JMenuBar();
	
	menuFile = new JMenu("File");
	option1 = new JMenuItem("Option1");
	option2 = new JMenuItem("Option2");
	option3 = new JMenuItem("Option3");
	
	menuSettings = new JMenu("Settings");
	option4 = new JMenuItem("Option4");
	option5 = new JMenuItem("Option5");
	
	menuHelp = new JMenu("Help");
	option6 = new JMenuItem("Option6");
	option7 = new JMenuItem("Option7");
	
	menuBar.add(menuFile);
	menuBar.add(menuSettings);
	menuBar.add(menuHelp);
	
	menuFile.add(option1);
	menuFile.add(option2);
	menuFile.add(option3);
	
	menuSettings.add(option4);
	menuSettings.add(option5);
	
	menuHelp.add(option6);
	menuHelp.add(option7);

	myFrame.setJMenuBar(menuBar);
	
	// Panels
	menuPanel = new JPanel();
	enterPanel = new JPanel();
	showPanel = new JPanel();
	
	menuPanel.setLayout(new GridBagLayout());
	enterPanel.setLayout(new GridBagLayout());
	showPanel.setLayout(new GridBagLayout());
	
	menuPanel.setBackground(Color.WHITE);
	enterPanel.setBackground(Color.WHITE);
	showPanel.setBackground(Color.WHITE);
	
	//All fonts
	Font menuPanelFont = new Font("Gill Sans MT", Font.PLAIN, 20);
	Font showTableFont = new Font("Gill Sans MT", Font.PLAIN, 14);
	Font buttonFont = new Font("Gill Sans MT", Font.PLAIN, 16);
	Font enterPanelFont = new Font("Gill Sans MT", Font.PLAIN, 18);
	
	
	String columnName[] = {"ID", "PRODUCT NAME", "DATE OF PURCHASE", "SHOP NAME", "PRICE"};
	final DefaultTableModel tableModel = new DefaultTableModel(columnName, 0);
	showTable = new JTable(tableModel);
	showTable.setRowHeight(showTable.getRowHeight() + 7);
	showTable.setFont(showTableFont);
	
	showTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	showTable.getColumnModel().getColumn(0).setPreferredWidth(25);
	showTable.getColumnModel().getColumn(1).setPreferredWidth(150);
	showTable.getColumnModel().getColumn(2).setPreferredWidth(150);
	showTable.getColumnModel().getColumn(3).setPreferredWidth(150);
	showTable.getColumnModel().getColumn(4).setPreferredWidth(75);
	
	GridBagConstraints c = new GridBagConstraints();
	
	// MENU PANEL
	
	// Button to hide menuPanel and show enterPanel
	enterButton = new JButton("To write what you bought - press here");
	enterButton.setFont(menuPanelFont);
	c.insets = new Insets(0, 0, 20, 0);
	c.gridx = 0;
	c.gridy = 0;
	
	enterButton.setBackground(Color.WHITE);
	menuPanel.add(enterButton, c);
	
	// Button to hide menuPanel and show showPanel
	showButton = new JButton("To see what you bought - press here");
	showButton.setFont(menuPanelFont);
	c.gridx = 0;
	c.gridy = 1;

	showButton.setBackground(Color.WHITE);
	menuPanel.add(showButton, c);
	
	
	// Button to exit the application
	exitButton = new JButton("To exit this application - press here");
	exitButton.setFont(menuPanelFont);
	c.insets = new Insets(0, 0, 0, 0);
	c.gridx = 0;
	c.gridy = 2;

	exitButton.setBackground(Color.WHITE);
	menuPanel.add(exitButton, c);
	
	
	
	// MenuPanel's ActionListeners
	
	enterButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
		
			menuPanel.setVisible(false);
			enterPanel.setVisible(true);
			a1.requestFocus();

		}
	});
	
	// ShowTable
	final String columnName1 = "ID";
	final String columnName2 = "PRODUCT NAME";
	final String columnName3 = "DATE OF PURCHASE";
	final String columnName4 = "SHOP NAME";
	final String columnName5 = "PRICE";
	
	showButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {

			menuPanel.setVisible(false);
			showPanel.setVisible(true);
			
			Object[] titleRow = {columnName1, columnName2, columnName3, columnName4, columnName5};
			tableModel.addRow(titleRow);
			
			for (int i = 0; i<WhatList.size(); i++){
				   
				int ID2 = i+1;
				String What = WhatList.get(i);
				String When = WhenList.get(i);
				String Where = WhereList.get(i);
				String HowMuch = HowMuchList.get(i);

				Object[] rows = {ID2, What, When, Where, HowMuch};
				
				tableModel.addRow(rows);

				}
			
		}
	});
	
	
	exitButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			myFrame.dispose();
		}	
	});
	
	// ENTER & SHOW PANELS
	
	// EnterPanel labels and text fields
		// q - question, a - answer
	
	
		q1 = new JLabel("Please type in what did you buy and then press Enter");
		c.insets = new Insets(0, 0, 5, 0);
		c.gridx = 0;
		c.gridy = 0;

		q1.setFont(enterPanelFont);
		enterPanel.add(q1, c);
		
		a1 = new JTextField(21);
		c.insets = new Insets(0, 0, 15, 0);
		c.gridx = 0;
		c.gridy = 1;
		
		a1.setFont(enterPanelFont);
		enterPanel.add(a1, c);

		q2 = new JLabel("Please type in when did you buy it and then press Enter");
		c.insets = new Insets(0, 0, 5, 0);
		c.gridx = 0;
		c.gridy = 2;
		
		q2.setFont(enterPanelFont);
		enterPanel.add(q2, c);
		
		a2 = new JTextField(21);
		c.insets = new Insets(0, 0, 15, 0);
		c.gridx = 0;
		c.gridy = 3;
		
		a2.setFont(enterPanelFont);
		enterPanel.add(a2, c);

		q3 = new JLabel("Please type in where did you buy it and then press Enter");
		c.insets = new Insets(0, 0, 5, 0);
		c.gridx = 0;
		c.gridy = 4;
		
		q3.setFont(enterPanelFont);
		enterPanel.add(q3, c);
		
		a3 = new JTextField(21);
		c.insets = new Insets(0, 0, 15, 0);
		c.gridx = 0;
		c.gridy = 5;
		
		a3.setFont(enterPanelFont);
		enterPanel.add(a3, c);

		q4 = new JLabel("Please type in how much PLN money did it cost and then press Enter");
		c.insets = new Insets(0, 0, 5, 0);
		c.gridx = 0;
		c.gridy = 6;
		
		q4.setFont(enterPanelFont);
		enterPanel.add(q4, c);
		
		a4 = new JTextField(21);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 7;
		
		a4.setFont(enterPanelFont);
		enterPanel.add(a4, c);

		
	// Button to save data
	saveButton = new JButton("To save your answers - press here");
	c.insets = new Insets(50, 0, 0, 250);
	c.gridx = 0;
	c.gridy = 8;
	
	saveButton.setBackground(Color.WHITE);
	saveButton.setFont(buttonFont);
	enterPanel.add(saveButton, c);
	
	// Button to go back from enterPanel to the main menu
	goBack1Button = new JButton("To go back - press here");
	c.insets = new Insets(50, 250, 0, 0);
	c.gridx = 0;
	c.gridy = 8;

	goBack1Button.setBackground(Color.WHITE);
	goBack1Button.setFont(buttonFont);
	enterPanel.add(goBack1Button, c);
	
	showPanel.add(showTable);

	// Saving user's answers in ArrayLists & load its data into JTable
	WhatList= new ArrayList<String>();
	WhenList = new ArrayList<String>();
	WhereList = new ArrayList<String>();
	HowMuchList = new ArrayList<String>();
	
	
	// EnterPanel's ActionListeners	

	saveButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {

			WhatList.add(a1.getText());
			WhenList.add(a2.getText());
			WhereList.add(a3.getText());
			HowMuchList.add(a4.getText());
			
			a1.setText("");
			a2.setText("");
			a3.setText("");
			a4.setText("");
			
			a1.requestFocus();
				
			}	
		});

	
	goBack1Button.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			enterPanel.setVisible(false);
			menuPanel.setVisible(true);
		}	
	});		

		
	
	// Button to go back from showPanel to the main menu
	goBack2Button = new JButton("To go back - press here");
	c.insets = new Insets(50, 0, 0, 0);
	c.gridx = 0;
	c.gridy = 5;
	
	goBack2Button.setBackground(Color.WHITE);
	goBack2Button.setFont(buttonFont);
	showPanel.add(goBack2Button, c);

	
	// ShowPanel's ActionListeners
	
	goBack2Button.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			showPanel.setVisible(false);
			menuPanel.setVisible(true);
			if (tableModel.getRowCount() > 0) {
            for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
                 tableModel.removeRow(i);
                   }
               }
		}
	});
	
	
	myFrame.add(menuPanel);
	myFrame.add(enterPanel);
	myFrame.add(showPanel);
	
	menuPanel.setSize(700, 500);
	enterPanel.setSize(700, 500);
	showPanel.setSize(700, 500);
	
	menuPanel.setVisible(true);
	enterPanel.setVisible(false);
	showPanel.setVisible(false);
	
	myFrame.setVisible(true);
		}
	}
