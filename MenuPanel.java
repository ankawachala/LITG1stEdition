import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class MenuPanel {

	JPanel menuPanel, enterPanel, showPanel;
	JButton enterButton, showButton, exitButton, saveButton, goBack1Button, goBack2Button, nextButton, previousButton, browseBillButton, uploadBillButton;
	JLabel q1, q2, q3, q4, warning;
	JTextField a1, a2, a3, a4;

	final String columnName1 = "ID";
	final String columnName2 = "PRODUCT NAME";
	final String columnName3 = "DATE OF PURCHASE";
	final String columnName4 = "SHOP NAME";
	final String columnName5 = "PRICE";
	
public void designMenuPanel(final JDBC db, final DefaultTableModel tableModel) {
		
		Font menuPanelFont = new Font("Gill Sans MT", Font.PLAIN, 20);
		GridBagConstraints c = new GridBagConstraints();
		
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
				enterPanel.setSize(MyApplication.myFrame.getSize());
				a1.requestFocus();

			}
		});


		showButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				menuPanel.setVisible(false);
				showPanel.setVisible(true);
				//			showPanel.setSize(myFrame.getSize());
				previousButton.setEnabled(false);

				if(MyApplication.WhatList.size()<=5)
				{
					nextButton.setEnabled(false);
				}
				else
				{
					nextButton.setEnabled(true);
				}

				Object[] titleRow = {columnName1, columnName2, columnName3, columnName4, columnName5};
				tableModel.addRow(titleRow);

				for (int i = 0; i<5 && i<MyApplication.WhatList.size(); i++){

					int ID2 = i+1;
					String What = MyApplication.WhatList.get(i);
					String When = MyApplication.WhenList.get(i);
					String Where = MyApplication.WhereList.get(i);
					String HowMuch = MyApplication.HowMuchList.get(i);

					Object[] rows = {ID2, What, When, Where, HowMuch};

					tableModel.addRow(rows);
				}	
			}
		});


		exitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				MyApplication.myFrame.dispose();			
				db.insertRecord();

				/*			Integer aa;
			String bb;
			String cc;
			String dd;
			String ee;
			String ff;

			for(int i=0; i<WhatList.size(); i++){
			aa= i+1;
			bb = WhatList.get(i);
			// WhatList, WhenList, WhereList, HowMuchList, ImagePath;
			cc = WhenList.get(i);
			dd = WhereList.get(i);
			ee = HowMuchList.get(i);
			ff = ImagePath.get(i);

			db.insertRecord(aa, bb, cc, dd, ee, ff);
			}*/
			}	
		});

	}
}
