package PresentationLayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BusinessLayer.*;
import BusinessLayer.MenuItem;
import DataLayer.RestaurantSerializator;

public class WaiterGraphicalUserInterface extends JFrame implements ActionListener {

	public JFrame waiterFrame;
	public JPanel waiterPanel;
	JButton addNewOrder, viewAllOrders, computeBill, backButton;
	public IRestaurantProcessing rere;
	
	/*RestaurantSerializator serializator = new RestaurantSerializator();
	Restaurant re = serializator.deserializare();*/


	public Restaurant restaurant;

	public void initWaiterInterface(RestaurantSerializator serializator, Restaurant re) {
		this.restaurant = re;
		waiterFrame = new JFrame("Waiter Interface");
		waiterFrame.setSize(500, 400);
		waiterFrame.setVisible(true);
		waiterFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		waiterPanel = new JPanel();
		waiterFrame.add(waiterPanel);
		waiterPanel.setLayout(null);
		waiterPanel.setSize(499, 399);

		addNewOrder = new JButton("Add New Order");
		waiterPanel.add(addNewOrder);
		addNewOrder.setBounds(100, 50, 200, 50);
		addNewOrder.setFont(new Font("TimesRoman", Font.PLAIN, 17));

		viewAllOrders = new JButton("View All Orders");
		waiterPanel.add(viewAllOrders);
		viewAllOrders.setBounds(100, 150, 200, 50);
		viewAllOrders.setFont(new Font("TimesRoman", Font.PLAIN, 17));

		computeBill = new JButton("Compute Bill");
		waiterPanel.add(computeBill);
		computeBill.setBounds(100, 250, 200, 50);
		computeBill.setFont(new Font("TimesRoman", Font.PLAIN, 17));

		backButton = new JButton("BACK");
		waiterPanel.add(backButton);
		backButton.setBounds(370, 50, 70, 250);

		backButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				waiterFrame.setVisible(false);
				MainInterface t = new MainInterface();
				t.initMainFrame(serializator,re);

			}
		});

		addNewOrder.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				waiterFrame.setVisible(false);
				JFrame addFrame = new JFrame("ADD NEW ORDER");
				JPanel addPanel = new JPanel();
				addFrame.add(addPanel);
				addFrame.setSize(500, 400);
				addFrame.setVisible(true);
				addPanel.setLayout(null);
				addFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

				JButton backB = new JButton("BACK");
				addPanel.add(backB);
				backB.setBounds(370, 318, 70, 30);

				backB.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						addFrame.setVisible(false);
						waiterFrame.setVisible(true);
						//MainInterface t = new MainInterface();
						//t.initMainFrame(serializator,re);

					}
				});

				JLabel idComanda = new JLabel("ID Comanda");
				addPanel.add(idComanda);
				idComanda.setBounds(10, 30, 100, 50);
				idComanda.setFont(new Font("TimesRoman", Font.PLAIN, 17));

				final JTextField textComanda = new JTextField();
				addPanel.add(textComanda);
				textComanda.setBounds(110, 45, 50, 25);

				JLabel ora = new JLabel("Ora");
				addPanel.add(ora);
				ora.setBounds(10, 85, 40, 25);
				ora.setFont(new Font("TimesRoman", Font.PLAIN, 17));

				final JTextField oraText = new JTextField();
				addPanel.add(oraText);
				oraText.setBounds(45, 85, 30, 25);

				JLabel minutul = new JLabel("Minutul");
				addPanel.add(minutul);
				minutul.setBounds(10, 125, 80, 25);
				minutul.setFont(new Font("TimesRoman", Font.PLAIN, 17));

				final JTextField minutulText = new JTextField();
				addPanel.add(minutulText);
				minutulText.setBounds(70, 125, 30, 25);

				JLabel masa = new JLabel("Masa");
				addPanel.add(masa);
				masa.setBounds(10, 165, 50, 25);
				masa.setFont(new Font("TimesRoman", Font.PLAIN, 17));

				final JTextField masaText = new JTextField();
				addPanel.add(masaText);
				masaText.setBounds(65, 165, 30, 25);

				final JLabel produs1 = new JLabel("Produs1");
				addPanel.add(produs1);
				produs1.setBounds(10, 205, 70, 25);
				produs1.setFont(new Font("TimesRoman", Font.PLAIN, 17));

				final JTextField produs1Text = new JTextField();
				addPanel.add(produs1Text);
				produs1Text.setBounds(75, 205, 200, 25);

				final JLabel cantitateProdus1 = new JLabel("Nr.bucati");
				addPanel.add(cantitateProdus1);
				cantitateProdus1.setBounds(280, 205, 70, 25);
				cantitateProdus1.setFont(new Font("TimesRoman", Font.PLAIN, 17));

				final JTextField bucatiProdus1 = new JTextField();
				addPanel.add(bucatiProdus1);
				bucatiProdus1.setBounds(350, 205, 50, 25);

				final JLabel produs2 = new JLabel("Produs2");
				//addPanel.add(produs2);
				produs2.setBounds(10, 245, 70, 25);
				produs2.setFont(new Font("TimesRoman", Font.PLAIN, 17));

				JTextField produs2Text = new JTextField();
				//addPanel.add(produs2Text);
				produs2Text.setBounds(75, 245, 200, 25);

				final JLabel cantitateProdus2 = new JLabel("Nr.bucati");
				//addPanel.add(cantitateProdus2);
				cantitateProdus2.setBounds(280, 245, 70, 25);
				cantitateProdus2.setFont(new Font("TimesRoman", Font.PLAIN, 17));

				final JTextField bucatiProdus2 = new JTextField();
				//addPanel.add(bucatiProdus2);
				bucatiProdus2.setBounds(350, 245, 50, 25);

				JLabel produs3 = new JLabel("Produs3");
				//addPanel.add(produs3);
				produs3.setBounds(10, 285, 70, 25);
				produs3.setFont(new Font("TimesRoman", Font.PLAIN, 17));

				JTextField produs3Text = new JTextField();
				//addPanel.add(produs3Text);
				produs3Text.setBounds(75, 285, 200, 25);

				final JLabel cantitateProdus3 = new JLabel("Nr.bucati");
				//addPanel.add(cantitateProdus3);
				cantitateProdus3.setBounds(280, 285, 70, 25);
				cantitateProdus3.setFont(new Font("TimesRoman", Font.PLAIN, 17));

				final JTextField bucatiProdus3 = new JTextField();
				//addPanel.add(bucatiProdus3);
				bucatiProdus3.setBounds(350, 285, 50, 25);

				JButton okButton = new JButton("SUBMIT");
				addPanel.add(okButton);
				okButton.setBounds(180, 318, 100, 30);

				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						waiterFrame.setVisible(false);
						//Restaurant re = new Restaurant(1);
						
						int id = Integer.parseInt(textComanda.getText());
						int ora = Integer.parseInt(oraText.getText());
						int minutul = Integer.parseInt(minutulText.getText());
						int masa = Integer.parseInt(masaText.getText());
						Order comanda = new Order(id, ora, minutul, masa);


						int bucatiP1 = Integer.parseInt(bucatiProdus1.getText());
						//int bucatiP2 = Integer.parseInt(bucatiProdus2.getText());
						//int bucatiP3 = Integer.parseInt(bucatiProdus3.getText());

						ArrayList<MenuItem> produse = new ArrayList<MenuItem>();
						String s = produs1Text.getText();
						int cat = 0;
						ArrayList<MenuItem> sws = restaurant.items;
						for (MenuItem x : sws) {
							if (x instanceof BaseProduct) {
								if (((BaseProduct) x).getNumeBaseProduct().equalsIgnoreCase(s)) {
									produse.add(new BaseProduct(s, bucatiP1,((BaseProduct) x).getPretBaseProduct()));
									cat++;
								}
							} else {

								if (((CompositeProduct) x).getNume().equalsIgnoreCase(s)) {
									produse.add(new CompositeProduct(s, bucatiP1,((CompositeProduct) x).getPret()));
									cat++;
								}

							}
						}

						if (cat == 0) {
							JOptionPane.showMessageDialog(null, "FELUL 1 NU SE GASESTE IN MENIU !");
							return;
						} else {
							JOptionPane.showMessageDialog(null, "FELUL 1 ESTE IN MENIU");
						}

						/*
						 * int cate = 0; String s1 = produs2.getText(); if (s1 != null) { for (MenuItem
						 * x : re.items) { if (x instanceof BaseProduct) { if (((BaseProduct)
						 * x).getNumeBaseProduct().equalsIgnoreCase(s)) { produse.add(new
						 * BaseProduct(s1, bucatiP2, 1)); cate++; } } else { if (x instanceof
						 * CompositeProduct) { if (((CompositeProduct) x).getNume().equalsIgnoreCase(s))
						 * { produse.add(new CompositeProduct(s1, bucatiP2, 1)); cate++; } } } } if(cate
						 * ==0) { JOptionPane.showMessageDialog(null,
						 * "FELUL 2 NU SE GASESTE IN MENIU ! "); } else {
						 * JOptionPane.showMessageDialog(null, "FELUL 2 ESTE IN MENIU"); } }
						 */
						//re.createNewOrder(comanda, produse);
						restaurant.createNewOrder(comanda,produse);
						serializator.serializare(re);
					}
				});

			}

		});
		viewAllOrders.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				TabelaOrder t = new TabelaOrder();
				System.out.println("FERI");
				String[][] result = t.retrieveProperties(re.orders);
				t.tableItems(result);

			}
		});

		computeBill.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				waiterFrame.setVisible(false);
				JFrame billFrame = new JFrame("COMPUTE BILL");
				JPanel billPanel = new JPanel();
				billFrame.add(billPanel);
				billFrame.setVisible(true);
				billPanel.setLayout(null);
				billFrame.setSize(500,400);
				billFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

				JLabel l1 = new JLabel("Introduceti ID-ul comenzii:");
				billPanel.add(l1);
				l1.setBounds(50,100,200,100);
				l1.setFont(new Font("TimesRoman", Font.BOLD,15));

				JTextField t1 = new JTextField();
				billPanel.add(t1);
				t1.setBounds(250,140,50,25);

				JButton ok = new JButton("OK");
				billPanel.add(ok);
				ok.setBounds(200, 318, 70, 30);

				ok.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						int id = Integer.parseInt(t1.getText());
						int suma = 0;
						for(Order x: re.getTable().keySet()){
							if(x.getOrderID() == id){
								for(MenuItem s : restaurant.getTable().get(x)){
									if(s instanceof BaseProduct){
										suma += s.computePrice();
									}
									else
									{
										if(s instanceof CompositeProduct){
											suma += s.computePrice();
										}
									}
								}
								System.out.println("Comanda " + id + " are valoarea de " + suma + " lei");
								Invoice chitanta = new Invoice();
								chitanta.createInvoice(id,suma);
								billFrame.setVisible(false);
								waiterFrame.setVisible(true);
								return;
							}
						}


						JOptionPane.showMessageDialog(null, "COMANDA " + id + " NU A FOST INREGISTRATA");
						billFrame.setVisible(false);
						waiterFrame.setVisible(true);
						return;


					}
				});
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

	}

}