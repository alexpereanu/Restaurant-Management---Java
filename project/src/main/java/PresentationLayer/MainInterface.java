package PresentationLayer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.*;

import BusinessLayer.Restaurant;
import DataLayer.RestaurantSerializator;



public class MainInterface {

	private static final int EXIT_ON_CLOSE = 1;
	public JFrame mainFrame;
	public JPanel mainPanel;

	public void initMainFrame(RestaurantSerializator serializator,  Restaurant restaurant) {

		
		final JFrame mainFrame = new JFrame("Main Interface");
		JPanel mainPanel = new JPanel();
		mainFrame.setVisible(true);
		mainFrame.setSize(500, 400);
		mainPanel.setLayout(null);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainPanel.setSize(499, 399);
		mainFrame.add(mainPanel);

		
		
		JButton adminButton = new JButton("Administrator");
		mainPanel.add(adminButton);
		adminButton.setBounds(160, 40, 150, 50);
		adminButton.setFont(new Font("TimesRoman", Font.PLAIN, 17));
		
		JButton waiterButton = new JButton("Waiter");
		mainPanel.add(waiterButton);
		waiterButton.setBounds(160, 150, 150, 50);
		waiterButton.setFont(new Font("TimesRoman", Font.PLAIN, 17));
		
		JButton chefButton = new JButton("Chef");
		mainPanel.add(chefButton);
		chefButton.setBounds(160, 260, 150, 50);
		chefButton.setFont(new Font("TimesRoman", Font.PLAIN, 17));
		
		adminButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				mainFrame.setVisible(false);
				//frameAdministrator.setVisible(true);
				AdministratorGraphicalUserInterface t = new AdministratorGraphicalUserInterface();
				t.initAdministratorInterface(serializator, restaurant);
				
			}
		});
		
		waiterButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				mainFrame.setVisible(false);
				//frameAdministrator.setVisible(true);
				WaiterGraphicalUserInterface t = new WaiterGraphicalUserInterface();
				t.initWaiterInterface(serializator, restaurant);
			}
		});

		chefButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				//mainFrame.setVisible(false);
				ChefGraphicalUserInterface chef = new ChefGraphicalUserInterface();
				chef.initChefGraphicalUserInterface();


			}
		});
	}
}
