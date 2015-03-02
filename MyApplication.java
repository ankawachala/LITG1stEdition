import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class MyApplication {

	final JFrame myFrame;
	final JPanel menuPanel, enterPanel, showPanel;
	JButton enterButton, showButton, exitButton, saveButton, goBack1Button, goBack2Button, nextButton, previousButton, browseBillButton, uploadBillButton;
	JLabel q1, q2, q3, q4, warning;
	JTextField a1, a2, a3, a4;
	ArrayList<String> WhatList, WhenList, WhereList;
	static ArrayList<String> HowMuchList;
	ArrayList<String> ImagePath;
	JTable showTable;
	JMenuBar menuBar;
	JMenu menuFile, menuSettings, menuHelp, ChangeLanguageSettings;
	JMenuItem saveChangesMenuFile, exitMenuFile, changeUserMenuSettings, aboutMyAppMenuHelp, englishLanguage, polishLanguage, arabicLanguage;
	JFileChooser fileChooser;
	FileNameExtensionFilter filter;
		
		public String getHowMuchValue(int a){
			return HowMuchList.get(a);
		}
		public String getWhatValue(int a){
			return WhatList.get(a);
		}
		public String getWhenValue(int a){
			return WhenList.get(a);
		}
		public String getWhereValue(int a){
			return WhereList.get(a);
		}
		public String getImagePathValue(int a){
			return ImagePath.get(a);
		}
	
		public static void main(String[] args) throws IOException 
		{  
			new MyApplication(); 
		}  

		public MyApplication() throws IOException {
			
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
	myFrame.setBackground(Color.WHITE);
	
	JDBC db = new JDBC();
	db.createDB();
	db.createTable();
	
	// MenuBar details
	menuBar = new JMenuBar();
	menuBar.setBackground(Color.BLACK);
	
	menuFile = new JMenu("File");
	menuFile.setForeground(Color.WHITE);
	menuFile.setFont(menuBarFont);
	saveChangesMenuFile = new JMenuItem("Save Changes");
	saveChangesMenuFile.setBackground(Color.WHITE);	
	saveChangesMenuFile.setForeground(Color.BLACK);
	saveChangesMenuFile.setFont(menuBarFont);
	exitMenuFile = new JMenuItem("Exit");
	exitMenuFile.setBackground(Color.WHITE);	
	exitMenuFile.setForeground(Color.BLACK);
	exitMenuFile.setFont(menuBarFont);
	
	menuSettings = new JMenu("Settings");
	menuSettings.setForeground(Color.WHITE);
	menuSettings.setFont(menuBarFont);
	changeUserMenuSettings = new JMenuItem("Change User");
	changeUserMenuSettings.setBackground(Color.WHITE);	
	changeUserMenuSettings.setForeground(Color.BLACK);
	changeUserMenuSettings.setFont(menuBarFont);
	ChangeLanguageSettings = new JMenu("Change Language");
	ChangeLanguageSettings.setBackground(Color.WHITE);	
	ChangeLanguageSettings.setForeground(Color.BLACK);
	ChangeLanguageSettings.setFont(menuBarFont);
	arabicLanguage = new JMenuItem("Arabic");
	arabicLanguage.setBackground(Color.WHITE);	
	arabicLanguage.setForeground(Color.BLACK);
	arabicLanguage.setFont(menuBarFont);	englishLanguage = new JMenuItem("English");
	englishLanguage.setBackground(Color.WHITE);	
	englishLanguage.setForeground(Color.BLACK);
	englishLanguage.setFont(menuBarFont);
	polishLanguage = new JMenuItem("Polish");
	polishLanguage.setBackground(Color.WHITE);	
	polishLanguage.setForeground(Color.BLACK);
	polishLanguage.setFont(menuBarFont);

	
	menuHelp = new JMenu("Help");
	menuHelp.setForeground(Color.WHITE);
	menuHelp.setFont(menuBarFont);
	aboutMyAppMenuHelp = new JMenuItem("About MyApplication");
	aboutMyAppMenuHelp.setBackground(Color.WHITE);	
	aboutMyAppMenuHelp.setForeground(Color.BLACK);
	aboutMyAppMenuHelp.setFont(menuBarFont);
	
	menuBar.add(menuFile);
	menuBar.add(menuSettings);
	menuBar.add(menuHelp);
	
	menuFile.add(saveChangesMenuFile);
	menuFile.addSeparator();
	menuFile.add(exitMenuFile);
	
	menuSettings.add(changeUserMenuSettings);
	menuSettings.add(ChangeLanguageSettings);
	ChangeLanguageSettings.add(arabicLanguage);	
	ChangeLanguageSettings.add(englishLanguage);
	ChangeLanguageSettings.add(polishLanguage);
	
	menuHelp.add(aboutMyAppMenuHelp);

	myFrame.setJMenuBar(menuBar);
	
	// Panels
	menuPanel = new JPanel(){
		private Image backgroundImage = ImageIO.read(new File("/Users/Anka/Desktop/Paragonsy_szkic.jpg"));
		   public void paint(Graphics g) {
		    super.paint(g);
		    g.drawImage(backgroundImage, 0, 0, myFrame.getWidth(), (myFrame.getWidth()/7), null);
		   }
		  };
	enterPanel = new JPanel(){
		private Image backgroundImage = ImageIO.read(new File("/Users/Anka/Desktop/Paragonsy_szkic.jpg"));
		   public void paint(Graphics g) {
		    super.paint(g);
		    g.drawImage(backgroundImage, 0, 0, myFrame.getWidth(), (myFrame.getWidth()/7), null);
		   }
		  };
	showPanel = new JPanel(){
		private Image backgroundImage = ImageIO.read(new File("/Users/Anka/Desktop/Paragonsy_szkic.jpg"));
		   public void paint(Graphics g) {
		    super.paint(g);
		    g.drawImage(backgroundImage, 0, 0, myFrame.getWidth(), (myFrame.getWidth()/7), null);
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
	enterButton.setFocusable(false);
	menuPanel.add(enterButton, c);
	
	// Button to hide menuPanel and show showPanel
	showButton = new JButton("Show your purchases");
	showButton.setFont(menuPanelFont);
	c.gridx = 0;
	c.gridy = 1;

	showButton.setPreferredSize(new Dimension(250, 50));
	showButton.setBackground(Color.BLACK);
	showButton.setForeground(Color.WHITE);
	showButton.setFocusable(false);
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
	exitButton.setFocusable(false);
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
//			showPanel.setSize(myFrame.getSize());
			previousButton.setEnabled(false);
			
			if(WhatList.size()<=5)
			{
				nextButton.setEnabled(false);
			}
			else
			{
				nextButton.setEnabled(true);
			}
			
			Object[] titleRow = {columnName1, columnName2, columnName3, columnName4, columnName5};
			tableModel.addRow(titleRow);
			
			for (int i = 0; i<5 && i<WhatList.size(); i++){
				   
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
			
			String a;
			String b;
			String c;
			String d;
			for(int i=0; i<WhatList.size(); i++){
			a= WhatList.get(i);
			b = WhatList.get(i);
			c = WhatList.get(i);
			d = WhatList.get(i);	
			db.insertRecord(a, b, c, d);
			}
		}	
	});
	
	// ENTER & SHOW PANELS
	
	// EnterPanel labels and text fields
		// q - question, a - answer
	
	
		warning = new JLabel("Please fill in all of the required fields");
		c.insets = new Insets(50, 0, 10, 0);
		c.gridx = 0;
		c.gridy = 0;		
		
		warning.setFont(enterPanelFont);
		warning.setForeground(Color.RED);
		enterPanel.add(warning, c);
		warning.setVisible(false);
		
		q1 = new JLabel("PRODUCT NAME:");
		c.insets = new Insets(15, 0, 15, 295);
		c.gridx = 0;
		c.gridy = 1;

		q1.setFont(enterPanelFont);
		enterPanel.add(q1, c);
		
		a1 = new JTextField(17);
		c.insets = new Insets(15, 250, 15, 100);
		c.gridx = 0;
		c.gridy = 1;
		
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
	c.insets = new Insets(25, 350, 0, 0);
	c.gridx = 0;
	c.gridy = 8;
	
	saveButton.setPreferredSize(new Dimension(125, 45));
	saveButton.setBackground(Color.BLACK);
	saveButton.setForeground(Color.WHITE);	
	saveButton.setFont(buttonFont);
	saveButton.setFocusable(false);
	enterPanel.add(saveButton, c);
	
	// Button to go back from enterPanel to the main menu
	goBack1Button = new JButton("GO BACK");
	c.insets = new Insets(25, 0, 0, 350);
	c.gridx = 0;
	c.gridy = 8;
	
	goBack1Button.setPreferredSize(new Dimension(125, 45));
	goBack1Button.setBackground(Color.BLACK);
	goBack1Button.setForeground(Color.WHITE);	
	goBack1Button.setFont(buttonFont);
	goBack1Button.setFocusable(false);
	enterPanel.add(goBack1Button, c);
	
	// Button to browse payment confirmation
	uploadBillButton = new JButton("UPLOAD YOUR BILL");
	c.insets = new Insets(25, 0, 0, 0);
	c.gridx = 0;
	c.gridy = 8;
	
	uploadBillButton.setPreferredSize(new Dimension(200, 45));
	uploadBillButton.setBackground(Color.WHITE);
	uploadBillButton.setForeground(Color.BLACK);	
	uploadBillButton.setFont(buttonFont);
	uploadBillButton.setFocusable(false);
	enterPanel.add(uploadBillButton, c);
	
	
// SHOW PANEL
	
	c.insets = new Insets(50, 0, 0, 0);
	c.gridx = 0;
	c.gridy = 1;
	showPanel.add(showTable, c);
	
	
	// Saving user's answers in ArrayLists & load its data into JTable
	WhatList= new ArrayList<String>();
	WhenList = new ArrayList<String>();
	WhereList = new ArrayList<String>();
	HowMuchList = new ArrayList<String>();
	
	
	// EnterPanel's ActionListeners	

	saveButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {

		if((!a1.getText().equals("") && !a2.getText().equals("") && !a3.getText().equals("") && !a4.getText().equals(""))){
			
			WhatList.add(a1.getText());
			WhenList.add(a2.getText());
			WhereList.add(a3.getText());
			HowMuchList.add(a4.getText());
			
			a1.setText("");
			a2.setText("");
			a3.setText("");
			a4.setText("");
			
			warning.setVisible(false);
			a1.requestFocus();
		}
		
		else{
			
			warning.setVisible(true);
			if(a1.getText().equals("")){
				a1.requestFocus();
			}
			else if(a2.getText().equals("")){
				a2.requestFocus();
			}
			else if(a3.getText().equals("")){
				a3.requestFocus();
			}
			else if(a4.getText().equals("")){
				a4.requestFocus();
			}
		}
				
			}	
		});

	
	goBack1Button.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			enterPanel.setVisible(false);
			menuPanel.setVisible(true);
			menuPanel.setSize(myFrame.getWidth(), myFrame.getHeight());
			menuPanel.validate();
			warning.setVisible(false);
			
			if (ImagePath.size()>0){
				for (int i=0; i<ImagePath.size(); i++){
				System.out.println(ImagePath.get(i));	
				}
			}
		}	
	});		

	
	fileChooser = new JFileChooser();
	ImagePath = new ArrayList<String>();
    filter = new FileNameExtensionFilter("Jpeg, gif and png files", "jpg", "gif", "png");
    fileChooser.addChoosableFileFilter(filter);
    
	uploadBillButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {

			if (fileChooser.showOpenDialog(uploadBillButton) == JFileChooser.APPROVE_OPTION){
		
			java.io.File billImage = fileChooser.getSelectedFile();		
			ImagePath.add(billImage.getPath());

	}
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
		goBack2Button.setFocusable(false);
		showPanel.add(goBack2Button, c);
		
	
		nextButton = new JButton("NEXT");
		c.insets = new Insets(50, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 5;
	
		nextButton.setPreferredSize(new Dimension(125, 45));
		nextButton.setBackground(Color.BLACK);
		nextButton.setForeground(Color.WHITE);	
		nextButton.setFont(buttonFont);
		nextButton.setFocusable(false);
		showPanel.add(nextButton, c);

		
		previousButton = new JButton("PREVIOUS");
		c.insets = new Insets(50, 350, 0, 0);
		c.gridx = 0;
		c.gridy = 5;

		previousButton.setPreferredSize(new Dimension(125, 45));
		previousButton.setBackground(Color.BLACK);
		previousButton.setForeground(Color.WHITE);	
		previousButton.setFont(buttonFont);
		previousButton.setFocusable(false);
		showPanel.add(previousButton, c);
		
	// Button to browse payment confirmation
		browseBillButton = new JButton("BROWSE YOUR BILL");
		
	
	// ShowPanel's ActionListeners
	
	final Click clickCounter = new Click();
		
	goBack2Button.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			showPanel.setVisible(false);
			menuPanel.setVisible(true);
			menuPanel.setSize(myFrame.getWidth(), myFrame.getHeight());
			menuPanel.validate();
			
			clickCounter.setClickedValue(0);
			
			if (tableModel.getRowCount() > 0) {
            for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
                 tableModel.removeRow(i);
                   }
               }
		}
	});
	
	
	nextButton.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int clicked = clickCounter.getClickedValue();
			
			previousButton.setEnabled(true);
			
			if (tableModel.getRowCount() > 0) {
	            for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
	                 tableModel.removeRow(i);
	                   }
	               }
			
			Object[] titleRow = {columnName1, columnName2, columnName3, columnName4, columnName5};
			tableModel.addRow(titleRow);
			
			for (int i = 5+(5*clicked); i<10+(5*clicked) && i<WhatList.size(); i++){
				   
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
			
			clickCounter.setClickedValue(clicked+1);
		}
	});

	
	previousButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (tableModel.getRowCount() > 0) {
	            for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
	                 tableModel.removeRow(i);
	                   }
	               }
			
			Object[] titleRow = {columnName1, columnName2, columnName3, columnName4, columnName5};
			tableModel.addRow(titleRow);
			
			int clicked = clickCounter.getClickedValue();
			
			for (int i = 5+(5*(clicked-2)); i<10+(5*(clicked-2)) && i<WhatList.size(); i++){
				   
				int ID2 = i+1;
				String What = WhatList.get(i);
				String When = WhenList.get(i);
				String Where = WhereList.get(i);
				String HowMuch = HowMuchList.get(i);

				Object[] rows = {ID2, What, When, Where, HowMuch};
				
				tableModel.addRow(rows);
				
				if(ID2<=5)
				{
					previousButton.setEnabled(false);
				}
				
				else
				{
					previousButton.setEnabled(true);
				}
				
				if(ID2<=WhatList.size()-(WhatList.size()%5))
				{
					nextButton.setEnabled(true);
				}
				else
				{
					nextButton.setEnabled(false);
				}
			}
			
			clickCounter.setClickedValue(clicked-1);
			
		}
	});
	
	browseBillButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}	
	});		
	

	myFrame.add(menuPanel);
	myFrame.add(enterPanel);
	myFrame.add(showPanel);
	
	
	menuPanel.setVisible(true);
	enterPanel.setVisible(false);
	showPanel.setVisible(false);
	
	myFrame.setVisible(true);
	
	myFrame.addComponentListener(new ComponentAdapter()
	{
		public void componentResized(ComponentEvent evt)
		{
			Component c=(Component)evt.getSource();
			
			if(menuPanel.isVisible()){
				menuPanel.setSize(myFrame.getWidth(), myFrame.getHeight());
				menuPanel.validate();	
			}
		
			else if(enterPanel.isVisible()){
				enterPanel.setSize(myFrame.getWidth(), myFrame.getHeight());
				enterPanel.validate();
			}
			
			else if(showPanel.isVisible()){
				showPanel.setSize(myFrame.getWidth(), myFrame.getHeight());
				showPanel.validate();
			}
		}
	});
		}
	}
