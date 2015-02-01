import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
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
	JButton enterButton, showButton, exitButton, saveButton, goBack1Button, goBack2Button, nextButton, previousButton;
	JLabel q1, q2, q3, q4;
	JTextField a1, a2, a3, a4;
	ArrayList<String> WhatList, WhenList, WhereList, HowMuchList;
	JTable showTable;
	JMenuBar menuBar;
	JMenu menuFile, menuSettings, menuHelp;
	JMenuItem option1, option2, option3, option4, option5, option6, option7;
	
		public static void main(String[] args) throws IOException 
		{  
			new MyMenu(); 
		}  

		public MyMenu() throws IOException {
			
	//All fonts
	Font menuPanelFont = new Font("Gill Sans MT", Font.PLAIN, 20);
	Font showTableFont = new Font("Gill Sans MT", Font.PLAIN, 14);
	Font buttonFont = new Font("Gill Sans MT", Font.PLAIN, 16);
	Font enterPanelFont = new Font("Gill Sans MT", Font.PLAIN, 18);
	Font menuBarFont = new Font("Gill Sans MT", Font.PLAIN, 16);
	
	// MyFrame details
	myFrame = new JFrame();
	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	myFrame.setTitle("MyApplication");
	myFrame.setSize(700, 500);
	// myFrame.setBackground(Color.WHITE); - it doesn't work :-(ó
	
	
	// MenuBar details
	menuBar = new JMenuBar();
	menuBar.setBackground(Color.BLACK);
	
	menuFile = new JMenu("File");
	menuFile.setForeground(Color.WHITE);
	menuFile.setFont(menuBarFont);
	option1 = new JMenuItem("Option1");
	option1.setBackground(Color.WHITE);	
	option1.setForeground(Color.BLACK);
	option1.setFont(menuBarFont);
	option2 = new JMenuItem("Option2");
	option2.setBackground(Color.WHITE);	
	option2.setForeground(Color.BLACK);
	option2.setFont(menuBarFont);
	option3 = new JMenuItem("Option3");
	option3.setBackground(Color.WHITE);	
	option3.setForeground(Color.BLACK);
	option3.setFont(menuBarFont);
	
	menuSettings = new JMenu("Settings");
	menuSettings.setForeground(Color.WHITE);
	menuSettings.setFont(menuBarFont);
	option4 = new JMenuItem("Option4");
	option4.setBackground(Color.WHITE);	
	option4.setForeground(Color.BLACK);
	option4.setFont(menuBarFont);
	option5 = new JMenuItem("Option5");
	option5.setBackground(Color.WHITE);	
	option5.setForeground(Color.BLACK);
	option5.setFont(menuBarFont);
	
	menuHelp = new JMenu("Help");
	menuHelp.setForeground(Color.WHITE);
	menuHelp.setFont(menuBarFont);
	option6 = new JMenuItem("Option6");
	option6.setBackground(Color.WHITE);	
	option6.setForeground(Color.BLACK);
	option6.setFont(menuBarFont);
	option7 = new JMenuItem("Option7");
	option7.setBackground(Color.WHITE);	
	option7.setForeground(Color.BLACK);
	option7.setFont(menuBarFont);
	
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
	menuPanel = new JPanel(){
		private Image backgroundImage = ImageIO.read(new File("/Users/Anka/Desktop/Paragonsy_szkic1.jpg"));
		   public void paint(Graphics g) {
		    super.paint(g);
		    g.drawImage(backgroundImage, 0, 0, null);
		   }
		  };
	enterPanel = new JPanel(){
		private Image backgroundImage = ImageIO.read(new File("/Users/Anka/Desktop/Paragonsy_szkic1.jpg"));
		   public void paint(Graphics g) {
		    super.paint(g);
		    g.drawImage(backgroundImage, 0, 0, null);
		   }
		  };
	showPanel = new JPanel(){
		private Image backgroundImage = ImageIO.read(new File("/Users/Anka/Desktop/Paragonsy_szkic1.jpg"));
		   public void paint(Graphics g) {
		    super.paint(g);
		    g.drawImage(backgroundImage, 0, 0, null);
		   }
		  };
	
	menuPanel.setLayout(new GridBagLayout());
	enterPanel.setLayout(new GridBagLayout());
	showPanel.setLayout(new GridBagLayout());
	
	menuPanel.setBackground(Color.WHITE);
	enterPanel.setBackground(Color.WHITE);
	showPanel.setBackground(Color.WHITE);
	
	
	// ShowTable details
	String columnName[] = {"ID", "PRODUCT NAME", "DATE OF PURCHASE", "SHOP NAME", "PRICE"};
	final DefaultTableModel tableModel = new DefaultTableModel(columnName, 0);
	showTable = new JTable(tableModel);
	showTable.setRowHeight(25);
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
	enterButton = new JButton("Enter new purchase");
	enterButton.setFont(menuPanelFont);
	c.insets = new Insets(0, 0, 20, 0);
	c.gridx = 0;
	c.gridy = 0;
	
	enterButton.setPreferredSize(new Dimension(250, 50));
	enterButton.setBackground(Color.BLACK);
	enterButton.setForeground(Color.WHITE);
	menuPanel.add(enterButton, c);
	
	// Button to hide menuPanel and show showPanel
	showButton = new JButton("Show your purchases");
	showButton.setFont(menuPanelFont);
	c.gridx = 0;
	c.gridy = 1;

	showButton.setPreferredSize(new Dimension(250, 50));
	showButton.setBackground(Color.BLACK);
	showButton.setForeground(Color.WHITE);
	menuPanel.add(showButton, c);
	
	
	// Button to exit the application
	exitButton = new JButton("Exit this application");
	exitButton.setFont(menuPanelFont);
	c.insets = new Insets(0, 0, 0, 0);
	c.gridx = 0;
	c.gridy = 2;

	exitButton.setPreferredSize(new Dimension(250, 50));
	exitButton.setBackground(Color.BLACK);
	exitButton.setForeground(Color.WHITE);
	menuPanel.add(exitButton, c);
	
	
	
	// MenuPanel's ActionListeners
	
	enterButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
		
			menuPanel.setVisible(false);
			enterPanel.setVisible(true);
			enterPanel.setSize(myFrame.getSize());
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
			showPanel.setSize(myFrame.getSize());
			previousButton.setEnabled(false);
			
			if(WhatList.isEmpty()==true)
			{
				nextButton.setEnabled(false);
			}
			else
			{
				nextButton.setEnabled(true);
			}
			
			Object[] titleRow = {columnName1, columnName2, columnName3, columnName4, columnName5};
			tableModel.addRow(titleRow);
			
			for (int i = 0; i<5; i++){
				   
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
	
	
		q1 = new JLabel("PRODUCT NAME:");
		c.insets = new Insets(50, 0, 15, 295);
		c.gridx = 0;
		c.gridy = 0;

		q1.setFont(enterPanelFont);
		enterPanel.add(q1, c);
		
		a1 = new JTextField(17);
		c.insets = new Insets(50, 250, 15, 100);
		c.gridx = 0;
		c.gridy = 0;
		
		a1.setFont(enterPanelFont);
		enterPanel.add(a1, c);

		q2 = new JLabel("DATE OF PURCHASE:");
		c.insets = new Insets(0, 0, 15, 323);
		c.gridx = 0;
		c.gridy = 2;
		
		q2.setFont(enterPanelFont);
		enterPanel.add(q2, c);
		
		a2 = new JTextField(17);
		c.insets = new Insets(0, 250, 15, 100);
		c.gridx = 0;
		c.gridy = 2;
		
		a2.setFont(enterPanelFont);
		enterPanel.add(a2, c);

		q3 = new JLabel("SHOP NAME:");
		c.insets = new Insets(0, 0, 15, 253);
		c.gridx = 0;
		c.gridy = 3;
		
		q3.setFont(enterPanelFont);
		enterPanel.add(q3, c);
		
		a3 = new JTextField(17);
		c.insets = new Insets(0, 250, 15, 100);
		c.gridx = 0;
		c.gridy = 3;
		
		a3.setFont(enterPanelFont);
		enterPanel.add(a3, c);

		q4 = new JLabel("PRICE:");
		c.insets = new Insets(0, 0, 15, 200);
		c.gridx = 0;
		c.gridy = 4;
		
		q4.setFont(enterPanelFont);
		enterPanel.add(q4, c);
		
		a4 = new JTextField(17);
		c.insets = new Insets(0, 250, 15, 100);
		c.gridx = 0;
		c.gridy = 4;
		
		a4.setFont(enterPanelFont);
		enterPanel.add(a4, c);

		
	// Button to save data
	saveButton = new JButton("SAVE");
	c.insets = new Insets(35, 0, 0, 200);
	c.gridx = 0;
	c.gridy = 8;
	
	saveButton.setPreferredSize(new Dimension(125, 45));
	saveButton.setBackground(Color.BLACK);
	saveButton.setForeground(Color.WHITE);	
	saveButton.setFont(buttonFont);
	enterPanel.add(saveButton, c);
	
	// Button to go back from enterPanel to the main menu
	goBack1Button = new JButton("GO BACK");
	c.insets = new Insets(35, 200, 0, 0);
	c.gridx = 0;
	c.gridy = 8;
	
	goBack1Button.setPreferredSize(new Dimension(125, 45));
	goBack1Button.setBackground(Color.BLACK);
	goBack1Button.setForeground(Color.WHITE);	
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
			menuPanel.setSize(myFrame.getSize());
		}	
	});		

		
	
	// Button to go back from showPanel to the main menu
	
		goBack2Button = new JButton("GO BACK");
		c.insets = new Insets(50, 0, 0, 350);
		c.gridx = 0;
		c.gridy = 5;
		
		goBack2Button.setPreferredSize(new Dimension(125, 45));
		goBack2Button.setBackground(Color.BLACK);
		goBack2Button.setForeground(Color.WHITE);	
		goBack2Button.setFont(buttonFont);
		showPanel.add(goBack2Button, c);
		
	
		nextButton = new JButton("NEXT");
		c.insets = new Insets(50, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 5;
	
		nextButton.setPreferredSize(new Dimension(125, 45));
		nextButton.setBackground(Color.BLACK);
		nextButton.setForeground(Color.WHITE);	
		nextButton.setFont(buttonFont);
		showPanel.add(nextButton, c);

		
		previousButton = new JButton("PREVIOUS");
		c.insets = new Insets(50, 350, 0, 0);
		c.gridx = 0;
		c.gridy = 5;

		previousButton.setPreferredSize(new Dimension(125, 45));
		previousButton.setBackground(Color.BLACK);
		previousButton.setForeground(Color.WHITE);	
		previousButton.setFont(buttonFont);
		showPanel.add(previousButton, c);
		
	
	// ShowPanel's ActionListeners
	
	goBack2Button.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			showPanel.setVisible(false);
			menuPanel.setVisible(true);
			menuPanel.setSize(myFrame.getSize());
			
			if (tableModel.getRowCount() > 0) {
            for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
                 tableModel.removeRow(i);
                   }
               }
		}
	});
	
	
	nextButton.addActionListener(new ActionListener(){
	
		int clicked;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			previousButton.setEnabled(true);
			
			if (tableModel.getRowCount() > 0) {
	            for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
	                 tableModel.removeRow(i);
	                   }
	               }
			
			Object[] titleRow = {columnName1, columnName2, columnName3, columnName4, columnName5};
			tableModel.addRow(titleRow);
			
			for (int i = 5+(5*clicked); i<10+(5*clicked); i++){
				   
				int ID2 = i+1;
				String What = WhatList.get(i);
				String When = WhenList.get(i);
				String Where = WhereList.get(i);
				String HowMuch = HowMuchList.get(i);

				Object[] rows = {ID2, What, When, Where, HowMuch};
				
				tableModel.addRow(rows);
				
				if(ID2==WhatList.size())
				{
					nextButton.setEnabled(false);
				}
				
				else
				{
					nextButton.setEnabled(true);
				}
			}
			
			clicked++;
		}
	});

	
	/*previousButton.addActionListener(new ActionListener(){
		
		int clicked;
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	});*/
	
	myFrame.add(menuPanel);
	myFrame.add(enterPanel);
	myFrame.add(showPanel);
	
	menuPanel.setSize(myFrame.getSize());
	enterPanel.setSize(myFrame.getSize());
	showPanel.setSize(myFrame.getSize());
	
	menuPanel.setVisible(true);
	enterPanel.setVisible(false);
	showPanel.setVisible(false);
	
	myFrame.setVisible(true);
		}
	}
